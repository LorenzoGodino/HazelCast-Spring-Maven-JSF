package com.innovation.web.store;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.hazelcast.core.MapStore;
import com.innovation.web.model.User;
import com.innovation.web.repository.UserRepository;

/**
 * The Class UserMapStore.
 */

public class UserMapStore implements MapStore<String, User> {
	private final Logger log = LoggerFactory.getLogger(UserMapStore.class);

	@Autowired
	private UserRepository userRepository;

	@Override
	public User load(String id) {
		return userRepository.findById(new Integer(id));
	}

	/* Para obtener todos los elementos de la tabla
	 * Obtiene todas las claves y hace una busqueda por el Id
	 * de esta forma puede montar el binomio entre el usuario y el id
	 */
	@Override
	public Map<String, User> loadAll(Collection<String> keys) {
		final Map<String, User> users = new HashMap<String, User>();
		for (String key : keys) {
			users.put(key, load(key));
		}
		return users;
	}

	@Override
	public void deleteAll(Collection<String> keys) {
		for (String key : keys) {
			this.delete(key);
		}

	}

	@Override
	public void store(String key, User value) {
		userRepository.save(value);

	}

	@Override
	public void storeAll(Map<String, User> map) {
		for (Map.Entry<String, User> userEntry : map.entrySet()) {
			this.store(userEntry.getKey(), userEntry.getValue());
		}
	}

	@Override
	public void delete(String key) {
		userRepository.delete(new Long(key));
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	/* (non-Javadoc)
	 * Recuperación de Todas las claves.
	 * 
	 */
	@Override
	public Set<String> loadAllKeys() {
		Set<Integer> lstIds= userRepository.findIds();
		Set <String> result=new HashSet<String>();
		for (Integer id : lstIds) {
			result.add(id.toString());			
		}
		return result;
		
	}

}
