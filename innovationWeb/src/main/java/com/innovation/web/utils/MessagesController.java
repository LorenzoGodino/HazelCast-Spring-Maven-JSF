package com.innovation.web.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * The Class MessagesController.
 */
@Component(value="messagesController")
public class MessagesController {
	private final Logger log = LoggerFactory.getLogger(MessagesController.class);

	/**
	 * Adds the info.
	 *
	 * @param actionEvent the action event
	 * @param strinfo the strinfo
	 */
	public void addInfo(ActionEvent actionEvent,String strinfo) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Info",strinfo));
	}

	/**
	 * Adds the warn.
	 *
	 * @param actionEvent the action event
	 * @param strwarn the strwarn
	 */
	public void addWarn(ActionEvent actionEvent,String strwarn) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Warning",strwarn));
	}

	/**
	 * Adds the error.
	 *
	 * @param actionEvent the action event
	 * @param strError the str error
	 */
	public void addError(ActionEvent actionEvent,String strError) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error", strError));
	}
	

	
	
}