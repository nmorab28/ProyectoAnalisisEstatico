package co.edu.unbosque.model.persistence;

import java.io.*;
import java.util.ArrayList;
import java.util.Properties;

import co.edu.unbosque.model.Ciclista;
import co.edu.unbosque.model.Director;
import co.edu.unbosque.model.Escuadra;
import co.edu.unbosque.model.Etapa;
import co.edu.unbosque.model.Masajista;

/**
 * La clase FileManager proporciona métodos para escribir y leer objetos desde archivos binarios,
 * así como para leer archivos de propiedades.
 */
public class FileManager {

    /**
     * Escribe una lista de ciclistas en un archivo binario.
     * 
     * @param nombreArchivo El nombre del archivo donde se escribirán los ciclistas.
     * @param ciclistas La lista de ciclistas a escribir.
     * @throws IOException Si ocurre un error de entrada/salida al escribir en el archivo.
     */
	public void escribirCiclistaBinario(String nombreArchivo, ArrayList<Ciclista> ciclistas) throws IOException {
		FileOutputStream outputStream = new FileOutputStream(new File(nombreArchivo));
		ObjectOutputStream escritor = new ObjectOutputStream(outputStream);
		// Escribir toda la lista de ciclistas en el archivo
		for (Ciclista ciclista : ciclistas) {
			escritor.writeObject(ciclista);
		}
		escritor.close();
		outputStream.close();
	}

	/**
     * Escribe una lista de escuadras en un archivo binario.
     * 
     * @param nombreArchivo El nombre del archivo donde se escribirán las escuadras.
     * @param escuadras La lista de escuadras a escribir.
     * @throws IOException Si ocurre un error de entrada/salida al escribir en el archivo.
     */
	public void escribirEscuadrasBinario(String nombreArchivo, ArrayList<Escuadra> escuadras) throws IOException {
		FileOutputStream outputStream = new FileOutputStream(new File(nombreArchivo));
		ObjectOutputStream escritor = new ObjectOutputStream(outputStream);
		// Escribir toda la lista de escuadras en el archivo
		for (Escuadra escuadra : escuadras) {
			escritor.writeObject(escuadra);
		}
		escritor.close();
		outputStream.close();
	}
	
	/**
     * Escribe una lista de etapas en un archivo binario.
     * 
     * @param nombreArchivo El nombre del archivo donde se escribirán las etapas.
     * @param etapas La lista de etapas a escribir.
     * @throws IOException Si ocurre un error de entrada/salida al escribir en el archivo.
     */
	public void escribirSimulacionBinario(String nombreArchivo, ArrayList<Etapa> etapas) throws IOException {
		FileOutputStream outputStream = new FileOutputStream(new File(nombreArchivo));
		ObjectOutputStream escritor = new ObjectOutputStream(outputStream);
		// Escribir toda la lista de escuadras en el archivo
		for (Etapa etapa : etapas) {
			escritor.writeObject(etapa);
		}
		escritor.close();
		outputStream.close();
	}
	
	/**
     * Escribe una lista de masajistas en un archivo binario.
     * 
     * @param nombreArchivo El nombre del archivo donde se escribirán los masajistas.
     * @param masajistas La lista de masajistas a escribir.
     * @throws IOException Si ocurre un error de entrada/salida al escribir en el archivo.
     */

	public void escribirMasajistasBinario(String nombreArchivo, ArrayList<Masajista> masajistas) throws IOException {
		FileOutputStream outputStream = new FileOutputStream(new File(nombreArchivo));
		ObjectOutputStream escritor = new ObjectOutputStream(outputStream);
		// Escribir toda la lista de escuadras en el archivo
		for (Masajista masajista : masajistas) {
			escritor.writeObject(masajista);
		}
		escritor.close();
		outputStream.close();
	}

	
	/**
     * Escribe una lista de directores en un archivo binario.
     * 
     * @param nombreArchivo El nombre del archivo donde se escribirán los directores.
     * @param directores La lista de directores a escribir.
     * @throws IOException Si ocurre un error de entrada/salida al escribir en el archivo.
     */
	public void escribirDirectorBinario(String nombreArchivo, ArrayList<Director> directores) throws IOException {
		FileOutputStream outputStream = new FileOutputStream(new File(nombreArchivo));
		ObjectOutputStream escritor = new ObjectOutputStream(outputStream);
		// Escribir toda la lista de escuadras en el archivo
		for (Director director : directores) {
			escritor.writeObject(director);
		}
		escritor.close();
		outputStream.close();
	}

	 /**
     * Lee una lista de ciclistas desde un archivo binario.
     * 
     * @param nombreArchivo El nombre del archivo desde donde se leerán los ciclistas.
     * @return Una lista de ciclistas leída desde el archivo.
     */
	public ArrayList<Ciclista> leerCiclistas(String nombreArchivo) {
		// Creamos un objeto de tipo ArrayList para almacenar los participantes leídos
		ArrayList<Ciclista> ciclistas = new ArrayList<>();

		// Creamos un objeto de tipo File para representar el archivo
		File archivo = new File(nombreArchivo);

		try {
			// Creamos un FileInputStream para leer el archivo
			FileInputStream fis = new FileInputStream(archivo);

			// Creamos un ObjectInputStream para leer objetos desde el FileInputStream
			ObjectInputStream leer = new ObjectInputStream(fis);

			// Leemos los objetos uno por uno hasta que no haya más en el archivo
			while (fis.available() > 0) {
				// Leemos un objeto ciclista del archivo y lo añadimos a la lista
				Ciclista ciclistaLeido = (Ciclista) leer.readObject();
				ciclistas.add(ciclistaLeido);
			}

			// Cerramos el ObjectInputStream y el FileInputStream
			leer.close();
			fis.close();

		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error al leer el archivo: " + e.getMessage());
		}

		// Devolvemos la lista de participantes leída del archivo
		return ciclistas;
	}

