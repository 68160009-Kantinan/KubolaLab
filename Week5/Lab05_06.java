import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Lab05_06 {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Save File with Menu");
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // สร้าง TextArea และ ScrollPane
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);

        // ===== 1. สร้าง Menu Bar =====
        JMenuBar menuBar = new JMenuBar();
        
        // เมนูหลัก File
        JMenu fileMenu = new JMenu("File");
        
        // เมนูย่อย Save และ Exit
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");

        // เพิ่มเมนูย่อยเข้าในเมนูหลัก
        fileMenu.add(saveItem);
        fileMenu.addSeparator(); // เส้นคั่น
        fileMenu.add(exitItem);

        // เพิ่มเมนูหลักเข้าใน Menu Bar
        menuBar.add(fileMenu);

        // ติดตั้ง Menu Bar ให้กับ Frame
        frame.setJMenuBar(menuBar);

        // ===== 2. กำหนดการทำงาน (Actions) =====

        // การทำงานของเมนู Save
        saveItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                // ตั้งค่าเริ่มต้นให้ไปที่ Drive D: (ถ้ามี)
                fileChooser.setCurrentDirectory(new File("D:\\"));
                
                int result = fileChooser.showSaveDialog(frame);

                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();

                    try {
                        PrintWriter writer = new PrintWriter(file);
                        writer.write(textArea.getText());
                        writer.close();

                        JOptionPane.showMessageDialog(frame, "Save file successfully.");
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(frame, "Error. Unable to save file.", 
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        // การทำงานของเมนู Exit
        exitItem.addActionListener(e -> System.exit(0));

        // ===== 3. จัด Layout และแสดงผล =====
        frame.setLayout(new BorderLayout());
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}