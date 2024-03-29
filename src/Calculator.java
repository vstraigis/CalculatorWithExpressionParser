import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {

    JFrame f;
    JTextField t;
    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bdiv, bmul, bsub, badd, bdec, beq, bdel, bclr, rparenth, lparenth;
    double a = 0, b = 0, result = 0;
    int operator = 0;
    Calculator() {
        creatingFrame();
        addingNumberButtons();
        makingLayout();
    }
    //Creating Frame
    private void creatingFrame() {
        f = new JFrame("Calculator");
        f.setLayout(null);
        f.setVisible(true);
        f.setSize(350, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
    }
    //Creating/adding buttons and ActionListener
    private void addingNumberButtons() {
        t = new JTextField();
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        b0 = new JButton("0");
        bdiv = new JButton("/");
        bmul = new JButton("*");
        bsub = new JButton("-");
        badd = new JButton("+");
        bdec = new JButton(".");
        beq = new JButton("=");
        bdel = new JButton("Del");
        bclr = new JButton("Clr");
        rparenth = new JButton(")");
        lparenth = new JButton("(");

        f.add(t);
        f.add(b7);
        f.add(b8);
        f.add(b9);
        f.add(bdiv);
        f.add(b4);
        f.add(b5);
        f.add(b6);
        f.add(bmul);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(bsub);
        f.add(bdec);
        f.add(b0);
        f.add(beq);
        f.add(badd);
        f.add(bdel);
        f.add(bclr);
        f.add(rparenth);
        f.add(lparenth);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b0.addActionListener(this);
        badd.addActionListener(this);
        bdiv.addActionListener(this);
        bmul.addActionListener(this);
        bsub.addActionListener(this);
        bdec.addActionListener(this);
        beq.addActionListener(this);
        bdel.addActionListener(this);
        bclr.addActionListener(this);
        rparenth.addActionListener(this);
        lparenth.addActionListener(this);

    }
    //creating a Layout
    private void makingLayout() {
        t.setBounds(30, 40, 280, 30);
        b7.setBounds(40, 100, 50, 40);
        b8.setBounds(110, 100, 50, 40);
        b9.setBounds(180, 100, 50, 40);
        bdiv.setBounds(250, 100, 50, 40);
        b4.setBounds(40, 170, 50, 40);
        b5.setBounds(110, 170, 50, 40);
        b6.setBounds(180, 170, 50, 40);
        bmul.setBounds(250, 170, 50, 40);
        b1.setBounds(40, 240, 50, 40);
        b2.setBounds(110, 240, 50, 40);
        b3.setBounds(180, 240, 50, 40);
        bsub.setBounds(250, 240, 50, 40);
        bdec.setBounds(40, 310, 50, 40);
        b0.setBounds(110, 310, 50, 40);
        beq.setBounds(180, 310, 50, 40);
        badd.setBounds(250, 310, 50, 40);
        bdel.setBounds(40, 380, 55, 40);
        bclr.setBounds(110, 380, 50, 40);
        lparenth.setBounds(180, 380, 50, 40);
        rparenth.setBounds(250, 380, 50, 40);
    }

    @Override
    public void actionPerformed(ActionEvent e){

        if(e.getSource()==b1)
            t.setText(t.getText().concat("1"));
        if(e.getSource()==b2)
            t.setText(t.getText().concat("2"));
        if(e.getSource()==b3)
            t.setText(t.getText().concat("3"));
        if(e.getSource()==b4)
            t.setText(t.getText().concat("4"));
        if(e.getSource()==b5)
            t.setText(t.getText().concat("5"));
        if(e.getSource()==b6)
            t.setText(t.getText().concat("6"));
        if(e.getSource()==b7)
            t.setText(t.getText().concat("7"));
        if(e.getSource()==b8)
            t.setText(t.getText().concat("8"));
        if(e.getSource()==b9)
            t.setText(t.getText().concat("9"));
        if(e.getSource()==b0)
            t.setText(t.getText().concat("0"));
        if(e.getSource()==bdec)
            t.setText(t.getText().concat("."));
        if(e.getSource()==badd)
            t.setText(t.getText().concat(" + "));
        if(e.getSource()==bsub)
            t.setText(t.getText().concat(" - "));
        if(e.getSource()==bmul)
            t.setText(t.getText().concat(" * "));
        if(e.getSource()==bdiv)
            t.setText(t.getText().concat(" / "));
        if(e.getSource()==lparenth)
            t.setText(t.getText().concat("( "));
        if(e.getSource()==rparenth)
            t.setText(t.getText().concat(" )"));

        {
            if(e.getSource()==beq)
            {
                String expr;
                expr = t.getText().replaceAll("\\s", "");
                Parsing EP = new Parsing(expr);

                t.setText("");
                t.setText(Double.toString(EP.parse()));
                System.out.println(t.getText());
            }

            if(e.getSource()==bclr)
                t.setText("");
            if(e.getSource()==bdel)
            {
                String s=t.getText();
                t.setText("");
                for(int i=0;i<s.length()-1;i++)
                    t.setText(t.getText()+s.charAt(i));
            }
        }
    }
}