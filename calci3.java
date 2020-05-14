


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calci3  implements ActionListener {

    JTextField tf;   // set text field area
    JButton ba= new JButton("+"); // set Jbutton (+)
    JButton bs= new JButton("-");  // set Jbutton(-)
    JButton bm=new JButton("*");    // Jbutton (*)
    JButton bd=new JButton("/");   // Jbutton(/)
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,bc,be,bdot;
    String op1,operator,op2;   // store (operator)operator and operand(op1,op2);



    calci3() {
        JPanel p1=new JPanel();
        p1.setBackground(Color.BLUE);
        p1.setBounds(1,1,375, 320);
        //p1.setBackground(Color.BLUE);

        op1 = operator = op2 = "";
        JFrame f1 = new JFrame("calculator");

        tf = new JTextField();
        tf.setBounds(20, 45, 250, 40);
        tf.setEditable(false);
        p1.add(tf);


        bs.setBounds(290, 152, 70, 40);


        bm.setBounds(290, 200, 70, 40);


        bd.setBounds(290, 249, 70, 40);

        be = new JButton("=");
        be.setBounds(200, 249, 70, 40);
        b7 = new JButton("7");
        b7.setBounds(20, 100, 70, 40);
        b8 = new JButton("8");
        b8.setBounds(110, 100, 70, 40);
        b9 = new JButton("9");
        b9.setBounds(200, 100, 70, 40);
        b4 = new JButton("4");
        b4.setBounds(20, 150, 70, 40);
        b5 = new JButton("5");
        b5.setBounds(110, 150, 70, 40);
        b6 = new JButton("6");
        b6.setBounds(200, 150, 70, 40);
        b1 = new JButton("1");
        b1.setBounds(20, 200, 70, 40);
        b2 = new JButton("2");
        b2.setBounds(110, 200, 70, 40);
        b3 = new JButton("3");
        b3.setBounds(200, 200, 70, 40);
        bc = new JButton("C");
        bc.setBounds(290, 45, 70, 40);
        b10 = new JButton("0");
        b10.setBounds(20, 250, 70, 40);
        bdot = new JButton(".");
        bdot.setBounds(110, 250, 70, 40);
        ba.setBounds(290, 100, 70, 40);

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
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {

            p1.add(ba);
            p1.add(bs);
            p1.add(bm);
            p1.add(bd);
            p1.add(be);
            p1.add(b7);
            p1.add(b8);
            p1.add(b9);
            p1.add(b4);
            p1.add(b5);
            p1.add(b6);
            p1.add(b1);
            p1.add(b2);
            p1.add(b3);
            p1.add(bc);
            p1.add(b10);
            p1.add(bdot);
            f1.add(p1);
            p1.setLayout(null);
            f1.setSize(378, 330);
//            f1.setLayout(null);
            f1.setLayout(null);
            f1.setVisible(true);


            //   f1.setBackground(Color.BLUE);
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        new calci3();
    }


    public void actionPerformed (ActionEvent e){
        String s = e.getActionCommand();
        /*
        for store operand
         */
        if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {
            if (!operator.equals("")) {  // after one operand and operator is already here in ta ex. (10+)
                op2 = op2 + s;      // after this line( op1,op2,and operator)textArea look like ex(10+20)
            } else {           // if no operator there ,we add operand1
                op1 = op1 + s;             // after this line ta look like (8)
            }
            tf.setText(op1 + operator + op2);      // print 10+20 in textarea
        } else if (s.charAt(0) == 'C') {
            op1 = operator = op2 = "";
            tf.setText(op1 + operator + op2);
        } else if (s.charAt(0) == '=') {
            double te;
            // store the value in 1st
            if (operator.equals("+"))
                te = (Double.parseDouble(op1) + Double.parseDouble(op2));         // addition operation
            else if (operator.equals("-"))
                te = (Double.parseDouble(op1) - Double.parseDouble(op2)); // substraction operation
            else if (operator.equals("/"))
                te = (Double.parseDouble(op1) / Double.parseDouble(op2));    // divide operation
            else
                te = (Double.parseDouble(op1) * Double.parseDouble(op2)); //multiplication operation

            // set the value of text
            tf.setText(op1 + operator + op2 + "=" + te);           // set result in ta ex(10+20=30)

            // convert it to string
            op1 = Double.toString(te);     // convert ans into operand 1st    for any next operation

            operator = op2 = "";   // set operand2 & operator =0
        } else {         // for operator
            // if there was no operand
            if (operator.equals("") || op2.equals(""))  // store operator before 2nd operand
                operator = s;         // ex(10+)
                // else evaluate
            else {         //if operand1,operand2& operator is already there  ex(10+20) // if click any operator like ex(10+20+)
                              // then first calculate 10+20 and store value in 1st operand  and print in ta .ex(30+)
                double te;
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
                operator = s; // store operator after operation ex(30+)

                // make the operand blank
                op2 = "";
            }

            // set the value of text
            tf.setText(op1 + operator + op2);
        }
    }
}


