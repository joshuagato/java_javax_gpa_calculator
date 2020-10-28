import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CalculatorFrame extends JFrame {

    public double c1gradePoint,c2gradePoint,c3gradePoint,c4gradePoint; //private double gradePoint1;
    public double c1gradeIndex,c2gradeIndex,c3gradeIndex,c4gradeIndex;
    public int c1creditHours,c2creditHours,c3creditHours,c4creditHours; //private int creditHours1;
    public int c1HourIndex,c2HourIndex,c3HourIndex,c4HourIndex;
    public int c1CreHrsCounter,c2CreHrsCounter,c3CreHrsCounter,c4CreHrsCounter;
    public double totalProduct, c1product,c2product,c3product,c4product;
    public int c1Selected, c2Selected,c3Selected,c4Selected;
    public int counterSum, selectedSum;
    public double gpa;
    public JComboBox course1hours,course2hours,course3hours,course4hours;
    public JComboBox course1Grade,course2Grade,course3Grade,course4Grade;
    public String hours [] = {"Select Hours","1","2","3","4","5","6","7","8","9"};
    public String grades [] = {"Select Grade","A","B+","B","C+","C","D+","D","E"};
    public int creditHours [] = {0,1,2,3,4,5,6,7,8,9};
    public double gradePoints [] = {0,4.0,3.5,3.0,2.5,2.0,1.5,1.0,0};
    public Color ltGray = new Color(214,220,219);
    public Color ltGreen = new Color(152,233,215);


    public CalculatorFrame() {
        super("GPA Calculator");

        //Creating a Tabbed Pane
        JTabbedPane tabbedPane = new JTabbedPane();

        //Creating a Panel and appending to first tab
        JPanel tab1Panel = new JPanel();
        tab1Panel.setLayout(null);
        //tab1Panel.setBackground(ltGray);
        tabbedPane.addTab("Calculate Semester GPA", null, tab1Panel, "Semester GPA");



        //Creating a Label and two Combo boxes for Course 1
        JLabel course1label = new JLabel("Course 1");
        tab1Panel.add(course1label);
        course1label.setBounds(10,15,60,25);

        course1hours = new JComboBox(hours);
        course1hours.setMaximumRowCount(4);
        course1hours.setBounds(70,15,100,25);
        tab1Panel.add(course1hours);

        course1Grade = new JComboBox(grades);
        course1Grade.setMaximumRowCount(4);
        course1Grade.setBounds(180,15,100,25);
        tab1Panel.add(course1Grade);



        //Creating a Label and two Combo boxes for Course 2
        JLabel course2label = new JLabel("Course 2");
        course2label.setBounds(300,15,60,25);
        tab1Panel.add(course2label);

        course2hours = new JComboBox(hours);
        course2hours.setMaximumRowCount(4);
        course2hours.setBounds(360,15,100,25);
        tab1Panel.add(course2hours);

        course2Grade = new JComboBox(grades);
        course2Grade.setMaximumRowCount(4);
        course2Grade.setBounds(470,15,100,25);
        tab1Panel.add(course2Grade);



        //Creating a Label and two Combo boxes for Course 3
        JLabel course3label = new JLabel("Course 3");
        course3label.setBounds(10,55,60,25);
        tab1Panel.add(course3label);

        course3hours = new JComboBox(hours);
        course3hours.setMaximumRowCount(4);
        course3hours.setBounds(70,55,100,25);
        tab1Panel.add(course3hours);

        course3Grade = new JComboBox(grades);
        course3Grade.setMaximumRowCount(4);
        course3Grade.setBounds(180,55,100,25);
        tab1Panel.add(course3Grade);



        //Creating a Label and two Combo boxes for Course 4
        JLabel course4label = new JLabel("Course 4");
        course4label.setBounds(300,55,60,25);
        tab1Panel.add(course4label);

        course4hours = new JComboBox(hours);
        course4hours.setMaximumRowCount(4);
        course4hours.setBounds(360,55,100,25);
        tab1Panel.add(course4hours);

        course4Grade = new JComboBox(grades);
        course4Grade.setMaximumRowCount(4);
        course4Grade.setBounds(470,55,100,25);
        tab1Panel.add(course4Grade);


        ButtonHandler handler = new ButtonHandler();


        JButton clear = new JButton("Clear");
        tab1Panel.add(clear);
        clear.setBounds(360,95,100,25);
        clear.addActionListener(handler);
        /*clear.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent event){
                    course1hours.setSelectedIndex(0);  course1Grade.setSelectedIndex(0);
                    course2hours.setSelectedIndex(0);  course2Grade.setSelectedIndex(0);
                    course3hours.setSelectedIndex(0);  course3Grade.setSelectedIndex(0);
                    course4hours.setSelectedIndex(0);  course4Grade.setSelectedIndex(0);
                }
            }
        );*/






        JButton calculate = new JButton("Calculate");
        tab1Panel.add(calculate);
        calculate.setBounds(470,95,100,25);
        calculate.addActionListener(handler);
        /*calculate.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent event){

                    if (course1hours.getSelectedIndex()>0 && course1Grade.getSelectedIndex()>0) {
                        c1Selected=1; c1CreHrsCounter=creditHours[course1hours.getSelectedIndex()];
                        c1product = (creditHours[course1hours.getSelectedIndex()] * gradePoints[course1Grade.getSelectedIndex()]);
                    }
                    if (course2hours.getSelectedIndex()>0 && course2Grade.getSelectedIndex()>0) {
                        c2Selected=1; c2CreHrsCounter=creditHours[course2hours.getSelectedIndex()];
                        c2product = (creditHours[course2hours.getSelectedIndex()] * gradePoints[course2Grade.getSelectedIndex()]);
                    }
                    if (course3hours.getSelectedIndex()>0 && course3Grade.getSelectedIndex()>0) {
                        c3Selected=1; c3CreHrsCounter=creditHours[course3hours.getSelectedIndex()];
                        c3product = (creditHours[course3hours.getSelectedIndex()] * gradePoints[course3Grade.getSelectedIndex()]);
                    }
                    if (course4hours.getSelectedIndex()>0 && course4Grade.getSelectedIndex()>0) {
                        c4Selected=1; c4CreHrsCounter=creditHours[course4hours.getSelectedIndex()];
                        c4product = (creditHours[course4hours.getSelectedIndex()] * gradePoints[course4Grade.getSelectedIndex()]);
                    }

                    selectedSum = c1Selected + c2Selected + c3Selected + c4Selected;
                    counterSum = c1CreHrsCounter + c2CreHrsCounter + c3CreHrsCounter + c4CreHrsCounter;
                    totalProduct = c1product + c2product + c3product + c4product;
                    gpa = totalProduct/counterSum;
                    JOptionPane.showMessageDialog(null,"The GPA of "+selectedSum+" course(s) is: "+ gpa, "Semesterly GPA", JOptionPane.PLAIN_MESSAGE);
                }
            }
        );*/


        JPanel tab2Panel = new JPanel();
        //tab2Panel.setBackground(ltGray);
        tabbedPane.addTab("Calculate Yearly CGPA", null, tab2Panel, "Yearly CGPA");

        JInternalFrame tab3Panel = new JInternalFrame("Internal Frame",true,true,true,true);
        tab3Panel.setVisible(true);
        //tab3Panel.setBackground(Color.cyan);
        tabbedPane.addTab("Check Your Summary", null, tab3Panel, "Summary Check");

        add(tabbedPane);
    }


    public class ButtonHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            if (event.getActionCommand() == "Clear") {
                course1hours.setSelectedIndex(0);  course1Grade.setSelectedIndex(0);
                course2hours.setSelectedIndex(0);  course2Grade.setSelectedIndex(0);
                course3hours.setSelectedIndex(0);  course3Grade.setSelectedIndex(0);
                course4hours.setSelectedIndex(0);  course4Grade.setSelectedIndex(0);
            }
            else if (event.getActionCommand() == "Calculate") {

                if (course1hours.getSelectedIndex()>0 && course1Grade.getSelectedIndex()>0) {
                    c1Selected=1; c1CreHrsCounter=creditHours[course1hours.getSelectedIndex()];
                    c1product = (creditHours[course1hours.getSelectedIndex()] * gradePoints[course1Grade.getSelectedIndex()]);
                }
                if (course2hours.getSelectedIndex()>0 && course2Grade.getSelectedIndex()>0) {
                    c2Selected=1; c2CreHrsCounter=creditHours[course2hours.getSelectedIndex()];
                    c2product = (creditHours[course2hours.getSelectedIndex()] * gradePoints[course2Grade.getSelectedIndex()]);
                }
                if (course3hours.getSelectedIndex()>0 && course3Grade.getSelectedIndex()>0) {
                    c3Selected=1; c3CreHrsCounter=creditHours[course3hours.getSelectedIndex()];
                    c3product = (creditHours[course3hours.getSelectedIndex()] * gradePoints[course3Grade.getSelectedIndex()]);
                }
                if (course4hours.getSelectedIndex()>0 && course4Grade.getSelectedIndex()>0) {
                    c4Selected=1; c4CreHrsCounter=creditHours[course4hours.getSelectedIndex()];
                    c4product = (creditHours[course4hours.getSelectedIndex()] * gradePoints[course4Grade.getSelectedIndex()]);
                }

                selectedSum = c1Selected + c2Selected + c3Selected + c4Selected;
                counterSum = c1CreHrsCounter + c2CreHrsCounter + c3CreHrsCounter + c4CreHrsCounter;
                totalProduct = c1product + c2product + c3product + c4product;
                gpa = totalProduct/counterSum;
                JOptionPane.showMessageDialog(null,"The GPA of "+selectedSum+" course(s) is: "+ gpa, "Semesterly GPA", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }


}
