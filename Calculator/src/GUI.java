import javax.lang.model.util.ElementScanner6;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GUI extends JApplet implements ActionListener
{
    /*private JButton btnEquals;
    private JButton btn1;    
    private JButton btn0;
    private JButton btn2;    
    private JButton btn3;    
    private JButton btn4;    
    private JButton btn5;    
    private JButton btn6;    
    private JButton btn7;    
    private JButton btn8;    
    private JButton btn9;
    private JButton btnAdd;
    private JButton btnSubtract;
    private JButton btnClear;
    private JButton btnDivide;
    private JButton btnMultiply;
    private JButton btnDecimal;
    private JButton btnSign;*/
    private JLabel outputField = new JLabel("0");
    private List<String> queue = new ArrayList<>();
    private String firstSelectedNumber = "";
    private String secondSelectedNumber = "";
    private List<String> numList = List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".");
    private List<String> actionList = List.of("+", "-", "X", "/", "+/-");
    private boolean signed = false;

    public GUI () {
        
        JFrame f = new JFrame();
        JPanel p2 = new JPanel();
        f.setSize(300, 450);
        f.setBackground(Color.gray);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //p2.getContentPane().setBackground(Color.TRANSLUCENT);

        /*JLabel output = new JLabel("0");
        output.setForeground(Color.white);
        output.setBounds(0, 0, 300, 50);
        output.setBackground(Color.black);
        p2.add(output);*/
        /*gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.weightx = 1;
        p2.add(output, gbc);*/

        /*JButton btnClear = new JButton("Clear");
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        p2.add(btnClear, gbc);

        JButton btnSign = new JButton("+/-");
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1;
        p2.add(btnSign, gbc);

        JButton btnDivide = new JButton("/");
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.weightx = 1;
        p2.add(btnDivide, gbc);*/


        JButton btn0 = new JButton("0");
        JButton btn1 = new JButton("1");    
        JButton btn2 = new JButton("2");    
        JButton btn3 = new JButton("3");    
        JButton btn4 = new JButton("4");    
        JButton btn5 = new JButton("5");    
        JButton btn6 = new JButton("6");    
        JButton btn7 = new JButton("7");    
        JButton btn8 = new JButton("8");    
        JButton btn9 = new JButton("9");
        JButton btnEquals = new JButton("=");
        JButton btnAdd = new JButton("+");
        JButton btnSubtract = new JButton("-");
        JButton btnClear = new JButton("C");
        JButton btnDivide = new JButton("/");
        JButton btnMultiply = new JButton("X");
        
        JButton btnDecimal = new JButton(".");
        
        JButton btnSign = new JButton("+/-");
        JLabel btnPlaceholder1 = new JLabel("");
        btnEquals.addActionListener(this);
        btnAdd.addActionListener(this);
        btnSubtract.addActionListener(this);
        btnClear.addActionListener(this);
        btnDivide.addActionListener(this);
        btnMultiply.addActionListener(this);
        btnDecimal.addActionListener(this);
        btnSign.addActionListener(this);
        btn0.addActionListener(this);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);
        btn6.addActionListener(this);
        btn7.addActionListener(this);
        btn8.addActionListener(this);
        btn9.addActionListener(this);
        outputField.setForeground(Color.black);
        outputField.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
        outputField.setHorizontalAlignment(JLabel.CENTER);
        //p1.setSize(300, 50);
        p2.add(outputField);

        p2.setSize(300, 400);
        //p2.add(btnPlaceholder5);
        p2.add(btnClear);
        p2.add(btnSign);
        p2.add(btnDivide);
        p2.add(btn7);
        p2.add(btn8);
        p2.add(btn9);
        p2.add(btnMultiply);
        p2.add(btn4);
        p2.add(btn5);
        p2.add(btn6);
        p2.add(btnSubtract);
        p2.add(btn1);
        p2.add(btn2);
        p2.add(btn3);
        p2.add(btnAdd);
        p2.add(btn0);
        p2.add(btnDecimal);
        p2.add(btnPlaceholder1);
        p2.add(btnEquals);
        p2.setLayout(new GridLayout(5,4));
        //equals.setBounds(225, 350, 75, 50);
        //p2.add(equals);
//        f.setLayout(null);
        //f.add(p1);
        f.add(p2);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        System.out.println(ae.getActionCommand());
        if (ae.getActionCommand() == "=")
        {
            Calculate(); 
        }
        if (ae.getActionCommand() == "C")
        {
            queue.clear();
            firstSelectedNumber = "";
            secondSelectedNumber = "";
            outputField.setText("0");
        }
        else {
            for (int i = 0; i < numList.size(); i++)
            {
                if (ae.getActionCommand() == numList.get(i) && !signed)
                {
                    firstSelectedNumber = firstSelectedNumber + ae.getActionCommand();
                    outputField.setText(firstSelectedNumber);
                }
                else if (ae.getActionCommand() == numList.get(i))
                {
                    secondSelectedNumber = secondSelectedNumber + ae.getActionCommand();
                    outputField.setText(secondSelectedNumber);
                }
            }
            for (int j = 0; j < actionList.size(); j++)
            {
                if (ae.getActionCommand() == actionList.get(j))
                {
                    if (ae.getActionCommand() == "+/-")
                    {
                        if (signed)
                        {
                            if (secondSelectedNumber.charAt(0) == '-')
                            {
                                secondSelectedNumber = secondSelectedNumber.replace("-", "");
                            }
                            else
                            {
                                secondSelectedNumber = "-" + secondSelectedNumber;
                            }
                            outputField.setText(secondSelectedNumber);
                        }
                        else
                        {
                            if (firstSelectedNumber.charAt(0) == '-')
                            {
                                firstSelectedNumber = firstSelectedNumber.replace("-", "");
                            }
                            else
                            {
                                firstSelectedNumber = "-" + firstSelectedNumber;
                            }
                            outputField.setText(firstSelectedNumber);
                        }
                    }
                    else
                    {
                    queue.add(firstSelectedNumber);
                    queue.add(ae.getActionCommand());
                    signed = true;
                    }
                }
                
            }
        }
    }

    private void Calculate() {
        queue.add(secondSelectedNumber);
        System.out.println(queue);
        double firstNumber = Double.parseDouble(queue.get(0));
        double secondNumber = Double.parseDouble(queue.get(2));
        double resultant;
        String action = queue.get(1).replaceAll("\\s", "");
        String result;
        //System.out.println(action);
        if (action == "+")
        {
            resultant = firstNumber + secondNumber;
        }
        else if (action == "-")
        {
            resultant = firstNumber - secondNumber;
        }
        else if (action == "X")
        {
            resultant = firstNumber * secondNumber;
        }
        else
        {
            resultant = firstNumber / secondNumber;
        }
        if (resultant % 1 == 0)
        {
            result = Integer.toString((int) resultant);
        }
        else
        {
            result = Double.toString(resultant);
        }

        System.out.println(result);
        outputField.setText(result);
        queue.clear();
        firstSelectedNumber = result;
        secondSelectedNumber = "";
        signed = false;
    }
}