
/**
 * @Project_Name: Java programming course in school
 * @Package_Name: PACKAGE_NAME
 * @File:
 * @Version: 1.0.0
 * @Author: zhangjiangh03
 * @Created: 2023-10-28 13:40
 * @Last_Modified: 2023-10-28 13:40
 * @Description: No Description.
 */

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
class Student implements Comparable<Student> {
    private final String name;
    private final double score;

    public Student(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }

    @Override
    public int compareTo(Student student) {
        return Double.compare(this.score, student.score);
    }
}

class StudentFrame extends JFrame implements ActionListener {
    private final JTextField name;
    private final JTextField score;
    private final JTextArea resultArea;

    private final TreeSet<Student> studentTreeSet;

    public StudentFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(500, 300);

        setLocationRelativeTo(null);

        JPanel inputPanel = new JPanel(new GridLayout());

        JLabel nameLabel = new JLabel("姓名");
        name = new JTextField();
        JLabel scoreLabel = new JLabel("分数");
        score = new JTextField();
        JButton addButton = new JButton("确定");

        inputPanel.add(nameLabel);
        inputPanel.add(name);
        inputPanel.add(scoreLabel);
        inputPanel.add(score);
        inputPanel.add(addButton);

        resultArea = new JTextArea();

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(inputPanel, BorderLayout.NORTH);
        contentPane.add(resultArea, BorderLayout.CENTER);

        studentTreeSet = new TreeSet<>();

        addButton.addActionListener(this);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = this.name.getText();
        int score = Integer.parseInt(this.score.getText());

        Student student = new Student(name, score);
        studentTreeSet.add(student);

        resultArea.setText("");
        studentTreeSet.forEach(s -> resultArea.append("姓名: " + s.getName() + ", 分数: " + s.getScore() + "\n"));
    }

}

public class Q9 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StudentFrame();
            }
        });
    }
}
