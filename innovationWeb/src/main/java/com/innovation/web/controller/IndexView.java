package com.innovation.web.controller;

import java.util.List;

import javax.faces.bean.ManagedProperty;

import org.springframework.beans.factory.annotation.Autowired;

import com.innovation.web.comun.ComunManagerBean;
import com.innovation.web.dto.ParamBusquedaDTO;
import com.innovation.web.model.User;
import com.innovation.web.service.interfaces.IUserService;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginView.
 */
public class IndexView extends ComunManagerBean {
	
	/** The user service. */
	@Autowired
	@ManagedProperty(value = "#{userService}")
	private IUserService userService;

	/** The hazelcast instance. */
	@Autowired
	/** The lst user. */
	private List<User> lstUser;
	
	/** The busqueda dto. */
	private ParamBusquedaDTO busquedaDTO =new ParamBusquedaDTO();

	/**
	 * Gets the user service.
	 *
	 * @return the user service
	 */
	public IUserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user service.
	 *
	 * @param userService the new user service
	 */
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	/**
	 * Gets the lst user.
	 *
	 * @return the lst user
	 */
	public List<User> getLstUser() {
		return lstUser;
	}

	/**
	 * Sets the lst user.
	 *
	 * @param lstUser the new lst user
	 */
	public void setLstUser(List<User> lstUser) {
		this.lstUser = lstUser;
	}

	public ParamBusquedaDTO getBusquedaDTO() {
		return busquedaDTO;
	}

	public void setBusquedaDTO(ParamBusquedaDTO busquedaDTO) {
		this.busquedaDTO = busquedaDTO;
	}


}
