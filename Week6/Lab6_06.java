import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Lab6_06 {

    public static void main(String[] args) {
        JFrame frame = new JFrame("แกลเลอรีรูปภาพ");
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // รายชื่อไฟล์รูป
        String[] images = {
            "Cheval.jpg",
            "Cheval2.jpg",
            "Cheval3.jpg",
            "Cheval4.jpg",
            "Cheval5.jpg"
        };

        for (String path : images) {
            // โหลดและย่อรูป
            ImageIcon icon = new ImageIcon(path);
            Image img = icon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
            JLabel label = new JLabel(new ImageIcon(img));

            // เมื่อคลิกรูป
            label.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    showLargeImage(path);
                }
            });

            panel.add(label);
        }

        frame.add(panel);
        frame.setVisible(true);
    }

    // แสดงรูปขนาดใหญ่
    private static void showLargeImage(String path) {
        JFrame imgFrame = new JFrame("รูปขนาดใหญ่");
        imgFrame.setSize(800, 800);

        ImageIcon icon = new ImageIcon(path);
        JLabel imgLabel = new JLabel(icon);

        imgFrame.add(new JScrollPane(imgLabel));
        imgFrame.setLocationRelativeTo(null);
        imgFrame.setVisible(true);
    }
}
