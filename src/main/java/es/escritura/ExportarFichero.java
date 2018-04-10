package es.escritura;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ExportarFichero {

	public static void main(String[] args) {
		String nombreFichero = "prueba.txt";
		try {
			FileWriter writer = new FileWriter(nombreFichero);
			PrintWriter pw = new PrintWriter(writer);
			pw.println("Esto es una prueba");
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
