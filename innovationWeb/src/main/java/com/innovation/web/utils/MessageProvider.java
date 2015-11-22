package com.innovation.web.utils;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component(value = "messageProvider")
public class MessageProvider {
	private final Logger log = LoggerFactory.getLogger(MessageProvider.class);

	/** The bundle. */
	private ResourceBundle bundle;

	public ResourceBundle getBundle() {
		if (bundle == null) {
			FacesContext context = FacesContext.getCurrentInstance();
			bundle = context.getApplication().getResourceBundle(context, "msg");
		}
		return bundle;
	}

	public String getValue(String key) {

		String result = null;
		try {
			result = getBundle().getString(key);
		} catch (MissingResourceException e) {
			result = "???" + key + "??? not found";
			log.error("Error Grave:" +  e.getMessage());
		}
		return result;
	}

}