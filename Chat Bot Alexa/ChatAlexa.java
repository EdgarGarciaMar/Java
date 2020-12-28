


import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;


        
public class ChatAlexa extends JFrame implements ActionListener, LeeRed,KeyListener {
    JButton b;//boton de enviar          
    
    JTextField m;//campo de entrada de datos       
    
    JTextArea mc;//campo de respuesta del bot no editable   
    
    Red red;// comunicacion por socket
    JPanel usuario;// panel de acomodo de campo de entrada y boton
    
    public ChatAlexa(){
        super("Alexa");
        red = new Red(this);
        this.setSize(450,300); 
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(1, 2));
        
        mc = new JTextArea();
        mc.setEditable(false);
        mc.setLineWrap(true);
        this.add(mc);
        usuario1();
        this.add(usuario);
    }
    
    public void usuario1(){
        usuario =new JPanel();
        usuario.setLayout(new GridLayout(2, 1));
        
        m = new JTextField(80);
        m.addKeyListener(this);
        b = new JButton("Enviar");
        b.addActionListener(this);
        usuario.add(m);
        usuario.add(b);
    }
    
    public void agregar(String usuario, String mensaje){
        mc.append(usuario+":"+mensaje+"\n");
    }
    
    public void enviarsms(){
        if(!m.getText().equals("")){
            agregar("Cliente",m.getText());
            red.escribeRed(m.getText());
            m.setText("");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        enviarsms();
    }

    @Override
    public void leeRed(Object obj) {
        System.out.println("Conexion exitosa con Alexa"+obj.getClass().getName());
        if(obj instanceof String){
            String respuesta = (String) obj;
            agregar("Alexa",respuesta);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            enviarsms();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    
        public static void main(String[] args) {
        new ChatAlexa();
    }
}
