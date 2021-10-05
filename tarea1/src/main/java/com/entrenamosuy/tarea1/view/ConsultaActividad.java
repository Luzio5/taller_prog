package com.entrenamosuy.tarea1.view;

import javax.swing.JInternalFrame;

import com.entrenamosuy.core.data.DataActividad;
import com.entrenamosuy.core.data.DataClase;
import com.entrenamosuy.core.data.DataCuponera;
import com.entrenamosuy.core.exceptions.ActividadNoEncontradaException;
import com.entrenamosuy.core.AbstractFacadeActividad;
import com.entrenamosuy.core.AbstractFacadeCuponera;
import com.entrenamosuy.core.AbstractFacadeUsuario;
import com.entrenamosuy.core.util.FechaUtil;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;
import javax.swing.JList;

public class ConsultaActividad extends JInternalFrame {
    private JTextField nombreField;
    private JTextField descripcionField;
    private JTextField duracionField;
    private JTextField registroField;
    private JTextField costoField;

    public ConsultaActividad(App app, String actividad, AbstractFacadeUsuario controladorUsuario,
							 AbstractFacadeActividad controladorActividadClase, AbstractFacadeCuponera controladorCuponera) {
	setTitle("Consulta actividad");
	setClosable(true);
	setResizable(true);
	setMaximizable(true);
	setSize(511, 477);

	GridBagLayout gridBagLayout = new GridBagLayout();
	gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
	gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
	gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0,
		0.0, Double.MIN_VALUE };
	getContentPane().setLayout(gridBagLayout);

	JLabel lblNombre = new JLabel("Nombre");
	GridBagConstraints gbc_lblNombre = new GridBagConstraints();
	gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
	gbc_lblNombre.anchor = GridBagConstraints.WEST;
	gbc_lblNombre.gridx = 1;
	gbc_lblNombre.gridy = 1;
	getContentPane().add(lblNombre, gbc_lblNombre);

	nombreField = new JTextField();
	nombreField.setEditable(false);
	GridBagConstraints gbc_nombreField = new GridBagConstraints();
	gbc_nombreField.insets = new Insets(0, 0, 5, 5);
	gbc_nombreField.fill = GridBagConstraints.HORIZONTAL;
	gbc_nombreField.gridx = 3;
	gbc_nombreField.gridy = 1;
	getContentPane().add(nombreField, gbc_nombreField);
	nombreField.setColumns(10);

	JLabel lblDescripcion = new JLabel("Descripcion");
	GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
	gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
	gbc_lblDescripcion.anchor = GridBagConstraints.WEST;
	gbc_lblDescripcion.gridx = 1;
	gbc_lblDescripcion.gridy = 3;
	getContentPane().add(lblDescripcion, gbc_lblDescripcion);

	descripcionField = new JTextField();
	descripcionField.setEditable(false);
	GridBagConstraints gbc_descripcionField = new GridBagConstraints();
	gbc_descripcionField.insets = new Insets(0, 0, 5, 5);
	gbc_descripcionField.fill = GridBagConstraints.HORIZONTAL;
	gbc_descripcionField.gridx = 3;
	gbc_descripcionField.gridy = 3;
	getContentPane().add(descripcionField, gbc_descripcionField);
	descripcionField.setColumns(10);

	JLabel lblDuracion = new JLabel("Duracion");
	GridBagConstraints gbc_lblDuracion = new GridBagConstraints();
	gbc_lblDuracion.insets = new Insets(0, 0, 5, 5);
	gbc_lblDuracion.anchor = GridBagConstraints.WEST;
	gbc_lblDuracion.gridx = 1;
	gbc_lblDuracion.gridy = 5;
	getContentPane().add(lblDuracion, gbc_lblDuracion);

	duracionField = new JTextField();
	duracionField.setEditable(false);
	GridBagConstraints gbc_duracionField = new GridBagConstraints();
	gbc_duracionField.insets = new Insets(0, 0, 5, 5);
	gbc_duracionField.fill = GridBagConstraints.HORIZONTAL;
	gbc_duracionField.gridx = 3;
	gbc_duracionField.gridy = 5;
	getContentPane().add(duracionField, gbc_duracionField);
	duracionField.setColumns(10);

	JLabel lblRegistro = new JLabel("Registro");
	GridBagConstraints gbc_lblRegistro = new GridBagConstraints();
	gbc_lblRegistro.insets = new Insets(0, 0, 5, 5);
	gbc_lblRegistro.anchor = GridBagConstraints.WEST;
	gbc_lblRegistro.gridx = 1;
	gbc_lblRegistro.gridy = 7;
	getContentPane().add(lblRegistro, gbc_lblRegistro);

	registroField = new JTextField();
	registroField.setEditable(false);
	GridBagConstraints gbc_registroField = new GridBagConstraints();
	gbc_registroField.insets = new Insets(0, 0, 5, 5);
	gbc_registroField.fill = GridBagConstraints.HORIZONTAL;
	gbc_registroField.gridx = 3;
	gbc_registroField.gridy = 7;
	getContentPane().add(registroField, gbc_registroField);
	registroField.setColumns(10);

