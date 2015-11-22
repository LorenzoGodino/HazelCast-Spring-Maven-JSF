package com.innovation.web.dto;

/**
 * The Class ParamBusquedaDTO.Clase Creada para Filtrar elementos Tabla
 */
public class ParamBusquedaDTO {
	
	/** The compania. */
	private String compania;
	
	/** The nombre. */
	private String nombre;
	
	private String telefono;

	/**
	 * Gets the compania.
	 *
	 * @return the compania
	 */
	public String getCompania() {
		return compania;
	}

	/**
	 * Sets the compania.
	 *
	 * @param compania the new compania
	 */
	public void setCompania(String compania) {
		this.compania = compania;
	}

	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Sets the nombre.
	 *
	 * @param nombre the new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	
}
