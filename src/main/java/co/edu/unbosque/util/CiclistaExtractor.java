package co.edu.unbosque.util;

import javax.swing.table.TableModel;
import co.edu.unbosque.model.Ciclista;

public class CiclistaExtractor {

    public static Ciclista desdeModelo(int fila, TableModel modelo) {
        if (fila < 0 || fila >= modelo.getRowCount()) return null;

        String nombre = (String) modelo.getValueAt(fila, 0);
        String id = (String) modelo.getValueAt(fila, 1);
        String tipo = (String) modelo.getValueAt(fila, 2);
        String genero = (String) modelo.getValueAt(fila, 3);
        String correo = (String) modelo.getValueAt(fila, 4);
        String usuario = (String) modelo.getValueAt(fila, 5);

        return new Ciclista(nombre, id, genero, correo, usuario, "", tipo, 0, 0);
    }
}