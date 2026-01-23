import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class myForm extends JFrame {
    private JLabel jlfirstname;
    private JTextField textField1;
    private JButton cliqueDessusButton;
    private JPanel myFormPannel;

    public myForm () {
        setContentPane(myFormPannel);
        setTitle("simple gui app");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);
        setVisible(true);

        cliqueDessusButton.addActionListener(e-> {
            String firstName = textField1.getText();
            JOptionPane.showMessageDialog(myForm.this, "welcom "+firstName+" !");
        });
    }

    public static void main(String[] args) {
        new myForm();

    }


}

