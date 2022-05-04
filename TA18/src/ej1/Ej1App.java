package ej1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import utils.ConnectionDB;

public class Ej1App {

	//la hacemos static para poder usarla desde los metodos
	static Connection conexion = null;
	
	public static void main(String[] args) {

		conexion = ConnectionDB.crearConexion("192.168.1.140","remote","Reus_2022");
		
		ConnectionDB.dropIfExistsDB("tienda_informatica");
		ConnectionDB.createDB("tienda_informatica");
		ConnectionDB.useDB("tienda_informatica");
		
		ConnectionDB.executeQuery("CREATE TABLE fabricantes(codigo_fabricante INT AUTO_INCREMENT PRIMARY KEY,\r\n"
				+ "		nombre NVARCHAR(100)\r\n"
				+ "		);");
		
		ConnectionDB.executeQuery("CREATE TABLE articulos(codigo_articulo INT AUTO_INCREMENT PRIMARY KEY,\r\n"
				+ "		nombre NVARCHAR(100),\r\n"
				+ "		precio INT DEFAULT 100,\r\n"
				+ "		codigo_fabricante INT,\r\n"
				+ "		KEY (codigo_fabricante),\r\n"
				+ "		FOREIGN KEY (codigo_fabricante) REFERENCES fabricantes(codigo_fabricante)\r\n"
				+ "		ON UPDATE CASCADE ON DELETE CASCADE\r\n"
				+ "		);");
		
		
		

		ConnectionDB.closeConnection();
	}
	


		/*CREATE TABLE fabricantes(codigo_fabricante INT AUTO_INCREMENT PRIMARY KEY,
		nombre NVARCHAR(100)
		);*/
	
		/*CREATE TABLE articulos(codigo_articulo INT AUTO_INCREMENT PRIMARY KEY,
		nombre NVARCHAR(100),
		precio INT DEFAULT 100,
		codigo_fabricante INT,
		KEY (codigo_fabricante),
		FOREIGN KEY (codigo_fabricante) REFERENCES fabricantes(codigo_fabricante)
		ON UPDATE CASCADE ON DELETE CASCADE
		);*/
	
}
