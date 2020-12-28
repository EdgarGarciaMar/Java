package frutas;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;
public  class Frutas extends JFrame implements ActionListener{
 private JButton b1,b2,b3;
 private JLabel m;
 public Frutas(){
        super("Frutas");
        this.setSize(500,100); 
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(1, 4,4,4));
        b1 = new JButton("Manzana");
        b2 = new JButton("Limon");
        b3 = new JButton("Naranja");
        m = new JLabel("---------");
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        this.add(b1);
        this.add(b2);
        this.add(b3);
        this.add(m);
 }
    @Override
    public void actionPerformed(ActionEvent e) {
        String a;
        if(e.getSource()==b1){
            a=b1.getText();
            m.setText(a);
        }
        if(e.getSource()==b2){
            a=b2.getText();
            m.setText(a);
         }
        if(e.getSource()==b3){
            a=b3.getText();
            m.setText(a);
        }
    }
    public static void main(String[] args) {
        new Frutas();
    }

}
