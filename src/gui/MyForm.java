package gui;

import models.Livre;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MyForm extends JFrame {

    List<Livre> listeLivre = new ArrayList<>();
    DefaultTableModel model;

    private JPanel mainPanel;
    private JPanel headerPanel;
    private JPanel rightPanel;
    private JPanel leftPanel;
    private JPanel formPanel;
    private JPanel labelsPanel;
    private JPanel txtFieldsPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JRadioButton ouiRadioButton;
    private JRadioButton nonRadioButton;
    ButtonGroup radioBtnGroupe;
    private JTable livreTable;
    private JButton btnSave;
    private JPanel actionPanel;
    private JButton btnCancel;

    public MyForm() throws HeadlessException {
        setContentPane(mainPanel);
        setTitle("simple gui app");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 500);

        radioBtnGroupe = new ButtonGroup();
        radioBtnGroupe.add(ouiRadioButton);
        radioBtnGroupe.add(nonRadioButton);
        nonRadioButton.setSelected(true);
        model = fillTable();
        livreTable.setModel(model);

        setVisible(true);
        btnSave.addActionListener(e -> {
            Livre newLivre = buildNewLivre();
            listeLivre.add(newLivre);
            model.addRow(new Object[]{newLivre.getId(), newLivre.getTitre(), newLivre.isDisponible(), newLivre.getAuteur()});
            clearTxtFields();
        });
        btnCancel.addActionListener(e -> {
            clearTxtFields();
        });
    }

    private Livre buildNewLivre() {
        // txt from jTextfields
        // Create new Livre
        // retrun new livre

        return null;
    }

    private void clearTxtFields() {
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
    }

    private DefaultTableModel fillTable() {
        for (long i = 1; i <= 10; i++) {
            Livre livre = new Livre(i, "titre" + i, true, "auteur" + i);
            listeLivre.add(livre);
        }

        String[] columnNames = {"Id", "Titre", "Disponible", "Auteur"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);


        for (Livre livre : listeLivre) {
            model.addRow(new Object[]{livre.getId(), livre.getTitre(), livre.isDisponible(), livre.getAuteur()});
        }

        return model;

    }

    public static void main(String[] args) {
        new MyForm();

    }
}
