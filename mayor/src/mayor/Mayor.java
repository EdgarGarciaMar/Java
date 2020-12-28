package mayor;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;
public class Mayor extends JFrame implements ActionListener {
     private JButton b1;
     private JTextField a1,a2,a3;
     private JLabel m,mm,dm,hm,i,q;
    public Mayor(){
        super("Mayor que");
        this.setSize(1000,200); 
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(2, 5,4,4));
        mm = new JLabel("Ingresa el primer numero");
        dm = new JLabel("Ingresa el segundo numero");
        q = new JLabel("Ingresa el tercer numero");
        hm = new JLabel("Haz clic en el boton");
        i = new JLabel("Resultado");
        a1 = new JTextField(25);
        a2 = new JTextField(25);
        a3 =new JTextField(25);
        b1 = new JButton("Comparar");
        m = new JLabel("----------");
        b1.addActionListener(this);
        this.add(mm);
        this.add(dm);
        this.add(q);
        this.add(hm);
        this.add(i);
        this.add(a1);
        this.add(a2);
        this.add(a3);
        this.add(b1);
        this.add(m);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        double num1= Double.parseDouble(a1.getText());
        double num2= Double.parseDouble(a2.getText());
        double num3= Double.parseDouble(a3.getText());
        if(e.getSource()==b1){
            if(num1>num2 && num1>num3)m.setText("El mayor de todos es:"+num1);
            if(num2>num1 && num2>num3)m.setText("El mayor de todos es:"+num2);
            if(num3>num1 && num3>num2)m.setText("El mayor de todos es:"+num3);
            if(num1==num2 && num2==num3)m.setText("Todos son iguales");
            if(num1==num2&&num1>num3)m.setText(num1+" y "+num2+" Son los mayores");
            if(num2==num3&&num2>num1)m.setText(num2+" y "+num3+" Son los mayores");
    }
    }
    public static void main(String[] args) {
       new Mayor();
    }
}
