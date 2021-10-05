package com.entrenamosuy.tarea1.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

import com.entrenamosuy.core.data.DataActividad;
import com.entrenamosuy.core.data.DataClase;
import com.entrenamosuy.core.data.DataProfesor;
import com.entrenamosuy.core.exceptions.ProfesorNoEncontradoException;
import com.entrenamosuy.core.AbstractFacadeActividad;
import com.entrenamosuy.core.AbstractFacadeCuponera;
import com.entrenamosuy.core.AbstractFacadeUsuario;

public class ConsultaProfesor extends JInternalFrame {
    private JTextField nicknameField;
    private JTextField nombreField;
    private JTextField apellidoField;
    private JTextField correoField;
    private JTextField nacimientoField;
    private JTextField descripcionField;
    private JTextField biografiaField;
    private JTextField sitioWebField;

    public ConsultaProfesor(App app, String nickname, AbstractFacadeUsuario controladorUsuario,
							AbstractFacadeCuponera controladorCuponera, AbstractFacadeActividad controladorActividadClase) {
	List<String> clases = new ArrayList<String>();
	List<String> actividades = new ArrayList<String>();
	DataProfesor profesor = null;

	try {
	    profesor = controladorUsuario.getDataProfesor(nickname);
	} catch (ProfesorNoEncontradoException e) {
	    e.printStackTrace();
	}

	for (DataActividad a : profesor.getActividades())
	    actividades.add(a.getNombre());

	for (DataClase c : profesor.getClases())
	    clases.add(c.getNombre());

	setResizable(true);
	setClosable(true);
	setTitle("Consulta profesor");
	setSize(757, 688);

	GridBagLayout gridBagLayout = new GridBagLayout();
	gridBagLayout.columnWidths = new int[] { 0, 108, 0, 0, 0, 0 };
	gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
	gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
		0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE };
	getContentPane().setLayout(gridBagLayout);

	JLabel lblNickname = new JLabel("Nickname");
	GridBagConstraints gbc_lblNickname = new GridBagConstraints();
	gbc_lblNickname.anchor = GridBagConstraints.WEST;
	gbc_lblNickname.insets = new Insets(0, 0, 5, 5);
	gbc_lblNickname.gridx = 1;
	gbc_lblNickname.gridy = 1;
	getContentPane().add(lblNickname, gbc_lblNickname);

	nicknameField = new JTextField();
	nicknameField.setEditable(false);
	GridBagConstraints gbc_nicknameField = new GridBagConstraints();
	gbc_nicknameField.insets = new Insets(0, 0, 5, 5);
	gbc_nicknameField.fill = GridBagConstraints.HORIZONTAL;
	gbc_nicknameField.gridx = 3;
	gbc_nicknameField.gridy = 1;
	getContentPane().add(nicknameField, gbc_nicknameField);
	nicknameField.setColumns(10);

	JLabel lblNombre = new JLabel("Nombre");
	GridBagConstraints gbc_lblNombre = new GridBagConstraints();
	gbc_lblNombre.anchor = GridBagConstraints.WEST;
	gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
	gbc_lblNombre.gridx = 1;
	gbc_lblNombre.gridy = 3;
	getContentPane().add(lblNombre, gbc_lblNombre);

	nombreField = new JTextField();
	nombreField.setEditable(false);
	nombreField.setColumns(10);
	GridBagConstraints gbc_nombreField = new GridBagConstraints();
	gbc_nombreField.insets = new Insets(0, 0, 5, 5);
	gbc_nombreField.fill = GridBagConstraints.HORIZONTAL;
	gbc_nombreField.gridx = 3;
	gbc_nombreField.gridy = 3;
	getContentPane().add(nombreField, gbc_nombreField);

	JLabel lblApellido = new JLabel("Apellido");
	GridBagConstraints gbc_lblApellido = new GridBagConstraints();
	gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
	gbc_lblApellido.anchor = GridBagConstraints.WEST;
	gbc_lblApellido.gridx = 1;
	gbc_lblApellido.gridy = 5;
	getContentPane().add(lblApellido, gbc_lblApellido);

	apellidoField = new JTextField();
	apellidoField.setEditable(false);
	apellidoField.setColumns(10);
	GridBagConstraints gbc_apellidoField = new GridBagConstraints();
	gbc_apellidoField.insets = new Insets(0, 0, 5, 5);
	gbc_apellidoField.fill = GridBagConstraints.HORIZONTAL;
	gbc_apellidoField.gridx = 3;
	gbc_apellidoField.gridy = 5;
	getContentPane().add(apellidoField, gbc_apellidoField);

