package com.innovation.web.comun;



import javax.faces.bean.ManagedProperty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.innovation.web.utils.MessageProvider;
import com.innovation.web.utils.MessagesController;



public class ComunManagerBean {
	
	private final Logger log = LoggerFactory.getLogger(ComunManagerBean.class);
	@Autowired
	@ManagedProperty(value="#{messagesController}")
	private MessagesController messageController;
	
	/** The message provider. */
	@Autowired
	@ManagedProperty(value="#{messageProvider}")
	private MessageProvider messageProvider;
	
	/**
	 * Gets the message provider.
	 *
	 * @return the messageProvider
	 */
	public MessageProvider getMessageProvider() {
		return messageProvider;
	}
	
	/**
	 * Sets the message provider.
	 *
	 * @param messageProvider the messageProvider to set
	 */
	public void setMessageProvider(MessageProvider messageProvider) {
		this.messageProvider = messageProvider;
	}

	/** The message provider. */

	/**
	 * @return the messageController
	 */
	public MessagesController getMessageController() {
		return messageController;
	}

	/**
	 * @param messageController the messageController to set
	 */

	public void setMessageController(MessagesController messageController) {
		this.messageController = messageController;
	}
	

}
