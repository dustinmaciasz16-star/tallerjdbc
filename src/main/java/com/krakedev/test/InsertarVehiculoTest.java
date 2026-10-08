package com.krakedev.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.entidades.Vehiculo;
import com.krakedev.jdbc.InsertVehiculo;

public class InsertarVehiculoTest {
	
	private static final Logger log = LogManager.getLogger(InsertarVehiculoTest.class);

	public static void main(String[] args) {
		
		Vehiculo vehiculo = new Vehiculo("GTX-5678", "KIA", "Soluto", 2027, 17000.00, "Blanco", true, 10000);
		
		InsertVehiculo.insertar(vehiculo);

	}

}
