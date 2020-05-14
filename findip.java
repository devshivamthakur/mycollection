package com.company;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;
import java.awt.*;
public class findip implements ActionListener {
    Frame f=new Frame("");
    Label l[]=new Label[2];
    Label l1=new Label("Ip :");
    TextField tf=new TextField();
    JButton b1=new JButton("Find IP");
    findip()
    {

Font  f1=new Font("",Font.BOLD+Font.ITALIC,15);
            l[0]=new Label("website name :");
            l[0].setBounds(30,40,120,40);
            l[0].setForeground(Color.RED);
            l[1]=new Label("");
            l[1].setBounds(100,140,240,30);
            l1.setBounds(70,140,50,30);
        tf.setBounds(150,44,190,30);
        b1.setBounds(150,90,85,40);
            l1.setFont(f1);
            for(int i=0;i<2;++i)
            {
                l[i].setFont(f1);
            }
            b1.addActionListener(this);
        for(int i=0;i<2;++i)
        {
            f.add(l[i]);
        }

            f.add(tf);
            f.add(b1);
            f.add(l1);
            l1.setVisible(false);
            f.setBackground(Color.YELLOW);
            f.setSize(400,200);
            f.setLayout(null);
            f.setVisible(true);

    }

    public static void main(String[] args) {
        new findip();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s1=tf.getText();
        String s2="";
        if(e.getSource()==b1)
        {
            try {
                InetAddress ia=InetAddress.getByName(s1);
                s2=ia.getHostAddress();
                l[1].setText(s2);
                l1.setVisible(true);
            } catch (UnknownHostException ex) {
                l[1].setText(ex.getMessage());
                l1.setVisible(true);
            }
        }

            }
}
