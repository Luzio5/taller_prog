package com.entrenamosuy.tarea1.view;

import com.entrenamosuy.core.exceptions.UsuarioNoEncontradoException;
import com.entrenamosuy.core.AbstractFacadeUsuario;
import com.entrenamosuy.core.util.FechaUtil;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;

public class ModificarDatosProfesor extends JInternalFrame {
    private JTextField nombreField;
    private JTextField apellidoField;
    private JDateChooser nacimientoField;
    private JTextField descripcionField;
    private JTextField biografiaField;
    private JTextField sitioWebField;

    public ModificarDatosProfesor(String nickname, AbstractFacadeUsuario controladorUsuario) {
        setTitle("Modificar datos profesor");
        setResizable(true);
        setClosable(true);
        setSize(668, 479);
        
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        getContentPane().setLayout(gridBagLayout);

        JLabel lblNombre = new JLabel("Nombre");
        GridBagConstraints gbc_lblNombre = new GridBagConstraints();
        gbc_lblNombre.anchor = GridBagConstraints.WEST;
        gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
        gbc_lblNombre.gridx = 1;
        gbc_lblNombre.gridy = 1;
        getContentPane().add(lblNombre, gbc_lblNombre);

        nombreField = new JTextField();
        GridBagConstraints gbc_nombre = new GridBagConstraints();
        gbc_nombre.insets = new Insets(0, 0, 5, 5);
        gbc_nombre.fill = GridBagConstraints.HORIZONTAL;
        gbc_nombre.gridx = 3;
        gbc_nombre.gridy = 1;
        getContentPane().add(nombreField, gbc_nombre);
        nombreField.setColumns(10);

        JLabel label = new JLabel("Apellido");
        GridBagConstraints gbc_label = new GridBagConstraints();
        gbc_label.anchor = GridBagConstraints.WEST;
        gbc_label.insets = new Insets(0, 0, 5, 5);
        gbc_label.gridx = 1;
        gbc_label.gridy = 3;
        getContentPane().add(label, gbc_label);

        apellidoField = new JTextField();
        GridBagConstraints gbc_apellido = new GridBagConstraints();
        gbc_apellido.insets = new Insets(0, 0, 5, 5);
        gbc_apellido.fill = GridBagConstraints.HORIZONTAL;
        gbc_apellido.gridx = 3;
        gbc_apellido.gridy = 3;
        getContentPane().add(apellidoField, gbc_apellido);
        apellidoField.setColumns(10);

        JLabel lblNacimiento = new JLabel("Nacimiento");
        GridBagConstraints gbc_lblNacimiento = new GridBagConstraints();
        gbc_lblNacimiento.insets = new Insets(0, 0, 5, 5);
        gbc_lblNacimiento.gridx = 1;
        gbc_lblNacimiento.gridy = 5;
        getContentPane().add(lblNacimiento, gbc_lblNacimiento);

        nacimientoField = new JDateChooser();
        GridBagConstraints gbc_nacimiento = new GridBagConstraints();
        gbc_nacimiento.insets = new Insets(0, 0, 5, 5);
        gbc_nacimiento.fill = GridBagConstraints.BOTH;
        gbc_nacimiento.gridx = 3;
        gbc_nacimiento.gridy = 5;
        getContentPane().add(nacimientoField, gbc_nacimiento);
        
        JLabel lblDescripcoin = new JLabel("Descripcion");
        GridBagConstraints gbc_lblDescripcoin = new GridBagConstraints();
        gbc_lblDescripcoin.insets = new Insets(0, 0, 5, 5);
        gbc_lblDescripcoin.gridx = 1;
        gbc_lblDescripcoin.gridy = 7;
        getContentPane().add(lblDescripcoin, gbc_lblDescripcoin);
        
        descripcionField = new JTextField();
        descripcionField.setColumns(10);
        GridBagConstraints gbc_descripcionField = new GridBagConstraints();
        gbc_descripcionField.insets = new Insets(0, 0, 5, 5);
        gbc_descripcionField.fill = GridBagConstraints.HORIZONTAL;
        gbc_descripcionField.gridx = 3;
        gbc_descripcionField.gridy = 7;
        getContentPane().add(descripcionField, gbc_descripcionField);
        
        JLabel lblBiografia = new JLabel("Biografia");
        GridBagConstraints gbc_lblBiografia = new GridBagConstraints();
        gbc_lblBiografia.anchor = GridBagConstraints.WEST;
        gbc_lblBiografia.insets = new Insets(0, 0, 5, 5);
        gbc_lblBiografia.gridx = 1;
        gbc_lblBiografia.gridy = 9;
        getContentPane().add(lblBiografia, gbc_lblBiografia);
        
        biografiaField = new JTextField();
        biografiaField.setColumns(10);
        GridBagConstraints gbc_biografiaField = new GridBagConstraints();
        gbc_biografiaField.insets = new Insets(0, 0, 5, 5);
        gbc_biografiaField.fill = GridBagConstraints.HORIZONTAL;
        gbc_biografiaField.gridx = 3;
        gbc_biografiaField.gridy = 9;
        getContentPane().add(biografiaField, gbc_biografiaField);
        
        JLabel lblSitioWeb = new JLabel("Sitio web");
        GridBagConstraints gbc_lblSitioWeb = new GridBagConstraints();
        gbc_lblSitioWeb.anchor = GridBagConstraints.WEST;
        gbc_lblSitioWeb.insets = new Insets(0, 0, 5, 5);
        gbc_lblSitioWeb.gridx = 1;
        gbc_lblSitioWeb.gridy = 11;
        getContentPane().add(lblSitioWeb, gbc_lblSitioWeb);
        
        sitioWebField = new JTextField();
        sitioWebField.setColumns(10);
        GridBagConstraints gbc_sitioWebField = new GridBagConstraints();
        gbc_sitioWebField.insets = new Insets(0, 0, 5, 5);
        gbc_sitioWebField.fill = GridBagConstraints.HORIZONTAL;
        gbc_sitioWebField.gridx = 3;
        gbc_sitioWebField.gridy = 11;
        getContentPane().add(sitioWebField, gbc_sitioWebField);

        JButton aceptar = new JButton("Aceptar");
        GridBagConstraints gbc_aceptar = new GridBagConstraints();
        gbc_aceptar.insets = new Insets(0, 0, 0, 5);
        gbc_aceptar.gridx = 3;
        gbc_aceptar.gridy = 13;
        getContentPane().add(aceptar, gbc_aceptar);

        aceptar.addActionListener((ActionEvent a) -> {
            String nombre = nombreField.getText();
            String apellido = apellidoField.getText();
            LocalDate nacimiento = null;
            String descripcion = descripcionField.getText();
            String biografia = biografiaField.getText();
            URL sitioWeb = null;
            
            nombre = nombre.length() == 0 ? null : nombre;
            apellido = apellido.length() == 0 ? null : apellido;
            descripcion = descripcion.length() == 0 ? null : descripcion;
            biografia = biografia.length() == 0 ? null : biografia;
            
            Date fecha = nacimientoField.getDate();
            if (fecha != null)
        	nacimiento = FechaUtil.toLocalDate(fecha);
            
            String sitioWebStr = sitioWebField.getText();
            if (sitioWebStr.length() > 0) {
        	try {
		    sitioWeb = new URL(sitioWebStr);
		} catch (MalformedURLException e) {
		    JOptionPane.showMessageDialog(this, "Sitio web invalido", "error", JOptionPane.ERROR_MESSAGE);
		    return;
		}
            }
            
            try {
                controladorUsuario.modificarDatosProfesor()
                    .setNickname(nickname)
                    .setNombre(nombre)
                    .setApellido(apellido)
                    .setNacimiento(nacimiento)
                    .setDescripcion(descripcion)
                    .setBiografia(biografia)
                    .setSitioWeb(sitioWeb)
                    .invoke();
            } catch (UsuarioNoEncontradoException e) {
                JOptionPane.showMessageDialog(this, "Nickname no encontrado", "error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            setVisible(false);
        });
    }
}
