import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Lab5_8 {
	
    private static File currentFile = null;

    public static void main(String[] args) {

        // สร้าง JFrame
        JFrame frame = new JFrame("Simple Text Editor");
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // ชื่อหัวโปรแกรมตอนเริ่มต้น
        String defaultTitle = "Kantinan Roekpiyasab 68160009 No.53";
        frame.setTitle(defaultTitle);

        // 1. ส่วนแสดงผล
        JTextArea textArea = new JTextArea();
        textArea.setEditable(true);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);

        // 2. ส่วนเมนู
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");

        JMenuItem itemNew = new JMenuItem("New");
        JMenuItem itemOpen = new JMenuItem("Open");
        JMenuItem itemSave = new JMenuItem("Save");
        JMenuItem itemSaveAs = new JMenuItem("Save As");
        JMenuItem itemExit = new JMenuItem("Exit");

        menuFile.add(itemNew);
        menuFile.add(itemOpen);
        menuFile.addSeparator();
        menuFile.add(itemSave);
        menuFile.add(itemSaveAs);
        menuFile.addSeparator();
        menuFile.add(itemExit);
        menuBar.add(menuFile);

        frame.setJMenuBar(menuBar); 
        frame.add(scrollPane, BorderLayout.CENTER);
        
        // --- 3. ActionListeners (แบบปกติที่คุณเข้าใจ) ---

        // NEW
        itemNew.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                currentFile = null;
                frame.setTitle(defaultTitle);
            }
        });
        
        // OPEN
        itemOpen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    currentFile = fileChooser.getSelectedFile();
                    try {
                        BufferedReader reader = new BufferedReader(new FileReader(currentFile));
                        textArea.setText("");
                        String line;
                        while ((line = reader.readLine()) != null) {
                            textArea.append(line + "\n");
                        }
                        reader.close();
                        frame.setTitle("Editor - " + currentFile.getName());
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(frame, "Error reading file", "Error", 0);
                    }
                }
            }
        });
        
        // SAVE
        itemSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currentFile != null) {
                    try {
                        PrintWriter writer = new PrintWriter(currentFile);
                        writer.write(textArea.getText());
                        writer.close();
                        JOptionPane.showMessageDialog(frame, "Saved successfully!");
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
                    }
                } else {
                    itemSaveAs.doClick(); // ถ้ายังไม่มีไฟล์ ให้ไปเรียก Save As
                }
            }
        });
        
        // SAVE AS (แก้ไขให้เป็น "การเขียน" แทน "การอ่าน")
        itemSaveAs.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showSaveDialog(frame); // ใช้ showSaveDialog

                if (result == JFileChooser.APPROVE_OPTION) {
                    currentFile = fileChooser.getSelectedFile();
                    try {
                        PrintWriter writer = new PrintWriter(currentFile);
                        writer.write(textArea.getText());
                        writer.close();
                        JOptionPane.showMessageDialog(frame, "Save file successfully.");
                        frame.setTitle("Editor - " + currentFile.getName());
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(frame, "Cannot save file.", "Error", 0);
                    }
                }
            }
        });
        
        // EXIT
        itemExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        frame.setVisible(true);
    }
}