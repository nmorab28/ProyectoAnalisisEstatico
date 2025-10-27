package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.regex.Pattern;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import co.edu.unbosque.model.AdminIsuci;
import co.edu.unbosque.model.Administrador;
import co.edu.unbosque.model.Ciclista;
import co.edu.unbosque.model.CiclistaDTO;
import co.edu.unbosque.model.Director;
import co.edu.unbosque.model.DirectorDTO;
import co.edu.unbosque.model.Escuadra;
import co.edu.unbosque.model.EscuadraDTO;
import co.edu.unbosque.model.Masajista;
import co.edu.unbosque.model.MasajistaDTO;
import co.edu.unbosque.model.Usuario;
import co.edu.unbosque.model.persistence.DataMapper;
import co.edu.unbosque.model.persistence.FileManager;
import co.edu.unbosque.view.PanelInformacion;
import co.edu.unbosque.view.PanelLlano;
import co.edu.unbosque.view.PanelMontana;
import co.edu.unbosque.view.PanelMostrarInfo;
import co.edu.unbosque.view.PanelOpcion;
import co.edu.unbosque.view.PanelRegistro;
import co.edu.unbosque.view.PanelSemillano;
import co.edu.unbosque.view.PanelTabla;
import co.edu.unbosque.view.VentanaAutenticacion;
import co.edu.unbosque.view.VentanaCiclista;
import co.edu.unbosque.view.VentanaEmergente;
import co.edu.unbosque.view.VentanaLlano;
import co.edu.unbosque.view.VentanaMontana;
import co.edu.unbosque.view.VentanaPrincipal;
import co.edu.unbosque.view.VentanaRegistroUsuarios;
import co.edu.unbosque.view.VentanaSemillano;
import co.edu.unbosque.view.VentanaUsuariosPdf;

public class Controller implements ActionListener {
	private VentanaPrincipal vp;
	private AdminIsuci admin;

	public Controller() {
		String titulo = "titulo por defecto";
		try {
			titulo = (String) FileManager.leerArchivoProperties().get("tituloVentana");
		} catch (IOException e) {
			e.printStackTrace();
		}
		vp = new VentanaPrincipal(this, titulo);
		admin = new AdminIsuci();
	}

    public Controller(VentanaPrincipal ventanaMock) {
        this.vp = ventanaMock;
        this.admin = new AdminIsuci();
    }

