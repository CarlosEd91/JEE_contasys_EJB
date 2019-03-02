/**
 * 
 */
package com.hogam.contasys.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.MapJoin;
import javax.persistence.criteria.Root;

import com.hogam.contasys.core.IAdminConsulta;
import com.hogam.contasys.modelo.MatTipoProducto;

/**
 * @author Usuario
 *
 */

@Stateless
public class AdminConsulta implements IAdminConsulta {

	@PersistenceContext(unitName = "contasysPU")
	private EntityManager manejador;

	@Override
	public List<MatTipoProducto> consulatarTodosJPQL() {

		Query conTipPro = manejador.createQuery("SELECT tipPro from MatTipoProducto tipPro");
		return conTipPro.getResultList();
	}

	@Override
	public List<MatTipoProducto> consultarTodosSQL() {

		Query conTipPro = manejador.createNativeQuery("SELECT * from mat_tipo_producto", MatTipoProducto.class);

		return conTipPro.getResultList();
	}

	@Override
	public List<MatTipoProducto> consultarCriteriaAPI() {

//		CriteriaBuilder criBui = manejador.getCriteriaBuilder();
//		CriteriaQuery<MatTipoProducto> criQue = criBui.createQuery(MatTipoProducto.class);
//		Query conTod = manejador.createQuery(criQue);
//		
//	
//
//		return conTod.getResultList();
		
		CriteriaBuilder criBui = manejador.getCriteriaBuilder();
	    CriteriaQuery<MatTipoProducto> query = criBui.createQuery(MatTipoProducto.class);
	    Root<MatTipoProducto> variableRoot = query.from(MatTipoProducto.class);
	    query.select(variableRoot);

	    return manejador.createQuery(query).getResultList();

	}

}
