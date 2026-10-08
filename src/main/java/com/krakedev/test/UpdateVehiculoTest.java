package com.krakedev.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.entidades.Vehiculo;
import com.krakedev.jdbc.UpdateVehiculo;


public class UpdateVehiculoTest {
	private static final Logger log = LogManager.getLogger(UpdateVehiculoTest.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vehiculo vehiculo = new Vehiculo("GTX-5678", "KIA", "RIO", 2027, 18000, "gris", true, 80000);
		Vehiculo vehiculo2 = null;
		
		UpdateVehiculo.update(vehiculo);
	}

}
