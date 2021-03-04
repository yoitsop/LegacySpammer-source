import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class LegacySpammerGui extends JFrame {
    private JPanel mainPanel;
    private JButton startAutoTyperButton;
    private JTextField textField1;
    private JTextField textField2;
    private JLabel messageTwo;
    private JLabel imageLogo;
    private JLabel messageOne;
    private JLabel legacyPic;
    private JFrame frame;
    public boolean isP2P = false;
    public boolean hopWorlds = false;

    ArrayList<String> messages = new ArrayList<String>();

    public LegacySpammerGui()
    {
        setTitle("Legacy Spammer");
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(650,350);
        setLayout(new FlowLayout());

        Image image = null;
        URL url;
        try {
            url = new URL("https://i.imgur.com/ILOOwGn.png");
            image = ImageIO.read(url);
        } catch (MalformedURLException ex) {
            System.out.println("Malformed URL");
        } catch (IOException iox) {
            System.out.println("Can not load file");
        }
        JLabel legacyPic = new JLabel(new ImageIcon(image));
        add(legacyPic);

        JLabel msg1 = new JLabel("Message One: ");
        textField1 = new JTextField("",57);
        add(msg1);
        add(textField1);
        msg1.setForeground(Color.WHITE);



        JLabel msg2 = new JLabel("Message Two: ");
        textField2 = new JTextField("",57);
        msg2.setForeground(Color.WHITE);
        add(msg2);
        add(textField2 );

        final JPanel checkBoxPanel = new JPanel();

        checkBoxPanel.setLayout(new FlowLayout(FlowLayout.CENTER,225,0));
        checkBoxPanel.setBackground(new Color(-12828863));
        add(checkBoxPanel);

        JCheckBox p2pBox = new JCheckBox("P2P Account");
        JCheckBox hopWorldsBox = new JCheckBox("Hop Worlds");

        p2pBox.setForeground(Color.WHITE);
        p2pBox.setBackground(new Color(-12828863));

        hopWorldsBox.setForeground(Color.WHITE);
        hopWorldsBox.setBackground(new Color(-12828863));


        checkBoxPanel.add(p2pBox);
        checkBoxPanel.add(hopWorldsBox);
        checkBoxPanel.setBackground(new Color(-12828863));
        checkBoxPanel.setForeground(new Color(-12828863));

        final JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton startButton = new JButton("Start Autotyper");
        add(buttonPanel);
        buttonPanel.add(startButton);
        buttonPanel.setBackground(new Color(-12828863));
        buttonPanel.setForeground(new Color(-12828863));

        getContentPane().setBackground(new Color(-12828863));

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (!textField1.getText().equals("")){
                    messages.add(textField1.getText());
                }
                if (!textField2.getText().equals("")){
                    messages.add(textField2.getText());
                }
                if (p2pBox.isSelected()){
                    isP2P = true;
                }
                if (hopWorldsBox.isSelected()){
                    hopWorlds = true;
                }
                setVisible(false);
            }
        });
        setVisible(true);
    }

    public ArrayList<String> getStringlist() {
        return messages;
    }

}