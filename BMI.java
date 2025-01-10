import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMI {
    public static void main(String[] args) {
        // Create the frame with increased height
        JFrame frame = new JFrame("BMI Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400); // Increased height from 350 to 400
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(Color.WHITE);

        // Header
        JLabel headerLabel = new JLabel("BMI Calculator", JLabel.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        headerLabel.setForeground(new Color(34, 139, 34));
        headerLabel.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));

        // Main panel
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Create text field dimensions
        Dimension textFieldSize = new Dimension(80, 25);

        // Age
        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        JTextField ageField = new JTextField();
        ageField.setPreferredSize(textFieldSize);
        JLabel ageRangeLabel = new JLabel("ages: 2 - 120");
        ageRangeLabel.setFont(new Font("Arial", Font.ITALIC, 12));
        ageRangeLabel.setForeground(Color.GRAY);

        // Gender
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        JRadioButton maleButton = new JRadioButton("Male");
        JRadioButton femaleButton = new JRadioButton("Female");
        maleButton.setBackground(Color.WHITE);
        femaleButton.setBackground(Color.WHITE);
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);

        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        genderPanel.setBackground(Color.WHITE);
        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);

        // Height
        JLabel heightLabel = new JLabel("Height:");
        heightLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        JTextField heightField = new JTextField();
        heightField.setPreferredSize(textFieldSize);
        JLabel heightUnitLabel = new JLabel("cm");
        heightUnitLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        // Weight
        JLabel weightLabel = new JLabel("Weight:");
        weightLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        JTextField weightField = new JTextField();
        weightField.setPreferredSize(textFieldSize);
        JLabel weightUnitLabel = new JLabel("kg");
        weightUnitLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        // Buttons
        JButton calculateButton = new JButton("Calculate");
        calculateButton.setBackground(new Color(34, 139, 34));
        calculateButton.setForeground(Color.WHITE);
        calculateButton.setFocusPainted(false);
        calculateButton.setFont(new Font("Arial", Font.BOLD, 14));
        calculateButton.setPreferredSize(new Dimension(120, 40)); // Set preferred size

        JButton clearButton = new JButton("Clear");
        clearButton.setBackground(new Color(192, 192, 192));
        clearButton.setForeground(Color.BLACK);
        clearButton.setFocusPainted(false);
        clearButton.setFont(new Font("Arial", Font.BOLD, 14));
        clearButton.setPreferredSize(new Dimension(120, 40)); // Set preferred size

        // Healthy BMI Range Label
        JLabel healthyBMIRangeLabel = new JLabel("Healthy BMI range: 18.5 kg/m² - 25 kg/m²");
        healthyBMIRangeLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        healthyBMIRangeLabel.setForeground(new Color(34, 139, 34));

        // Add components to panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(ageLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        mainPanel.add(ageField, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        mainPanel.add(ageRangeLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(genderLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        mainPanel.add(genderPanel, gbc);
        gbc.gridwidth = 1;

        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(heightLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        mainPanel.add(heightField, gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        mainPanel.add(heightUnitLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(weightLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        mainPanel.add(weightField, gbc);

        gbc.gridx = 2;
        gbc.gridy = 3;
        mainPanel.add(weightUnitLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(calculateButton);
        buttonPanel.add(clearButton);
        mainPanel.add(buttonPanel, gbc);

        // Add the Healthy BMI Range label below buttons and center it
        gbc.gridy = 5;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER; // Center the label
        mainPanel.add(healthyBMIRangeLabel, gbc);

        // Add header and main panel to frame
        frame.add(headerLabel, BorderLayout.NORTH);
        frame.add(mainPanel, BorderLayout.CENTER);

        // Action listeners
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String ageText = ageField.getText();
                    String heightText = heightField.getText();
                    String weightText = weightField.getText();

                    // Gender validation
                    if (!maleButton.isSelected() && !femaleButton.isSelected()) {
                        JOptionPane.showMessageDialog(frame, "Please select a gender.", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Validate fields for emptiness
                    if (ageText.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Please enter your age.", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if (heightText.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Please enter your height.", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if (weightText.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Please enter your weight.", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Parse the input values
                    int age = Integer.parseInt(ageText);
                    double height = Double.parseDouble(heightText);
                    double weight = Double.parseDouble(weightText);

                    // Additional validation for valid ranges
                    if (age < 2 || age > 120) {
                        JOptionPane.showMessageDialog(frame, "Please enter a valid age (2 - 120).", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if (height <= 0) {
                        JOptionPane.showMessageDialog(frame, "Please enter a valid height (in cm).", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if (weight <= 0) {
                        JOptionPane.showMessageDialog(frame, "Please enter a valid weight (in kg).", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Calculate BMI
                    double bmi = weight / ((height / 100) * (height / 100));

                    // Determine BMI category
                    String category;
                    if (bmi < 18.5) {
                        category = "UNDERWEIGHT";
                    } else if (bmi >= 18.5 && bmi < 24.9) {
                        category = "NORMAL WEIGHT";
                    } else if (bmi >= 25 && bmi < 29.9) {
                        category = "OVERWEIGHT";
                    } else {
                        category = "OBESE";
                    }

                    // Format and display the result
                    JOptionPane.showMessageDialog(frame, String.format("BMI = %.1f kg/m²\n%s", bmi, category),
                            "BMI Result",
                            JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid numeric values in the fields.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ageField.setText("");
                heightField.setText("");
                weightField.setText("");
                genderGroup.clearSelection();
            }
        });

        // Display the frame
        frame.setVisible(true);
    }
}