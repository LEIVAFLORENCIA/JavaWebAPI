package com.educacionit.interfaces;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public interface ConexionMariaDB {
	
	default Connection getConexion() {
		Connection conexion = null; //Si no le damos null tendremos un error al devolver la conexion
		Properties propiedades = new Properties();
		
		try {
			//Si nosotros levantamos un archivo de un .jar el archivo de propiedades puede estar en el disco C:  lo va a buscar en la carpeta donde esta ejecutandose, si se ejecuta en un servidor va a buscar en el servidor y no donde se encuentra el proyecto
			propiedades.load(new FileInputStream(new File("src"+File.separator+"resources"+File.separator+"database.properties")));
			String URL = propiedades.getProperty("url");
			String USER = propiedades.getProperty("user");
			String PASS = propiedades.getProperty("pass", "1234"); //Si no consigues la clave, le asigna 1234 por defecto	
			
			conexion = DriverManager.getConnection(URL,USER,PASS);
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return conexion;
	}
}
