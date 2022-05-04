package ej7;

import java.sql.Connection;

import utils.ConnectionDB;

public class Ej7App {
	
	//la hacemos static para poder usarla desde los metodos
	static Connection conexion = null;

	public static void main(String[] args) {
		
		conexion = ConnectionDB.crearConexion("192.168.1.140","remote","Reus_2022");

		ConnectionDB.dropIfExistsDB("cientificos");
		ConnectionDB.createDB("cientificos");
		ConnectionDB.useDB("cientificos");
		
		//ConnectionDB.executeQuery("");
		ConnectionDB.executeQuery("CREATE TABLE cientificos(dni VARCHAR(8) PRIMARY KEY,\r\n"
				+ "nombre_apellidos NVARCHAR(255)\r\n"
				+ ");");
		ConnectionDB.executeQuery("CREATE TABLE proyecto(id CHAR(4) PRIMARY KEY,\r\n"
				+ "nombre NVARCHAR(255),\r\n"
				+ "horas INT\r\n"
				+ ");");
		ConnectionDB.executeQuery("CREATE TABLE asignado_a(dni VARCHAR(8),\r\n"
				+ "KEY (dni),\r\n"
				+ "FOREIGN KEY (dni) REFERENCES cientificos(dni)\r\n"
				+ "ON UPDATE CASCADE ON DELETE CASCADE,\r\n"
				+ "id CHAR(4),\r\n"
				+ "KEY (id),\r\n"
				+ "FOREIGN KEY (id) REFERENCES proyecto(id)\r\n"
				+ "ON UPDATE CASCADE ON DELETE CASCADE\r\n"
				+ ");");
		
		ConnectionDB.executeQuery("INSERT INTO cientificos(dni,nombre_apellidos) VALUES\r\n"
				+ "(\"12345678\",\"Jose\"),\r\n"
				+ "(\"12095824 \",\"Cristina\"),\r\n"
				+ "(\"30340459 \",\"Juan\"),\r\n"
				+ "(\"80982838 \",\"Juanjo\"),\r\n"
				+ "(\"99328846 \",\"Damaris\"),\r\n"
				+ "(\"75351499 \",\"Jimena\"),\r\n"
				+ "(\"64331320 \",\"Paula\"),\r\n"
				+ "(\"23257790 \",\"Ramon\"),\r\n"
				+ "(\"47266291 \",\"Paco\"),\r\n"
				+ "(\"61855715 \",\"Milena\");");
		ConnectionDB.executeQuery("INSERT INTO proyecto(id,nombre,horas) VALUES\r\n"
				+ "('JHOP',\"JHOPE\",100),\r\n"
				+ "('JIMI',\"JIMIN\",10),\r\n"
				+ "('RMEN',\"RMENETERPRISES\",100),\r\n"
				+ "('SUGA',\"SUGACORP\",10),\r\n"
				+ "('JINA',\"JINAIR\",10),\r\n"
				+ "('JORD',\"JORDANADIDAS\",10),\r\n"
				+ "('TAET',\"TAETAE\",10),\r\n"
				+ "('SAMS',\"SAMSUNG\",10),\r\n"
				+ "('TAIW',\"TAIWAN\",10),\r\n"
				+ "('CHIN',\"CHINAINC\",10),\r\n"
				+ "('JOHN',\"JOHNCOOK\",100);");
		ConnectionDB.executeQuery("INSERT INTO asignado_a(dni,id) VALUES\r\n"
				+ "(\"75351499\",'TAET'),\r\n"
				+ "(\"61855715\",'TAET'),\r\n"
				+ "(\"47266291\",'SUGA'),\r\n"
				+ "(\"23257790\",'TAET'),\r\n"
				+ "(\"64331320\",'SUGA'),\r\n"
				+ "(\"99328846\",'TAET'),\r\n"
				+ "(\"80982838\",'SUGA'),\r\n"
				+ "(\"12345678\",'JORD'),\r\n"
				+ "(\"12095824\",'JORD'),\r\n"
				+ "(\"30340459\",'CHIN');");
		
	}

}
