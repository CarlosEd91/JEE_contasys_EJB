/**
 * 
 */
package com.hogam.contasys.core;


import java.util.List;

import javax.ejb.Local;

import com.hogam.contasys.modelo.MatTipoProducto;


/**
 * @author Usuario
 *
 */

@Local
public interface IAdminCrud {
	
	public String guardar(Object entidad);
	
	public String actualizar (Object entidad);
	
	public String eliminar (Object entidad);
	
	public List<Object> consultarTodos(Class tabla);
	
	public Object consultarPorId(Class tabla, Object id);



}
