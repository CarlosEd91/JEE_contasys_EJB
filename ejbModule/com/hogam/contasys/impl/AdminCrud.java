/**
 * 
 */
package com.hogam.contasys.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.hogam.contasys.core.IAdminCrud;
import com.hogam.contasys.modelo.MatTipoProducto;

/**
 * @author Usuario
 * @Stateless // como maneja las operaciones sin estado
 * @Stalefull // maneja estados
 */

@Stateless
public class AdminCrud implements IAdminCrud {

	@PersistenceContext(unitName = "contasysPU")
	private EntityManager manejador;

	@Override
	public String guardar(Object entidad) {
		// TODO Auto-generated method stub

		manejador.persist(entidad);
		return "Registro ingresado correctamente";
	}

	@Override
	public String actualizar(Object entidad) {
		manejador.merge(entidad);
		return "Registro actualizado correctamente";
	}

//	@Override
	public String eliminar(Object entidad) {

//		manejador.remove(entidad);

		manejador.remove(manejador.contains(entidad) ? entidad : manejador.merge(entidad));

		return "Registro eliminada correctamente";
	}

	@Override
	public List<Object> consultarTodos(Class tabla) {
		Query conTod = manejador.createQuery("SELECT ali FROM " + tabla.getSimpleName() + " ali");
		return conTod.getResultList();
	}

	@Override
	public Object consultarPorId(Class tabla, Object id) {
		Object objDev = manejador.find(tabla, id);
		return objDev;
	}

}
