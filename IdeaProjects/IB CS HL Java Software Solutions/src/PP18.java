import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PP18 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Programming Project 18");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PP18Panel panel = new PP18Panel();
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}

class PP18Panel extends JPanel {
    private JLabel subjectLabel, toLabel, ccLabel, bccLabel, messageLabel;
    private JTextField subjectInput, toInput, ccInput, bccInput, messageInput;
    private JButton send;

    public PP18Panel() {
        subjectLabel = new JLabel("Subject: ");
        toLabel = new JLabel("To: ");
        ccLabel = new JLabel("Cc: ");
        bccLabel = new JLabel("Bcc: ");
        messageLabel = new JLabel("Message: ");
        subjectInput = new JTextField(20);
        toInput = new JTextField(20);
        ccInput = new JTextField(20);
        bccInput = new JTextField(20);
        messageInput = new JTextField(20);
        send = new JButton("Send");
        send.addActionListener(new ButtonListener());

        add(subjectLabel);
        add(subjectInput);

        add(toLabel);
        add(toInput);

        add(ccLabel);
        add(ccInput);

        add(bccLabel);
        add(bccInput);

        add(messageLabel);
        add(messageInput);
        add(send);

        setPreferredSize(new Dimension(250, 300));
        setBackground(Color.CYAN);
    }

    private class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent event)
        {
            String subject = subjectInput.getText();
            String to = toInput.getText();
            String cc = ccInput.getText();
            String bcc = bccInput.getText();
            String message = messageInput.getText();

            System.out.println("Subject: " + subject);
            System.out.println("To: " + to);
            System.out.println("Cc: " + cc);
            System.out.println("Bcc: " + bcc);
            System.out.println("Message: " + message);
        }

    }
}

