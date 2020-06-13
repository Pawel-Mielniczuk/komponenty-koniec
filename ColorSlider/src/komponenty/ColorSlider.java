/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komponenty;

/**
 *
 * @author Paweł Mielniczuk, Cezary Wątor
 */
import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class ColorSlider extends JFrame {
    JSlider redSlider, greenSlider, blueSlider;
    JLabel redLable, greenLable, blueLable;
    JPanel colorPanel, sliders, labels;

    public ColorSlider() {
        redSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        greenSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        blueSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);


        redSlider.setMajorTickSpacing(50);
        redSlider.setPaintTicks(true);
        redSlider.setPaintLabels(true);

        greenSlider.setMajorTickSpacing(50);
        greenSlider.setPaintTicks(true);
        greenSlider.setPaintLabels(true);

        blueSlider.setMajorTickSpacing(50);
        blueSlider.setPaintTicks(true);
        blueSlider.setPaintLabels(true);

        redLable = new JLabel("Red = 0");
        greenLable = new JLabel("Green = 0");
        blueLable = new JLabel("Blue= 0");

        event e = new event();
        redSlider.addChangeListener(e);
        greenSlider.addChangeListener(e);
        blueSlider.addChangeListener(e);


        colorPanel = new JPanel();
        colorPanel.setBackground(Color.BLACK);

        Container pane = this.getContentPane();
        pane.setLayout(new GridLayout(1,3,3,3));

        sliders = new JPanel();
        labels = new JPanel();

        pane.add(sliders);
        pane.add(labels);
        pane.add(colorPanel);

        sliders.setLayout(new GridLayout(3,1,2,2));
        sliders.add(redSlider);
        sliders.add(greenSlider);
        sliders.add(blueSlider);

        labels.setLayout(new GridLayout(3,1,2,2));
        labels.add(redLable);
        labels.add(greenLable);
        labels.add(blueLable);

    }

    public class event implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            int redValue = redSlider.getValue();
            int greenValue = greenSlider.getValue();
            int blueValue = blueSlider.getValue();

            redLable.setText("Red =" + redValue);
            greenLable.setText("Green =" + greenValue);
            blueLable.setText("Blue = " + blueValue);

            colorPanel.setBackground(new Color(redValue, greenValue, blueValue));
        }
    }

    public static void main(String args[]) {
        ColorSlider gui = new ColorSlider();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
        gui.setTitle("Color Picker");
        gui.setSize(500,200);
    }
}

