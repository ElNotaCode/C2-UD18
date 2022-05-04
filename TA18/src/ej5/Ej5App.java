package ej5;

import java.sql.Connection;

import utils.ConnectionDB;

public class Ej5App {
	
	//la hacemos static para poder usarla desde los metodos
			static Connection conexion = null;

			public static void main(String[] args) {
				
				conexion = ConnectionDB.crearConexion("192.168.1.140","remote","Reus_2022");

				ConnectionDB.dropIfExistsDB("empresa");
				ConnectionDB.createDB("empresa");
				ConnectionDB.useDB("empresa");
				
				//ConnectionDB.executeQuery("");
				ConnectionDB.executeQuery("CREATE TABLE despachos(id_despacho INT AUTO_INCREMENT PRIMARY KEY,\r\n"
						+ "capacidad INT DEFAULT 1\r\n"
						+ ");");
				ConnectionDB.executeQuery("CREATE TABLE directores(dni VARCHAR(8) PRIMARY KEY,\r\n"
						+ "nombre_apellidos NVARCHAR(255),\r\n"
						+ "despacho INT,\r\n"
						+ "KEY(despacho),\r\n"
						+ "FOREIGN KEY (despacho) REFERENCES despachos(id_despacho)\r\n"
						+ "ON UPDATE CASCADE ON DELETE CASCADE,\r\n"
						+ "dni_jefe VARCHARACTER(8),\r\n"
						+ "KEY (dni_jefe),\r\n"
						+ "FOREIGN KEY (dni_jefe) REFERENCES directores(dni)\r\n"
						+ "ON UPDATE CASCADE ON DELETE CASCADE\r\n"
						+ ");");
				
				ConnectionDB.executeQuery("INSERT INTO despachos(capacidad) VALUES\r\n"
						+ "(3),\r\n"
						+ "(4),\r\n"
						+ "(1),\r\n"
						+ "(1),\r\n"
						+ "(1),\r\n"
						+ "(4),\r\n"
						+ "(3),\r\n"
						+ "(2),\r\n"
						+ "(2),\r\n"
						+ "(2);");
				ConnectionDB.executeQuery("INSERT INTO directores(dni,nombre_apellidos,despacho) VALUES\r\n"
						+ "(\"12345678\",\"Jose\",1),\r\n"
						+ "(\"12095824 \",\"Cristina\",2),\r\n"
						+ "(\"30340459 \",\"Juan\",2),\r\n"
						+ "(\"80982838 \",\"Juanjo\",3),\r\n"
						+ "(\"99328846 \",\"Damaris\",4),\r\n"
						+ "(\"75351499 \",\"Jimena\",5);");
				ConnectionDB.executeQuery("INSERT INTO directores(dni,nombre_apellidos,despacho,dni_jefe) VALUES\r\n"
						+ "(\"64331320 \",\"Paula\",6,\"12345678\"),\r\n"
						+ "(\"23257790 \",\"Ramon\",7,\"12345678\"),\r\n"
						+ "(\"47266291 \",\"Paco\",8,\"12345678\"),\r\n"
						+ "(\"61855715 \",\"Milena\",9,\"12345678\");");
				
			}

}
