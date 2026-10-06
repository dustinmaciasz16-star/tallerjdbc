package com.krakedev.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.entidades.Vehiculo;


public class InsertVehiculo {
	private static final Logger log = LogManager.getLogger(InsertVehiculo.class);
	
	public static void insertar(Vehiculo vehiculo) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = """
				INSERT INTO vehiculo(placa, marca, modelo, anio, precio, color, disponible)
				VALUES(?, ?, ?, ?, ?, ?, ?)
				""";
		
		try {
			con = Conexion.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, vehiculo.getPlaca());
			ps.setString(2, vehiculo.getMarca());
			ps.setString(3, vehiculo.getModelo());
			ps.setInt(4, vehiculo.getAnio());
			ps.setDouble(5, vehiculo.getPrecio());
			ps.setString(6, vehiculo.getColor());
			ps.setBoolean(7, vehiculo.isDisponible());
			
			int filas = ps.executeUpdate();
			
			log.info("Se insertaron las filas correctamente" + filas);
			
		}catch(Exception e){
			log.error("Ocurrio un error en la conexion" + e.getMessage());
		}finally {
			try {				
				ps.close();
				con.close();
				log.info("Conexion cerrada");
			}catch(SQLException e){
				log.error("Ocurrio un error al cerrar la conexion: " + e.getMessage());
			}
		}
	}
}
