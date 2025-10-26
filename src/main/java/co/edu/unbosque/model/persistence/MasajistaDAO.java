package co.edu.unbosque.model.persistence;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Optional;
import co.edu.unbosque.model.Masajista;
/**
 * La clase MasajistaDAO proporciona funcionalidades para realizar operaciones CRUD
 * (crear, leer, actualizar, eliminar) en objetos de tipo Masajista en un almacenamiento
 * persistente.
 */
public class MasajistaDAO implements RegistroDAO<Masajista, String> {
	/**
     * Una constante que representa el nombre del archivo donde se almacenan los datos de los masajistas.
     */
	private static final String ARCHIVO_MASAJISTAS = "Masajistas.dat";
	/**
     * Una lista de objetos Masajista que almacena los masajistas cargados en memoria durante la ejecución del programa.
     */
	private ArrayList<Masajista>listaMasajistas;
	
	/**
     * Agrega un nuevo masajista al archivo de datos.
     *
     * @param m El masajista que se va a agregar.
     * @throws IOException si ocurre un error durante la escritura en el archivo.
     */
	@Override
	public void crear(Masajista m) throws IOException {
		FileManager fm = new FileManager();
		 // Leer los ciclistas existentes del archivo
	    ArrayList<Masajista> masajistas = fm.leerMasajistas("Masajistas.dat");
	    // Agregar el nuevo ciclistas a la lista
	    masajistas.add(m);
	    // Escribir todos los ciclistas (incluyendo el nuevo) de nuevo en el archivo
	    fm.escribirMasajistasBinario("Masajistas.dat", masajistas);
		
	}
	@Override
	public void actualizar(String entidad, Masajista entidadActualizada) throws IOException {
		for(Masajista m : listaMasajistas) {
			if(m.getId().equals(entidad)) {
				m.setExperiencia(entidadActualizada.getExperiencia());
				break;
			}
		}	
	}

	public void eliminar(String id) {
        try {
            // Abre un flujo de lectura y escritura para el archivo binario
            RandomAccessFile file = new RandomAccessFile(ARCHIVO_MASAJISTAS, "rw");
            boolean encontrado = false;
            
            while (file.getFilePointer() < file.length()) {
                long currentPosition = file.getFilePointer();
                
                // Lee el ID del ciclista en la posición actual
                String currentId = file.readUTF();
                
                // Compara el ID leído con el ID proporcionado
                if (currentId.equals(id)) {
                    encontrado = true;
                    // Establece el puntero en la posición actual para sobrescribir el registro eliminado
                    file.seek(currentPosition);
                    // Sobrescribe el ID con un valor nulo para indicar que el registro ha sido eliminado
                    file.writeUTF(""); // ID
                    file.writeUTF(""); // Nombre
                    break;
                } else {
                    // Si el ID no coincide, salta los datos restantes del registro
                    file.readUTF(); // Nombre
                    file.readInt(); // Edad
                    // Aquí saltarías los demás datos que estén almacenados
                }
            }
            
            file.close();
            
            if (!encontrado) {
                System.out.println("Masajista no encontrado.");
            }
        } catch (IOException e) {
            System.out.println("Error al intentar eliminar el masajista.");
            e.printStackTrace();
        }
    }
	@Override
	public Optional<Masajista> consultarPorId(String idEntidad) {
		return listaMasajistas.stream().filter(masajista -> masajista.getId().equals(idEntidad)).findFirst();
	}	

}
