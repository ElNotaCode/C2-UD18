package ej2;

import java.sql.Connection;

import utils.ConnectionDB;

public class Ej2App {
	
	//la hacemos static para poder usarla desde los metodos
		static Connection conexion = null;

	public static void main(String[] args) {

		conexion = ConnectionDB.crearConexion("192.168.1.140","remote","Reus_2022");
		
		ConnectionDB.dropIfExistsDB("empleados");
		ConnectionDB.createDB("empleados");
		ConnectionDB.useDB("empleados");
		
		ConnectionDB.executeQuery("CREATE TABLE departamentos(codigo INT AUTO_INCREMENT PRIMARY KEY,\r\n"
				+ "nombre VARCHAR(60),\r\n"
				+ "presupuesto INT DEFAULT 0\r\n"
				+ ");");
		ConnectionDB.executeQuery("CREATE TABLE empleados(dni VARCHARACTER(8) NOT NULL PRIMARY KEY,\r\n"
				+ "nombre NVARCHAR(100),\r\n"
				+ "apellidos NVARCHAR(255),\r\n"
				+ "departamento INT NOT NULL,\r\n"
				+ "KEY (departamento),\r\n"
				+ "FOREIGN KEY (departamento) REFERENCES departamentos(codigo)\r\n"
				+ "ON UPDATE CASCADE ON DELETE CASCADE\r\n"
				+ ");");
		
		ConnectionDB.executeQuery("INSERT INTO departamentos(nombre,presupuesto) VALUES\r\n"
				+ "(\"MARKETING\",20),\r\n"
				+ "(\"FINANZAS\",5000),\r\n"
				+ "(\"COMERCIALES\",30000),\r\n"
				+ "(\"ASUNTOS INTERNOS\",1000000),\r\n"
				+ "(\"DIRECCION\",300);");
		ConnectionDB.executeQuery("INSERT INTO empleados(dni,nombre,apellidos,departamento) VALUES\r\n"
				+ "(\"00120954 \",\"Kim\",\"Jun\",1),\r\n"
				+ "(\"09908109 \",\"Jon\",\"Koock\",2),\r\n"
				+ "(\"23663041 \",\"Park\",\"Jimin\",2),\r\n"
				+ "(\"56374870 \",\"Kim\",\"Tae\",2),\r\n"
				+ "(\"97818373 \",\"Min\",\"Suga\",2),\r\n"
				+ "(\"05890313 \",\"Jin\",\"Kim\",3),\r\n"
				+ "(\"25037474 \",\"Hobby\",\"Jeon\",3),\r\n"
				+ "(\"92262195 \",\"Fox\",\"Mulder\",4),\r\n"
				+ "(\"86860699 \",\"Eloi\",\"Martorell\",5),\r\n"
				+ "(\"34060177 \",\"Cristina\",\"Castany\",5);");
		
	}

}
