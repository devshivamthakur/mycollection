package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static java.awt.Font.ITALIC;
import static java.lang.Thread.sleep;

public class tic extends WindowAdapter implements ActionListener,Runnable  {
    Button l1, l2, l3, l4, l5, l6, l7, l8, l9;  //set button
    String sl1 = "", sl2 = "", sl3 = "", sl4 = "", sl5 = "", sl6 = "", sl7 = "", sl8 = "", sl9 = ""; // get the label of the button
    static String sb1 = "", sb2 = "", sb3 = "", sb4 = "", sb5 = "", sb6 = "", sb7 = "", sb8 = "", sb9 = ""; // for save repeat labe
    Label lb1, lb, lc, lc1, lc2;
    TextField tf1, tf2; // for name
    Button b1,b2;
    Thread t=null;
    int h=0,m=0,s=0;
    String  ts="";
    int x=0;
    String s1 = "", s2 = "", s3 = "1"; // get the name and s3 is used to show the no of player to be move
    static int player = 1;
    Font f=new Font("",Font.BOLD,22);
    Font fon=new Font("",Font.BOLD,15);
    JFrame f1 = new JFrame("enter first");// login frame
    JFrame f2 = new JFrame("tic tac toi"); // main game frame
    Image icon=Toolkit.getDefaultToolkit().getImage("D:\\New folder\\download.JPG");
    JFrame f3=new JFrame(); // result frame
    JPanel p1=new JPanel();     // frame1
    JPanel p2=new JPanel();       // frame2
    JPanel p3=new JPanel();       //frame 3
    tic() {

        /* digital
      watch
        area*/
        f1.setIconImage(icon);
        f2.setIconImage(icon);
        f3.setIconImage(icon);
        t= new Thread(this);
        t.start();
        b2=new Button();
        b2.setBounds(80,240,100,50);
        /*digital watch component

         */
        tf1 = new TextField(30);
        tf1.setBounds(150, 70, 80, 30);   //f1
        tf1.setFont(fon);
        tf2 = new TextField();
        tf2.setBounds(150, 100, 80, 30);   //f1
        tf2.setFont(fon);
        lc = new Label("");
        lb1 = new Label(" player 1 name");
        lb1.setFont(fon);
        lb = new Label(" player 2 name");
        lb.setFont(fon);
        b1 = new Button("play");
        l1 = new Button(" ");
        l2 = new Button("  ");
        l3 = new Button("  ");
        l4 = new Button("");
        l5 = new Button("   ");
        l6 = new Button("     ");
        l7 = new Button("  ");
        l8 = new Button(" ");
        l9 = new Button("");
        lc1 = new Label("player ");
        lc1.setBounds(30, 150, 70, 40);
        lc2 = new Label();
        lc2.setBounds(110, 150, 60, 40);
        lc.setBounds(70, 300, 150, 30);///f1
        lc.setFont(fon);
        lc.setBackground(Color.MAGENTA);
        lc.setForeground(Color.BLACK);
        b1.setBounds(100, 165, 70, 50);  //f1
        b1.setFont(f);
        lb1.setBounds(30, 70, 115, 30); //f1
        lb.setBounds(30, 100, 115, 30);  // f1
        l1.setBounds(30, 40, 40, 40);
        l2.setBounds(70, 40, 40, 40);
        l3.setBounds(110, 40, 40, 40);
        l4.setBounds(30, 80, 40, 40);
        l5.setBounds(70, 80, 40, 40);
        l6.setBounds(110, 80, 40, 40);
        l7.setBounds(30, 120, 40, 40);
        l8.setBounds(70, 120, 40, 40);
        l9.setBounds(110, 120, 40, 40);
        /*
        set fonts in button
         👇
         */
        l1.setFont(f);
        l2.setFont(f);
        l3.setFont(f);
        l4.setFont(f);
        l5.setFont(f);
        l6.setFont(f);
        l7.setFont(f);
        l8.setFont(f);
        l9.setFont(f);

        /*   set labal color  👇
         * */
        l1.setForeground(Color.RED);
        l2.setForeground(Color.RED);
        l3.setForeground(Color.RED);
        l4.setForeground(Color.RED);
        l5.setForeground(Color.RED);
        l6.setForeground(Color.RED);
        l7.setForeground(Color.RED);
        l8.setForeground(Color.RED);
        l9.setForeground(Color.RED);
        /**
         *
         */
        /*set action listener with button  👇
         * */
        l1.addActionListener(this);
        l2.addActionListener(this);
        l3.addActionListener(this);
        l4.addActionListener(this);
        l5.addActionListener(this);
        l6.addActionListener(this);
        l7.addActionListener(this);
        l8.addActionListener(this);
        l9.addActionListener(this);
        b1.addActionListener(this);
/*
add component in frame   👇
 */
        p2.add(l1);
        p2.add(l2);
        p2.add(l3);
        p2.add(l4);
        p2.add(l5);
        p2.add(l6);
        p2.add(l7);
        p2.add(l8);
        p2.add(l9);
        f2.add(p2);

        p1.add(b2);

        f2.add(lc1);
        f2.add(lc2);
        p1.add(lb1);
        p1.add(lb);
        p1.add(tf1);
        p1.add(tf2);
        p1.add(b1);
        p1.add(lc);
        f1.add(p1);
        //  f1.add(b2);
        p1.setBackground(Color.magenta);
        p2.setBackground(Color.BLUE);
        p2.setForeground(Color.BLACK);
        p1.setSize(300, 400);
        p1.setLayout(null);
        p1.setVisible(true);
        f1.setSize(300, 400);
        f1.setLayout(null);
        f1.setVisible(true);

        p2.setSize(200, 300);
        p2.setLayout(null);
        p2.setVisible(false);
        f2.setSize(200, 300);
        f2.setLayout(null);
        f2.setVisible(false);
     /*
     framne listener
      */

    }

