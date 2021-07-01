package dead;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

public class Dead extends JFrame implements ActionListener {
     private JButton b1;
     private JTextField a1,a2;
     private JLabel m,a,h,r,R;
     
     public Dead(){
        super("Año de muerte :(");
        this.setSize(1000,200); 
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(2, 4,4,4));
        m = new JLabel("Ingresa tu edad");
        a = new JLabel("Ingresa el año actual");
        h = new JLabel("Haz clic");
        r = new JLabel("Posible año de muerte");
        a1 = new JTextField(25);
        a2 = new JTextField(25);
        b1 = new JButton("Calcular");
        R = new JLabel("------");
        this.add(m);
        this.add(a);
        this.add(h);
        this.add(r);
        this.add(a1);
        this.add(a2);
        this.add(b1);
        this.add(R);
        b1.addActionListener(this);
     }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==b1){
           int edad= Integer.parseInt(a1.getText());
           int año =Integer.parseInt(a2.getText());
           int dead = 77-edad;
           int añodead= año+dead;
           if(edad>=77)R.setText("Felicidades has superado la esperansa de vida promedio.");
           else R.setText(""+añodead);
       }
    }
        public static void main(String[] args) {
        new Dead();
    }
}
