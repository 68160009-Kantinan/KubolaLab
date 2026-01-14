import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter; // สำหรับเขียนไฟล์
import java.io.IOException; // สำหรับจัดการข้อผิดพลาดไฟล์

public class Lab05_04 {

    public static void main(String[] args) {

        // สร้าง Frame
        JFrame frame = new JFrame("Program with JTextArea and Save File");
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // สร้าง TextArea
        JTextArea textArea = new JTextArea(8, 30);
        textArea.setLineWrap(true);       // ตัดบรรทัดอัตโนมัติ
        textArea.setWrapStyleWord(true);  // ตัดตามคำ

        // ใส่ ScrollBar ให้ TextArea
        JScrollPane scrollPane = new JScrollPane(textArea);

        // สร้างปุ่ม
        JButton btnShow = new JButton("Show message");
        JButton btnSave = new JButton("Save"); // ปุ่มใหม่

        // สร้าง Panel สำหรับวางปุ่มคู่กัน
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnShow);
        buttonPanel.add(btnSave);

        // --- Action ของปุ่ม Show message ---
        btnShow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = textArea.getText();
                JOptionPane.showMessageDialog(frame, text, 
                        "Your message: ", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // --- Action ของปุ่ม Save (บันทึกลง Drive D:) ---
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // กำหนดตำแหน่งไฟล์ (ตรวจสอบว่าคุณมีสิทธิ์เขียนไฟล์ใน Drive D: หรือไม่)
                    FileWriter writer = new FileWriter("D:\\message.txt");
                    writer.write(textArea.getText());
                    writer.close();
                    
                    JOptionPane.showMessageDialog(frame, "Saved to D:\\message.txt successfully!");
                } catch (IOException ex) {
                    // กรณีเกิดข้อผิดพลาด เช่น หา Drive ไม่เจอ หรือไม่มีสิทธิ์เข้าถึง
                    JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage(), 
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // จัด Layout
        frame.setLayout(new BorderLayout());
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH); // ใส่ Panel ที่มี 2 ปุ่มลงด้านล่าง

        // แสดงหน้าจอ
        frame.setVisible(true);
    }
}