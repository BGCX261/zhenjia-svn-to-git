package com.evan.zj.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;

import com.evan.zj.bo.Email;


/**
 * 
 * @author yiming
 * 
 */
public class IMAPMailReceiver extends Authenticator {
	private Logger logger = Logger.getLogger(IMAPMailReceiver.class);
	private PasswordAuthentication authentication;
	private Session session;

	public IMAPMailReceiver(String protocol, String host, String port,
			String username, String password) {
		super();
		Properties props = new Properties();
		props.setProperty("mail.store.protocol", protocol);
		props.setProperty("mail.imap.host", host);
		props.setProperty("mail.imap.port", port);
		props.setProperty("mail.imap.auth.login.disable", "true");
		authentication = new PasswordAuthentication(username, password);
		session = Session.getInstance(props, this);
	}

	public List<Email> checkMail() {
		List<Email> result = new ArrayList<Email>(0);
		try {
			Store store = session.getStore();
			store.connect();
			Folder inbox = store.getDefaultFolder().getFolder("inbox");
			inbox.open(Folder.READ_WRITE);
			logger.info("Unread messages: " + inbox.getUnreadMessageCount());
			Message[] messages = inbox.getMessages();

			for (Message message : messages) {
				logger.info("Receiving: " + message.getSubject());
				Email mail = new Email();
				Object content = message.getContent();
				mail.setFrom(((InternetAddress) message.getFrom()[0])
						.getAddress());
				mail.setSubject(message.getSubject());
				mail.setSentDate(message.getSentDate());
				if (content instanceof Multipart) {
					Multipart multipart = (Multipart) content;
					for (int i = 0; i < multipart.getCount(); i++) {
						BodyPart bodyPart = multipart.getBodyPart(i);
						String contentType = bodyPart.getContentType()
								.toLowerCase();
						if (contentType.startsWith("text/plain")) {
							mail.setContent(mail.getContent() != null ? mail
									.getContent()
									+ "\r\n" : ""
									+ bodyPart.getContent().toString());
						} else if (contentType.startsWith("text/html")) {
							mail.setContent(mail.getContent() != null ? mail
									.getContent()
									+ "\r\n" : ""
									+ bodyPart.getContent().toString());
						} else if (contentType.startsWith("multipart")) {
							MimeMultipart mimePart = (MimeMultipart) bodyPart
									.getContent();
							for (int j = 0; j < mimePart.getCount(); j++) {
								BodyPart subBodyPart = mimePart.getBodyPart(j);
								mail
										.setContent(mail.getContent() != null ? mail
												.getContent()
												+ "\r\n"
												: "" + subBodyPart.getContent());
							}
						} else {
							String fileName = bodyPart.getFileName();
							logger.info("Ingore attachment: " + fileName);
						}
					}
				}
				result.add(mail);
			}
			inbox.close(false);
			store.close();
		} catch (Exception e) {
			logger.warn(e.toString());
		}
		return result;
	}

	@Override
	public PasswordAuthentication getPasswordAuthentication() {
		return this.authentication;
	}
}

