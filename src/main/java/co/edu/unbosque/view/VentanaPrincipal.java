package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import co.edu.unbosque.model.Ciclista;
import co.edu.unbosque.model.Escuadra;
import co.edu.unbosque.model.Masajista;

public class VentanaPrincipal extends JFrame {
	private PanelInicio panelInicio;
	private VentanaRegistroUsuarios vru;
	private VentanaAutenticacion va;
	private VentanaCiclista vc;
	private VentanaAdministrador vad;
	private VentanaMostrarInfo vmi;
	private VentanaUsuariosPdf vup;
	private VentanaEtapa ve;
	private VentanaMontana vm;
	private VentanaLlano vl;
	private VentanaSemillano vsl;
	private ActionListener listener;

	public VentanaPrincipal(ActionListener listener, String titulo) {
		this.listener = listener; // Asigna el ActionListener recibido al campo de clase
		setSize(1000, 650);
		setTitle(titulo);
		setLayout(new BorderLayout()); // Usamos BorderLayout para organizar los componentes
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponents();
		setLocationRelativeTo(null); // Centra la ventana en la pantalla
		setVisible(true);

		ImageIcon icono = new ImageIcon("Imagenes/icono.png");
		setIconImage(icono.getImage());
	}

	private void initComponents() {

		panelInicio = new PanelInicio(listener);
		add(panelInicio);

	}

	public void abrirVentanaRegistro() {
		vru = new VentanaRegistroUsuarios(listener);
		vru.setVisible(true);
	}

	public void cerrarVentanaRegistro() {
		vru.dispose();
	}

	public void abrirVentanaCiclista() {
		vc = new VentanaCiclista(listener);
		vc.setVisible(true);
	}

	public void cerrarVentanaCiclistas() {
		vc.dispose();
	}

	public void abrirVentanaAutenticacion() {
		va = new VentanaAutenticacion(listener);
		va.setVisible(true);
	}

	public void cerrarVentanaAutenticacion() {
		va.dispose();

	}

	public void abrirVentanaAdmin() {
		vad = new VentanaAdministrador(listener);
		vad.setVisible(true);
	}

	public void cerrarVentanaAdmin() {
		this.vad.dispose();
	}

	public void abrirVentanaInfo(Ciclista ciclista) {
		vmi = new VentanaMostrarInfo(listener);
		vmi.mostrarCiclista(ciclista);
		vmi.setVisible(true);
	}

	public void abrirVentanaInfo(Masajista masajista) {
		vmi = new VentanaMostrarInfo(listener);
		vmi.mostrarMasajista(masajista);
		vmi.setVisible(true);
	}

	public void cerrarVentanaInfo() {
		this.vmi.dispose();
	}

	public void abrirVentanaPdf() {
		vup = new VentanaUsuariosPdf(listener);
		vup.setVisible(true);
	}

	public void cerrarVentanaPdf() {
		vup.dispose();
	}

	public void abrirVentanaEtapa() {
		ve = new VentanaEtapa(listener);
		ve.setVisible(true);
	}

	public void cerrarVentanaEtapa() {
		ve.dispose();
	}

	public VentanaRegistroUsuarios getVentanaRegistroUsuario() {
		return this.vru;
	}

	public VentanaMostrarInfo getVentanaMostrar() {
		return this.vmi;
	}

	public VentanaCiclista getVentanaCiclistas() {
		return this.vc;
	}

	public VentanaAutenticacion getVentanaAutenticacion() {
		return this.va;
	}

	public VentanaUsuariosPdf getVentanaPdf() {
		return this.vup;
	}

	public void abrirVentanaMontana(ArrayList<Escuadra> escuadras) {
		vm = new VentanaMontana(listener);
		vm.getPanelMontana().setEscuadras(escuadras);
		vm.setVisible(true);
	}

	public void cerrarVentanaMontana() {
		vm.dispose();
	}

	public void abrirVentanaLlano(ArrayList<Escuadra> escuadras) {
		vl = new VentanaLlano(listener);
		vl.getPanelMontana().setEscuadras(escuadras);
		vl.setVisible(true);
	}
	public void cerrarVentanaLlano() {
		this.vl.dispose();
	}
	public void cerrarVentanaSemillano() {
		this.vsl.dispose();
	}
	public void abrirVentanaSemillano(ArrayList<Escuadra> escuadras) {
		 vsl = new VentanaSemillano(listener);
		vsl.getPanelSemillano().setEscuadras(escuadras);
		vsl.setVisible(true);
	}

	public VentanaMontana getVentanaMontana() {
		return this.vm;
	}

	public PanelMostrarInfo getPanelInfo() {
		PanelMostrarInfo panelInfo = new PanelMostrarInfo(listener);
		return panelInfo;
	}

	public VentanaLlano getVentanaLlano() {
		// TODO Auto-generated method stub
		return null;
	}

	public VentanaSemillano getVentanaSemillano() {
		// TODO Auto-generated method stub
		return null;
	}


}
