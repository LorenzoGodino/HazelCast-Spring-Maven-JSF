package com.innovation.web.controller;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;




@RequestScoped
@ManagedBean(name = "indexMB")
public class IndexController extends IndexView  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4077459838277657537L;
	
	/**
	 * Recuperacion de todos los Usuarios
	 */
	@Autowired
	@PostConstruct
	public void init() {	
		setLstUser(getUserService().getAllUser());
    }
	
	public void filtroCompania(ActionEvent event) {
		setLstUser(getUserService().getUserFiltrado(getBusquedaDTO()));
	}

}
