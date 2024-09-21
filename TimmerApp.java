import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class SimpleTimerApp {
    private static long elapsedTime = 0; 
    private static boolean isRunning = false;
    private static Timer timer; 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Sanyu Timer Application");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 150);
            frame.setLayout(new FlowLayout());
            JLabel timeLabel = new JLabel("Elapsed Time: 0 seconds");
            JButton startButton = new JButton("Start");
            JButton stopButton = new JButton("Stop");
            JButton resetButton = new JButton("Rset");
            timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    elapsedTime++; 
                    updateTimeLabel(timeLabel); 
                }
            });
            startButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!isRunning) {
                        isRunning = true; 
                        timer.start(); 
                    }
                }
            });
            stopButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (isRunning) {
                        isRunning = false; 
                        timer.stop(); 
                    }
                }
            });
            resetButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    isRunning = false; 
                    timer.stop(); 
                    elapsedTime = 0; 
                    updateTimeLabel(timeLabel); 
                }
            });
            frame.add(timeLabel);
            frame.add(startButton);
            frame.add(stopButton);
            frame.add(resetButton);
            frame.setVisible(true); 
        });
    }
    private static void updateTimeLabel(JLabel label) {
        SwingUtilities.invokeLater(() -> {
            label.setText("Elapsed Time: " + elapsedTime + " seconds");
        });
    }
}
