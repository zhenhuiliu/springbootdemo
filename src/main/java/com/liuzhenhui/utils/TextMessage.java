package com.liuzhenhui.utils;

import java.util.Date;

public class TextMessage extends BaseMessage{

	// 回复的消息内容
	private String Content;

	public TextMessage() {

	}

	public TextMessage(String fromUserName, String toUserName, String responseText, String messageType) {
		this.setToUserName(toUserName);
		this.setFromUserName(fromUserName);
		this.setCreateTime(new Date().getTime());
		this.setMsgType(messageType);
		this.Content = responseText;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}


}
