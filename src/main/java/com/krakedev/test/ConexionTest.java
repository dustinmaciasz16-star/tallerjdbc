package com.krakedev.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

 
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConexionTest {
	
	private static final Logger log = LogManager.getLogger(ConexionTest.class);

	public static void main(String[] args) {
		
		Connection con = null;
		
		try	{
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tallerjdbc","postgres","dustin");
			log.info("Conectado");
		}catch (SQLException e){
			log.error("Error de conecion: " + e.getMessage());
		}finally {
			try {
				con.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		

	}

}
