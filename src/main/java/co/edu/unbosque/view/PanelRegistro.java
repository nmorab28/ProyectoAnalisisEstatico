package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelRegistro extends JPanel {
	private JCheckBox chkCiclistas, chkDt, chkMasajista;
	private JComboBox<String> tipoCiclistas, genero;
	private JTextField txtNombre, txtId, txtExperiencia, txtCadenciaPedaleo, txtUsuario, txtContrasena, txtCorreo;
	private JButton btnRegistrar, home;
	private JLabel fondoInicio;

	public PanelRegistro(ActionListener listener) {
		setLayout(null);

		txtNombre = new JTextField();
		txtNombre.setBorder(BorderFactory.createEmptyBorder());
		txtNombre.setOpaque(false);
		txtNombre.setBackground(new Color(0, 0, 0, 0));
		txtNombre.setForeground(Color.BLACK);
		txtNombre.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		txtNombre.setBounds(440, 165, 340, 45);

		txtId = new JTextField();
		txtId.setBorder(BorderFactory.createEmptyBorder());
		txtId.setOpaque(false);
		txtId.setBackground(new Color(0, 0, 0, 0));
		txtId.setForeground(Color.BLACK);
		txtId.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		txtId.setBounds(440, 220, 342, 45);
		
		String[] opcionesGenero = { "Seleccione una opcion", "Femenino", "Masculino",  };
		genero = new JComboBox<>(opcionesGenero);
		genero.setForeground(Color.BLACK);
		genero.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		genero.setBounds(440, 275, 380, 42);
		
		txtCorreo = new JTextField();
		txtCorreo.setBorder(BorderFactory.createEmptyBorder());
		txtCorreo.setOpaque(false);
		txtCorreo.setBackground(new Color(0, 0, 0, 0));
		txtCorreo.setForeground(Color.BLACK);
		txtCorreo.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		txtCorreo.setBounds(440, 325, 342, 45);

		txtExperiencia = new JTextField();
		txtExperiencia.setBorder(BorderFactory.createEmptyBorder());
		txtExperiencia.setOpaque(false);
		txtExperiencia.setBackground(new Color(0, 0, 0, 0));
		txtExperiencia.setForeground(Color.BLACK);
		txtExperiencia.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		txtExperiencia.setBounds(440, 490, 342, 45);

		txtCadenciaPedaleo = new JTextField();
		txtCadenciaPedaleo.setBorder(BorderFactory.createEmptyBorder());
		txtCadenciaPedaleo.setOpaque(false);
		txtCadenciaPedaleo.setBackground(new Color(0, 0, 0, 0));
		txtCadenciaPedaleo.setForeground(Color.BLACK);
		txtCadenciaPedaleo.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		txtCadenciaPedaleo.setBounds(440, 435, 342, 45);

		txtUsuario = new JTextField();
		txtUsuario.setBorder(BorderFactory.createEmptyBorder());
		txtUsuario.setOpaque(false);
		txtUsuario.setBackground(new Color(0, 0, 0, 0));
		txtUsuario.setForeground(Color.BLACK);
		txtUsuario.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		txtUsuario.setBounds(440, 545, 342, 45);

		txtContrasena = new JTextField();
		txtContrasena.setBorder(BorderFactory.createEmptyBorder());
		txtContrasena.setOpaque(false);
		txtContrasena.setForeground(Color.BLACK);
		txtContrasena.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		txtContrasena.setBounds(440, 600, 342, 45);

		String[] opcionesTipo = { "Seleccione una opcion", "Contrarreloj", "Escalador", "Gregario", "Rodador",
				"Sprinter" };
		tipoCiclistas = new JComboBox<>(opcionesTipo);
		tipoCiclistas.setForeground(Color.BLACK);
		tipoCiclistas.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		tipoCiclistas.setBounds(440, 385, 380, 42);

		chkCiclistas = new JCheckBox();
		chkCiclistas.setBounds(80, 112, 40, 39);
		chkCiclistas.setSelectedIcon(new ImageIcon("Imagenes/Chulito.png"));
		chkCiclistas.setIcon(new ImageIcon("Imagenes/NoChulito.png"));
		chkCiclistas.setBorder(null);

		chkMasajista = new JCheckBox();
		chkMasajista.setBounds(400, 112, 40, 39);
		chkMasajista.setSelectedIcon(new ImageIcon("Imagenes/Chulito.png"));
		chkMasajista.setIcon(new ImageIcon("Imagenes/NoChulito.png"));
		chkMasajista.setBorder(null);

		chkDt = new JCheckBox();
		chkDt.setBounds(681, 112, 40, 39);
		chkDt.setSelectedIcon(new ImageIcon("Imagenes/Chulito.png"));
		chkDt.setIcon(new ImageIcon("Imagenes/NoChulito.png"));
		chkDt.setBorder(null);

		home = new JButton();
		ImageIcon casa = new ImageIcon("Imagenes/home.png");
		home.setBounds(930, 45, 75, 65);
		home.setContentAreaFilled(false);
		home.setBorder(null);
		home.setCursor(new Cursor(Cursor.HAND_CURSOR));
		home.setIcon(new ImageIcon(
				casa.getImage().getScaledInstance(home.getWidth(), home.getHeight(), Image.SCALE_SMOOTH)));
		home.setActionCommand("BOTON_HOME");
		home.addActionListener(listener);

		btnRegistrar = new JButton();
		ImageIcon flechita = new ImageIcon("Imagenes/Regis.png");
		btnRegistrar.setBounds(930, 570, 50, 50);
		btnRegistrar.setContentAreaFilled(false);
		btnRegistrar.setBorder(null);
		btnRegistrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnRegistrar.setIcon(new ImageIcon(flechita.getImage().getScaledInstance(btnRegistrar.getWidth(),
				btnRegistrar.getHeight(), Image.SCALE_SMOOTH)));
		btnRegistrar.setActionCommand("BOTON_REGISTRAR");
		btnRegistrar.addActionListener(listener);

		fondoInicio = new JLabel();
		fondoInicio.setSize(1000, 650);
		ImageIcon icono = new ImageIcon("Imagenes/registro.png");
		Image imagen = icono.getImage();
		imagen = imagen.getScaledInstance(fondoInicio.getWidth(), fondoInicio.getHeight(), Image.SCALE_SMOOTH);
		fondoInicio.setIcon(new ImageIcon(imagen));

		add(home);
		add(chkCiclistas);
		add(chkMasajista);
		add(chkDt);
		add(txtNombre);
		add(txtId);
		add(genero);
		add(txtCorreo);
		add(tipoCiclistas);
		add(txtCadenciaPedaleo);
		add(txtExperiencia);
		add(txtUsuario);
		add(txtContrasena);
		add(btnRegistrar);
		add(fondoInicio);

		chkDt.addItemListener(new ItemListener() {
		    public void itemStateChanged(ItemEvent e) {
		        // Si está seleccionado
		        if (e.getStateChange() == ItemEvent.SELECTED) {
		            // Habilitar los componentes específicos para el caso de entrenador
		            txtNombre.setEditable(true);
		            txtId.setEditable(true);
		            txtExperiencia.setEditable(true);
		            txtUsuario.setEditable(true);
		            txtContrasena.setEditable(true);
		        } else {
		            // Deshabilitar los componentes específicos para el caso de entrenador
		            tipoCiclistas.setEnabled(false);
		            txtCadenciaPedaleo.setEditable(false);
		        }
		    }
		});

		chkCiclistas.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        // Si está seleccionado
		        if (e.getStateChange() == ItemEvent.SELECTED) {
		        	txtNombre.setEditable(true);
		            txtId.setEditable(true);
		            txtUsuario.setEditable(true);
		            txtContrasena.setEditable(true);
		            tipoCiclistas.setEnabled(true);
		            txtCadenciaPedaleo.setEditable(true);
		        } else {
		            txtExperiencia.setEditable(false);
		        }
		    }
		});
		
		chkMasajista.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        // Si está seleccionado
		        if (e.getStateChange() == ItemEvent.SELECTED) {
		        	txtNombre.setEditable(true);
		            txtId.setEditable(true);
		            txtUsuario.setEditable(true);
		            txtContrasena.setEditable(true);
		            txtExperiencia.setEditable(true);
		        } else {
		            tipoCiclistas.setEnabled(false);
		            txtCadenciaPedaleo.setEditable(false);
		        }
		    }
		});

	} 
	
	public String getTxtNombre() {
		return txtNombre.getText();
	}
	
	public String getTxtId() {
		return txtId.getText();
	}
	
	public String getTxtTipo() {
        int selectedIndex = tipoCiclistas.getSelectedIndex();
        
        if (selectedIndex != -1) {
            return tipoCiclistas.getItemAt(selectedIndex).toString();
        } else {
            return "";
        }
	}
	
	public String getTxtGenero() {
        int selectedIndex = genero.getSelectedIndex();
        
        if (selectedIndex != -1) {
            return genero.getItemAt(selectedIndex).toString();
        } else {
            return "";
        }
	}
	public String getTxtCadencia() {
		return txtCadenciaPedaleo.getText();
	}
	
	public String getTxtCorreo() {
		return txtCorreo.getText();
	}
	public String getTxtExperiencia() {
		return txtExperiencia.getText();
	}
	public String getTxtUsuario() {
		return txtUsuario.getText();
	}
	
	public String getTxtContrasena() {
		return txtContrasena.getText();
	}

	public boolean isCiclistasSelected() {
		return chkCiclistas.isSelected();
	}
	public boolean isMasajistasSelected() {
		return chkMasajista.isSelected();
	}
	public boolean isDtSelected() {
		return chkDt.isSelected();
	}
	
	
}