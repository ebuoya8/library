package gui;

import models.Adherent;
import models.Emprunt;
import models.Livre;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MyForm extends JFrame {

    List<Livre> listeLivre = new ArrayList<>();
    List<Emprunt> listeEmprunt = new ArrayList<>();
    List<Adherent> listeAdherent = new ArrayList<>();
    DefaultTableModel livreModel;
    DefaultTableModel adherentModel;
    DefaultTableModel empruntModel = new DefaultTableModel(new Object[]{"Adherent", "Livre", "Date de l'emprunt"},0);
    private Adherent adherentTrouver = null;
    private Livre livreTrouver = null;


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
    private JPanel empruntPanel;
    private JPanel empTablePanel;
    private JTable empTable;
    private JPanel modEmpPanel;
    private JPanel formsPanel;
    private JTextField txtCinSaisi;
    private JTextField txtRefSaisi;
    private JTextField txtref;
    private JPanel empbtnPanel;
    private JButton btnChercherLivre;
    private JButton btnChercherAdherent;
    private JButton btnEmp;
    private JLabel txtAdhCin;

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
        empTable = new JTable(empruntModel);
        empTable.setFillsViewportHeight(true);
        empTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setVisible(true);


        btnSave.addActionListener(e -> {
            Livre newLivre = buildNewLivre();
            listeLivre.add(newLivre);
            livreModel.addRow(new Object[]{newLivre.getId(), newLivre.getTitre(), newLivre.isDisponible(), newLivre.getAuteur(), newLivre.getReference()});
            clearTxtLivreFields();
        });
        btnCancel.addActionListener(e -> {
            clearTxtLivreFields();
        });
        adhTable.addComponentListener(new ComponentAdapter() {
        });

        adherentModel = fillAdherentTable();
        adhTable.setModel(adherentModel);


        btnAjout.addActionListener(e -> {
            Adherent newAdherent = buildNewAdherent();
            listeAdherent.add(newAdherent);
            adherentModel.addRow(new Object[]{newAdherent.getID(), newAdherent.getPrenom(), newAdherent.getNom(), newAdherent.getCin(), newAdherent.getNmTelephone()});
            clearTxtLivreFields();

        });


        btnSupp.addActionListener(e -> clearTxtAdherentFields());
        btnChercherAdherent.addActionListener(e -> {
            Optional<Adherent> resultat = trouverAdherentParCin(listeAdherent, txtCinSaisi.getText());
            resultat.ifPresent((adh -> {
                adherentTrouver = resultat.get();
                JOptionPane.showMessageDialog(this,
                        "adhérent(e) trouvé(e) avec ce CIN, et il(le) porte le nom complet :" +adh.getNom() +" "+ adh.getPrenom(),
                        "trouvé",
                        JOptionPane.WARNING_MESSAGE);

            }));

            if (resultat.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Aucun adhérent trouvé avec ce CIN",
                        "Non trouvé",
                        JOptionPane.WARNING_MESSAGE);
                clearTxtEmpruntFields();
            }
        });
        btnChercherLivre.addActionListener(e -> {
            Optional<Livre> resultat = trouverLivreParReference(listeLivre, Long.parseLong(txtRefSaisi.getText()));
            resultat.ifPresent((liv -> {
                if (!liv.isDisponible()) {
                    JOptionPane.showMessageDialog(this,
                            "Ce livre n'est pas dispo pour le moment !",
                            "indisponible", JOptionPane.WARNING_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(this,
                            "livre trouvé avec cette référence porte le titre " + liv.getTitre(),
                            "trouvé",
                            JOptionPane.WARNING_MESSAGE);
                    livreTrouver = resultat.get();
                }
            }));

            if (resultat.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Aucun livretrouvé avec ce reférence",
                        "Non trouvé",
                        JOptionPane.WARNING_MESSAGE);
                clearTxtEmpruntFields();
            }

        });
        btnEmp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (adherentTrouver == null || livreTrouver == null) {
                    JOptionPane.showMessageDialog(MyForm.this, "Manque adhérent ou livre");
                    return;
                }

                Emprunt emprunt = new Emprunt(LocalDate.now(),livreTrouver,adherentTrouver);
                listeEmprunt.add(emprunt);
                livreTrouver.setDisponible(false);
                empruntModel.addRow(new Object[]{emprunt.getAdherent(),emprunt.getLivre(),emprunt.getDate()});
                JOptionPane.showMessageDialog(MyForm.this, "Emprunt enregistré !");

            }
        });
    }

    private Livre buildNewLivre() {
        boolean isDisponible = ouiRadioButton.isSelected();

        return new Livre(Long.parseLong(txtId.getText()), txtTitre.getText(), isDisponible, txtAuteur.getText(), Long.parseLong(txtref.getText())); // ajouter les attributs
    }

    private void clearTxtLivreFields() {
        txtId.setText("");
        txtTitre.setText("");
        txtAuteur.setText("");
        txtref.setText("");
    }

    private Adherent buildNewAdherent() {
        return new Adherent(Long.parseLong(textID.getText()), textPrenom.getText(), textNom.getText(),textCin.getText(), Long.parseLong(textnumTele.getText()));

    }

    public Optional<Adherent> trouverAdherentParCin(List<Adherent> listeAdherent, String cinRecherche) {
    if (cinRecherche == null || cinRecherche.trim().isEmpty()) {
        return Optional.empty();
    }

        String cinNormalise = cinRecherche.trim().toUpperCase();

        return listeAdherent.stream()
                .filter(a -> {
                    String cin = a.getCin();
                    return cin != null && cinNormalise.equals(cin.trim().toUpperCase());
                })
                .findFirst();
}

    public Optional<Livre> trouverLivreParReference(List<Livre> livres, long refRecherche) {
        return livres.stream()
                .filter(l -> l.getReference() == refRecherche)
                .findFirst();
    }



    private void clearTxtAdherentFields() {
        textID.setText("");
        textPrenom.setText("");
        textNom.setText("");
        textCin.setText("");
        textnumTele.setText("");
    }

    private DefaultTableModel fillLivreTable() {
        for (long i = 1; i <= 10; i++) {
            Livre livre = new Livre(i, "titre" + i, true, "auteur" + i, i * 101010);
            listeLivre.add(livre);
        }

        String[] columnNames = {"Id", "Titre", "Disponible", "Auteur", "Référence"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);


        for (Livre livre : listeLivre) {
            model.addRow(new Object[]{livre.getId(), livre.getTitre(), livre.isDisponible(), livre.getAuteur(), livre.getReference()});
        }

        return model;

    }

    private DefaultTableModel fillAdherentTable() {
        for (long i = 1; i <= 10; i++) {
            Adherent adherent = new Adherent(i, "Prenom" + i, "Nom" + i, "CIN"+i, i * 1111111111);
            listeAdherent.add(adherent);
        }

        String[] columnNames = {"Id", "Prenom", "Nom", "CIN", "nmTelephone"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);


        for (Adherent adherent : listeAdherent) {
            model.addRow(new Object[]{adherent.getID(), adherent.getPrenom(), adherent.getNom(), adherent.getCin(), adherent.getNmTelephone()});
        }

        return model;

    }

    private void clearTxtEmpruntFields() {
        txtRefSaisi.setText("");
        txtref.setText("");
    }

    private void fillTableEmprunt(Adherent adherent) {
        Livre livre = new Livre(1212,"Misérables",true,"Hugo",121211111);
        Emprunt emp = new Emprunt(LocalDate.now(),livre,adherent);
        listeEmprunt.add(emp);
        empruntModel.addRow(new Object[]{emp.adherent.getNom(),emp.livre.getTitre(),emp.getDate()});
        empTable.setModel(empruntModel);
    }

    
    public static void main(String[] args) {
        new MyForm();

    }
}
