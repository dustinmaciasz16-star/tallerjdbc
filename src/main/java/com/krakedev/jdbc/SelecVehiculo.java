package com.krakedev.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.entidades.Vehiculo;

public class SelecVehiculo {
	private static final Logger log = LogManager.getLogger(SelecVehiculo.class);
	
	public static void select() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = """
				select placa, marca, modelo, anio, precio, color, disponible from vehiculo;
				""";
		
		try {
			con = Conexion.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Vehiculo vehiculo = new Vehiculo();
				
				vehiculo.setPlaca(rs.getString("placa"));
				vehiculo.setMarca(rs.getString("marca"));
				vehiculo.setModelo(rs.getString("modelo"));
				vehiculo.setAnio(rs.getInt("anio"));
				vehiculo.setPrecio(rs.getDouble("precio"));
				vehiculo.setColor(rs.getString("color"));
				vehiculo.setDisponible(rs.getBoolean("disponible"));
				
				log.info(vehiculo);
			}
			
		}catch(Exception e) {
			log.error("Error al mostrar datos de vehiculo" + e.getMessage());
		}finally {
			try {
				con.close();
				ps.close();
				rs.close();
				
				log.info("Conexiones cerradas correctamente");
			}catch(Exception e) {
				log.error("Error al cerrar la cesion" + e.getMessage());
			}
		}
	}
}
