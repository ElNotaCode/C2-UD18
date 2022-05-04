package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class ConnectionDB {

	//Autor Eloy Martorell 04/05/2022
	private static String IP = "192.168.1.140";
	private static String USER = "remote";
	private static String PASSWORD = "Reus_2022";
	private static Connection conexion = null;
	private static Statement statement = null;
	
	//crear conexiones
	public static Connection crearConexion(String ip,String user,String password) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306?useTimezone=true&serverTimezone=UTC", user, password);
			System.out.println("Conexion establecida.");
			statement = conexion.createStatement();
			return conexion;
		} catch (SQLException |ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("No se ha podido conectar.");
			System.out.println(e);
			return null;
		}
		
	}
	
	//metodos en orden de procedimiento (crear db, tablas y finalmente cerrar...)
	//crear base de datos
	public static void createDB(String name) {
		try {
			String query = "CREATE DATABASE " + name;
			statement.executeUpdate(query);
			System.out.println("DB "+ name +" creada.");
		} catch (SQLException e) {
			// ERROR
			System.out.println(e.getMessage());
			System.out.println("No se ha podido crear la base de datos.");
		}
	}
	
	//borrar if exists
	public static void dropIfExistsDB(String name) {
		try {
			String query = "DROP DATABASE IF EXISTS " + name;
			statement.executeUpdate(query);
			System.out.println("DB "+ name +" destruida.");
		} catch (SQLException e) {
			// ERROR
			System.out.println(e.getMessage());
			System.out.println("No se ha podido destruir la base de datos.");
		}
	}
	
	//borrar base de datos
	public static void dropDB(String name) {
		try {
			String query = "DROP DATABASE " + name;
			statement.executeUpdate(query);
			System.out.println("DB "+ name +" destruida.");
		} catch (SQLException e) {
			// ERROR
			System.out.println(e.getMessage());
			System.out.println("No se ha podido destruir la base de datos.");
		}
	}
	
	//use db
	public static void useDB(String name) {
		try {
			String query = "USE " + name;
			statement.executeUpdate(query);
			System.out.println("Apuntando a la base de datos " + name + ".");
		} catch (SQLException e) {
			// ERROR
			System.out.println(e.getMessage());
			System.out.println("No se ha podido apuntar a la base de datos.");
		}
	}
	
	//borrar tabla
	public static void dropTableIfExists(String name) {
		try {
			String query = "DROP TABLE IF EXISTS" + name;
			statement.executeUpdate(query);
			System.out.println("Tabla " + name + " destruida.");
		} catch (SQLException e) {
			// ERROR
			System.out.println(e.getMessage());
			System.out.println("No se ha podido destruir la tabla.");
		}
	}
	
	//borrar tabla
	public static void dropTable(String name) {
		try {
			String query = "DROP TABLE " + name;
			statement.executeUpdate(query);
			System.out.println("Tabla "+ name +" destruida.");
		} catch (SQLException e) {
			// ERROR
			System.out.println(e.getMessage());
			System.out.println("No se ha podido destruir la tabla.");
		}
	}
	
	//ejecutar query (para tablas y values)
	//metodos para crear tablas
	public static void executeQuery(String query) {
		/*CREATE TABLE fabricantes(codigo_fabricante INT AUTO_INCREMENT PRIMARY KEY,
		nombre NVARCHAR(100)
		);*/
		try {
			Statement statement = conexion.createStatement();
			statement.execute(query);
			System.out.println("Tabla fabricantes creada.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			System.out.println("Error creando la tabla.");
		}
		
		
	}

	//cerrar conexion
	public static void closeConnection() {
		try {
			conexion.close();
			System.out.println("Conexión cerrada.");
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error al cerrar la conexión.");
		}
	}

}
