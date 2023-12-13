import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PVZLevelEditor extends  JFrame {


    private JPanel body;
    private JCheckBox cbPeashooter;
    private JButton saveChangesButton;
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
    private JList plantList;
    private JList zombieList;
    private JCheckBox coneheadZombieCheckBox;
    private JCheckBox checkBox2;
    private JCheckBox checkBox10;
    private JCheckBox screendoorZombieeCheckBox;
    private JCheckBox footballZombieCheckBox;
    private JCheckBox bucketheadZombieCheckBox;
    private JSlider slider1;
    private JCheckBox cbSunflower;
    private JCheckBox checkBox1;
    private JCheckBox chomperCheckBox;
    private JCheckBox cbGatlingPea;
    private JCheckBox cbRepeater;
    private JCheckBox checkBox6;
    private JCheckBox checkBox11;
    private JCheckBox checkBox12;
    private JCheckBox checkBox13;
    private JCheckBox checkBox14;


    public static final int MAX_PLANT_COUNT = 8;
    public static final int MAX_ZOMBIE_COUNT = 12;

    protected int plantCount = 0;
    protected int zombieCount = 0;

    protected ArrayList<String> selectedPlants;
    protected ArrayList<String> selectedZombies;
    protected int initialSun;
    protected int sunValue;
    protected int sunFallRate;

    public PVZLevelEditor() {
        JOptionPane jOption = new JOptionPane();

        ActionListener cbPlantsActionListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                JCheckBox cbPlant = ((JCheckBox)e.getSource());
                String pName = cbPlant.getText();
                boolean isSelected = cbPlant.isSelected();

                if (isSelected) {

                    if (plantCount == MAX_PLANT_COUNT) {
                        jOption.createDialog("Maximum plant count! Remove one to add " + pName + " to the list");
                        return;
                    }

                    ++plantCount;
                    selectedPlants.add(pName);
                } else {
                    selectedPlants.remove(pName);
                }
            }
        };

        cbPeashooter.addActionListener(cbPlantsActionListener);
        cbSunflower.addActionListener(cbPlantsActionListener);
        cbRepeater.addActionListener(cbPlantsActionListener);
        cbGatlingPea.addActionListener(cbPlantsActionListener);
//        .addActionListener(cbPlantsActionListener);
//        cbSunflower.addActionListener(cbPlantsActionListener);

        ActionListener cbZombiesActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        };

        cbNormalZombie.addActionListener(cbPlantsActionListener);

        saveChangesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        resetToDefaultButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
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
