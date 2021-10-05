package com.entrenamosuy.tarea1.view;

import javax.swing.JInternalFrame;

import com.entrenamosuy.core.data.DataClase;
import com.entrenamosuy.core.data.DescProfesor;
import com.entrenamosuy.core.exceptions.ClaseNoEncontradaException;
import com.entrenamosuy.core.AbstractFacadeActividad;
import com.entrenamosuy.core.AbstractFacadeCuponera;
import com.entrenamosuy.core.AbstractFacadeUsuario;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JList;

public class ConsultaDictadoClase extends JInternalFrame {
    private JTextField nombreField;
    private JTextField inicioField;
    private JTextField cantMinField;
    private JTextField cantMaxField;
    private JTextField urlField;
    private JTextField actividadField;

    public ConsultaDictadoClase(App app, String clase, AbstractFacadeUsuario controladorUsuario,
                                AbstractFacadeActividad controladorActividadClase, AbstractFacadeCuponera controladorCuponera) {
	setMaximizable(true);
	setResizable(true);
	setClosable(true);
	setTitle("Consulta clase");
	setSize(505, 499);

	GridBagLayout gridBagLayout = new GridBagLayout();
	gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
	gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
	gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
		1.0, Double.MIN_VALUE };
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

	JLabel lblInicio = new JLabel("Inicio");
	GridBagConstraints gbc_lblInicio = new GridBagConstraints();
	gbc_lblInicio.insets = new Insets(0, 0, 5, 5);
	gbc_lblInicio.anchor = GridBagConstraints.WEST;
	gbc_lblInicio.gridx = 1;
	gbc_lblInicio.gridy = 3;
	getContentPane().add(lblInicio, gbc_lblInicio);

	inicioField = new JTextField();
	inicioField.setEditable(false);
	GridBagConstraints gbc_inicioField = new GridBagConstraints();
	gbc_inicioField.insets = new Insets(0, 0, 5, 5);
	gbc_inicioField.fill = GridBagConstraints.HORIZONTAL;
	gbc_inicioField.gridx = 3;
	gbc_inicioField.gridy = 3;
	getContentPane().add(inicioField, gbc_inicioField);
	inicioField.setColumns(10);

	JLabel lblCantidadMinima = new JLabel("Cantidad minima");
	GridBagConstraints gbc_lblCantidadMinima = new GridBagConstraints();
	gbc_lblCantidadMinima.anchor = GridBagConstraints.WEST;
	gbc_lblCantidadMinima.insets = new Insets(0, 0, 5, 5);
	gbc_lblCantidadMinima.gridx = 1;
	gbc_lblCantidadMinima.gridy = 5;
	getContentPane().add(lblCantidadMinima, gbc_lblCantidadMinima);

	cantMinField = new JTextField();
	cantMinField.setEditable(false);
	GridBagConstraints gbc_cantMinField = new GridBagConstraints();
	gbc_cantMinField.insets = new Insets(0, 0, 5, 5);
	gbc_cantMinField.fill = GridBagConstraints.HORIZONTAL;
	gbc_cantMinField.gridx = 3;
	gbc_cantMinField.gridy = 5;
	getContentPane().add(cantMinField, gbc_cantMinField);
	cantMinField.setColumns(10);

	JLabel lblCantidadMaxima = new JLabel("Cantidad maxima");
	GridBagConstraints gbc_lblCantidadMaxima = new GridBagConstraints();
	gbc_lblCantidadMaxima.anchor = GridBagConstraints.WEST;
	gbc_lblCantidadMaxima.insets = new Insets(0, 0, 5, 5);
	gbc_lblCantidadMaxima.gridx = 1;
	gbc_lblCantidadMaxima.gridy = 7;
	getContentPane().add(lblCantidadMaxima, gbc_lblCantidadMaxima);

	cantMaxField = new JTextField();
	cantMaxField.setEditable(false);
	GridBagConstraints gbc_cantMaxField = new GridBagConstraints();
	gbc_cantMaxField.insets = new Insets(0, 0, 5, 5);
	gbc_cantMaxField.fill = GridBagConstraints.HORIZONTAL;
	gbc_cantMaxField.gridx = 3;
	gbc_cantMaxField.gridy = 7;
	getContentPane().add(cantMaxField, gbc_cantMaxField);
	cantMaxField.setColumns(10);

