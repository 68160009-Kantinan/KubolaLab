import javax.swing.*;

public class Lab05_02 {
    public static void main(String[] args) {
        // ===== 1. สร้าง JFrame =====
        JFrame frame = new JFrame("GUI with Menu");
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ===== 2. สร้าง Menu Bar =====
        JMenuBar menuBar = new JMenuBar();

        // เมนูหลัก
        JMenu menuCalculate = new JMenu("Calculate");
        JMenu menuOther = new JMenu("Others");

        // เมนูย่อย
        JMenuItem itemAdd = new JMenuItem("Add");
        JMenuItem itemSub = new JMenuItem("Subtract");
        JMenuItem itemMultiply = new JMenuItem("Multiply"); // เพิ่มเมนูคูณ
        JMenuItem itemName = new JMenuItem("Greeting");
        JMenuItem itemExit = new JMenuItem("Quit");

        // เพิ่มเมนูย่อยลงใน Calculate
        menuCalculate.add(itemAdd);
        menuCalculate.add(itemSub);
        menuCalculate.add(itemMultiply); // ใส่เมนูคูณเข้าไปในกลุ่มคำนวณ

        // เพิ่มเมนูย่อยลงใน Others
        menuOther.add(itemName);
        menuOther.addSeparator();
        menuOther.add(itemExit);

        // นำเมนูหลักใส่ใน MenuBar
        menuBar.add(menuCalculate);
        menuBar.add(menuOther);

        // ติดตั้ง MenuBar ให้กับ Frame
        frame.setJMenuBar(menuBar);

        // ===== 3. จัดการ Action ของเมนูต่างๆ =====

        // บวก (Add)
        itemAdd.addActionListener(e -> {
            int a = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter number#1"));
            int b = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter number#2"));
            JOptionPane.showMessageDialog(frame, "Adding result = " + (a + b));
        });

        // ลบ (Subtract)
        itemSub.addActionListener(e -> {
            int a = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter number#1"));
            int b = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter number#2"));
            JOptionPane.showMessageDialog(frame, "Subtract result = " + (a - b));
        });

        // คูณ (Multiply) - ปรับแก้จากที่คุณส่งมา
        itemMultiply.addActionListener(e -> {
            int a = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter number#1"));
            int b = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter number#2"));
            JOptionPane.showMessageDialog(frame, "Multiply result = " + (a * b));
        });

        // ทักทาย (Greeting)
        itemName.addActionListener(e -> {
            String name = JOptionPane.showInputDialog(frame, "Enter name");
            JOptionPane.showMessageDialog(frame, "Hello " + name);
        });

        // ออกจากโปรแกรม (Quit)
        itemExit.addActionListener(e -> System.exit(0));

        // ===== 4. แสดงหน้าต่าง =====
        frame.setVisible(true);
    }
}