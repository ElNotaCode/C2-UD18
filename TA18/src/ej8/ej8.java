package ej8;

import java.sql.Connection;

import utils.ConnectionDB;

public class ej8 {
	
	//la hacemos static para poder usarla desde los metodos
	static Connection conexion = null;

	public static void main(String[] args) {
	
	conexion = ConnectionDB.crearConexion("192.168.1.140","remote","Reus_2022");

	ConnectionDB.dropIfExistsDB("cientificos");
	ConnectionDB.createDB("cientificos");
	ConnectionDB.useDB("cientificos");
	
	//ConnectionDB.executeQuery("");
	ConnectionDB.executeQuery("CREATE TABLE productos(id_producto INT AUTO_INCREMENT PRIMARY KEY,\r\n"
			+ "nombre NVARCHAR(100),\r\n"
			+ "precio INT\r\n"
			+ ");");
	ConnectionDB.executeQuery("CREATE TABLE cajeros(id_cajero INT AUTO_INCREMENT PRIMARY KEY,\r\n"
			+ "nombre_apellidos NVARCHAR(255)\r\n"
			+ ");");
	ConnectionDB.executeQuery("CREATE TABLE maquinas_registradoras(id_maquina INT AUTO_INCREMENT PRIMARY KEY,\r\n"
			+ "piso INT\r\n"
			+ ");");
	ConnectionDB.executeQuery("CREATE TABLE venta(id_venta INT AUTO_INCREMENT PRIMARY KEY,\r\n"
			+ "cajero INT,\r\n"
			+ "KEY (cajero),\r\n"
			+ "FOREIGN KEY (cajero) REFERENCES cajeros(id_cajero)\r\n"
			+ "ON UPDATE CASCADE ON DELETE CASCADE,\r\n"
			+ "maquina INT,\r\n"
			+ "KEY (maquina),\r\n"
			+ "FOREIGN KEY (maquina) REFERENCES maquinas_registradoras(id_maquina)\r\n"
			+ "ON UPDATE CASCADE ON DELETE CASCADE,\r\n"
			+ "producto INT,\r\n"
			+ "KEY (producto),\r\n"
			+ "FOREIGN KEY (producto) REFERENCES productos(id_producto)\r\n"
			+ "ON UPDATE CASCADE ON DELETE CASCADE\r\n"
			+ ");");
}

}
