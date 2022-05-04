package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

	static String IP = "192.168.1.140";
	static String USER = "remote";
	static String PASSWORD = "Reus_2022";
	private static Connection conexion = null;
	
	//crear conexiones
	public static Connection crearConexion(String ip,String user,String password) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://"+ ip +":3306?useTimezone=true&serverTimezone=UTC,"+ password +"," + user);
			System.out.println("Conexion establecida");
			return conexion;
		} catch (SQLException |ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("No se ha podido conectar");
			System.out.println(e);
			return null;
		}
		
		
	}
	
	//Por defecto con mi ip, user y pass
	public static Connection crearConexion() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://"+ IP +":3306?useTimezone=true&serverTimezone=UTC,"+ PASSWORD +"," + USER);
			System.out.println("Conexion establecida");
			return conexion;
		} catch (SQLException |ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("No se ha podido conectar");
			System.out.println(e);
			return null;
		}
		
		
	}

	//cerrar conexion
	void closeConnection() {
		try {
			conexion.close();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}

}