	JLabel lblCorreo = new JLabel("Correo");
	GridBagConstraints gbc_lblCorreo = new GridBagConstraints();
	gbc_lblCorreo.insets = new Insets(0, 0, 5, 5);
	gbc_lblCorreo.anchor = GridBagConstraints.WEST;
	gbc_lblCorreo.gridx = 1;
	gbc_lblCorreo.gridy = 7;
	getContentPane().add(lblCorreo, gbc_lblCorreo);

	correoField = new JTextField();
	correoField.setEditable(false);
	correoField.setColumns(10);
	GridBagConstraints gbc_correoField = new GridBagConstraints();
	gbc_correoField.insets = new Insets(0, 0, 5, 5);
	gbc_correoField.fill = GridBagConstraints.HORIZONTAL;
	gbc_correoField.gridx = 3;
	gbc_correoField.gridy = 7;
	getContentPane().add(correoField, gbc_correoField);

	JLabel lblNacimiento = new JLabel("Nacimiento");
	GridBagConstraints gbc_lblNacimiento = new GridBagConstraints();
	gbc_lblNacimiento.insets = new Insets(0, 0, 5, 5);
	gbc_lblNacimiento.anchor = GridBagConstraints.WEST;
	gbc_lblNacimiento.gridx = 1;
	gbc_lblNacimiento.gridy = 9;
	getContentPane().add(lblNacimiento, gbc_lblNacimiento);

	nacimientoField = new JTextField();
	nacimientoField.setEditable(false);
	nacimientoField.setColumns(10);
	GridBagConstraints gbc_nacimientoField = new GridBagConstraints();
	gbc_nacimientoField.insets = new Insets(0, 0, 5, 5);
	gbc_nacimientoField.fill = GridBagConstraints.HORIZONTAL;
	gbc_nacimientoField.gridx = 3;
	gbc_nacimientoField.gridy = 9;
	getContentPane().add(nacimientoField, gbc_nacimientoField);

	JLabel descripcionbutton = new JLabel("Descripcion");
	GridBagConstraints gbc_descripcionbutton = new GridBagConstraints();
	gbc_descripcionbutton.anchor = GridBagConstraints.WEST;
	gbc_descripcionbutton.insets = new Insets(0, 0, 5, 5);
	gbc_descripcionbutton.gridx = 1;
	gbc_descripcionbutton.gridy = 11;
	getContentPane().add(descripcionbutton, gbc_descripcionbutton);

	descripcionField = new JTextField();
	descripcionField.setEditable(false);
	descripcionField.setColumns(10);
	GridBagConstraints gbc_descripcionField = new GridBagConstraints();
	gbc_descripcionField.insets = new Insets(0, 0, 5, 5);
	gbc_descripcionField.fill = GridBagConstraints.HORIZONTAL;
	gbc_descripcionField.gridx = 3;
	gbc_descripcionField.gridy = 11;
	getContentPane().add(descripcionField, gbc_descripcionField);

	JLabel lblBiografia = new JLabel("Biografia");
	GridBagConstraints gbc_lblBiografia = new GridBagConstraints();
	gbc_lblBiografia.anchor = GridBagConstraints.WEST;
	gbc_lblBiografia.insets = new Insets(0, 0, 5, 5);
	gbc_lblBiografia.gridx = 1;
	gbc_lblBiografia.gridy = 13;
	getContentPane().add(lblBiografia, gbc_lblBiografia);

	biografiaField = new JTextField();
	biografiaField.setEditable(false);
	biografiaField.setColumns(10);
	GridBagConstraints gbc_biografiaField = new GridBagConstraints();
	gbc_biografiaField.insets = new Insets(0, 0, 5, 5);
	gbc_biografiaField.fill = GridBagConstraints.HORIZONTAL;
	gbc_biografiaField.gridx = 3;
	gbc_biografiaField.gridy = 13;
	getContentPane().add(biografiaField, gbc_biografiaField);

	JLabel lblSitioWeb = new JLabel("Sitio Web");
	GridBagConstraints gbc_lblSitioWeb = new GridBagConstraints();
	gbc_lblSitioWeb.anchor = GridBagConstraints.WEST;
	gbc_lblSitioWeb.insets = new Insets(0, 0, 5, 5);
	gbc_lblSitioWeb.gridx = 1;
	gbc_lblSitioWeb.gridy = 15;
	getContentPane().add(lblSitioWeb, gbc_lblSitioWeb);

