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
		
		ConnectionDB.executeQuery("INSERT INTO fabricantes(nombre) VALUES\r\n"
				+ "(\"CIMPASA\"),\r\n"
				+ "(\"TICNOVA\"),\r\n"
				+ "(\"IBM\"),\r\n"
				+ "(\"INTEL\"),\r\n"
				+ "(\"AMD\"),\r\n"
				+ "(\"INDRA\"),\r\n"
				+ "(\"TSYSTEMS\"),\r\n"
				+ "(\"BOSTONTEC\"),\r\n"
				+ "(\"WIRESL\"),\r\n"
				+ "(\"NASA\");");
		
		ConnectionDB.executeQuery("INSERT INTO articulos(nombre,precio,codigo_fabricante) VALUES\r\n"
				+ "(\"RATON\",10,1),\r\n"
				+ "(\"TECLADO\",30,2),\r\n"
				+ "(\"PANTALLA\",115,2),\r\n"
				+ "(\"GRAFICA\",300,5),\r\n"
				+ "(\"PLACA BASE\",350,4),\r\n"
				+ "(\"AURICULARES\",85,10),\r\n"
				+ "(\"ALTAVOCES\",10,9),\r\n"
				+ "(\"IMPRESORA\",60,1),\r\n"
				+ "(\"WEBCAM\",30,7),\r\n"
				+ "(\"CPU\",199,3);");

		ConnectionDB.closeConnection();
	}
	
}
