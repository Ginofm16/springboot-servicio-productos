/**
 * 
 */
package com.formacionbdi.springboot.app.productos.dao;

import org.springframework.data.repository.CrudRepository;

import com.formacionbdi.springboot.app.commons.models.entity.Producto;

/**
 * @author leo10
 *
 */
public interface ProductoDao extends CrudRepository<Producto, Long>{

}
