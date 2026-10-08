package com.krakedev.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.entidades.Vehiculo;
import com.krakedev.jdbc.DeleteVehiculo;

public class DeleteVehiculoTest {
	
	private static final Logger log = LogManager.getLogger(DeleteVehiculoTest.class);


	public static void main(String[] args) {
		
		Vehiculo  vehiculo = new Vehiculo();
		
		vehiculo.setPlaca("GTX-5678");
		
		DeleteVehiculo.delete(vehiculo.getPlaca());

	}

}
