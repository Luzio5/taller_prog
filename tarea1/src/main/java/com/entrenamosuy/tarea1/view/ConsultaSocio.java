package com.entrenamosuy.tarea1.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

import com.entrenamosuy.core.data.DataClase;
import com.entrenamosuy.core.data.DataSocio;
import com.entrenamosuy.core.AbstractFacadeActividad;
import com.entrenamosuy.core.AbstractFacadeCuponera;
import com.entrenamosuy.core.AbstractFacadeUsuario;

public class ConsultaSocio extends JInternalFrame {

    public ConsultaSocio(App app, AbstractFacadeActividad controladorActividadClase,
						 AbstractFacadeUsuario controladorUsuario, AbstractFacadeCuponera controladorCuponera, String nickname) {
	DataSocio data = null;

	try {
	    data = controladorUsuario.consultarSocio(nickname);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	
	String nome = data.getNombre();
	String apellido = data.getApellido();
	String correo = data.getCorreo().toString();
	String nacimiento = data.getNacimiento().toString();

	List<String> clasesLista = new ArrayList<String>();
	for (DataClase c : data.getClases())
	    clasesLista.add(c.getNombre());

	setResizable(true);
	setClosable(true);
	setTitle("Consulta socio");
	setSize(460, 412);

	GridBagLayout gridBagLayout = new GridBagLayout();
	gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
	gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
	gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0,
		Double.MIN_VALUE };
	getContentPane().setLayout(gridBagLayout);

	JLabel lblNickname = new JLabel("Nickname");
	GridBagConstraints gbc_lblNickname = new GridBagConstraints();
	gbc_lblNickname.anchor = GridBagConstraints.WEST;
	gbc_lblNickname.insets = new Insets(0, 0, 5, 5);
	gbc_lblNickname.gridx = 1;
	gbc_lblNickname.gridy = 1;
	getContentPane().add(lblNickname, gbc_lblNickname);

	JTextField textField = new JTextField();
	textField.setEditable(false);
	textField.setText(nickname);
	GridBagConstraints gbc_textField = new GridBagConstraints();
	gbc_textField.insets = new Insets(0, 0, 5, 5);
	gbc_textField.fill = GridBagConstraints.HORIZONTAL;
	gbc_textField.gridx = 3;
	gbc_textField.gridy = 1;
	getContentPane().add(textField, gbc_textField);
	textField.setColumns(10);

	JLabel lblNombre = new JLabel("Nombre");
	GridBagConstraints gbc_lblNombre = new GridBagConstraints();
	gbc_lblNombre.anchor = GridBagConstraints.WEST;
	gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
	gbc_lblNombre.gridx = 1;
	gbc_lblNombre.gridy = 3;
	getContentPane().add(lblNombre, gbc_lblNombre);

	JTextField textField_1 = new JTextField();
	textField_1.setEditable(false);
	textField_1.setColumns(10);
	textField_1.setText(nome);
	GridBagConstraints gbc_textField_1 = new GridBagConstraints();
	gbc_textField_1.insets = new Insets(0, 0, 5, 5);
	gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
	gbc_textField_1.gridx = 3;
	gbc_textField_1.gridy = 3;
	getContentPane().add(textField_1, gbc_textField_1);

	JLabel lblApellido = new JLabel("Apellido");
	GridBagConstraints gbc_lblApellido = new GridBagConstraints();
	gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
	gbc_lblApellido.anchor = GridBagConstraints.WEST;
	gbc_lblApellido.gridx = 1;
	gbc_lblApellido.gridy = 5;
	getContentPane().add(lblApellido, gbc_lblApellido);

	JTextField textField_2 = new JTextField();
	textField_2.setEditable(false);
	textField_2.setColumns(10);
	textField_2.setText(apellido);
	GridBagConstraints gbc_textField_2 = new GridBagConstraints();
	gbc_textField_2.insets = new Insets(0, 0, 5, 5);
	gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
	gbc_textField_2.gridx = 3;
	gbc_textField_2.gridy = 5;
	getContentPane().add(textField_2, gbc_textField_2);

	JLabel lblCorreo = new JLabel("Correo");
	GridBagConstraints gbc_lblCorreo = new GridBagConstraints();
	gbc_lblCorreo.insets = new Insets(0, 0, 5, 5);
	gbc_lblCorreo.anchor = GridBagConstraints.WEST;
	gbc_lblCorreo.gridx = 1;
	gbc_lblCorreo.gridy = 7;
	getContentPane().add(lblCorreo, gbc_lblCorreo);

	JTextField textField_3 = new JTextField();
	textField_3.setEditable(false);
	textField_3.setColumns(10);
	textField_3.setText(correo);
	GridBagConstraints gbc_textField_3 = new GridBagConstraints();
	gbc_textField_3.insets = new Insets(0, 0, 5, 5);
	gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
	gbc_textField_3.gridx = 3;
	gbc_textField_3.gridy = 7;
	getContentPane().add(textField_3, gbc_textField_3);

	JLabel lblNacimiento = new JLabel("Nacimiento");
	GridBagConstraints gbc_lblNacimiento = new GridBagConstraints();
	gbc_lblNacimiento.insets = new Insets(0, 0, 5, 5);
	gbc_lblNacimiento.anchor = GridBagConstraints.WEST;
	gbc_lblNacimiento.gridx = 1;
	gbc_lblNacimiento.gridy = 9;
	getContentPane().add(lblNacimiento, gbc_lblNacimiento);

	JTextField textField_4 = new JTextField();
	textField_4.setEditable(false);
	textField_4.setColumns(10);
	textField_4.setText(nacimiento);
	GridBagConstraints gbc_textField_4 = new GridBagConstraints();
	gbc_textField_4.insets = new Insets(0, 0, 5, 5);
	gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
	gbc_textField_4.gridx = 3;
	gbc_textField_4.gridy = 9;
	getContentPane().add(textField_4, gbc_textField_4);

	JLabel lblClases = new JLabel("Clases");
	GridBagConstraints gbc_lblClases = new GridBagConstraints();
	gbc_lblClases.anchor = GridBagConstraints.WEST;
	gbc_lblClases.insets = new Insets(0, 0, 5, 5);
	gbc_lblClases.gridx = 1;
	gbc_lblClases.gridy = 11;
	getContentPane().add(lblClases, gbc_lblClases);

	JList<String> clases = new JList<>(clasesLista.toArray(new String[] {}));
	GridBagConstraints gbc_clases = new GridBagConstraints();
	gbc_clases.insets = new Insets(0, 0, 5, 5);
	gbc_clases.fill = GridBagConstraints.BOTH;
	gbc_clases.gridx = 3;
	gbc_clases.gridy = 11;
	getContentPane().add(clases, gbc_clases);

	MouseListener mouseListener = new MouseAdapter() {

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

	clases.addMouseListener(mouseListener);
    }
}