	JLabel lblUrlAcceso = new JLabel("URL acceso");
	GridBagConstraints gbc_lblUrlAcceso = new GridBagConstraints();
	gbc_lblUrlAcceso.insets = new Insets(0, 0, 5, 5);
	gbc_lblUrlAcceso.anchor = GridBagConstraints.WEST;
	gbc_lblUrlAcceso.gridx = 1;
	gbc_lblUrlAcceso.gridy = 9;
	getContentPane().add(lblUrlAcceso, gbc_lblUrlAcceso);

	urlField = new JTextField();
	urlField.setEditable(false);
	GridBagConstraints gbc_urlField = new GridBagConstraints();
	gbc_urlField.insets = new Insets(0, 0, 5, 5);
	gbc_urlField.fill = GridBagConstraints.HORIZONTAL;
	gbc_urlField.gridx = 3;
	gbc_urlField.gridy = 9;
	getContentPane().add(urlField, gbc_urlField);
	urlField.setColumns(10);

	JLabel lblActividad = new JLabel("Actividad");
	GridBagConstraints gbc_lblActividad = new GridBagConstraints();
	gbc_lblActividad.insets = new Insets(0, 0, 5, 5);
	gbc_lblActividad.anchor = GridBagConstraints.WEST;
	gbc_lblActividad.gridx = 1;
	gbc_lblActividad.gridy = 11;
	getContentPane().add(lblActividad, gbc_lblActividad);

	actividadField = new JTextField();
	actividadField.setEditable(false);
	GridBagConstraints gbc_actividadField = new GridBagConstraints();
	gbc_actividadField.insets = new Insets(0, 0, 5, 5);
	gbc_actividadField.fill = GridBagConstraints.HORIZONTAL;
	gbc_actividadField.gridx = 3;
	gbc_actividadField.gridy = 11;
	getContentPane().add(actividadField, gbc_actividadField);
	actividadField.setColumns(10);

	JLabel lblProfesores = new JLabel("Profesores");
	GridBagConstraints gbc_lblProfesores = new GridBagConstraints();
	gbc_lblProfesores.insets = new Insets(0, 0, 5, 5);
	gbc_lblProfesores.anchor = GridBagConstraints.WEST;
	gbc_lblProfesores.gridx = 1;
	gbc_lblProfesores.gridy = 13;
	getContentPane().add(lblProfesores, gbc_lblProfesores);

	DataClase dataClase = null;

	try {
	    dataClase = controladorActividadClase.consultarClase(clase);
	} catch (ClaseNoEncontradaException e) {
	    e.printStackTrace();
	    return;
	}

	nombreField.setText(dataClase.getNombre());
	inicioField.setText(dataClase.getInicio().toString());
	cantMinField.setText(Integer.toString(dataClase.getCantMin()));
	cantMaxField.setText(Integer.toString(dataClase.getCantMax()));
	urlField.setText(dataClase.getAccesoURL().toString());
	actividadField.setText(dataClase.getActividad().getNombre());

	List<String> profesoresLista = new ArrayList<>();

	for (DescProfesor p : dataClase.getProfesores())
	    profesoresLista.add(p.getNickname());

	JList<String> list = new JList<>(profesoresLista.toArray(new String[] {}));
	GridBagConstraints gbc_list = new GridBagConstraints();
	gbc_list.insets = new Insets(0, 0, 5, 5);
	gbc_list.fill = GridBagConstraints.BOTH;
	gbc_list.gridx = 3;
	gbc_list.gridy = 13;
	getContentPane().add(list, gbc_list);

	MouseListener mouseListener = new MouseAdapter() {

	    public void mouseClicked(MouseEvent mouseEvent) {
		JList<?> theList = (JList<?>) mouseEvent.getSource();
		if (mouseEvent.getClickCount() == 2) {
		    int index = theList.locationToIndex(mouseEvent.getPoint());
		    if (index >= 0) {
			String profesor = theList.getModel().getElementAt(index).toString();
			ConsultaProfesor dictadoClase = new ConsultaProfesor(app, profesor, controladorUsuario,
				controladorCuponera, controladorActividadClase);
			dictadoClase.setVisible(true);
			app.getContentPane().add(dictadoClase);
		    }
		}
	    }
	};

	list.addMouseListener(mouseListener);
    }
}
