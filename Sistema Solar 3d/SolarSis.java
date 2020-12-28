/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.image.TextureLoader;
import com.sun.j3d.utils.universe.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import java.awt.*;
import javax.swing.*;


public class SolarSis {
public SolarSis(){	 
BranchGroup group = new BranchGroup();//nodo
	Appearance appsol = new Appearance();//apariencia 
	Appearance appearth = new Appearance();
        TextureLoader tex=new TextureLoader(getClass().getResource("TIERRA.JPG"), null);//textura del planeta
	appearth.setTexture(tex.getTexture());
	tex=new TextureLoader(getClass().getResource("SOL.JPG"), null);//textura del planeta
	appsol.setTexture(tex.getTexture());
	Sphere earth = new Sphere(0.045f, Primitive.GENERATE_NORMALS | 	//tamaño de los planetas		
	Primitive.GENERATE_TEXTURE_COORDS, 32, appearth);
	Sphere sol = new Sphere(0.25f, Primitive.GENERATE_NORMALS | //tamaño de los planetas
	Primitive.GENERATE_TEXTURE_COORDS, 32, appsol);
	TransformGroup earthRotXformGroup = Posi.rotate(earth, new Alpha(-1, 1250));//rotacion sobre el mismo eje
	TransformGroup solRotXformGroup = Posi.rotate(sol, new Alpha(-1, 1250));//rotacion sobre el mismo eje
	TransformGroup earthTransXformGroup = Posi.translate(earthRotXformGroup, 
	new Vector3f(0.0f, 0.0f, 0.4f));//cordenadas en el ambiente 3d
	TransformGroup earthRotGroupXformGroup = Posi.rotate(earthTransXformGroup, new Alpha(-1, 5000));
    	group.addChild(earthRotGroupXformGroup);
    	group.addChild(solRotXformGroup);
	//parametros de venus
        Appearance appvenus = new Appearance();
	tex=new TextureLoader(getClass().getResource("VENUS.JPG"), null);
	appvenus.setTexture(tex.getTexture());
	Sphere venus = new Sphere(0.048f, Primitive.GENERATE_NORMALS | 			
	Primitive.GENERATE_TEXTURE_COORDS, 32, appvenus);                                              
	TransformGroup venusRotXformGroup = Posi.rotate(venus, new Alpha(-1, 1260));
	TransformGroup venusTransXformGroup = Posi.translate(venusRotXformGroup, 
	new Vector3f(0.0f, 0.0f, 0.35f));                                                             
	TransformGroup venusRotGroupXformGroup = Posi.rotate(venusTransXformGroup, new Alpha(-1, 4600));
    	group.addChild(venusRotGroupXformGroup);
        //parametros de marte
	Appearance appmar = new Appearance();
	tex=new TextureLoader(getClass().getResource("MARTE.JPG"), null);
	appmar.setTexture(tex.getTexture());
	Sphere mar = new Sphere(0.040f, Primitive.GENERATE_NORMALS | 			
	Primitive.GENERATE_TEXTURE_COORDS, 32, appmar);                                              
	TransformGroup marRotXformGroup = Posi.rotate(mar, new Alpha(-1, 1282));
	TransformGroup marTransXformGroup = Posi.translate(marRotXformGroup, 
	new Vector3f(0.0f, 0.0f, 0.52f));                                                             
	TransformGroup marRotGroupXformGroup = Posi.rotate(marTransXformGroup, new Alpha(-1, 6000));
    	group.addChild(marRotGroupXformGroup);
        //parametros de jupiter
	Appearance appmer = new Appearance();
	tex=new TextureLoader(getClass().getResource("JUPITER.JPG"), null);
	appmer.setTexture(tex.getTexture());
	Sphere mer = new Sphere(0.12f, Primitive.GENERATE_NORMALS | 			
	Primitive.GENERATE_TEXTURE_COORDS, 32, appmer);
	TransformGroup merRotXformGroup = Posi.rotate(mer, new Alpha(-1, 730));                       
	TransformGroup merTransXformGroup = Posi.translate(merRotXformGroup, 
	new Vector3f(0.0f, 0.0f, 0.8f));
	TransformGroup merRotGroupXformGroup = Posi.rotate(merTransXformGroup, new Alpha(-1, 50000));  
    	group.addChild(merRotGroupXformGroup);
        //parametros de saturno
        Appearance appsaturno = new Appearance();
	tex=new TextureLoader(getClass().getResource("SATURNO.JPG"), null);
	appsaturno.setTexture(tex.getTexture());
	Sphere saturno = new Sphere(0.08f, Primitive.GENERATE_NORMALS | 			
	Primitive.GENERATE_TEXTURE_COORDS, 32, appsaturno);
	TransformGroup saturnoRotXformGroup = Posi.rotate(saturno, new Alpha(-1, 780));                       
	TransformGroup saturnoTransXformGroup = Posi.translate(saturnoRotXformGroup, 
	new Vector3f(0.0f, 0.0f, 1.2f));
	TransformGroup saturnoRotGroupXformGroup = Posi.rotate(saturnoTransXformGroup, new Alpha(-1, 49000));  
    	group.addChild(saturnoRotGroupXformGroup);


    	GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();//creacion del universo
    	Canvas3D canvas = new Canvas3D(config); canvas.setSize(1000, 1000);//creacion de canvas y definicion de tamaño de la ventana
    	SimpleUniverse universe = new SimpleUniverse(canvas);
    	universe.getViewingPlatform().setNominalViewingTransform();
    	universe.addBranchGraph(group);  
    	JFrame f = new JFrame("Sistema Solar");//creacion del contenedor
    	f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
    	f.add(canvas); f.pack(); f.setVisible(true);//añadimos el canvas al contenedor
}

    public static void main(String[] args) {
        new SolarSis();
    }
    
}