	public void init() {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String accion = e.getActionCommand();

		switch (accion) {
		case "BOTON_INICIO":
			vp.abrirVentanaAutenticacion();
			vp.setVisible(false);
			break;
		case "BOTON_INICIO_REGISTRAR":
			vp.abrirVentanaRegistro();
			vp.setVisible(false);
			break;
		case "BOTON_HOME":
			vp.cerrarVentanaRegistro();
			vp.setVisible(true);
			break;
		case "BOTON_BACK":
			vp.cerrarVentanaAutenticacion();
			vp.setVisible(true);
			break;
		case "BOTON_REGISTRAR":
			registrarInformacion();
			String email = vp.getVentanaRegistroUsuario().getPanelRegistro().getTxtCorreo();
			if (validarEmail(email)) {
                try {
                    enviarGmail(email);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                vp.cerrarVentanaRegistro();
				vp.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(vp, "Dirección de correo electrónico no válida", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		case "BOTON_REGISTRAR_AUTH":
			buscarUsuario();
			break;
		case "BOTON_REGISTRO":
			if (seHaIngresadoInformacion()) {
				registrarEscuadra();
				vp.abrirVentanaMontana(null);
				vp.cerrarVentanaCiclistas();
			} else {
				VentanaEmergente.mostrarMensajeError("Debe ingresar los datos para poder continuar");
			}
			break;
		case "ACTUALIZAR":
			cargarDatos();
			break;
		case "SELECCION_CICLISTA":
			seleccionarUsuarios();
			break;
		case "BOTON_EXIT":
			vp.cerrarVentanaInfo();
			vp.setVisible(true);
			break;
		case"BOTON_EXIT_ETAPA":
			vp.cerrarVentanaEtapa();
			vp.abrirVentanaAdmin();
			break;
		case "BOTON_VER_USUARIOS":
			vp.abrirVentanaPdf();
			vp.cerrarVentanaAdmin();
			break;
		case "BOTON_SIMULACION":
			vp.abrirVentanaEtapa();
			vp.cerrarVentanaAdmin();
			break;
		case "BOTON_MONTAÑA":
			ArrayList<Escuadra> escuadras = obtenerEscuadras(); // Método para obtener la lista de escuadras
			vp.abrirVentanaMontana(escuadras);
			vp.cerrarVentanaEtapa();
			break;
		case "BOTON_LLANO":
			obtenerEscuadras();
			ArrayList<Escuadra> escuadras1 = obtenerEscuadras(); // Método para obtener la lista de escuadras
			vp.abrirVentanaLlano(escuadras1);
			vp.cerrarVentanaEtapa();
			break;
		case "BOTON_SEMILLANO":
			obtenerEscuadras();
			ArrayList<Escuadra> escuadras2 = obtenerEscuadras(); // Método para obtener la lista de escuadras
			vp.abrirVentanaSemillano(escuadras2);
			vp.cerrarVentanaEtapa();
			break;
		case "MOSTRAR_USUARIOS":
			generarVerUsuarios();
			break;
		case "BOTON_PDF":
			VentanaUsuariosPdf vup = vp.getVentanaPdf();
			PanelTabla pt = vup.getPanelTabla();
			JTable tabla = pt.getTablaUsuarios();
			generarPDF(tabla);
			break;
		case "BTN_SALIR":
			vp.cerrarVentanaPdf();
			vp.abrirVentanaAdmin();
			break;
		case "BOTON_ELIMINAR":
			eliminarUsuario();
			break;
		case"BOTON_EXIT_MONTANA":
			vp.cerrarVentanaMontana();
			vp.abrirVentanaEtapa();
			break;
		case "BOTON_EXIT_LLANO":
			vp.cerrarVentanaLlano();
			vp.abrirVentanaEtapa();
			break;
		case "BOTON_EXIT_SEMILLANO":
			vp.cerrarVentanaSemillano();
			vp.abrirVentanaEtapa();
			break;

		}
	}

	public void cargarEscuadrasEnComboBox(String nombrePersona) {
		PanelMostrarInfo pmi = vp.getPanelInfo();

		// Limpiar el JComboBox antes de agregar nuevas escuadras
		pmi.getEscuadrasComboBox().removeAllItems();

		// Obtener las escuadras en las que ha estado la persona
		ArrayList<String> escuadrasPersona = obtenerEscuadrasDePersona(nombrePersona);

		// Verificar si hay escuadras disponibles
		if (!escuadrasPersona.isEmpty()) {
			// Agregar las escuadras al JComboBox
			for (String escuadra : escuadrasPersona) {
				pmi.getEscuadrasComboBox().addItem(escuadra);
			}
		} else {
			// Si no hay escuadras disponibles, mostrar un mensaje
			JOptionPane.showMessageDialog(vp, "No se encontraron escuadras para esta persona", "Aviso",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	public ArrayList<String> obtenerEscuadrasDePersona(String nombrePersona) {
		ArrayList<String> escuadrasPersona = new ArrayList<>();

		// Llama a tu método existente para leer el archivo binario
		ArrayList<Escuadra> escuadras = admin.leerEscuadras();

		// Itera sobre la lista de escuadras para encontrar las asociadas a la persona
		for (Escuadra escuadra : escuadras) {
			for (Usuario usuario : escuadra.getMiembros()) {
				if (usuario.getNombre().equals(nombrePersona)) {
					escuadrasPersona.add(escuadra.getNombre());
					break; // Sal del bucle interno si se encuentra una coincidencia
				}
			}
		}

		return escuadrasPersona;
	}

	private ArrayList<Escuadra> obtenerEscuadras() {
		FileManager fileManager = new FileManager();
		ArrayList<Escuadra> escuadras = fileManager.leerEscuadras("Escuadras.dat");
		if (escuadras != null && !escuadras.isEmpty()) {
			System.out.println("Escuadras cargadas correctamente desde el archivo.");
			// Imprimir la lista de ciclistas de cada escuadra y verificar si son null
			for (Escuadra escuadra : escuadras) {
				if (escuadra.getCiclistas() == null) {
					System.out.println("¡Error! Los ciclistas de la escuadra " + escuadra.getNombre() + " son null.");
				} else {
					System.out.println(
							"Ciclistas de la escuadra " + escuadra.getNombre() + ": " + escuadra.getCiclistas());
				}
			}
		} else {
			System.out.println("No se encontraron escuadras en el archivo.");
		}
		return escuadras;
	}

	private void generarPDF(JTable tabla) {
		// Obtener el índice de la fila seleccionada en la tabla
		int filaSeleccionada = tabla.getSelectedRow();
		// Obtener el ciclista seleccionado usando el índice de la fila
		Ciclista ciclistaSeleccionado = obtenerCiclistaSeleccionado(filaSeleccionada, tabla);
		// Generar el PDF con la información del ciclista seleccionado
		try {
			generarPDF(ciclistaSeleccionado);
			JOptionPane.showMessageDialog(vp, "PDF de ciclista generado correctamente.", "Información",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(vp, "Error al generar el PDF de ciclista.", "Error",
					JOptionPane.ERROR_MESSAGE);
			ex.printStackTrace();
		}
	}

	public void generarPDF(Ciclista ciclistaSeleccionado) throws IOException {
		Document documento = new Document();
		try {
			FileOutputStream archivoPDF = new FileOutputStream("InformeCiclista.pdf");
			com.itextpdf.text.pdf.PdfWriter.getInstance(documento, archivoPDF);
			documento.open();

			// Agregar título al documento
			Font fontTitulo = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
			Paragraph titulo = new Paragraph("Información del Ciclista", fontTitulo);
			titulo.setAlignment(Element.ALIGN_CENTER);
			documento.add(titulo);
			documento.add(Chunk.NEWLINE); // Agregar una línea en blanco

			// Agregar información del ciclista seleccionado al documento
			Paragraph parrafo = new Paragraph();
			parrafo.add("Nombre: " + ciclistaSeleccionado.getNombre() + "\n");
			parrafo.add("ID: " + ciclistaSeleccionado.getId() + "\n");
			parrafo.add("Tipo: " + ciclistaSeleccionado.getTipo() + "\n");
			parrafo.add("Género: " + ciclistaSeleccionado.getGenero() + "\n");
			parrafo.add("Correo: " + ciclistaSeleccionado.getCorreo() + "\n");
			parrafo.add("Usuario: " + ciclistaSeleccionado.getUsuario() + "\n");
			parrafo.add("Cadencia de Pedaleo: " + ciclistaSeleccionado.getCadenciaPedaleo() + "\n");
			parrafo.add("Tiempo Acumulado en Carrera: " + ciclistaSeleccionado.getTiempoAC() + "\n");
			parrafo.add(Chunk.NEWLINE);
			documento.add(parrafo);

			// Cerrar el documento
			documento.close();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	// metodos necesarios para enviar el correo electronico
	public boolean validarEmail(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		Pattern pattern = Pattern.compile(emailRegex);
		return pattern.matcher(email).matches();
	}

    private void enviarGmail(String email) throws IOException {
        Properties config = FileManager.leerArchivoProperties();

        String host = config.getProperty("mailgun.host");
        String port = config.getProperty("mailgun.port");
        String username = config.getProperty("mailgun.username");
        String password = config.getProperty("mailgun.password");

        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "false");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("ISUCI registro confirmado");
            message.setText("Hola, ¿estás listo para tus competencias de ciclismo?\nNos alegra que te hayas inscrito correctamente en nuestro sistema.");

            Transport.send(message);

            JOptionPane.showMessageDialog(vp, "Se ha enviado un correo de confirmación a " + email, "Correo enviado",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (MessagingException e) {
            JOptionPane.showMessageDialog(vp, "Error al enviar el correo electrónico", "Error",
                    JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(e);
        }
    }

	public Ciclista obtenerCiclistaSeleccionado(int filaSeleccionada, JTable tabla) {
		// Verificar si la fila seleccionada es válida
		if (filaSeleccionada < 0 || filaSeleccionada >= tabla.getRowCount()) {
			return null; // Retorna null si la fila seleccionada no es válida
		}

		// Obtener la información del ciclista de la fila seleccionada
		String nombre = (String) tabla.getValueAt(filaSeleccionada, 0);
		String id = (String) tabla.getValueAt(filaSeleccionada, 1);
		String tipo = (String) tabla.getValueAt(filaSeleccionada, 2);
		String genero = (String) tabla.getValueAt(filaSeleccionada, 3);
		String correo = (String) tabla.getValueAt(filaSeleccionada, 4);
		String usuario = (String) tabla.getValueAt(filaSeleccionada, 5);

		// Crear un objeto de tipo Ciclista con la información obtenida
		Ciclista ciclista = new Ciclista(nombre, id, genero, correo, usuario, "", tipo, 0, 0);
		// Asegúrate de proporcionar un valor predeterminado para las variables que no
		// tienes en este contexto

		return ciclista; // Retorna el objeto de tipo Ciclista
	}

	private void eliminarUsuario() {
		VentanaUsuariosPdf vup = vp.getVentanaPdf();
		PanelTabla pt = vup.getPanelTabla();
		DefaultTableModel datos = pt.getTableModel();

		// Obtiene el índice de la fila seleccionada
		int filaSeleccionada = pt.getTablaUsuarios().getSelectedRow();

		datos.removeRow(filaSeleccionada);

		VentanaEmergente.mostrarMensaje("Usuario eliminado exitosamente");

	}

	private void generarVerUsuarios() {

		VentanaUsuariosPdf vup = vp.getVentanaPdf();
		PanelTabla pt = vup.getPanelTabla();
		DefaultTableModel datos = pt.getTableModel();
		datos.setRowCount(0);

		ArrayList<Ciclista> ciclistas = admin.leerCiclista();
		for (Ciclista ciclista : ciclistas) {
			datos.addRow(new Object[] { ciclista.getNombre(), ciclista.getId(), ciclista.getTipo(),
					ciclista.getGenero(), ciclista.getCorreo(), ciclista.getUsuario(), "" });
		}

		ArrayList<Masajista> masajistas = admin.leerMasajistas();
		for (Masajista masajista : masajistas) {
			datos.addRow(new Object[] { masajista.getNombre(), masajista.getId(), "Masajista", masajista.getGenero(),
					masajista.getCorreo(), masajista.getUsuario(), masajista.getExperiencia() });
		}

		ArrayList<Director> directores = admin.leerDirectores();
		for (Director director : directores) {
			datos.addRow(new Object[] { director.getNombre(), director.getId(), "Director", director.getGenero(),
					director.getCorreo(), director.getUsuario(), director.getExperiencia() });
		}
	}

	private boolean seHaIngresadoInformacion() {
		String nombre = vp.getVentanaCiclistas().getPanelOpcion().getTxtNombre();
		String pais = vp.getVentanaCiclistas().getPanelOpcion().getTxtPais();
		return !nombre.isEmpty() && !pais.isEmpty();
	}

	private ArrayList<Object[]> seleccionarUsuarios() {
		VentanaCiclista vc = vp.getVentanaCiclistas();
		PanelOpcion po = vc.getPanelOpcion();
		int[] selectedRows = po.getSelectedRows();
		ArrayList<Object[]> selectedUsers = new ArrayList<>();

		for (int row : selectedRows) {
			Object[] rowData = po.getRowData(row);
			String nombre = (String) rowData[0];
			String id = (String) rowData[1];

			// Crear un arreglo con el nombre y el ID y agregarlo a la lista de usuarios
			// seleccionados
			Object[] selectedData = { nombre, id };
			selectedUsers.add(selectedData);
		}

		return selectedUsers;
	}

	private void registrarEscuadra() {
		VentanaCiclista vc = vp.getVentanaCiclistas();
		PanelOpcion po = vc.getPanelOpcion();
		EscuadraDTO dto = new EscuadraDTO();
		String txtNombre = po.getTxtNombre();
		dto.setNombre(txtNombre);
		String txtPais = po.getTxtPais();
		dto.setPais(txtPais);

		// Llamar al método seleccionarUsuarios() para obtener las personas
		// seleccionadas
		ArrayList<Object[]> selectedUsers = seleccionarUsuarios();

		// Crear la lista de miembros de la escuadra a partir de las personas
		// seleccionadas
		ArrayList<Usuario> miembros = new ArrayList<>();
		for (Object[] userData : selectedUsers) {
			String nombre = (String) userData[0];
			String id = (String) userData[1];
			Usuario usuario = new Usuario(nombre, id, "", "", "", "");
			miembros.add(usuario);
		}

		dto.setMiembros(miembros);

		Escuadra c = DataMapper.traducirdeDTO(dto);

		// Guardar la escuadra en el sistema
		try {
			admin.crearEscuadra(c);
			VentanaEmergente.mostrarMensaje("Escuadra registrada exitosamente");
		} catch (IOException e) {
			e.printStackTrace();
			VentanaEmergente.mostrarMensajeError("Escuadra no registrada ");
		}
	}

	private void cargarDatos() {
		VentanaCiclista vc = vp.getVentanaCiclistas();
		PanelOpcion po = vc.getPanelOpcion();
		DefaultTableModel datos = po.getTableModel();

		datos.setRowCount(0); // Limpiar la tabla antes de cargar nuevos datos

		ArrayList<Ciclista> ciclistas = admin.leerCiclista();
		for (Ciclista ciclista : ciclistas) {
			datos.addRow(new Object[] { ciclista.getNombre(), ciclista.getId(), ciclista.getTipo(),
					ciclista.getGenero(), ciclista.getCorreo(), ciclista.getUsuario(), " " });
		}

		ArrayList<Masajista> masajistas = admin.leerMasajistas();
		for (Masajista masajista : masajistas) {
			datos.addRow(new Object[] { masajista.getNombre(), masajista.getId(), "Masajista", masajista.getGenero(),
					masajista.getCorreo(), masajista.getUsuario(), masajista.getExperiencia() });
		}

	}

	private void registrarInformacion() {
		VentanaRegistroUsuarios vru = vp.getVentanaRegistroUsuario(); // Obtener la ventana de registro de usuario
		PanelRegistro pr = vru.getPanelRegistro();
		if (pr.isCiclistasSelected()) {
			CiclistaDTO cdto = new CiclistaDTO();
			String txtNombre = pr.getTxtNombre();
			cdto.setNombre(txtNombre);
			String txtId = pr.getTxtId();
			cdto.setId(txtId);
			String txtGenero = pr.getTxtGenero();
			cdto.setGenero(txtGenero);
			String txtCorreo = pr.getTxtCorreo();
			cdto.setCorreo(txtCorreo);
			String txtTipo = pr.getTxtTipo();
			cdto.setTipo(txtTipo);
			String txtCadencia = pr.getTxtCadencia();
			cdto.setCadenciaPedaleo(Integer.parseInt(txtCadencia));
			String txtUsuario = pr.getTxtUsuario();
			cdto.setUsuario(txtUsuario);
			String txtContrasena = pr.getTxtContrasena();
			cdto.setContrasena(txtContrasena);
			Ciclista c = DataMapper.traducirdeDTO(cdto);
			try {
				admin.crearCiclista(c);
				VentanaEmergente.mostrarMensaje("Ciclista registrado exitosamente");
			} catch (IOException e) {
				VentanaEmergente.mostrarMensajeError("Error al guardar el ciclista en el archivo.");
				e.printStackTrace();
			}
		}
		if (pr.isMasajistasSelected()) {
			MasajistaDTO mdto = new MasajistaDTO();
			String txtNombre = pr.getTxtNombre();
			mdto.setNombre(txtNombre);
			String txtId = pr.getTxtId();
			mdto.setId(txtId);
			String txtGenero = pr.getTxtGenero();
			mdto.setGenero(txtGenero);
			String txtCorreo = pr.getTxtCorreo();
			mdto.setCorreo(txtCorreo);
			String txtExperiencia = pr.getTxtExperiencia();
			mdto.setExperiencia(txtExperiencia);
			String txtUsuario = pr.getTxtUsuario();
			mdto.setUsuario(txtUsuario);
			String txtContrasena = pr.getTxtContrasena();
			mdto.setContrasena(txtContrasena);
			Masajista m = DataMapper.traducirdeDTO(mdto);
			try {
				admin.crearMasajista(m);
				VentanaEmergente.mostrarMensaje("Masajista registrado exitosamente");
			} catch (IOException e) {
				VentanaEmergente.mostrarMensajeError("Error al guardar el masajista en el archivo.");
				e.printStackTrace();
			}
		}

		if (pr.isDtSelected()) {
			DirectorDTO didto = new DirectorDTO();
			String txtNombre = pr.getTxtNombre();
			didto.setNombre(txtNombre);
			String txtId = pr.getTxtId();
			didto.setId(txtId);
			String txtGenero = pr.getTxtGenero();
			didto.setGenero(txtGenero);
			String txtCorreo = pr.getTxtCorreo();
			didto.setCorreo(txtCorreo);
			String txtExperiencia = pr.getTxtExperiencia();
			didto.setExperiencia(txtExperiencia);
			String txtUsuario = pr.getTxtUsuario();
			didto.setUsuario(txtUsuario);
			String txtContrasena = pr.getTxtContrasena();
			didto.setContrasena(txtContrasena);
			Director d = DataMapper.traducirdeDTO(didto);
			try {
				admin.crearDt(d);
				VentanaEmergente.mostrarMensaje("Director registrado exitosamente");
			} catch (IOException e) {
				VentanaEmergente.mostrarMensajeError("Error al guardar el director en el archivo.");
				e.printStackTrace();
			}
		}
	}

	public void buscarUsuario() {
		String usuario = obtenerUsuarioIngresado(); // Obtener el nombre de usuario ingresado por el usuario
		String contrasena = obtenerContrasenaIngresada(); // SObtener la contraseña ingresada por el usuario
		Administrador administrador = new Administrador();

		if (administrador.getUsuario().equals(usuario) && administrador.getContraseña().equals(contrasena)) {
			vp.abrirVentanaAdmin();
			vp.setVisible(false);
			vp.cerrarVentanaAutenticacion();
			return;
		}
		// Leer los archivos binarios que contienen los usuarios de cada tipo
		ArrayList<Ciclista> ciclistas = admin.leerCiclista();
		ArrayList<Masajista> masajistas = admin.leerMasajistas();
		ArrayList<Director> directores = admin.leerDirectores();

		// Buscar el usuario en la lista de ciclistas
		for (Ciclista ciclista : ciclistas) {
			if (ciclista.getUsuario().equals(usuario) && ciclista.getContrasena().equals(contrasena)) {
				cargarEscuadrasEnComboBox(ciclista.getNombre()); // Aquí cargamos las escuadras cuando encontramos al
																	// ciclista
				vp.abrirVentanaInfo(ciclista);
				vp.setVisible(false);
				vp.cerrarVentanaAutenticacion();
				return; // Salir del método ya que se encontró una coincidencia
			}
		}

		// Buscar el usuario en la lista de masajistas
		for (Masajista masajista : masajistas) {
			if (masajista.getUsuario().equals(usuario) && masajista.getContrasena().equals(contrasena)) {
				cargarEscuadrasEnComboBox(masajista.getNombre()); // Aquí cargamos las escuadras cuando encontramos al
																	// ciclista
				vp.abrirVentanaInfo(masajista);
				vp.setVisible(false);
				vp.cerrarVentanaAutenticacion();
				return; // Salir del método ya que se encontró una coincidencia
			}
		}

		// Buscar el usuario en la lista de directores
		for (Director director : directores) {
			if (director.getUsuario().equals(usuario) && director.getContrasena().equals(contrasena)) {
				// Usuario encontrado, abrir la siguiente ventana
				vp.abrirVentanaCiclista();
				vp.setVisible(false);
				vp.cerrarVentanaAutenticacion();
				return; // Salir del método ya que se encontró una coincidencia
			}
		}

		// Si llegamos aquí, significa que las credenciales son incorrectas
		VentanaEmergente.mostrarMensajeError("Usuario no encontrado, debe registrarse para poder continuar");

	}

	private String obtenerContrasenaIngresada() {
		VentanaAutenticacion va = vp.getVentanaAutenticacion(); // Obtener la ventana de registro de usuario
		PanelInformacion pi = va.getPanelInfo();
		return pi.getTxtContrasena();
	}

	private String obtenerUsuarioIngresado() {
		VentanaAutenticacion va = vp.getVentanaAutenticacion(); // Obtener la ventana de registro de usuario
		PanelInformacion pi = va.getPanelInfo();
		return pi.getTxtId();
	}

}
