package com.formacionbdi.springboot.app.productos.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.springboot.app.productos.entity.Producto;
import com.formacionbdi.springboot.app.productos.models.service.IProductoService;

@RestController
public class ProductoController {

	//Environment, nos permitira obtener el puerto
	/*
	 * @Autowired private Environment env;
	 */
	
	//envez de utilizar Environment, lo haremos con Value.
	/*de forma automatica convierte  aun integer y lo va inyectar, value es 
	 * generalmente para inyectar los valores que se tiene configurado en los properties/
	 */
	@Value("${server.port}")
	private Integer port;
	
	@Autowired
	private IProductoService productoService;
	
	@GetMapping("/listar")
	public List<Producto> listar(){
		//return productoService.findAll();
		return productoService.findAll()
				.stream()
				.map(producto -> {
					//producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
					//con value
					producto.setPort(port);
					return producto;
				})
				.collect(Collectors.toList());
	}
	
	@GetMapping("/ver/{id}")
	public Producto detalle(@PathVariable Long id) {
		Producto producto = productoService.findById(id);
		//producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		producto.setPort(port);
		
//		try {
//			Thread.sleep(2000L);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	
		return productoService.findById(id);
	}
}
