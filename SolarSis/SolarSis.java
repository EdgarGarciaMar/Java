


import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.image.TextureLoader;
import com.sun.j3d.utils.universe.*;
import com.sun.j3d.utils.picking.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.net.*;
//sudo cp /usr/lib/jni/libj3dcore-ogl.so /usr/lib/jvm/java-7-openjdk-amd64/jre/lib/ext
//sudo cp /usr/share/java/vecmath-*.jar /usr/lib/jvm/java-7-openjdk-amd64/jre/lib/ext

public class SolarSis extends MouseAdapter implements LeeRed{

    protected Transform3D viewTransform = new Transform3D();
    protected Vector3f viewVector;
    protected ViewingPlatform vp = null;
    protected TransformGroup viewTG = null;
    private TransformGroup riderPos;
    private TransformGroup earthRotX;
    private TransformGroup solRotX;
    private TransformGroup earthTransX;
    private TransformGroup marteRotX;
    private TransformGroup marteTransX;
    SimpleUniverse universe;
    private PickCanvas pickCanvas;
    private JComboBox jcb;
    private JTextArea jta;
    private MiniBrowser miniB;
    String opcs[] = {"Sol", "Tierra", "Marte"};
    
    Red red;
    ComboHandler combo;

    public SolarSis() {
        red = new Red(this);
        
        
        BranchGroup group = new BranchGroup();
        Appearance appsol = new Appearance();
        Appearance appearth = new Appearance();
        Appearance appLun = new Appearance();
        Appearance appmart = new Appearance();
        TextureLoader tex = new TextureLoader(getClass().getResource("TIERRA.JPG"), null);
        appearth.setTexture(tex.getTexture());
        tex = new TextureLoader(getClass().getResource("MARTE.JPG"), null);
        appmart.setTexture(tex.getTexture());
        tex = new TextureLoader(getClass().getResource("SOL.JPG"), null);
        appsol.setTexture(tex.getTexture());
        tex = new TextureLoader(getClass().getResource("LUNA.JPG"), null);
        appLun.setTexture(tex.getTexture());
        Sphere earth = new Sphere(0.045f, Primitive.GENERATE_NORMALS
                | Primitive.GENERATE_TEXTURE_COORDS, 32, appearth);
        earth.setUserData("Tierra");
        Sphere luna = new Sphere(0.018f, Primitive.GENERATE_NORMALS
                | Primitive.GENERATE_TEXTURE_COORDS, 32, appLun);
        luna.setUserData("Luna");
        Sphere marte = new Sphere(0.049f, Primitive.GENERATE_NORMALS
                | Primitive.GENERATE_TEXTURE_COORDS, 32, appmart);
        marte.setUserData("Marte");
        Sphere sol = new Sphere(0.33f, Primitive.GENERATE_NORMALS
                | Primitive.GENERATE_TEXTURE_COORDS, 32, appsol);
        sol.setUserData("Sol");
        
        earthRotX = Posi.rotate(earth, new Alpha(-1, 1250));
        solRotX = Posi.rotate(sol, new Alpha(-1, 1250));
        earthTransX = Posi.translate(earthRotX, new Vector3f(0.0f, 0.0f, 0.7f));
        TransformGroup earthRotGroupX = Posi.rotate(earthTransX, new Alpha(-1, 5000));
        group.addChild(earthRotGroupX);

        TransformGroup lunaRotX = Posi.rotate(luna, new Alpha(-1, 1249));
        TransformGroup lunaTransX = Posi.translate(lunaRotX, new Vector3f(0.0f, 0.0f, 0.1f));
        TransformGroup lunaRotGroupX = Posi.rotate(lunaTransX, new Alpha(-1, 2000));
        earthTransX.addChild(lunaRotGroupX);
        
        marteRotX = Posi.rotate(marte, new Alpha(-1, 12820));
        marteTransX = Posi.translate(marteRotX, new Vector3f(0.0f, 0.0f, 0.52f));
        TransformGroup marteRotGroupX = Posi.rotate(marteTransX, new Alpha(-1, 6000));
        group.addChild(marteRotGroupX);
        
        group.addChild(solRotX);
        GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
        Canvas3D canvas = new Canvas3D(config);
        canvas.setSize(400, 400);
        universe = new SimpleUniverse(canvas);
        universe.getViewingPlatform().setNominalViewingTransform();

        solRotX.setCapability(Group.ALLOW_LOCAL_TO_VWORLD_READ);
        solRotX.setCapability(Group.ALLOW_CHILDREN_EXTEND);
        solRotX.setCapability(Group.ALLOW_CHILDREN_WRITE);
        solRotX.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

        earthRotX.setCapability(Group.ALLOW_LOCAL_TO_VWORLD_READ);
        earthRotX.setCapability(Group.ALLOW_CHILDREN_EXTEND);
        earthRotX.setCapability(Group.ALLOW_CHILDREN_WRITE);
        earthRotX.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        
        marteRotX.setCapability(Group.ALLOW_LOCAL_TO_VWORLD_READ);
        marteRotX.setCapability(Group.ALLOW_CHILDREN_EXTEND);
        marteRotX.setCapability(Group.ALLOW_CHILDREN_WRITE);
        marteRotX.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

        vp = universe.getViewingPlatform();
        viewTG = vp.getViewPlatformTransform();
        universe.addBranchGraph(group);
        JFrame f = new JFrame("Sistema Solar");
        JPanel jp = new JPanel();
        f.setLayout(new BorderLayout());
        miniB = new MiniBrowser();
        combo = new ComboHandler();
        jp.add(new ComboPanel(opcs, combo));
        jp.add(miniB);
        JScrollPane dst_pane = new JScrollPane(jp);
        JSplitPane split_pane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, canvas, dst_pane);
        split_pane.setResizeWeight(0.5);
        split_pane.setContinuousLayout(true);
        f.add("Center", split_pane);
        pickCanvas = new PickCanvas(canvas, group);
        pickCanvas.setMode(PickCanvas.BOUNDS);
        canvas.addMouseListener(this);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }

    public void mouseClicked(MouseEvent e) {//metodo de eventos mouse
        envia(e);
        cambiarVistaMouse(e);
    }
    
    public void cambiarVistaMouse(MouseEvent e){
        pickCanvas.setShapeLocation(e);
        PickResult result = pickCanvas.pickClosest();
        if (result == null) {
            System.out.println("nada recibido");
        } else {
            Primitive p = (Primitive) result.getNode(PickResult.PRIMITIVE);
            Shape3D s = (Shape3D) result.getNode(PickResult.SHAPE3D);
            if (p != null) {
                System.out.println("UserData1: " + p.getUserData());
                System.out.println(p.getClass().getName());
                viewVector = new Vector3f(.0f, .0f, 0.95f);
                viewTransform.setTranslation(viewVector);
                viewTG.setTransform(viewTransform);
                vp.detach();
                if (p.getUserData().equals("Sol")) {
                    solRotX.addChild(vp);
                }
                if (p.getUserData().equals("Tierra")) {
                    earthRotX.addChild(vp);
                }
                if (p.getUserData().equals("Marte")) {
                    marteRotX.addChild(vp);
                }
                miniB.showPage("http://localhost:8080/" + p.getUserData() + ".html", true);
            } else if (s != null) {
                System.out.println("UserData2: " + s.getUserData());
                System.out.println(s.getClass().getName());
                jta.setText(s.getClass().getName());
            } else {
                System.out.println("null");
            }
        }
    }

    class ComboHandler implements AccionString {//clase anidada

        public void accion(String nombre) {
            envia(nombre);
            cambiarVistaCombo(nombre);
        }

        public void cambiarVistaCombo(String nombre){
            viewVector = new Vector3f(.0f, .0f, 0.95f);
            viewTransform.setTranslation(viewVector);
            viewTG.setTransform(viewTransform);
            vp.detach();
            if (nombre.equals("Sol")) {
                solRotX.addChild(vp);
            }
            if (nombre.equals("Tierra")) {
                earthRotX.addChild(vp);
            }
            if (nombre.equals("Marte")) {
                marteRotX.addChild(vp);
            }
            miniB.showPage("http://localhost:8080/" + nombre + ".html", true);
        }
    }
    
    public void envia(Object obj){
        if(obj instanceof String){
            String planeta = (String)obj;
            red.escribeRed(planeta);
        }
        if(obj instanceof MouseEvent){
            MouseEvent planetaEvent = (MouseEvent)obj;
            red.escribeRed(planetaEvent);
        }
    }
    
    public void leeRed(Object obj){
        System.out.println("clase obtenida"+  obj.getClass().getName());
        if(obj instanceof String){
            String planeta = (String)obj;
            combo.cambiarVistaCombo(planeta);
        }
        if(obj instanceof MouseEvent){
            MouseEvent planetaEvent = (MouseEvent)obj;
            cambiarVistaMouse(planetaEvent);
        }
    }
	
	public static void main(String a[]) {
		new SolarSis();
		}
}