
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;


public class Ticker extends JFrame implements Runnable {
    JLabel l;
    Thread hilo;
    String  a = "HOLA MUNDO ";
    char [] c = a.toCharArray();
    int count;
    int sleep1;
    int x,y;
    
    public Ticker(int howmany,int sleep){
        super("Tickets");
        this.setSize(400,200); 
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        l = new JLabel("----------");
        l.setBounds(120, 50, 100, 50);
        this.add(l);
        count = howmany;
        sleep1 = sleep;
        hilo=new Thread(this); //debe ser de las ultimas lin. del constructor
        hilo.start(); //debe ser de las ultimas lineas del constructor
    }
    @Override
    public void run() {
        while(count-->0){
            x=c[c.length -1];
            for(y=c.length -1;y>0;y--){
                c[y]=c[y-1];
            }
            c[0]=(char) x;
            l.setText(String.valueOf(c));
            try{
                Thread.sleep(sleep1);
            }
            catch(Exception e){
                return;
            }
        }
    }
        public static void main(String[] args) {
        new Ticker(40,500);
    }
}
