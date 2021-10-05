package com.entrenamosuy.tarea1.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.entrenamosuy.core.exceptions.ActividadRepetidaException;
import com.entrenamosuy.core.exceptions.InstitucionNoEncontradaException;
import com.entrenamosuy.core.AbstractFacadeActividad;
import com.entrenamosuy.core.util.FechaUtil;
import com.entrenamosuy.core.util.Triple;
import com.toedter.calendar.JDateChooser;

public class AltaActividad extends JInternalFrame {
    private JTextField nombre;
    private JTextField descripcion;
    private JTextField duracion;
    private JTextField costo;

    public AltaActividad(App app, AbstractFacadeActividad controladorActividadClase) {
	String[] instituciones = controladorActividadClase.obtenerDescInstituciones()
		.stream()
		.map(Triple::getFirst)
		.toArray(String[]::new);
	
    	setClosable(true);
    	setResizable(true);
    	setMaximizable(true);
        setBounds(100, 100, 554, 308);
        setTitle("Alta de actividad deportiva");
        getContentPane().setForeground(Color.RED);
        
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        getContentPane().setLayout(gridBagLayout);

        JLabel lblNewLabel = new JLabel("Seleccionar Institucion");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 1;
        gbc_lblNewLabel.gridy = 1;
        getContentPane().add(lblNewLabel, gbc_lblNewLabel);

        JComboBox institucionComboBox = new JComboBox(instituciones);
        GridBagConstraints gbc_institucionComboBox = new GridBagConstraints();
        gbc_institucionComboBox.insets = new Insets(0, 0, 5, 5);
        gbc_institucionComboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_institucionComboBox.gridx = 3;
        gbc_institucionComboBox.gridy = 1;
        getContentPane().add(institucionComboBox, gbc_institucionComboBox);

        JLabel lblIngresarNombre = new JLabel("Ingresar Nombre");
        GridBagConstraints gbc_lblIngresarNombre = new GridBagConstraints();
        gbc_lblIngresarNombre.anchor = GridBagConstraints.WEST;
        gbc_lblIngresarNombre.insets = new Insets(0, 0, 5, 5);
        gbc_lblIngresarNombre.gridx = 1;
        gbc_lblIngresarNombre.gridy = 2;
        getContentPane().add(lblIngresarNombre, gbc_lblIngresarNombre);

        nombre = new JTextField();
        GridBagConstraints gbc_nombre = new GridBagConstraints();
        gbc_nombre.insets = new Insets(0, 0, 5, 5);
        gbc_nombre.fill = GridBagConstraints.HORIZONTAL;
        gbc_nombre.gridx = 3;
        gbc_nombre.gridy = 2;
        getContentPane().add(nombre, gbc_nombre);
        nombre.setColumns(10);

        JLabel lblIngresarApellido = new JLabel("Ingresar descripcion");
        GridBagConstraints gbc_lblIngresarApellido = new GridBagConstraints();
        gbc_lblIngresarApellido.anchor = GridBagConstraints.WEST;
        gbc_lblIngresarApellido.insets = new Insets(0, 0, 5, 5);
        gbc_lblIngresarApellido.gridx = 1;
        gbc_lblIngresarApellido.gridy = 3;
        getContentPane().add(lblIngresarApellido, gbc_lblIngresarApellido);

        descripcion = new JTextField();
        GridBagConstraints gbc_descripcion = new GridBagConstraints();
        gbc_descripcion.insets = new Insets(0, 0, 5, 5);
        gbc_descripcion.fill = GridBagConstraints.HORIZONTAL;
        gbc_descripcion.gridx = 3;
        gbc_descripcion.gridy = 3;
        getContentPane().add(descripcion, gbc_descripcion);
        descripcion.setColumns(10);

        JLabel lblIngresarEmail = new JLabel("Ingresar duracion (min)");
        GridBagConstraints gbc_lblIngresarEmail = new GridBagConstraints();
        gbc_lblIngresarEmail.anchor = GridBagConstraints.WEST;
        gbc_lblIngresarEmail.insets = new Insets(0, 0, 5, 5);
        gbc_lblIngresarEmail.gridx = 1;
        gbc_lblIngresarEmail.gridy = 4;
        getContentPane().add(lblIngresarEmail, gbc_lblIngresarEmail);

        duracion = new JTextField();
        GridBagConstraints gbc_duracion = new GridBagConstraints();
        gbc_duracion.insets = new Insets(0, 0, 5, 5);
        gbc_duracion.fill = GridBagConstraints.HORIZONTAL;
        gbc_duracion.gridx = 3;
        gbc_duracion.gridy = 4;
        getContentPane().add(duracion, gbc_duracion);
        duracion.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Ingresar costo");
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_1.gridx = 1;
        gbc_lblNewLabel_1.gridy = 5;
        getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);

        costo = new JTextField();
        GridBagConstraints gbc_costo = new GridBagConstraints();
        gbc_costo.insets = new Insets(0, 0, 5, 5);
        gbc_costo.fill = GridBagConstraints.HORIZONTAL;
        gbc_costo.gridx = 3;
        gbc_costo.gridy = 5;
        getContentPane().add(costo, gbc_costo);
        costo.setColumns(10);

        JLabel lblIngresarFecha = new JLabel("Ingresar fecha");
        GridBagConstraints gbc_lblIngresarFecha = new GridBagConstraints();
        gbc_lblIngresarFecha.anchor = GridBagConstraints.WEST;
        gbc_lblIngresarFecha.insets = new Insets(0, 0, 5, 5);
        gbc_lblIngresarFecha.gridx = 1;
        gbc_lblIngresarFecha.gridy = 7;
        getContentPane().add(lblIngresarFecha, gbc_lblIngresarFecha);

        JDateChooser calendario = new JDateChooser();
        GridBagConstraints gbc_calendario = new GridBagConstraints();
        gbc_calendario.fill = GridBagConstraints.HORIZONTAL;
        gbc_calendario.insets = new Insets(0, 0, 5, 5);
        gbc_calendario.gridx = 3;
        gbc_calendario.gridy = 7;
        getContentPane().add(calendario, gbc_calendario);
        
        JButton aceptar = new JButton("Aceptar");
        GridBagConstraints gbc_aceptar = new GridBagConstraints();
        gbc_aceptar.insets = new Insets(0, 0, 0, 5);
        gbc_aceptar.gridx = 3;
        gbc_aceptar.gridy = 9;
        getContentPane().add(aceptar, gbc_aceptar);
        
        aceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Duration duration = Duration.ofMinutes(Integer.parseInt(duracion.getText()));
                    float precio = Float.parseFloat(costo.getText());
                    LocalDate fecha = FechaUtil.toLocalDate(calendario.getDate());

                    controladorActividadClase.crearActividad()
                        .setInstitucion((String) institucionComboBox.getSelectedItem())
                        .setNombre(nombre.getText())
                        .setDescripcion(descripcion.getText())
                        .setDuracion(duration)
                        .setCosto(precio)
                        .setRegistro(fecha)
                        .invoke();

                    JOptionPane.showMessageDialog(app, "Actividad registrada exitosamente.");
                    setVisible(false);
                } catch (ActividadRepetidaException are) {
                    JOptionPane.showMessageDialog(app, "Ya existe una actividad con ese nombre.", "error", JOptionPane.ERROR_MESSAGE);
                    nombre.setText("");
                    return;
                } catch (InstitucionNoEncontradaException inee) {
                    inee.printStackTrace();
                    return;
                }

                setVisible(false);
            }
        });
    }
}