	 /**
     * Lee una lista de escuadras desde un archivo binario.
     * 
     * @param nombreArchivo El nombre del archivo desde donde se leerán las escuadras.
     * @return Una lista de escuadras leída desde el archivo.
     */

	public ArrayList<Escuadra> leerEscuadras(String nombreArchivo) {
		// Creamos un objeto de tipo ArrayList para almacenar los participantes leídos
		ArrayList<Escuadra> escuadras = new ArrayList<>();

		// Creamos un objeto de tipo File para representar el archivo
		File archivo = new File(nombreArchivo);

		try {
			// Creamos un FileInputStream para leer el archivo
			FileInputStream fis = new FileInputStream(archivo);

			// Creamos un ObjectInputStream para leer objetos desde el FileInputStream
			ObjectInputStream leer = new ObjectInputStream(fis);

			// Leemos los objetos uno por uno hasta que no haya más en el archivo
			while (fis.available() > 0) {
				Escuadra escuadraLeida = (Escuadra) leer.readObject();
				escuadras.add(escuadraLeida);
			}

			// Cerramos el ObjectInputStream y el FileInputStream
			leer.close();
			fis.close();

		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error al leer el archivo: " + e.getMessage());
		}

		return escuadras;
	}

	 /**
     * Lee una lista de etapas desde un archivo binario.
     * 
     * @param nombreArchivo El nombre del archivo desde donde se leerán las etapas.
     * @return Una lista de etapas leída desde el archivo.
     */
	public ArrayList<Etapa> leerEtapas(String nombreArchivo) {
		// Creamos un objeto de tipo ArrayList para almacenar los participantes leídos
		ArrayList<Etapa> etapas = new ArrayList<>();

		// Creamos un objeto de tipo File para representar el archivo
		File archivo = new File(nombreArchivo);

		try {
			// Creamos un FileInputStream para leer el archivo
			FileInputStream fis = new FileInputStream(archivo);

			// Creamos un ObjectInputStream para leer objetos desde el FileInputStream
			ObjectInputStream leer = new ObjectInputStream(fis);

			// Leemos los objetos uno por uno hasta que no haya más en el archivo
			while (fis.available() > 0) {
				// Leemos un objeto ciclista del archivo y lo añadimos a la lista
				Etapa etapaLeida = (Etapa) leer.readObject();
				etapas.add(etapaLeida);
			}

			// Cerramos el ObjectInputStream y el FileInputStream
			leer.close();
			fis.close();

		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error al leer el archivo: " + e.getMessage());
		}

		// Devolvemos la lista de participantes leída del archivo
		return etapas;
	}

	  /**
     * Lee una lista de masajistas desde un archivo binario.
     * 
     * @param nombreArchivo El nombre del archivo desde donde se leerán los masajistas.
     * @return Una lista de masajistas leída desde el archivo.
     */
	public ArrayList<Masajista> leerMasajistas(String nombreArchivo) {
		// Creamos un objeto de tipo ArrayList para almacenar los participantes leídos
		ArrayList<Masajista> masajistas = new ArrayList<>();

		// Creamos un objeto de tipo File para representar el archivo
		File archivo = new File(nombreArchivo);

		try {
			// Creamos un FileInputStream para leer el archivo
			FileInputStream fis = new FileInputStream(archivo);

			// Creamos un ObjectInputStream para leer objetos desde el FileInputStream
			ObjectInputStream leer = new ObjectInputStream(fis);

			// Leemos los objetos uno por uno hasta que no haya más en el archivo
			while (fis.available() > 0) {
				// Leemos un objeto ciclista del archivo y lo añadimos a la lista
				Masajista masajistaLeido = (Masajista) leer.readObject();
				masajistas.add(masajistaLeido);
			}

			// Cerramos el ObjectInputStream y el FileInputStream
			leer.close();
			fis.close();

		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error al leer el archivo: " + e.getMessage());
		}

		// Devolvemos la lista de participantes leída del archivo
		return masajistas;

	}
	
	/**
     * Lee una lista de directores desde un archivo binario.
     * 
     * @param nombreArchivo El nombre del archivo desde donde se leerán los directores.
     * @return Una lista de director
     * */

	public ArrayList<Director> leerDirectores(String nombreArchivo) {
		// Creamos un objeto de tipo ArrayList para almacenar los participantes leídos
		ArrayList<Director> directores = new ArrayList<>();

		// Creamos un objeto de tipo File para representar el archivo
		File archivo = new File(nombreArchivo);

		try {
			// Creamos un FileInputStream para leer el archivo
			FileInputStream fis = new FileInputStream(archivo);

			// Creamos un ObjectInputStream para leer objetos desde el FileInputStream
			ObjectInputStream leer = new ObjectInputStream(fis);

			// Leemos los objetos uno por uno hasta que no haya más en el archivo
			while (fis.available() > 0) {
				// Leemos un objeto ciclista del archivo y lo añadimos a la lista
				Director directorLeido = (Director) leer.readObject();
				directores.add(directorLeido);
			}

			// Cerramos el ObjectInputStream y el FileInputStream
			leer.close();
			fis.close();

		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error al leer el archivo: " + e.getMessage());
		}

		// Devolvemos la lista de participantes leída del archivo
		return directores;
	}

    public static Properties leerArchivoProperties() throws IOException {
        Properties properties = new Properties();
        try (InputStream input = FileManager.class.getClassLoader().getResourceAsStream("ISUCI.properties")) {
            if (input == null) {
                throw new FileNotFoundException("No se encontró el archivo ISUCI.properties en src/main/resources");
            }
            properties.load(input);
        }
        return properties;
    }
}