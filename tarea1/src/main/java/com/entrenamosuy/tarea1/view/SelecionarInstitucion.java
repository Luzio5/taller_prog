package com.entrenamosuy.tarea1.view;

import com.entrenamosuy.core.util.Triple;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SelecionarInstitucion extends JInternalFrame {

    public interface Callback {
        void run(String institucion);
    }

    public SelecionarInstitucion(Set<Triple<String, String, URL>> instituciones, Callback callback) {
        setMaximizable(true);
        setResizable(true);
        setClosable(true);
        setTitle("Selecionar institucion");
        setSize(398, 273);

        List<Triple<String, String, URL>> institucionesLista = new ArrayList<>(instituciones.size());
        institucionesLista.addAll(instituciones);

        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 350, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
        getContentPane().setLayout(gridBagLayout);

        String[] datos = new String[institucionesLista.size()];

        for (int i = 0; i < institucionesLista.size(); i++)
            datos[i] = institucionesLista.get(i).getFirst();

        JComboBox<String> comboBox = new JComboBox<String>(datos);
        GridBagConstraints gbc_comboBox = new GridBagConstraints();
        gbc_comboBox.insets = new Insets(0, 0, 5, 5);
        gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBox.gridx = 1;
        gbc_comboBox.gridy = 0;
        getContentPane().add(comboBox, gbc_comboBox);

        JButton btnNewButton = new JButton("Aceptar");
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
        gbc_btnNewButton.gridx = 1;
        gbc_btnNewButton.gridy = 1;
        getContentPane().add(btnNewButton, gbc_btnNewButton);

        btnNewButton.addActionListener((ActionEvent a) -> {
            callback.run((String) comboBox.getSelectedItem());
            dispose();
        });
    }
}
