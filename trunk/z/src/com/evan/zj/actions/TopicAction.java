package com.evan.zj.actions;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.evan.zj.service.TopicService;
import com.evan.zj.service.UserService;
import com.evan.zj.vo.TTopic;
import com.opensymphony.xwork2.ModelDriven;


@Controller
@Namespace("/topic")
public class TopicAction extends BaseAction implements ModelDriven<TTopic>{

	@Action(value = "add", results = { @Result(name = "success", location = "/topic/add.jsp") })
	public String add() throws Exception {
		return SUCCESS; 
	}
	
	@Action(value = "save", results = { @Result(name = "success", location = "/topic/add.jsp") })
	public String save() throws Exception {
		topic.setCreatorip(getIp());
		topic.setCreatorid(getUser().getTid());
		topicService.save(topic);
		
		return SUCCESS; 
	}
	
	private TTopic topic = new TTopic();

	public void setTopic(TTopic topic) {
		this.topic = topic;
	}

	@Override
	public TTopic getModel() {
		return this.topic;
	}
	
	@Autowired
	private TopicService topicService;
	
}
