package ej6;

import java.sql.Connection;

import utils.ConnectionDB;

public class Ej6App {
	
	//la hacemos static para poder usarla desde los metodos
	static Connection conexion = null;

	public static void main(String[] args) {
		
		conexion = ConnectionDB.crearConexion("192.168.1.140","remote","Reus_2022");

		ConnectionDB.dropIfExistsDB("proveedores");
		ConnectionDB.createDB("proveedores");
		ConnectionDB.useDB("proveedores");
		
		//ConnectionDB.executeQuery("");
		ConnectionDB.executeQuery("CREATE TABLE piezas(id_pieza INT AUTO_INCREMENT PRIMARY KEY,\r\n"
				+ "nombre NVARCHAR(100)\r\n"
				+ ");");
		ConnectionDB.executeQuery("CREATE TABLE proveedores(id_proveedor CHAR(4) PRIMARY KEY,\r\n"
				+ "nombre NVARCHAR(100)\r\n"
				+ ");");
		ConnectionDB.executeQuery("CREATE TABLE suministra(id_pieza INT,\r\n"
				+ "KEY (id_pieza),\r\n"
				+ "FOREIGN KEY (id_pieza) REFERENCES piezas(id_pieza)\r\n"
				+ "ON UPDATE CASCADE ON DELETE CASCADE,\r\n"
				+ "id_proveedor CHAR(4),\r\n"
				+ "KEY(id_proveedor),\r\n"
				+ "FOREIGN KEY (id_proveedor) REFERENCES proveedores(id_proveedor)\r\n"
				+ "ON UPDATE CASCADE ON DELETE CASCADE,\r\n"
				+ "precio INT\r\n"
				+ ");");
		
		ConnectionDB.executeQuery("INSERT INTO piezas(nombre) VALUES\r\n"
				+ "(\"CLAVO\"),\r\n"
				+ "(\"TORNILLO\"),\r\n"
				+ "(\"ZAPATOS\"),\r\n"
				+ "(\"ORDENADORES\"),\r\n"
				+ "(\"AVIONES\");");
		ConnectionDB.executeQuery("INSERT INTO proveedores(id_proveedor,nombre) VALUES\r\n"
				+ "(\"TICN\",\"TICNOVA\"),\r\n"
				+ "(\"IBM1\",\"IBM\"),\r\n"
				+ "(\"DANI\",\"DANIINC\"),\r\n"
				+ "(\"CRIS\",\"CRISTINAAIR\"),\r\n"
				+ "(\"QUES\",\"QUESOSL\");");
		ConnectionDB.executeQuery("INSERT INTO suministra(id_pieza,id_proveedor,precio) VALUES\r\n"
				+ "(1,\"TICN\",16),\r\n"
				+ "(2,\"IBM1\",20),\r\n"
				+ "(3,\"DANI\",14),\r\n"
				+ "(4,\"CRIS\",17),\r\n"
				+ "(5,\"QUES\",18);");
		
	}

}
