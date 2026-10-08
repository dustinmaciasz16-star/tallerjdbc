package com.krakedev.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class DeleteVehiculo {
	private static final Logger log = LogManager.getLogger(DeleteVehiculo.class);
	
	public static void delete(String vehiculo) {
		
		if(vehiculo == null || vehiculo.isBlank()) {
			log.info("Vehiculo vacio o nulo se puede actualizar");
		}
		
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = """
				DELETE from vehiculo where placa = ?;
				""";
		
		try {
			con = Conexion.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, vehiculo);
			
			int fila = ps.executeUpdate();
			log.info("Fila eliminada" + fila);
		}catch(Exception e) {
			log.error("Error al eliminar al vehiculo " + e.getMessage());
		}finally {
			try {
				con.close();
				ps.close();
				log.info("Conecion cerrada correctamente ");
			}catch(Exception e) {
				log.error("Erro al cerrar la conecion" + e);
			}
		}
	}
}
