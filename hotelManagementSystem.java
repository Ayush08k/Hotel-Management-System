import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class hotelManagementSystem extends JFrame implements ActionListener {
    hotelManagementSystem() {
        setSize(1366, 565);
        setLocation(10, 100);
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1366, 565);
        add(image);

        JLabel text = new JLabel("Hotel Management System");
        text.setBounds(20, 430, 1000, 90);
        image.add(text);
        text.setForeground(Color.white);
        text.setFont(new Font("serif", Font.BOLD, 50));

        JButton next = new JButton("Next");
        next.setBounds(1150, 450, 150, 50);
        next.setBackground(Color.WHITE);
        next.addActionListener(this);
        next.setForeground(Color.BLACK);
        next.setFont(new Font("serif", Font.BOLD, 24));

        image.add(next);

        setVisible(true);
        while (true) {
            text.setVisible(false);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
            text.setVisible(true);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new login();
    }

    public static void main(String[] args) {
        new hotelManagementSystem();
    }
}
