package co.edu.unbosque.view;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.Ciclista;
import co.edu.unbosque.model.Escuadra;

public class PanelSemillano extends JPanel {
	private JProgressBar progressBar;
	private SwingWorker<Void, Void> worker;
	private int maxValue;
	private JButton start, btnSalir;
	private JComboBox<Escuadra> escuadraComboBox1;
	private JComboBox<Escuadra> escuadraComboBox2;
	private JComboBox<Escuadra> escuadraComboBox3;
	private JComboBox<Escuadra> escuadraComboBox4;
	private JTable table;
	private DefaultTableModel tableModel;
	private JLabel fondoVentana;

	public PanelSemillano(ActionListener listener) {
		setLayout(null);

		escuadraComboBox1 = new JComboBox<>();
		escuadraComboBox1.setBounds(10, 375, 200, 30); // Usar coordenadas absolutas
		add(escuadraComboBox1);

		escuadraComboBox2 = new JComboBox<>();
		escuadraComboBox2.setBounds(220, 375, 200, 30); // Usar coordenadas absolutas
		add(escuadraComboBox2);

		escuadraComboBox3 = new JComboBox<>();
		escuadraComboBox3.setBounds(220, 300, 200, 30); // Usar coordenadas absolutas
		add(escuadraComboBox3);

		escuadraComboBox4 = new JComboBox<>();
		escuadraComboBox4.setBounds(10, 300, 200, 30); // Usar coordenadas absolutas
		add(escuadraComboBox4);

		start = new JButton("Start");
		start.setBounds(10, 210, 100, 30); // Usar coordenadas absolutas
		start.addActionListener(e -> startProgress());
		add(start);

		progressBar = new JProgressBar(0, 100);
		progressBar.setStringPainted(true);
		progressBar.setBounds(120, 210, 300, 30); // Usar coordenadas absolutas
		add(progressBar);

		// Prueba inicializando escuadras
		Escuadra escuadra1 = new Escuadra();
		escuadra1.setCiclistas(List.of(new Ciclista("Ciclista 1"), new Ciclista("Ciclista 2")));
		escuadraComboBox1.addItem(escuadra1);
		escuadraComboBox2.addItem(escuadra1);
		escuadraComboBox3.addItem(escuadra1);
		escuadraComboBox4.addItem(escuadra1);

		btnSalir = new JButton();
		ImageIcon botonSalir = new ImageIcon("Imagenes/exit.png");
		btnSalir.addActionListener(listener);
		btnSalir.setBounds(880, 40, 75, 65);
		btnSalir.setContentAreaFilled(false);
		btnSalir.setBorder(null);
		btnSalir.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSalir.setIcon(new ImageIcon(botonSalir.getImage().getScaledInstance(btnSalir.getWidth(),
				btnSalir.getHeight(), Image.SCALE_SMOOTH)));
		btnSalir.setActionCommand("BOTON_EXIT_SEMILLANO");
		add(btnSalir);

		fondoVentana = new JLabel();
		fondoVentana.setSize(1000, 620);
		ImageIcon icono = new ImageIcon("Imagenes/carreraSemillano.png");
		Image imagen = icono.getImage();
		imagen = imagen.getScaledInstance(fondoVentana.getWidth(), fondoVentana.getHeight(), Image.SCALE_SMOOTH);
		fondoVentana.setIcon(new ImageIcon(imagen));
		add(fondoVentana);
	}

	public void setEscuadras(List<Escuadra> escuadras) {
		escuadraComboBox1.removeAllItems();
		escuadraComboBox2.removeAllItems();
		escuadraComboBox3.removeAllItems();
		escuadraComboBox4.removeAllItems();

		for (Escuadra escuadra : escuadras) {
			escuadraComboBox1.addItem(escuadra);
			escuadraComboBox2.addItem(escuadra);
			escuadraComboBox3.addItem(escuadra);
			escuadraComboBox4.addItem(escuadra);
		}
	}

	private void startProgress() {
		Escuadra escuadraSeleccionada1 = (Escuadra) escuadraComboBox1.getSelectedItem();
		Escuadra escuadraSeleccionada2 = (Escuadra) escuadraComboBox2.getSelectedItem();
		Escuadra escuadraSeleccionada3 = (Escuadra) escuadraComboBox3.getSelectedItem();
		Escuadra escuadraSeleccionada4 = (Escuadra) escuadraComboBox4.getSelectedItem();

		if (escuadraSeleccionada1 == null || escuadraSeleccionada2 == null) {
			JOptionPane.showMessageDialog(this, "Por favor seleccione dos escuadras.");
			return;
		}

		if (worker == null || worker.isDone()) {
			maxValue = 100;
			progressBar.setMaximum(maxValue);

			tableModel.setRowCount(0);

			worker = new SwingWorker<>() {
				private int tiempoEscuadra1;
				private int tiempoEscuadra2;
				private int tiempoEscuadra3;
				private int tiempoEscuadra4;

				@Override
				public Void doInBackground() throws Exception {
					for (int i = 0; i <= maxValue; i++) {
						progressBar.setValue(i);
						Thread.sleep(1000); // Esperar 1 segundo (1000 ms)
					}
					// Calcular los tiempos después de que la barra de progreso termine
					tiempoEscuadra1 = (int) (Math.random() * 3600);
					tiempoEscuadra2 = (int) (Math.random() * 3600);
					tiempoEscuadra3 = (int) (Math.random() * 3600);
					tiempoEscuadra4 = (int) (Math.random() * 3600);

					return null;
				}

				@Override
				protected void done() {
					tableModel.addRow(new Object[] { escuadraSeleccionada1.getNombre(), tiempoEscuadra1 });
					tableModel.addRow(new Object[] { escuadraSeleccionada2.getNombre(), tiempoEscuadra2 });
					tableModel.addRow(new Object[] { escuadraSeleccionada3.getNombre(), tiempoEscuadra3 });
					tableModel.addRow(new Object[] { escuadraSeleccionada4.getNombre(), tiempoEscuadra4 });

					JOptionPane.showMessageDialog(null, "Proceso completado", "Información",
							JOptionPane.INFORMATION_MESSAGE);
				}
			};

			worker.execute();
		}
	}

}
