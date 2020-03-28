package com.formacionbdi.springboot.app.productos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
/*Una vez eliminado el package Entity, el inconveniente es que el package de Producto esta 
  ahora en el proyecto commons, que es un package que esta fuera de esta aplicacion, 
  para configurarlo se realiza en EntityScan, en su arreglo de string colocamos los package de otro proyecto,
  de la Entity*/
@EntityScan({"com.formacionbdi.springboot.app.commons.models.entity"})
public class SpringbootServicioProductosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServicioProductosApplication.class, args);
	}

}