	JLabel lblCosto = new JLabel("Costo");
	GridBagConstraints gbc_lblCosto = new GridBagConstraints();
	gbc_lblCosto.insets = new Insets(0, 0, 5, 5);
	gbc_lblCosto.anchor = GridBagConstraints.WEST;
	gbc_lblCosto.gridx = 1;
	gbc_lblCosto.gridy = 9;
	getContentPane().add(lblCosto, gbc_lblCosto);

	costoField = new JTextField();
	costoField.setEditable(false);
	GridBagConstraints gbc_costoField = new GridBagConstraints();
	gbc_costoField.insets = new Insets(0, 0, 5, 5);
	gbc_costoField.fill = GridBagConstraints.HORIZONTAL;
	gbc_costoField.gridx = 3;
	gbc_costoField.gridy = 9;
	getContentPane().add(costoField, gbc_costoField);
	costoField.setColumns(10);

	JLabel lblClases = new JLabel("Clases");
	GridBagConstraints gbc_lblClases = new GridBagConstraints();
	gbc_lblClases.insets = new Insets(0, 0, 5, 5);
	gbc_lblClases.anchor = GridBagConstraints.WEST;
	gbc_lblClases.gridx = 1;
	gbc_lblClases.gridy = 11;
	getContentPane().add(lblClases, gbc_lblClases);

	JLabel lblCuponeras = new JLabel("Cuponeras");
	GridBagConstraints gbc_lblCuponeras = new GridBagConstraints();
	gbc_lblCuponeras.insets = new Insets(0, 0, 5, 5);
	gbc_lblCuponeras.anchor = GridBagConstraints.WEST;
	gbc_lblCuponeras.gridx = 1;
	gbc_lblCuponeras.gridy = 13;
	getContentPane().add(lblCuponeras, gbc_lblCuponeras);

	DataActividad dataActividad = null;

	try {
	    dataActividad = controladorActividadClase.getDataActividad(actividad);
	} catch (ActividadNoEncontradaException e) {
	    e.printStackTrace();
	    return;
	}

	nombreField.setText(dataActividad.getNombre());
	descripcionField.setText(dataActividad.getDescripcion());
	duracionField.setText(FechaUtil.formatDuration(dataActividad.getDuracion()));
	registroField.setText(dataActividad.getRegistro().toString());
	costoField.setText(((Float) dataActividad.getCosto()).toString());

	List<String> clases = new ArrayList<>();
	List<String> cuponeras = new ArrayList<>();

	for (DataClase c : dataActividad.getClases())
	    clases.add(c.getNombre());

	for (DataCuponera c : dataActividad.getCuponeras())
	    cuponeras.add(c.getNombre());

	JList<String> cuponerasLista = new JList<>(cuponeras.toArray(new String[] {}));
	GridBagConstraints gbc_cuponerasLista = new GridBagConstraints();
	gbc_cuponerasLista.insets = new Insets(0, 0, 5, 5);
	gbc_cuponerasLista.fill = GridBagConstraints.BOTH;
	gbc_cuponerasLista.gridx = 3;
	gbc_cuponerasLista.gridy = 13;
	getContentPane().add(cuponerasLista, gbc_cuponerasLista);

	MouseListener mouseListener = new MouseAdapter() {

	    public void mouseClicked(MouseEvent mouseEvent) {
		JList<?> theList = (JList<?>) mouseEvent.getSource();
		if (mouseEvent.getClickCount() == 2) {
		    int index = theList.locationToIndex(mouseEvent.getPoint());
		    if (index >= 0) {
			String cuponera = theList.getModel().getElementAt(index).toString();
			ConsultarCuponera consultaCuponera = new ConsultarCuponera(app, cuponera, controladorUsuario,
				controladorCuponera, controladorActividadClase);
			consultaCuponera.setVisible(true);
			app.getContentPane().add(consultaCuponera);
		    }
		}
	    }
	};
	cuponerasLista.addMouseListener(mouseListener);

	JList<String> clasesLista = new JList<>(clases.toArray(new String[] {}));
	GridBagConstraints gbc_clasesLista = new GridBagConstraints();
	gbc_clasesLista.insets = new Insets(0, 0, 5, 5);
	gbc_clasesLista.fill = GridBagConstraints.BOTH;
	gbc_clasesLista.gridx = 3;
	gbc_clasesLista.gridy = 11;
	getContentPane().add(clasesLista, gbc_clasesLista);

	MouseListener mouseListenerClases = new MouseAdapter() {

	    public void mouseClicked(MouseEvent mouseEvent) {
		JList<?> theList = (JList<?>) mouseEvent.getSource();
		if (mouseEvent.getClickCount() == 2) {
		    int index = theList.locationToIndex(mouseEvent.getPoint());
		    if (index >= 0) {
			String clase = theList.getModel().getElementAt(index).toString();
			ConsultaDictadoClase dictadoClase = new ConsultaDictadoClase(app, clase, controladorUsuario,
				controladorActividadClase, controladorCuponera);
			dictadoClase.setVisible(true);
			app.getContentPane().add(dictadoClase);
		    }
		}
	    }
	};

	clasesLista.addMouseListener(mouseListenerClases);
    }
}
