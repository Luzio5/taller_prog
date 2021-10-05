package com.entrenamosuy.tarea1.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.entrenamosuy.core.exceptions.InstitucionRepetidaException;
import com.entrenamosuy.core.AbstractFacadeActividad;

public class AltaInstitucion extends JInternalFrame {

    public AltaInstitucion(AbstractFacadeActividad controladorActividadClase, App app) {
    	setMaximizable(true);
    	setResizable(true);
    	setClosable(true);
        setTitle("Alta de institucion deportiva");
        getContentPane().setForeground(Color.RED);
        setBounds(100, 100, 475, 249);
        
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        getContentPane().setLayout(gridBagLayout);

        JLabel lblNewLabel = new JLabel("Ingresar Nombre");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 1;
        gbc_lblNewLabel.gridy = 1;
        getContentPane().add(lblNewLabel, gbc_lblNewLabel);

        JTextField nombreField = new JTextField();
        GridBagConstraints gbc_nombreField = new GridBagConstraints();
        gbc_nombreField.insets = new Insets(0, 0, 5, 5);
        gbc_nombreField.fill = GridBagConstraints.HORIZONTAL;
        gbc_nombreField.gridx = 3;
        gbc_nombreField.gridy = 1;
        getContentPane().add(nombreField, gbc_nombreField);
        nombreField.setColumns(10);

        JLabel lblIngresarNombre = new JLabel("Ingresar Descripcion");
        GridBagConstraints gbc_lblIngresarNombre = new GridBagConstraints();
        gbc_lblIngresarNombre.anchor = GridBagConstraints.WEST;
        gbc_lblIngresarNombre.insets = new Insets(0, 0, 5, 5);
        gbc_lblIngresarNombre.gridx = 1;
        gbc_lblIngresarNombre.gridy = 3;
        getContentPane().add(lblIngresarNombre, gbc_lblIngresarNombre);
        
        JTextField descripcionField = new JTextField();
        GridBagConstraints gbc_descripcionField = new GridBagConstraints();
        gbc_descripcionField.insets = new Insets(0, 0, 5, 5);
        gbc_descripcionField.fill = GridBagConstraints.HORIZONTAL;
        gbc_descripcionField.gridx = 3;
        gbc_descripcionField.gridy = 3;
        getContentPane().add(descripcionField, gbc_descripcionField);

        JLabel lblIngresarApellido = new JLabel("Ingresar URL");
        GridBagConstraints gbc_lblIngresarApellido = new GridBagConstraints();
        gbc_lblIngresarApellido.anchor = GridBagConstraints.WEST;
        gbc_lblIngresarApellido.insets = new Insets(0, 0, 5, 5);
        gbc_lblIngresarApellido.gridx = 1;
        gbc_lblIngresarApellido.gridy = 5;
        getContentPane().add(lblIngresarApellido, gbc_lblIngresarApellido);

        JTextField urlField = new JTextField();
        GridBagConstraints gbc_urlField = new GridBagConstraints();
        gbc_urlField.insets = new Insets(0, 0, 5, 5);
        gbc_urlField.fill = GridBagConstraints.HORIZONTAL;
        gbc_urlField.gridx = 3;
        gbc_urlField.gridy = 5;
        getContentPane().add(urlField, gbc_urlField);
        urlField.setColumns(10);

        JButton aceptar = new JButton("Aceptar");
        GridBagConstraints gbc_aceptar = new GridBagConstraints();
        gbc_aceptar.insets = new Insets(0, 0, 5, 5);
        gbc_aceptar.gridx = 3;
        gbc_aceptar.gridy = 7;
        getContentPane().add(aceptar, gbc_aceptar);
        
        aceptar.addActionListener((ActionEvent e) -> {
            String nombre = nombreField.getText();
            String desc = descripcionField.getText();
            String link = urlField.getText();
            
            try {
		controladorActividadClase.crearInstitucion(nombre, desc, new URL(link));
	    } catch (MalformedURLException e1) {
		urlField.setText("");
		JOptionPane.showMessageDialog(app, "URL no valida", "error", JOptionPane.ERROR_MESSAGE);
		return;
	    } catch (InstitucionRepetidaException e2) {
		nombreField.setText("");
		JOptionPane.showMessageDialog(app, "Institucion ya existente", "error", JOptionPane.ERROR_MESSAGE);
		return;
	    }
            
            JOptionPane.showMessageDialog(app,"Institucion creada exitosamente,", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            setVisible(true);
        });
    }
}