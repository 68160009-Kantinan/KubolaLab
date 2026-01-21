import javax.swing.*;

public class Lab6_01 {

    public static void main(String[] args) {

        // สร้าง JFrame
        JFrame frame = new JFrame("แสดงรูปภาพบน JLabel");
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // โหลดรูปภาพ (ใส่ path ของรูป)
        ImageIcon icon = new ImageIcon("image1.jpg");

        // สร้าง JLabel และใส่รูปภาพ
        JLabel label = new JLabel(icon);
        label.setHorizontalAlignment(JLabel.CENTER);

        // เพิ่ม JLabel ลงใน JFrame
        frame.add(label);

        // แสดงหน้าต่าง
        frame.setVisible(true);
    }
}
