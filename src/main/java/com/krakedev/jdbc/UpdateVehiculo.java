package com.krakedev.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.entidades.Vehiculo;

public class UpdateVehiculo {
	private static final Logger log = LogManager.getLogger(UpdateVehiculo.class);
	
	public static void update(Vehiculo vehiculo) {
		
		if(vehiculo == null || vehiculo.getPlaca() == null || vehiculo.getPlaca().isBlank()) {
			log.info("Vehiculo vacio o nulo se puede actualizar");
		}
		
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = """
				update vehiculo set marca = ?, modelo = ?, anio = ?, precio = ?, color = ?, disponible = ?, kilometraje = ? where placa = 'GTX-5678';
				""";
		
		try {
			con = Conexion.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, vehiculo.getMarca());
			ps.setString(2, vehiculo.getModelo());
			ps.setInt(3, vehiculo.getAnio());
			ps.setDouble(4, vehiculo.getPrecio());
			ps.setString(5, vehiculo.getColor());
			ps.setBoolean(6, vehiculo.isDisponible());
			ps.setInt(7, vehiculo.getKilometraje());
			
			int filas = ps.executeUpdate();
			
			log.info("Filas actualizadas" + filas);
			
		}catch(Exception e) {
			log.error("Ocurrio un error al actualizar " + e.getMessage());
		}finally {
			try {
				con.close();
				ps.close();
				log.info("cerrando cesion");
			}catch(Exception e) {
				log.error("Error al cerrar la cecion" + e);
			}
		}
	}
}
