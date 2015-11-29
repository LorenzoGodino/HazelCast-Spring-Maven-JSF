package com.innovation.web.service.servicesImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.query.SqlPredicate;
import com.innovation.web.comparator.UserComparator;
import com.innovation.web.dto.ParamBusquedaDTO;
import com.innovation.web.model.User;
import com.innovation.web.service.interfaces.IUserService;

@Transactional(readOnly = false)
@Service("userService")
public class UserService implements IUserService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6032071510524170422L;
	private IMap<String, User> userMapStore;
	private HazelcastInstance hazelcastInstance;

	@Override
	public List<User> getAllUser() {
		List<User> lstUser = new ArrayList<User>();
		// Recuperamos todos los elementos
		Iterator<User> ituser = (Iterator<User>) userMapStore.values().iterator();
		// Conversion de Array
		while (ituser.hasNext()) {
			lstUser.add(ituser.next());
		}
		Collections.sort(lstUser, new UserComparator());
		return lstUser;
	}

	/**
	 * Instantiates a new user service.Creado para Recuperar la Instancia
	 *
	 * @param instance
	 *            the instance
	 */
	@Autowired
	public UserService(HazelcastInstance instance) {
		hazelcastInstance = instance;
		this.userMapStore = hazelcastInstance.getMap("userMap");
	}

	@Override
	public List<User> getUserFiltrado(ParamBusquedaDTO dto) {
		String strConsulta = "";
		Iterator<User> ituser;
		List<User> lstUser = new ArrayList<User>();
		// Si el dto viene en null
		if (dto != null){
			// Si el campo de la consulta compania viene distinto blanco.
			if (!"".equals(dto.getCompania())) {
				strConsulta = "company like '" + "%" + dto.getCompania() + "%'";
			}
			// Si el Campo de la consulta nombre viene en blanco  
			if(!"".equals(dto.getNombre())){
				if(!strConsulta.isEmpty()){
					strConsulta = strConsulta + " and ";
				}
				strConsulta =strConsulta +  "name like '" + "%" + dto.getNombre() + "%'";
			}
			
			if(!"".equals(dto.getTelefono())){
				if(!strConsulta.isEmpty()){
					strConsulta = strConsulta + " and ";
				}
				strConsulta =strConsulta +  "phone like '" + "%" + dto.getTelefono() + "%'";
			}
		}
		
		
		if (!strConsulta.isEmpty()) {
			ituser= userMapStore.values(new SqlPredicate(strConsulta)).iterator();
		}else {
		// Recuperamos todos los elementos
			ituser = (Iterator<User>) userMapStore.values().iterator();
		}
		// Conversion de Array
		while (ituser.hasNext()) {
			lstUser.add(ituser.next());
		}
		Collections.sort(lstUser, new UserComparator());
		return lstUser;
	}
}