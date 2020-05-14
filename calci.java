

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calci implements ActionListener {

    TextField tf;   // set text field area
    JButton ba = new JButton("+"); // set button (+)
    JButton bs = new JButton("-");  // set button(-)
    JButton bm = new JButton("*");    // button (*)
    JButton bd = new JButton("/");   // button(/)
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, bc, be, bdot, sqrt, bre;
    JButton bx;
    String op1, operator, op2;   // store (operator)operator and operand(op1,op2);

    calci() {
        op1 = operator = op2 = "";
        Frame f1 = new Frame("calculator");

        tf = new TextField();
        tf.setBounds(150, 50, 200, 40);
        f1.add(tf);


        bs.setBounds(300, 210, 70, 40);


        bm.setBounds(300, 270, 70, 40);


        bd.setBounds(300, 330, 70, 40);

        be = new Button("=");
        be.setBounds(300, 390, 70, 40);
        b7 = new Button("7");
        b7.setBounds(20, 200, 70, 40);
        b8 = new Button("8");
        b8.setBounds(110, 200, 70, 40);
        b9 = new Button("9");
        b9.setBounds(200, 200, 70, 40);
        b4 = new Button("4");
        b4.setBounds(20, 250, 70, 40);
        b5 = new Button("5");
        b5.setBounds(110, 250, 70, 40);
        b6 = new Button("6");
        b6.setBounds(200, 250, 70, 40);
        b1 = new Button("1");
        b1.setBounds(20, 300, 70, 40);
        b2 = new Button("2");
        b2.setBounds(110, 300, 70, 40);
        b3 = new Button("3");
        b3.setBounds(200, 300, 70, 40);
        bc = new Button("C");
        bc.setBounds(20, 150, 70, 40);
        b10 = new Button("0");
        b10.setBounds(90, 350, 90, 40);
        bdot = new Button(".");
        bdot.setBounds(190, 350, 90, 40);
        ba.setBounds(300, 150, 70, 40);
        sqrt = new Button("sqrt");
        sqrt.setBounds(110, 150, 70, 40);
        bre = new Button("%");
        bre.setBounds(200, 150, 70, 40);
        bx = new JButton("1/x");
        bx.setBounds(380, 150, 70, 40);
        try {
            ba.addActionListener(this);
            bs.addActionListener(this);
            bm.addActionListener(this);
            bd.addActionListener(this);
            be.addActionListener(this);
            b7.addActionListener(this);
            b8.addActionListener(this);
            b9.addActionListener(this);
            b4.addActionListener(this);
            b5.addActionListener(this);
            b6.addActionListener(this);
            b1.addActionListener(this);
            b2.addActionListener(this);
            b3.addActionListener(this);
            bc.addActionListener(this);
            b10.addActionListener(this);
            bdot.addActionListener(this);
            sqrt.addActionListener(this);
            bre.addActionListener(this);
            bx.addActionListener(this);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {

            f1.add(ba);
            f1.add(bs);
            f1.add(bm);
            f1.add(bd);
            f1.add(be);
            f1.add(b7);
            f1.add(b8);
            f1.add(b9);
            f1.add(b4);
            f1.add(b5);
            f1.add(b6);
            f1.add(b1);
            f1.add(b2);
            f1.add(b3);
            f1.add(bc);
            f1.add(b10);
            f1.add(bdot);
            f1.add(sqrt);
            f1.add(bre);
            f1.add(bx);
            f1.setSize(460, 480);
            f1.setLayout(null);
            f1.setVisible(true);
            f1.show();
            f1.setBackground(Color.blue);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        new calci();
    }


    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();    // store the any action command
        String s1 = tf.getText();    //
        if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {
            if (!operator.equals("")) {
                op2 = op2 + s;
            } else {
                op1 = op1 + s;
            }
            tf.setText(op1 + operator + op2);
        } else if (s.charAt(0) == 'C')
        {
            op1 = operator = op2 = "";
            tf.setText(op1 + op2);
        }
        else if (s.charAt(0) == '=')
        {
            double te = 0;     // calculate result
            // store the value in 1st
            if (operator.equals("+"))
                te = (Double.parseDouble(op1) + Double.parseDouble(op2));
            else if (operator.equals("-"))
                te = (Double.parseDouble(op1) - Double.parseDouble(op2));
            else if (operator.equals("/"))
                te = (Double.parseDouble(op1) / Double.parseDouble(op2));
            else if (operator.equals("*"))
                te = (Double.parseDouble(op1) * Double.parseDouble(op2));
            else if (operator.equals("%")) {
                te = (Double.parseDouble(op1) % Double.parseDouble(op2));
            } else if (operator.equals("sqrt")) {

                Double r = Double.parseDouble(String.valueOf(s1));
                te = Math.sqrt(r);
            } else if (e.getSource()==bx) {
                System.out.println("hello from sqrt");
                Double r = Double.parseDouble(String.valueOf(s1));
                te = 1 / r;
            }
            // set the value of text
            tf.setText(op1 + operator + op2 + "=" + te);

            // convert it to string
            op1 = Double.toString(te);

            operator = op2 = "";
        } else {
            // if there was no operand
            if (operator.equals("") || op2.equals("")) {
                operator = s;
                tf.setText(op1 + operator + op2);
        }
                // else evaluate
            else {
                double te;

                // store the value in 1st
                if (operator.equals("+"))
                    te = (Double.parseDouble(op1) + Double.parseDouble(op2));
                else if (operator.equals("-"))
                    te = (Double.parseDouble(op1) - Double.parseDouble(op2));
                else if (operator.equals("/"))
                    te = (Double.parseDouble(op1) / Double.parseDouble(op2));

                else
                    te = (Double.parseDouble(op1) * Double.parseDouble(op2));

                // convert it to string
                op1 = Double.toString(te);

                // place the operator
                operator = s;

                // make the operand blank
                op2 = "";
            }

            // set the value of text
            tf.setText(op1 +op2);

            }
        }


    }



