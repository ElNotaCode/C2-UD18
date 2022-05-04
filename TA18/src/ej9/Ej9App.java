package ej9;

import java.sql.Connection;

import utils.ConnectionDB;

public class Ej9App {
	
	//la hacemos static para poder usarla desde los metodos
	static Connection conexion = null;

	public static void main(String[] args) {
		
		conexion = ConnectionDB.crearConexion("192.168.1.140","remote","Reus_2022");

		ConnectionDB.dropIfExistsDB("cientificos");
		ConnectionDB.createDB("cientificos");
		ConnectionDB.useDB("cientificos");
		
		//ConnectionDB.executeQuery("");
		ConnectionDB.executeQuery("CREATE TABLE facultad(id_facultad INT AUTO_INCREMENT PRIMARY KEY,\r\n"
				+ "nombre NVARCHAR(100)\r\n"
				+ ");");
		ConnectionDB.executeQuery("CREATE TABLE investigadores(dni VARCHAR(8) PRIMARY KEY,\r\n"
				+ "nombre_apellidos NVARCHAR(255),\r\n"
				+ "id_facultad INT,\r\n"
				+ "KEY (id_facultad),\r\n"
				+ "FOREIGN KEY (id_facultad) REFERENCES facultad(id_facultad)\r\n"
				+ "ON UPDATE CASCADE ON DELETE CASCADE\r\n"
				+ ");");
		ConnectionDB.executeQuery("CREATE TABLE equipos(id_equipos CHAR(4) PRIMARY KEY,\r\n"
				+ "nombre NVARCHAR(100),\r\n"
				+ "id_facultad INT,\r\n"
				+ "KEY (id_facultad),\r\n"
				+ "FOREIGN KEY (id_facultad) REFERENCES facultad(id_facultad)\r\n"
				+ "ON UPDATE CASCADE ON DELETE CASCADE\r\n"
				+ ");");
		ConnectionDB.executeQuery("CREATE TABLE reserva(id_reserva INT AUTO_INCREMENT PRIMARY KEY,\r\n"
				+ "equipo CHAR(4),\r\n"
				+ "KEY (equipo),\r\n"
				+ "FOREIGN KEY (equipo) REFERENCES equipos(id_equipos)\r\n"
				+ "ON UPDATE CASCADE ON DELETE CASCADE,\r\n"
				+ "dni VARCHAR(8),\r\n"
				+ "KEY (dni),\r\n"
				+ "FOREIGN KEY (dni) REFERENCES investigadores(dni)\r\n"
				+ "ON UPDATE CASCADE ON DELETE CASCADE\r\n"
				+ ");");
		
		ConnectionDB.executeQuery("INSERT INTO facultad(nombre) VALUES\r\n"
				+ "(\"Dudeversity\"),\r\n"
				+ "(\"Wolong\"),\r\n"
				+ "(\"Nasa\"),\r\n"
				+ "(\"Oxford\"),\r\n"
				+ "(\"Dudeversity2\"),\r\n"
				+ "(\"Wolong2\"),\r\n"
				+ "(\"Nasa2\"),\r\n"
				+ "(\"Oxford2\"),\r\n"
				+ "(\"Dudeversity3\"),\r\n"
				+ "(\"Wolong3\");");
		ConnectionDB.executeQuery("INSERT INTO investigadores(dni,nombre_apellidos,id_facultad) VALUES\r\n"
				+ "(\"12345678\",\"Jose\",1),\r\n"
				+ "(\"12095824 \",\"Cristina\",3),\r\n"
				+ "(\"30340459 \",\"Juan\",1),\r\n"
				+ "(\"80982838 \",\"Juanjo\",2),\r\n"
				+ "(\"99328846 \",\"Damaris\",1),\r\n"
				+ "(\"75351499 \",\"Jimena\",1),\r\n"
				+ "(\"64331320 \",\"Paula\",2),\r\n"
				+ "(\"23257790 \",\"Ramon\",1),\r\n"
				+ "(\"47266291 \",\"Paco\",1),\r\n"
				+ "(\"61855715 \",\"Milena\",1);");
		ConnectionDB.executeQuery("INSERT INTO equipos(id_equipos,nombre,id_facultad) VALUES\r\n"
				+ "('JHOP',\"JHOPE\",1),\r\n"
				+ "('JIMI',\"JIMIN\",2),\r\n"
				+ "('RMEN',\"RMENETERPRISES\",3),\r\n"
				+ "('SUGA',\"SUGACORP\",1),\r\n"
				+ "('JINA',\"JINAIR\",1),\r\n"
				+ "('JORD',\"JORDANADIDAS\",1),\r\n"
				+ "('TAET',\"TAETAE\",2),\r\n"
				+ "('SAMS',\"SAMSUNG\",2),\r\n"
				+ "('TAIW',\"TAIWAN\",3),\r\n"
				+ "('CHIN',\"CHINAINC\",3),\r\n"
				+ "('JOHN',\"JOHNCOOK\",4);");
		ConnectionDB.executeQuery("INSERT INTO reserva(dni,equipo,comienzo,fin) VALUES\r\n"
				+ "('12345678',\"JHOP\",'2020-12-31 23:59:59' , '2022-12-31 23:59:59');");
		
	}

}
