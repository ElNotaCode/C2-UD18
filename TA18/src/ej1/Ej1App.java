package ej1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ej1App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://192.168.1.140:3306?useTimezone=true&serverTimezone=UTC","remote","Reus_2022");
			System.out.println("Conexion establecida");
		} catch (SQLException |ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("No se ha podido conectar");
			System.out.println(e);
		}

	}

}
