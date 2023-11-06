import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI extends JFrame implements ActionListener {

    JButton submitBtn;
    JTextField textField;
    JTextField textField2;
    JComboBox comboBox;
    JComboBox tempBox;
    JComboBox tempBox2;

    GUI() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 40));

        JPanel emptyPanel = new JPanel();
        emptyPanel.setPreferredSize(new Dimension(500,40));
        this.add(emptyPanel);
        
        String[] options = {"Temperature"};
        comboBox = new JComboBox(options);
        comboBox.setPreferredSize(new Dimension(680,30));
        comboBox.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        
        submitBtn = new JButton("Submit");
        submitBtn.setPreferredSize(new Dimension(100,30));
        submitBtn.addActionListener(this);

        
        JPanel temperaturePanel = new JPanel(new GridLayout(2, 2, 10, 10));
        textField = new JTextField("0");
        textField.setPreferredSize(new Dimension(200,40));
        
        String[] temperature = {"Fahrenheit", "Kelvin", "Degrees Celsius"};
        tempBox = new JComboBox(temperature);
        tempBox.setPreferredSize(new Dimension(200,40));


        textField2 = new JTextField("0");
        textField2.setPreferredSize(new Dimension(200,50));

        String[] temperature2 = {"Degrees Celsius", "Kelvin", "Fahrenheit"};
        tempBox2 = new JComboBox(temperature2);
        tempBox2.setPreferredSize(new Dimension(300,40));

        temperaturePanel.add(textField);
        temperaturePanel.add(tempBox);
        temperaturePanel.add(textField2);
        temperaturePanel.add(tempBox2);


        this.setTitle("Temperature Converter");
        this.add(comboBox);
        this.add(temperaturePanel);
        this.add(submitBtn);
        this.pack();
        this.setSize(new Dimension(700,600));
        this.setVisible(true);
        this.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedOption1 = (String)tempBox.getSelectedItem();
        String selectedOption2 = (String)tempBox2.getSelectedItem();
        double toDegreesCelsius = 0.0; 
    
        if(e.getSource() == submitBtn) {
            double temp1 = Double.parseDouble(textField.getText());
            double temp2 = Double.parseDouble(textField2.getText());

            if (selectedOption1.equals("Fahrenheit") && selectedOption2.equals("Degrees Celsius")) {
                    toDegreesCelsius = ((temp1 - 32) * 5.0 / 9.0);
                    String convertedStringTemp = String.format("%.2f", toDegreesCelsius);
                    
                    textField2.setText(convertedStringTemp );
                    comboBox.setBorder(BorderFactory.createLineBorder(Color.WHITE));
                    comboBox.repaint();
                }
            else if (selectedOption1.equals("Degrees Celsius") && selectedOption2.equals("Fahrenheit")) {
                    toDegreesCelsius = ((temp1  * 9.0 / 5.0) + 32);
                    String convertedStringTemp = String.format("%.2f", toDegreesCelsius);
                    
                    textField2.setText(convertedStringTemp);
                    comboBox.setBorder(BorderFactory.createLineBorder(Color.WHITE));
                    comboBox.repaint();
                }
            else if (selectedOption1.equals("Degrees Celsius") && selectedOption2.equals("Kelvin")) {
                    toDegreesCelsius = (temp1 + 273.15);
                    String convertedStringTemp = String.format("%.2f", toDegreesCelsius);
                    
                    textField2.setText(convertedStringTemp);
                    comboBox.setBorder(BorderFactory.createLineBorder(Color.WHITE));
                    comboBox.repaint();
                }
            else if (selectedOption1.equals("Kelvin") && selectedOption2.equals("Degrees Celsius")) {
                    toDegreesCelsius = (temp1 - 273.15);
                    String convertedStringTemp = String.format("%.2f", toDegreesCelsius);
                    
                    textField2.setText(convertedStringTemp);
                    comboBox.setBorder(BorderFactory.createLineBorder(Color.WHITE));
                    comboBox.repaint();
                }
            else if (selectedOption1.equals("Kelvin") && selectedOption2.equals("Fahrenheit")) {
                    toDegreesCelsius = ((temp1 - 273.15) * 9.0/5.0 + 32);
                    String convertedStringTemp = String.format("%.2f", toDegreesCelsius);
                    
                    textField2.setText(convertedStringTemp);
                    comboBox.setBorder(BorderFactory.createLineBorder(Color.WHITE));
                    comboBox.repaint();
                }
            else if (selectedOption1.equals("Fahrenheit") && selectedOption2.equals("Kelvin")) {
                    toDegreesCelsius = ((temp1 - 32) * 5.0/9.0 + 273.15);
                    String convertedStringTemp = String.format("%.2f", toDegreesCelsius);
                    
                    textField2.setText(convertedStringTemp);
                    comboBox.setBorder(BorderFactory.createLineBorder(Color.WHITE));
                    comboBox.repaint();
                }
            else {
                textField2.setText(Double.toString(temp1));
           }
            }
        }
    
}
