import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GUI extends JApplet implements ActionListener
{
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
        p2.setSize(300, 400);
        p2.add(outputField);
        outputField.setForeground(Color.black);
        outputField.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
        outputField.setHorizontalAlignment(JLabel.CENTER);
        List<String> btnList = List.of("C", "+/-", "/", "7", "8", "9", "X", "4", "5", "6", "-", "1", "2", "3", "+", "0", ".", "", "=");
        String id;
        for (int i = 0; i < btnList.size(); i++)
        {
            id = btnList.get(i);
            if (id == "")
            {
                JLabel button = new JLabel(id);
                p2.add(button);
            }
            else
            {
                JButton button = new JButton(id);
                button.addActionListener(this);
                p2.add(button);
            }
        }
        p2.setLayout(new GridLayout(5,4));
        f.add(p2);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
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
        double firstNumber = Double.parseDouble(queue.get(0));
        double secondNumber = Double.parseDouble(queue.get(2));
        double resultant;
        String action = queue.get(1).replaceAll("\\s", "");
        String result;
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
