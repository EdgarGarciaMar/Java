package compara;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;
public class Compara extends JFrame implements ActionListener {
     private JButton b1;
     private JTextField a1,a2;
     private JLabel m,mm,dm,hm,i;
     public Compara(){
        super("Compara");
        this.setSize(1000,200); 
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(2, 4,4,4));
        mm = new JLabel("Ingresa el primer numero");
        dm = new JLabel("Ingresa el segundo numero");
        hm = new JLabel("Haz clic en el boton");
        i = new JLabel("Resultado");
        a1 = new JTextField(25);
        a2 = new JTextField(25);
        b1 = new JButton("Comparar");
        m = new JLabel("----------");
        b1.addActionListener(this);
        this.add(mm);
        this.add(dm);
        this.add(hm);
        this.add(i);
        this.add(a1);
        this.add(a2);
        this.add(b1);
        this.add(m);
     }
    @Override
    public void actionPerformed(ActionEvent e) {
        double num1= Double.parseDouble(a1.getText());
        double num2= Double.parseDouble(a2.getText());
        if(e.getSource()== b1){
            if(num1 == num2 )m.setText("Son iguales");
            else m.setText("No son iguales");
        }
    }
        public static void main(String[] args) {
        new Compara();
    }
}