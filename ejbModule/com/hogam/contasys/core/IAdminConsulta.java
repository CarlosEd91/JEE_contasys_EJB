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
public interface IAdminConsulta {

	public List<MatTipoProducto> consulatarTodosJPQL();
	
	public List<MatTipoProducto> consultarTodosSQL();
	
	public List<MatTipoProducto> consultarCriteriaAPI();
	
}
