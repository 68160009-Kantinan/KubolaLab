import javax.swing.*;
import java.awt.*;

public class Lab6_02 {

    public static void main(String[] args) {

        // สร้าง JFrame
        JFrame frame = new JFrame("แสดงรูปภาพบน JLabel");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // โหลดรูปภาพ (ใส่ path ของรูป)
        ImageIcon icon = new ImageIcon("image1.jpg");

        //ปรับขนาดรูปภาพ
        Image img = icon.getImage().getScaledInstance(250, 200, Image.SCALE_SMOOTH);
            
        // สร้าง JLabel และใส่รูปภาพ
       JLabel label = new JLabel(new ImageIcon(img));
        label.setHorizontalAlignment(JLabel.CENTER);

        // เพิ่ม JLabel ลงใน JFrame
        frame.add(label);

        // แสดงหน้าต่าง
        frame.setVisible(true);
    }
}
