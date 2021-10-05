package com.entrenamosuy.tarea1.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.*;

import com.entrenamosuy.core.util.Pair;

public class SelecionarActividad extends JInternalFrame {

    public interface Callback {

        void run(String actividad);
    }

    public SelecionarActividad(Set<Pair<String, String>> actividades, Callback callback) {
        setMaximizable(true);
        setResizable(true);
        setClosable(true);
        setTitle("Selecionar actividad");
        setSize(398, 273);

        List<Pair<String, String>> actividadesLista = new ArrayList<>(actividades.size());
        actividadesLista.addAll(actividades);

        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 350, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
        getContentPane().setLayout(gridBagLayout);

        String[] datos = new String[actividadesLista.size()];

        for (int i = 0; i < actividadesLista.size(); i++)
            datos[i] = actividadesLista.get(i).getFirst();

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