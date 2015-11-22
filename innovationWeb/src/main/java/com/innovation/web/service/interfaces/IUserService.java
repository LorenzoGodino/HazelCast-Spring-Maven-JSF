package com.innovation.web.service.interfaces;

import java.util.List;

import com.innovation.web.dto.ParamBusquedaDTO;
import com.innovation.web.model.User;

// TODO: Auto-generated Javadoc
/**
 * The Interface IUserService.
 */
public interface IUserService {
	
	/**
	 * Gets the all user.Cacheado Por Hazelcast
	 *
	 * @return the all user
	 */
	public abstract List<User>  getAllUser();
	
	/**
	 * Gets the user filtrado.
	 *
	 * @param dto the dto
	 * @return the user filtrado
	 */
	public abstract List<User> getUserFiltrado(ParamBusquedaDTO dto);
}
