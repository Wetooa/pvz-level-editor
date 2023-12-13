import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PVZLevelEditor extends  JFrame {


    private JPanel body;
    private JCheckBox cbPeashooter;
    private JButton saveChangesButton;
    private JButton discardChangesButton;
    private JTabbedPane tabbedPane1;
    private JCheckBox cbNormalZombie;
    private JPanel cbPlants;
    private JComboBox comboBox1;
    private JSlider FallRate;
    private JButton resetToDefaultButton;
    private JRadioButton fullscreenRadioButton;
    private JRadioButton hardWhatIfShitRadioButton;
    private JRadioButton windowedRadioButton;
    private JCheckBox whosYourDaddyCheckBox;
    private JCheckBox checkBox4;
    private JCheckBox checkBox5;
    private JCheckBox warptenCheckBox;
    private JSlider SunValue;
    private JPanel StartingSun;
    private JCheckBox checkBox7;
    private JCheckBox checkBox8;
    private JCheckBox checkBox9;
    private JList list1;
    private JList list2;
    private JCheckBox coneheadZombieCheckBox;
    private JCheckBox checkBox2;
    private JCheckBox checkBox10;
    private JCheckBox screendoorZombieeCheckBox;
    private JCheckBox footballZombieCheckBox;
    private JCheckBox bucketheadZombieCheckBox;
    private JSlider slider1;
    private JCheckBox cbSunflower;
    private JCheckBox checkBox1;
    private JCheckBox checkBox3;
    private JCheckBox checkBox6;
    private JCheckBox checkBox11;

    public PVZLevelEditor() {
        ActionListener cbPlantsActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(((JCheckBox)e.getSource()).getText());
            }
        };

        cbPeashooter.addActionListener(cbPlantsActionListener );

        ActionListener cbZombiesActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        };

        cbNormalZombie.addActionListener(cbPlantsActionListener);
    }

    public static void main(String[] args) {
        PVZLevelEditor app = new PVZLevelEditor ();
        app.setContentPane(app.body);
        app.setSize(1000, 600);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setTitle("PvZ Level Editor");
        app.setVisible(true);
        app.setLocationRelativeTo(null);
    }

}
