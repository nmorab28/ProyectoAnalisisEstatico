package co.edu.unbosque.view;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PanelTabla extends JPanel {
    private JTable tablaUsuarios;
    private DefaultTableModel datos;
    private JLabel fondoVentana;
    private JButton btnGenerarPdf, verPersonas, btnSalir, btnEliminar;

    public PanelTabla(ActionListener listener) {
        setLayout(null);

        btnSalir = new JButton();
		ImageIcon botonSalir = new ImageIcon("Imagenes/exit.png");
		btnSalir.addActionListener(listener);
		btnSalir.setBounds(880, 40, 75,65);
		btnSalir.setContentAreaFilled(false);
		btnSalir.setBorder(null);
		btnSalir.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSalir.setIcon(new ImageIcon(botonSalir.getImage().getScaledInstance(btnSalir.getWidth(), btnSalir.getHeight(), Image.SCALE_SMOOTH)));
		btnSalir.setActionCommand("BTN_SALIR");
		add(btnSalir);

		btnEliminar = new JButton();
        ImageIcon delete = new ImageIcon("Imagenes/eliminar.png");
        btnEliminar.setBounds(520, 500, 230, 36);
        btnEliminar.setContentAreaFilled(false);
        btnEliminar.setBorder(null);
        btnEliminar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnEliminar.setIcon(new ImageIcon(delete.getImage().getScaledInstance(btnEliminar.getWidth(),
        		btnEliminar.getHeight(), Image.SCALE_SMOOTH)));
        btnEliminar.setActionCommand("BOTON_ELIMINAR");
        btnEliminar.addActionListener(listener);
        add(btnEliminar);
        
        // Botón para generar PDF
        btnGenerarPdf = new JButton();
        ImageIcon pdf = new ImageIcon("Imagenes/generarpdf.png");
        btnGenerarPdf.setBounds(200, 500, 238, 36);
        btnGenerarPdf.setContentAreaFilled(false);
        btnGenerarPdf.setBorder(null);
        btnGenerarPdf.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnGenerarPdf.setIcon(new ImageIcon(pdf.getImage().getScaledInstance(btnGenerarPdf.getWidth(),
                btnGenerarPdf.getHeight(), Image.SCALE_SMOOTH)));
        btnGenerarPdf.setActionCommand("BOTON_PDF");
        btnGenerarPdf.addActionListener(listener);
        add(btnGenerarPdf);

        // Botón para ver lista de personas
        verPersonas = new JButton("Ver lista personas");
        verPersonas.setActionCommand("MOSTRAR_USUARIOS");
        verPersonas.addActionListener(listener);
        verPersonas.setBounds(100, 45, 150, 30); // Ajusta el tamaño del botón según sea necesario
        add(verPersonas);

        // Configuración de la tabla
        datos = new DefaultTableModel();
        datos.addColumn("Nombre");
        datos.addColumn("ID");
        datos.addColumn("Tipo");
        datos.addColumn("Genero");
        datos.addColumn("Correo");
        datos.addColumn("Usuario");
        datos.addColumn("Experiencia");

        setTablaUsuarios(new JTable(datos));
        JScrollPane scrollPane = new JScrollPane(getTablaUsuarios());
        scrollPane.setBounds(170, 180, 650, 300);
        add(scrollPane);

        // Fondo de la ventana
        fondoVentana = new JLabel();
        fondoVentana.setSize(1000, 580);
        ImageIcon icono = new ImageIcon("Imagenes/sistemver.png");
        Image imagen = icono.getImage();
        imagen = imagen.getScaledInstance(fondoVentana.getWidth(), fondoVentana.getHeight(), Image.SCALE_SMOOTH);
        fondoVentana.setIcon(new ImageIcon(imagen));
        add(fondoVentana);
    }

    public DefaultTableModel getTableModel() {
        return datos;
    }

	public JTable getTablaUsuarios() {
		return tablaUsuarios;
	}

	public void setTablaUsuarios(JTable tablaUsuarios) {
		this.tablaUsuarios = tablaUsuarios;
	}
}