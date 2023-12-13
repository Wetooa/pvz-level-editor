import javax.swing.*;

public class PVZLevelEditor extends  JFrame {


    private JPanel body;
    private JCheckBox checkBox1;
    private JButton saveChangesButton;
    private JButton discardChangesButton;
    private JTabbedPane tabbedPane1;
    private JCheckBox checkBox2;
    private JPanel cbPlants;
    private JComboBox comboBox1;
    private JSlider FallRate;
    private JButton resetToDefaultButton;
    private JRadioButton fullscreenRadioButton;
    private JRadioButton hardWhatIfShitRadioButton;
    private JRadioButton windowedRadioButton;
    private JCheckBox checkBox3;
    private JCheckBox checkBox4;
    private JCheckBox checkBox5;
    private JCheckBox checkBox6;
    private JSlider SunValue;
    private JPanel StartingSun;

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
