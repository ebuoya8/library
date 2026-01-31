package gui;

import models.Adherent;
import models.Livre;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.util.ArrayList;
import java.util.List;

public class MyForm extends JFrame {

    List<Livre> listeLivre = new ArrayList<>();
    List<Adherent> liseAdherent = new ArrayList<>();
    DefaultTableModel livreModel;
    DefaultTableModel adherenttModel;

    private JPanel mainPanel;
    private JPanel headerPanel;
    private JPanel rightPanel;
    private JPanel leftPanel;
    private JPanel formPanel;
    private JPanel labelsPanel;
    private JPanel txtFieldsPanel;
    private JTextField txtId;
    private JTextField txtTitre;
    private JTextField txtAuteur;
    private JRadioButton ouiRadioButton;
    private JRadioButton nonRadioButton;
    ButtonGroup radioBtnGroupe;
    private JTable livreTable;
    private JButton btnSave;
    private JButton btnCancel;
    private JPanel actionPanel;
    private JTabbedPane navBar;
    private JPanel livrePanel;
    private JPanel adherentPanel;
    private JLabel tableLivre;
    private JPanel adhTablePanel;
    private JTable adhTable;
    private JPanel modadhPanel;
    private JPanel attributsPanel;
    private JTextField textID;
    private JTextField textPrenom;
    private JTextField textNom;
    private JTextField textCin;
    private JTextField textnumTele;
    private JPanel btnPanel;
    private JButton btnAjout;
    private JButton btnSupp;

    public MyForm() throws HeadlessException {
        setContentPane(mainPanel);
        setTitle("simple gui app");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 500);

        radioBtnGroupe = new ButtonGroup();
        radioBtnGroupe.add(ouiRadioButton);
        radioBtnGroupe.add(nonRadioButton);
        nonRadioButton.setSelected(true);
        livreModel = fillLivreTable();
        livreTable.setModel(livreModel);
        setVisible(true);

        btnSave.addActionListener(e -> {
            Livre newLivre = buildNewLivre();
            listeLivre.add(newLivre);
            livreModel.addRow(new Object[]{newLivre.getId(), newLivre.getTitre(), newLivre.isDisponible(), newLivre.getAuteur()});
            clearTxtLivreFields();
        });
        btnCancel.addActionListener(e -> {
            clearTxtLivreFields();
        });
        adhTable.addComponentListener(new ComponentAdapter() {
        });

        adherenttModel = fillAdherentTable();
        adhTable.setModel(adherenttModel);


        btnAjout.addActionListener(e -> {
            Adherent newAdherent = buildNewAdherent();
            liseAdherent.add(newAdherent);
            adherenttModel.addRow(new Object[]{newAdherent.getID(),newAdherent.getPrenom(),newAdherent.getNom(),newAdherent.getCin(),newAdherent.getNmTelephone()});
            clearTxtLivreFields();

        });


        btnSupp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearTxtAdherentFields();
            }
        });
    }

    private Livre buildNewLivre() {
        boolean isDisponible = ouiRadioButton.isSelected();

        return new Livre(Long.parseLong(txtId.getText()), txtTitre.getText(), isDisponible, txtAuteur.getText()); // ajouter les attributs
    }

    private void clearTxtLivreFields() {
        txtId.setText("");
        txtTitre.setText("");
        txtAuteur.setText("");
    }

    private Adherent buildNewAdherent () {
        return new Adherent(Long.parseLong(textID.getText()), textPrenom.getText(), textNom.getText(), Long.parseLong(textCin.getText()), Long.parseLong(textnumTele.getText()));

    }

    private void clearTxtAdherentFields (){
        textID.setText("");
        textPrenom.setText("");
        textNom.setText("");
        textCin.setText("");
        textnumTele.setText("");
    }

    private DefaultTableModel fillLivreTable() {
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

    private DefaultTableModel fillAdherentTable() {
        for (long i = 1; i <= 10; i++) {
            Adherent adherent = new Adherent (i, "Prenom" + i, "Nom"+i, i*1111, i*1111111111);
            liseAdherent.add(adherent);
        }

        String[] columnNames = {"Id", "Prenom", "Nom", "CIN","nmTelephone"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);


        for (Adherent adherent : liseAdherent) {
            model.addRow(new Object[]{adherent.getID(), adherent.getPrenom(), adherent.getNom(), adherent.getCin(),adherent.getNmTelephone()});
        }

        return model;

    }



    public static void main(String[] args) {
        new MyForm();

    }
}
