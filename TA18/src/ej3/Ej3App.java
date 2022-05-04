package ej3;

import java.sql.Connection;

import utils.ConnectionDB;

public class Ej3App {
	
	//la hacemos static para poder usarla desde los metodos
	static Connection conexion = null;

	public static void main(String[] args) {
		
		conexion = ConnectionDB.crearConexion("192.168.1.140","remote","Reus_2022");

		ConnectionDB.dropIfExistsDB("almacenes");
		ConnectionDB.createDB("almacenes");
		ConnectionDB.useDB("almacenes");
		
		//ConnectionDB.executeQuery("");
		ConnectionDB.executeQuery("CREATE TABLE almacenes(codigo INT AUTO_INCREMENT PRIMARY KEY,\r\n"
				+ "lugar NVARCHAR(100),\r\n"
				+ "capacidad INT DEFAULT 0\r\n"
				+ ");");
		ConnectionDB.executeQuery("CREATE TABLE cajas(num_referencia CHAR(5) PRIMARY KEY,\r\n"
				+ "contenido NVARCHAR(100),\r\n"
				+ "valor INT DEFAULT 0,\r\n"
				+ "almacen INT, \r\n"
				+ "KEY (almacen),\r\n"
				+ "FOREIGN KEY (almacen) REFERENCES almacenes(codigo)\r\n"
				+ "ON UPDATE CASCADE ON DELETE CASCADE\r\n"
				+ ");");
		
		ConnectionDB.executeQuery("INSERT INTO almacenes(lugar,capacidad) VALUES\r\n"
				+ "(\"Reus\",10),\r\n"
				+ "(\"Tarragona\",20),\r\n"
				+ "(\"Barcelona\",200),\r\n"
				+ "(\"Riudoms\",4);");
		ConnectionDB.executeQuery("INSERT INTO cajas(num_referencia,contenido,valor,almacen) VALUES\r\n"
				+ "(\"JUGET\",\"JUEGUETES\",100,1),\r\n"
				+ "(\"ZAPAT\",\"ZAPATOS\",250,1),\r\n"
				+ "(\"DIAES\",\"DIAMANTES Y ESMERALDAS\",10000000,4),\r\n"
				+ "(\"INFOR\",\"PRODUCTOS INFORMATICOS\",10000,3),\r\n"
				+ "(\"VERMU\",\"VERMUT\",300,3),\r\n"
				+ "(\"MECAN\",\"PIEZAS MECANICAS\",5000,1),\r\n"
				+ "(\"MASCA\",\"MASCARILLAS\",1000,3),\r\n"
				+ "(\"FERTI\",\"FERTILIZANTE\",4000,3),\r\n"
				+ "(\"PETRO\",\"PETROLEO\",1000000,3),\r\n"
				+ "(\"PESCA\",\"PESCADO FRESCO\",1000,2);");
		
	}

}
