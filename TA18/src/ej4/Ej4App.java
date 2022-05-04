package ej4;

import java.sql.Connection;

import utils.ConnectionDB;

public class Ej4App {
	
	//la hacemos static para poder usarla desde los metodos
		static Connection conexion = null;

		public static void main(String[] args) {
			
			conexion = ConnectionDB.crearConexion("192.168.1.140","remote","Reus_2022");

			ConnectionDB.dropIfExistsDB("cine");
			ConnectionDB.createDB("cine");
			ConnectionDB.useDB("cine");
			
			//ConnectionDB.executeQuery("");
			ConnectionDB.executeQuery("INSERT INTO peliculas(nombre,calificacion_edad) VALUES\r\n"
					+ "(\"The Batman\", 18),\r\n"
					+ "(\"Estopa la pelicula\", 12),\r\n"
					+ "(\"Marselo, la venganza de los caidos\",16),\r\n"
					+ "(\"La plaza\",16),\r\n"
					+ "(\"Gran torino\", 12),\r\n"
					+ "(\"Aventuras Robots\",3),\r\n"
					+ "(\"Star Wars: Jar Jar Returns\", 7),\r\n"
					+ "(\"Warhammer40k: Wolves at the gate\",12),\r\n"
					+ "(\"8 hour long SQL tutorial Part 2\",3),\r\n"
					+ "(\"Jojo Bizarre Adventure: Paella is forever\",18);");
			ConnectionDB.executeQuery("INSERT INTO salas(nombre,pelicula) VALUES\r\n"
					+ "(\"Sala 1\", NULL),\r\n"
					+ "(\"Sala 2\",13),\r\n"
					+ "(\"Sala 3\",21),\r\n"
					+ "(\"Sala 4\",20),\r\n"
					+ "(\"Sala 5\",19),\r\n"
					+ "(\"Sala 6\",19),\r\n"
					+ "(\"Sala 7\",NULL),\r\n"
					+ "(\"Sala 8\",NULL),\r\n"
					+ "(\"Sala 9\",17),\r\n"
					+ "(\"Sala 10\",14);");
			
			ConnectionDB.executeQuery("CREATE TABLE peliculas(id_pelicula INT AUTO_INCREMENT PRIMARY KEY,\r\n"
					+ "nombre NVARCHAR(100),\r\n"
					+ "calificacion_edad INT DEFAULT 18\r\n"
					+ ");");
			ConnectionDB.executeQuery("CREATE TABLE salas(id_pelicula INT AUTO_INCREMENT PRIMARY KEY,\r\n"
					+ "nombre NVARCHAR(100),\r\n"
					+ "pelicula INT,\r\n"
					+ "KEY (pelicula),\r\n"
					+ "FOREIGN KEY (pelicula) REFERENCES peliculas(id_pelicula)\r\n"
					+ "ON UPDATE CASCADE ON DELETE CASCADE\r\n"
					+ ");");
			
		}

}