    public void win()
    {
        String s11=" YOU ARE WINNER";
        String s22;
        if(x==1)
        {
            s22=s1;
            s22=s22+s11;
        }
        else
        {
            s22=s2;
            s22=s22+s11;
        }
        f2.setVisible(false);
        f1.setVisible(false);
        p2.setVisible(false);
        p1.setVisible(false);
        JFrame f=new JFrame("");
        JPanel p=new JPanel();
        f.setIconImage(icon);
        f.setSize(400,200);
        p.setSize(400,200);
        Label l1=new Label(s22);
        l1.setAlignment(Label.CENTER);
        l1.setBackground(Color.green);
        l1.setForeground(Color.BLACK);
        l1.setBounds(75,80,200,40);
        p.add(l1);
        b2.setBounds(130,110,100,40);
        p.add(b2);
        f.add(p);
        p.setBackground(Color.white);
        p.setLayout(null);
        p.setVisible(true);
        f.setLayout(null);
        f.setVisible(true);
        f.addWindowListener(this);
    }


    public void draw()
    {
        String s11=" GAME DRAW";

        f2.setVisible(false);
        f1.setVisible(false);
        JFrame f=new JFrame("");
        JPanel p=new JPanel();
        f.setIconImage(icon);
        f.setSize(400,200);
        p.setSize(400,200);
        Label l1=new Label(s11);
        l1.setAlignment(Label.CENTER);
        l1.setBackground(Color.ORANGE);
        l1.setForeground(Color.BLACK);
        l1.setBounds(75,80,200,40);
        p.add(l1);
        b2.setBounds(130,110,100,40);
        p.add(b2);
        f.add(p);
        p.setBackground(Color.white);
        p.setLayout(null);
        p.setVisible(true);
        f.setLayout(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new tic();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        s1 = tf1.getText();
        s2 = tf2.getText();
        lc2.setText(s3);
        if (e.getSource() == b1) {
            try {
                if (s1.isEmpty() || s2.isEmpty()) {
                    JOptionPane.showMessageDialog(p1,"please enter name first");
                } else if (s1.equals(s2)) {
                    JOptionPane.showMessageDialog(p1,"enter different name");
                }
                f1.setVisible(false);
                p1.setVisible(false);
                sleep(1000);
                f2.setVisible(true);
                p2.setVisible(true);
                b2.setBounds(40,180,100,40);// show current time
                p2.add(b2);
            } catch (Exception e1) {
                lc.setText(e1.getMessage());
            }
        }

        if (e.getSource() == l1) {
            if (sb1.isEmpty()) {
                if (player == 1) {
                    l1.setLabel("X");
                    sb1 = "X";
                } else {
                    l1.setLabel("O");
                    sb1 = "O";

                }
                player++;
            }

        } else if (e.getSource() == l2)
        {
            if (sb2.isEmpty()) {
                if (player == 1) {
                    l2.setLabel("X");
                    sb2 = "X";
                    player++;
                } else {
                    l2.setLabel("O");
                    sb2 = "O";
                    player++;
                }

            }

        } else if (e.getSource() == l3) {

            if (sb3.isEmpty()) {
                if (player == 1) {
                    l3.setLabel("X");
                    sb3 = "X";
                } else {
                    l3.setLabel("O");
                    sb3 = "O";
                }
                player++;
            }

        } else if (e.getSource() == l4) {

            if (sb4.isEmpty()) {
                if (player == 1) {
                    l4.setLabel("X");
                    sb4 = "X";
                } else {
                    l4.setLabel("O");
                    sb4 = "O";
                }
                player++;
            }

        } else if (e.getSource() == l5) {

            if (sb5.isEmpty()) {
                if (player == 1) {
                    l5.setLabel("X");
                    sb5 = "X";
                } else {
                    l5.setLabel("O");
                    sb5 = "O";
                }
                player++;
            }

        } else if (e.getSource() == l6) {

            if (sb6.isEmpty()) {
                if (player == 1) {
                    l6.setLabel("X");
                    sb6 = "X";
                } else {
                    l6.setLabel("O");
                    sb6 = "O";
                }
                player++;
            }

        } else if (e.getSource() == l7) {

            if (sb7.isEmpty()) {
                if (player == 1) {
                    l7.setLabel("X");
                    sb7 = "X";
                } else {
                    l7.setLabel("O");
                    sb7 = "O";
                }
                player++;
            }

        } else if (e.getSource() == l8) {

            if (sb8.isEmpty()) {
                if (player == 1) {
                    l8.setLabel("X");
                    sb8 = "X";
                } else {
                    l8.setLabel("O");
                    sb8 = "O";
                }
                player++;
            }

        } else if (e.getSource() == l9) {

            if (sb9.isEmpty()) {
                if (player == 1) {
                    l9.setLabel("X");
                    sb9 = "X";
                } else {
                    l9.setLabel("O");
                    sb9 = "O";
                }
                player++;
            }

        }
        if (player % 2 == 0) {
            player = 2;
            s3 = "2";
        } else {
            player = 1;
            s3 = "1";
        }
        sl1 = l1.getLabel();
        sl2 = l2.getLabel();
        sl3 = l3.getLabel();
        sl4 = l4.getLabel();
        sl5 = l5.getLabel();
        sl6 = l6.getLabel();
        sl7 = l7.getLabel();
        sl8 = l8.getLabel();
        sl9 = l9.getLabel();

        if (sl1 == sl2 && sl2 == sl3)
        {
            f2.setVisible(false);
            win();

        } else if (sl4 == sl5 && sl5 == sl6)
        {
            win();

        } else if (sl7 == sl8 && sl8 == sl9)
        {
            win();

        } else if (sl1 == sl4 && sl4 == sl7)
        {
            win();

        } else if (sl2 == sl5 && sl5 == sl8)
        {
            win();
        } else if (sl3 == sl6 && sl6 == sl9)
        {
            win();

        } else if (sl1 == sl5 && sl5 == sl9)
        {
            win();

        } else if (sl3 == sl5 && sl5 == sl7)
        {
            win();

        } else if (!sl1.isEmpty() && !sl2.isEmpty() && !sl3.isEmpty() && !sl4.isEmpty() && !sl5.isEmpty() && !sl6.isEmpty() && !sl7.isEmpty() && !sl8.isEmpty() && !sl9.isEmpty())
        {
            draw();
            System.out.println("game draw");
        }
        x=player;
        lc2.setText(s3);



    }

    @Override
    public void run() {
        try
        {
            while (true)
            {
                Calendar c=Calendar.getInstance();
                h=c.get(Calendar.HOUR);
                m=c.get(Calendar.MINUTE);
                s=c.get(Calendar.SECOND);
                SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss");
                Date d=c.getTime();
                ts=sdf.format(d);
                b2.setLabel(ts);
                t.sleep(1000);

            }
        }catch (Exception e)
        {

        }
    }
}



