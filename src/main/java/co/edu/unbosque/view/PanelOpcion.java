package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class PanelOpcion extends JPanel {
	private JLabel fondoVentana;
	private JButton btnRegistrar;
	private JTextField txtNombre, txtPais;
	private JTable table;
	private DefaultTableModel datos;
	private JButton btnActualizar;

	public PanelOpcion(ActionListener listener) {
		setLayout(null);

		txtNombre = new JTextField();
		txtNombre.setBorder(BorderFactory.createEmptyBorder());
		txtNombre.setOpaque(false);
		txtNombre.setBackground(new Color(0, 0, 0, 0));
		txtNombre.setForeground(Color.BLACK);
		txtNombre.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		txtNombre.setBounds(300, 115, 225, 35);
		add(txtNombre);

		txtPais = new JTextField();
		txtPais.setBorder(BorderFactory.createEmptyBorder());
		txtPais.setOpaque(false);
		txtPais.setBackground(new Color(0, 0, 0, 0));
		txtPais.setForeground(Color.BLACK);
		txtPais.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		txtPais.setBounds(800, 115, 225, 35);
		add(txtPais);

		btnRegistrar = new JButton();
		ImageIcon flechita = new ImageIcon("Imagenes/Regis.png");
		btnRegistrar.setBounds(900, 500, 50, 50);
		btnRegistrar.setContentAreaFilled(false);
		btnRegistrar.setBorder(null);
		btnRegistrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnRegistrar.setIcon(new ImageIcon(flechita.getImage().getScaledInstance(btnRegistrar.getWidth(),
				btnRegistrar.getHeight(), Image.SCALE_SMOOTH)));
		btnRegistrar.setActionCommand("BOTON_REGISTRO");
		btnRegistrar.addActionListener(listener);
		add(btnRegistrar);


		btnActualizar = new JButton("Mostrar usuarios registrados");
		btnActualizar.setActionCommand("ACTUALIZAR");
		btnActualizar.addActionListener(listener);
		btnActualizar.setBounds(540, 550, 200, 30);
		add(btnActualizar);

		datos = new DefaultTableModel();
		datos.addColumn("Nombre");
		datos.addColumn("ID");
		datos.addColumn("Tipo");
		datos.addColumn("Genero");
		datos.addColumn("Correo");
		datos.addColumn("Usuario");
		datos.addColumn("Experiencia");

		table = new JTable(datos);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(100, 180, 800, 300);
		add(scrollPane);
	        
		fondoVentana = new JLabel();
		fondoVentana.setSize(1000, 640);
		ImageIcon icono = new ImageIcon("Imagenes/escuadra.png");
		Image imagen = icono.getImage();
		imagen = imagen.getScaledInstance(fondoVentana.getWidth(), fondoVentana.getHeight(), Image.SCALE_SMOOTH);
		fondoVentana.setIcon(new ImageIcon(imagen));
		add(fondoVentana);

	}

	public DefaultTableModel getTableModel() {
        return datos;
    }

    public int[] getSelectedRows() {
        return table.getSelectedRows();
    }

    public Object[] getRowData(int row) {
        Object[] rowData = new Object[table.getColumnCount()];
        for (int i = 0; i < table.getColumnCount(); i++) {
            rowData[i] = table.getValueAt(row, i);
        }
        return rowData;
    }

    public String getTxtNombre() {
        return txtNombre.getText();
    }

    public String getTxtPais() {
        return txtPais.getText();
    }
}