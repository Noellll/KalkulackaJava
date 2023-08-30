package academy.learnprogramming;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {

    JButton[] numberButtons= new JButton[10];
    JButton[] functionButtons = new JButton[6];
    JPanel panelButtons = new JPanel();
    JTextField textField = new JTextField();
    JButton clear;
    char operator;
    Integer cislo1;
    Integer cislo2;
    Integer vysledok;

    Calculator(){
        functionButtons[0] = new JButton("+");
        functionButtons[1] = new JButton("-");
        functionButtons[2] = new JButton("=");
        functionButtons[3] = new JButton("*");
        functionButtons[4] = new JButton("/");
        functionButtons[5] = new JButton("!");

        clear = new JButton("Clear");
        clear.setBounds(20,500,90,40);
        clear.addActionListener(this);

        for(int i = 0;i<numberButtons.length;i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            panelButtons.add(numberButtons[i]);

        }
        for(int i = 0;i<functionButtons.length;i++){
            functionButtons[i].addActionListener(this);
            panelButtons.add(functionButtons[i]);
        }

        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setLayout(null);


        textField.setBounds(50,50,370,30);

        panelButtons.setBounds(50,130,350,350);
        panelButtons.setLayout(new GridLayout(4,4,5,5));
        frame.add(clear);
        frame.add(textField);
        frame.add(panelButtons);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0;i<10;i++){
            if(e.getSource()==numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        //funkcne tlacidla
        if(e.getSource()==functionButtons[0]){
            cislo1 = Integer.parseInt(textField.getText());
            operator = '+';
            textField.setText("");
        }

        if(e.getSource()==functionButtons[1]){
            cislo1 = Integer.parseInt(textField.getText());
            operator = '-';
            textField.setText("");
        }

        if(e.getSource()==functionButtons[2]){
            cislo2 = Integer.parseInt(textField.getText());

            switch(operator){
                case '+':
                    vysledok = cislo1 + cislo2;
                    break;
                case '-':
                    vysledok = cislo1 - cislo2;
                    break;
                case '*':
                    vysledok = cislo1 * cislo2;
                    break;
                case '/':
                    vysledok = cislo1 / cislo2;
                    break;
            }
            textField.setText(String.valueOf(vysledok));
        }

        if(e.getSource()==functionButtons[3]){
            cislo1 = Integer.parseInt(textField.getText());
            operator = '*';
            textField.setText("");
        }

        if(e.getSource()==functionButtons[4]){
            cislo1 = Integer.parseInt(textField.getText());
            operator = '/';
            textField.setText("");
        }

        if(e.getSource()==functionButtons[5]){
            cislo1 = Integer.parseInt(textField.getText());
            int vysledokFakt = fakt(cislo1);
            textField.setText(String.valueOf(vysledokFakt));
        }
        if(e.getSource()==clear){
            textField.setText("");
        }



    }
    public Integer fakt(Integer cislo){
        int vysledokFakt = 1;
        for(int i=cislo; i>0 ;i--){
            vysledokFakt *= i;
        }
        return vysledokFakt;
    }
}