	sitioWebField = new JTextField();
	sitioWebField.setEditable(false);
	sitioWebField.setColumns(10);
	GridBagConstraints gbc_sitioWebField = new GridBagConstraints();
	gbc_sitioWebField.insets = new Insets(0, 0, 5, 5);
	gbc_sitioWebField.fill = GridBagConstraints.HORIZONTAL;
	gbc_sitioWebField.gridx = 3;
	gbc_sitioWebField.gridy = 15;
	getContentPane().add(sitioWebField, gbc_sitioWebField);

	JLabel lblClases = new JLabel("Clases");
	GridBagConstraints gbc_lblClases = new GridBagConstraints();
	gbc_lblClases.anchor = GridBagConstraints.WEST;
	gbc_lblClases.insets = new Insets(0, 0, 5, 5);
	gbc_lblClases.gridx = 1;
	gbc_lblClases.gridy = 17;
	getContentPane().add(lblClases, gbc_lblClases);

	JLabel lblActividades = new JLabel("Actividades");
	GridBagConstraints gbc_lblActividades = new GridBagConstraints();
	gbc_lblActividades.anchor = GridBagConstraints.WEST;
	gbc_lblActividades.fill = GridBagConstraints.VERTICAL;
	gbc_lblActividades.insets = new Insets(0, 0, 5, 5);
	gbc_lblActividades.gridx = 1;
	gbc_lblActividades.gridy = 19;
	getContentPane().add(lblActividades, gbc_lblActividades);

	nicknameField.setText(profesor.getNickname());
	nombreField.setText(profesor.getNombre());
	apellidoField.setText(profesor.getApellido());
	correoField.setText(profesor.getCorreo().toString());
	nacimientoField.setText(profesor.getNacimiento().toString());
	descripcionField.setText(profesor.getDescripcion());
	biografiaField.setText(profesor.getBiografia());

	URL profesorURL = profesor.getSitioWeb();

	if (profesorURL != null)
	    sitioWebField.setText(profesorURL.toString());

	JList<String> actividadesLista = new JList<>(actividades.toArray(new String[] {}));
	GridBagConstraints gbc_actividadesLista = new GridBagConstraints();
	gbc_actividadesLista.insets = new Insets(0, 0, 5, 5);
	gbc_actividadesLista.fill = GridBagConstraints.BOTH;
	gbc_actividadesLista.gridx = 3;
	gbc_actividadesLista.gridy = 19;
	getContentPane().add(actividadesLista, gbc_actividadesLista);

	JList<String> clasesLista = new JList<>(clases.toArray(new String[] {}));
	GridBagConstraints gbc_clasesLista = new GridBagConstraints();
	gbc_clasesLista.insets = new Insets(0, 0, 5, 5);
	gbc_clasesLista.fill = GridBagConstraints.BOTH;
	gbc_clasesLista.gridx = 3;
	gbc_clasesLista.gridy = 17;
	getContentPane().add(clasesLista, gbc_clasesLista);

	MouseListener mouseListenerActividades = new MouseAdapter() {

	    public void mouseClicked(MouseEvent mouseEvent) {
		JList<?> theList = (JList<?>) mouseEvent.getSource();
		if (mouseEvent.getClickCount() == 2) {
		    int index = theList.locationToIndex(mouseEvent.getPoint());
		    if (index >= 0) {
			String actividad = theList.getModel().getElementAt(index).toString();
			ConsultaActividad consultaActividad = new ConsultaActividad(app, actividad, controladorUsuario,
				controladorActividadClase, controladorCuponera);
			consultaActividad.setVisible(true);
			app.getContentPane().add(consultaActividad);
		    }
		}
	    }
	};

	actividadesLista.addMouseListener(mouseListenerActividades);

	MouseListener mouseListenerClases = new MouseAdapter() {

	    public void mouseClicked(MouseEvent mouseEvent) {
		JList<?> theList = (JList<?>) mouseEvent.getSource();
		if (mouseEvent.getClickCount() == 2) {
		    int index = theList.locationToIndex(mouseEvent.getPoint());
		    if (index >= 0) {
			String clase = theList.getModel().getElementAt(index).toString();
			ConsultaDictadoClase consultaClase = new ConsultaDictadoClase(app, clase, controladorUsuario,
				controladorActividadClase, controladorCuponera);
			consultaClase.setVisible(true);
			app.getContentPane().add(consultaClase);
		    }
		}
	    }
	};

	clasesLista.addMouseListener(mouseListenerClases);
    }
}
