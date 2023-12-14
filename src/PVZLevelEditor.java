
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class PVZLevelEditor extends  JFrame {


    private JPanel body;
    private JCheckBox cbPeashooter;
    private JButton saveChangesButton;
    private JTabbedPane tabbedPane1;
    private JCheckBox cbZombie;
    private JPanel cbPlants;
    private JComboBox comboMusic;
    private JSlider slSunFallRate;
    private JButton resetToDefaultButton;
    private JRadioButton fullscreenRadioButton;
    private JRadioButton windowedRadioButton;
    private JCheckBox cbPlantInvulnerability;
    private JCheckBox cbNoLawnmower;
    private JCheckBox cbPlantDoubleSpeed;
    private JCheckBox cbPlantNoCooldown;
    private JSlider slSunValue;
    private JPanel StartingSun;
    private JList plantList;
    private JList zombieList;
    private JCheckBox cbConeheadZombie;
    private JCheckBox checkBox2;
    private JCheckBox cbPoleVaultingZombie;
    private JCheckBox cbFootballZombie;
    private JCheckBox cbBucketheadZombie;
    private JSlider slZombieMovementSpeed;
    private JCheckBox cbSunflower;
    private JCheckBox checkBox1;
    private JCheckBox cbChomper;
    private JCheckBox cbGatlingPea;
    private JCheckBox cbRepeater;
    private JCheckBox checkBox6;
    private JCheckBox checkBox11;
    private JCheckBox checkBox12;
    private JCheckBox checkBox13;
    private JCheckBox checkBox14;
    private JSlider slZombieSpawnRate;
    private JSlider slZombieDamage;
    private JSlider slZombieHealth;
    private JSlider slStartingSun;
    private JButton stopButton1;
    private JButton stopButton;
    private JProgressBar progressBar1;
    private JRadioButton lawnSummerRadioButton;
    private JRadioButton lawnFallRadioButton;
    private JRadioButton lawnNightRadioButton;
    private JRadioButton lawnWinterRadioButton;
    private JCheckBox cbInvisighoul;


    public static final int MAX_PLANT_COUNT = 8;

    protected int plantCount = 0;
    protected int zombieCount = 0;
    GameSettings gameSettings;
    protected static final String filePath = "./settings.ser";

    public void loadFromFile(String file) {
        try (
                ObjectInputStream ois = new ObjectInputStream(
                        new FileInputStream(file)
                )
        ) {
            gameSettings = (GameSettings) ois.readObject();

            cbPlantInvulnerability.setSelected(gameSettings.plantInvulnerable);
            cbPlantNoCooldown.setSelected(gameSettings.plantNoCooldown);
            cbPlantDoubleSpeed.setSelected(gameSettings.plantDoubleSpeed);
            cbNoLawnmower.setSelected(gameSettings.noLawnmower);

            System.out.println(gameSettings.sunFallRate);

            slSunFallRate.setValue(gameSettings.sunFallRate);
            slSunValue.setValue(gameSettings.sunSunValue);
            slStartingSun.setValue(gameSettings.startingSun);

            slZombieHealth.setValue(gameSettings.zombieHealthMultiplier);
            slZombieDamage.setValue(gameSettings.zombieDamageMultiplier);
            slZombieMovementSpeed.setValue(gameSettings.zombieMovementSpeedMultiplier);
            slZombieSpawnRate.setValue(gameSettings.zombieSpawnRateMultiplier);

            System.out.println("Game state loaded from file successfully.");

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Game settings could not be loaded! Initializing default settings!");
            gameSettings = new GameSettings();
        }
    }


    public PVZLevelEditor() {

        loadFromFile(filePath);

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
                    gameSettings.selectedPlants.add(pName);
                } else {
                    gameSettings.selectedPlants.remove(pName);
                }


            }
        };

        cbPeashooter.addActionListener(cbPlantsActionListener);
        cbSunflower.addActionListener(cbPlantsActionListener);
        cbRepeater.addActionListener(cbPlantsActionListener);
        cbGatlingPea.addActionListener(cbPlantsActionListener);

        ActionListener cbZombiesActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JCheckBox cbZombie = ((JCheckBox)e.getSource());
                String zName = cbZombie.getText();
                boolean isSelected = cbZombie.isSelected();

                if (isSelected) {
                    ++zombieCount;
                    gameSettings.selectedZombies.add(zName);
                } else {
                    gameSettings.selectedZombies.remove(zName);
                }
            }
        };

        cbZombie.addActionListener(cbZombiesActionListener);
        cbConeheadZombie.addActionListener(cbZombiesActionListener);
        cbBucketheadZombie.addActionListener(cbZombiesActionListener);
        cbFootballZombie.addActionListener(cbZombiesActionListener);
        cbPoleVaultingZombie.addActionListener(cbZombiesActionListener);

        saveChangesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (
                        ObjectOutputStream oos = new ObjectOutputStream(
                                new FileOutputStream(filePath)
                        )
                ) {
                    oos.writeObject(gameSettings);
                    System.out.println("Game state saved to file successfully.");
                } catch (IOException error) {
                    error.printStackTrace();
                }
            }
        });

        resetToDefaultButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadFromFile("./default.ser");
            }
        });

        cbPlantInvulnerability.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameSettings.plantInvulnerable = ((JCheckBox)(e.getSource())).isSelected();
            }
        });

        cbPlantNoCooldown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameSettings.plantNoCooldown = ((JCheckBox)(e.getSource())).isSelected();
            }
        });

        cbPlantDoubleSpeed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameSettings.plantDoubleSpeed = ((JCheckBox)(e.getSource())).isSelected();
            }
        });

        cbNoLawnmower.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameSettings.noLawnmower = ((JCheckBox)(e.getSource())).isSelected();
            }
        });

        slSunFallRate.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                gameSettings.sunFallRate = ((JSlider)(e.getSource())).getValue();
            }
        });
        slSunValue.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                gameSettings.sunFallRate = ((JSlider)(e.getSource())).getValue();
            }
        });
        slStartingSun.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                gameSettings.startingSun = ((JSlider)(e.getSource())).getValue();
            }
        });
        slZombieHealth.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                gameSettings.zombieHealthMultiplier = ((JSlider)(e.getSource())).getValue();
            }
        });
        slZombieDamage.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                gameSettings.zombieDamageMultiplier = ((JSlider)(e.getSource())).getValue();
            }
        });
        slZombieMovementSpeed.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                gameSettings.zombieMovementSpeedMultiplier = ((JSlider)(e.getSource())).getValue();
            }
        });
        slZombieSpawnRate.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                gameSettings.zombieSpawnRateMultiplier = ((JSlider)(e.getSource())).getValue();
            }
        });
        comboMusic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String m = (String)((JComboBox<?>)e.getSource()).getSelectedItem();
                gameSettings.music = "bg" + m.charAt(3);
            }
        });

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameSettings.window = ((JRadioButton)e.getSource()).getText();
            }
        };

        fullscreenRadioButton.addActionListener(listener);
        windowedRadioButton.addActionListener(listener);

        cbInvisighoul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameSettings.zombieInvisighoul = ((JCheckBox)e.getSource()).isSelected();
            }
        });

        ActionListener listener1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameSettings.background = ((JRadioButton)e.getSource()).getText();
            }
        };

        lawnSummerRadioButton.addActionListener(listener1);
        lawnFallRadioButton.addActionListener(listener1);
        lawnNightRadioButton.addActionListener(listener1);
        lawnWinterRadioButton.addActionListener(listener1);
    }

    public static void main(String[] args) {
        PVZLevelEditor app = new PVZLevelEditor ();
        app.setContentPane(app.body);
        app.setSize(1200, 800);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setTitle("PvZ Level Editor");
        app.setVisible(true);
        app.setLocationRelativeTo(null);
    }

}
