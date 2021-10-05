package com.entrenamosuy.tarea1.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import com.entrenamosuy.core.AbstractFacadeCuponera;

public class AgregarActividadACuponera extends JInternalFrame {

    public AgregarActividadACuponera(Set<String> actividades, String cuponera, App app, AbstractFacadeCuponera controladorCuponera) {
    	setResizable(true);
    	setMaximizable(true);
    	setClosable(true);
        setTitle("Agregar actividad a cuponera.");
        setBounds(100, 100, 555, 360);

        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        getContentPane().setLayout(gridBagLayout);

        JLabel lblNewLabel = new JLabel("Seleccionar Actividad");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 1;
        gbc_lblNewLabel.gridy = 1;
        getContentPane().add(lblNewLabel, gbc_lblNewLabel);

        JComboBox actividadComboBox = new JComboBox(actividades.toArray(new String[0]));
        GridBagConstraints gbc_actividadComboBox = new GridBagConstraints();
        gbc_actividadComboBox.insets = new Insets(0, 0, 5, 5);
        gbc_actividadComboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_actividadComboBox.gridx = 3;
        gbc_actividadComboBox.gridy = 1;
        getContentPane().add(actividadComboBox, gbc_actividadComboBox);

        JLabel lblIngresarNombre = new JLabel("Seleccionar Cantidad Clases");
        GridBagConstraints gbc_lblIngresarNombre = new GridBagConstraints();
        gbc_lblIngresarNombre.anchor = GridBagConstraints.WEST;
        gbc_lblIngresarNombre.insets = new Insets(0, 0, 5, 5);
        gbc_lblIngresarNombre.gridx = 1;
        gbc_lblIngresarNombre.gridy = 3;
        getContentPane().add(lblIngresarNombre, gbc_lblIngresarNombre);

        SpinnerNumberModel model = new SpinnerNumberModel(1, 1, 100, 1);
        JSpinner cantSpinner = new JSpinner(model);
        GridBagConstraints gbc_cantSpinner = new GridBagConstraints();
        gbc_cantSpinner.insets = new Insets(0, 0, 5, 5);
        gbc_cantSpinner.gridx = 3;
        gbc_cantSpinner.gridy = 3;
        getContentPane().add(cantSpinner, gbc_cantSpinner);

        JButton aceptar = new JButton("Aceptar");
        GridBagConstraints gbc_aceptar = new GridBagConstraints();
        gbc_aceptar.insets = new Insets(0, 0, 5, 5);
        gbc_aceptar.gridx = 3;
        gbc_aceptar.gridy = 5;
        getContentPane().add(aceptar, gbc_aceptar);

        aceptar.addActionListener((ActionEvent a) -> {
            String actividad = (String) actividadComboBox.getSelectedItem();
            int cantidad = (int) cantSpinner.getValue();

            try {
        	controladorCuponera.agregarACuponera(cuponera, actividad, cantidad);
            } catch (Exception e) {
        	e.printStackTrace();
        	return;
            }

            JOptionPane.showMessageDialog(app,"Actividad agregada.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            setVisible(false);
        });
    }
}
