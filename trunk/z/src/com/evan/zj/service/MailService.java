package com.evan.zj.service;


import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.multipart.MultipartFile;

import com.evan.zj.bo.Email;

/**
 * 
 * @author 
 * 
 */
public class MailService  {
	private Logger logger = Logger.getLogger(MailService.class);
	protected JavaMailSender mailSender;
	protected IMAPMailReceiver mailReceiver;

	protected SimpleMailMessage registerMessage;

	protected ThreadPoolTaskExecutor taskExecutor;

	protected String defaultFrom;

	public List<Email> checkMail() {
		return mailReceiver.checkMail();
	}

	public String getDefaultFrom() {
		return defaultFrom;
	}

	public IMAPMailReceiver getMailReceiver() {
		return mailReceiver;
	}

	public JavaMailSender getMailSender() {
		return mailSender;
	}

	public SimpleMailMessage getRegisterMessage() {
		return registerMessage;
	}

	public ThreadPoolTaskExecutor getTaskExecutor() {
		return taskExecutor;
	}

	public void sendMail(final Email email, boolean isSynchronized) {
		if (email.getFrom() == null || email.getFrom().length() == 0) {
			email.setFrom(defaultFrom);
		}
		if (email.getTo() == null || email.getTo().length == 0) {
			throw new RuntimeException("No mail To");
		}
		if (isSynchronized) {
			try {
				sendMailBySynchronizationMode(email);
			} catch (Exception e) {
				e.printStackTrace();
				logger.warn("Send Mail Exception " + e.toString());
			}
		} else {
			taskExecutor.execute(new Runnable() {
				public void run() {
					try {
						sendMailBySynchronizationMode(email);
					} catch (Exception e) {
						logger.warn("Send Mail Exception " + e.toString());
					}
				}
			});
		}
	}

	public void sendMail(final Email email) {
		sendMail(email,false);
	}
	
	
	
	/**
	 * 以异步的方式发送邮件
	 * 
	 * @param email
	 * @throws MessagingException
	 * @throws IOException
	 */
	public void sendMailBySynchronizationMode(Email email)
			throws MessagingException, IOException {
		MimeMessage mime = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mime, true, "utf-8");
		helper.setFrom(email.getFrom());
		helper.setTo(email.getTo());
		if (email.getCc() != null) {
			helper.setCc(email.getCc());
		}
		helper.setSubject(email.getSubject());
		helper.setText(email.getContent(), true);

		if (email.getAttachment() != null) {
			for (MultipartFile file : email.getAttachment()) {
				if (file == null || file.isEmpty()) {
					continue;
				}
				String fileName = file.getOriginalFilename();
				try {
					fileName = new String(fileName.getBytes("utf-8"),
							"ISO-8859-1");
				} catch (Exception e) {
				}
				helper.addAttachment(fileName, new ByteArrayResource(file
						.getBytes()));
			}
		}
		mailSender.send(mime);
	}

	public void sendRegisterMail(String mailTo) {
		registerMessage.setTo(mailTo);
		mailSender.send(registerMessage);
	}

	public void setDefaultFrom(String defaultFrom) {
		this.defaultFrom = defaultFrom;
	}

	public void setMailReceiver(IMAPMailReceiver mailReceiver) {
		this.mailReceiver = mailReceiver;
	}

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void setRegisterMessage(SimpleMailMessage mailMessage) {
		this.registerMessage = mailMessage;
	}

	public void setTaskExecutor(ThreadPoolTaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}

}

