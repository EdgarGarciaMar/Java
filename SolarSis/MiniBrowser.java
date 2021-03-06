import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.html.*;
import java.beans.*;
public class MiniBrowser extends JPanel implements AccionInt {
    private JTextField locationTextField; 
    private JEditorPane displayEditorPane; 
    private ArrayList pageList = new ArrayList();
    String etiqs[]={"< Back","Forward >","GO"};
    PaletaGral pal; 
    URL currentUrl ;
    public MiniBrowser() {
        setSize(740, 480);     
        pal=new PaletaGral(etiqs, new FlowLayout(), this);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2,1));
        locationTextField = new JTextField(35);
        locationTextField.addKeyListener(new ManejaKeyListener());
        buttonPanel.add(pal);
        buttonPanel.add(locationTextField);   
        displayEditorPane = new JEditorPane(){
    public boolean getScrollableTracksViewportWidth() {
        return true;
    }};
        
        displayEditorPane.setSize(300, 600);
        displayEditorPane.addPropertyChangeListener(
           new ManejaPropertyChangeListener(this) );
        displayEditorPane.setContentType("text/html");
        displayEditorPane.setEditable(false);
        displayEditorPane.addHyperlinkListener(new ManejaHyperlinkListener());      
        setLayout(new BorderLayout());
        add(buttonPanel, BorderLayout.NORTH);
        JScrollPane js = new JScrollPane(displayEditorPane);
        js.setSize(320, 620);
        js.setPreferredSize( new Dimension(320, 620 ));
        add(js , BorderLayout.CENTER);
    }
    public void accion(int n){
	if(n==0) actionBack();
	if(n==1) actionForward();
	if(n==2) actionGo();
    }
    private void actionBack() {
        URL currentUrl = displayEditorPane.getPage();
        int pageIndex = pageList.indexOf(currentUrl.toString());
        try {
            showPage(
                    new URL((String) pageList.get(pageIndex - 1)), false);
        } catch (Exception e) {}
    } 
    private void actionForward() {
        URL currentUrl = displayEditorPane.getPage();
        int pageIndex = pageList.indexOf(currentUrl.toString());
        try {
            showPage(
                    new URL((String) pageList.get(pageIndex + 1)), false);
        } catch (Exception e) {}
    }
    private void actionGo() {
        URL verifiedUrl = verifyUrl(locationTextField.getText());
        System.out.println("actionGo =("
                            +locationTextField.getText()+")");  
        if (verifiedUrl != null) {
            showPage(verifiedUrl, true);
        } else {
            showError("URL no valido");
        }
    } 
    private void showError(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage,
                "Error", JOptionPane.ERROR_MESSAGE);
    } 
    private URL verifyUrl(String url) {
        if (!url.toLowerCase().startsWith("http://") && 
            !url.toLowerCase().startsWith("https://"))
            return null;     
        URL verifiedUrl = null;
        try {
            verifiedUrl = new URL(url);
        } catch (Exception e) { return null; }  
        return verifiedUrl;
    }   
    public void showPage(String page, boolean addToList) {
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));   
        try {
            URL pageUrl=new URL(page);
            currentUrl = displayEditorPane.getPage();
            System.out.println("pageurl "+pageUrl);         
            displayEditorPane.setPage(pageUrl);   
        } catch (Exception e) {
            e.printStackTrace();
            showError("Unable to load page"+e);
        } finally {
            setCursor(Cursor.getDefaultCursor());
        }
    } 
    private void showPage(URL pageUrl, boolean addToList) {
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));   
        try {
            currentUrl = displayEditorPane.getPage();         
            displayEditorPane.setPage(pageUrl);   
        } catch (Exception e) {
            e.printStackTrace();
            showError("Unable to load page"+e);
        } finally {
            setCursor(Cursor.getDefaultCursor());
        }
    } 
   class ManejaKeyListener extends KeyAdapter {
      public void keyReleased(KeyEvent e) {
         if (e.getKeyCode() == KeyEvent.VK_ENTER) { actionGo(); }
      }
   }
   class ManejaPropertyChangeListener implements PropertyChangeListener {
        MiniBrowser mb;
        ManejaPropertyChangeListener(MiniBrowser mb){
		this.mb=mb;
        }
      	public void propertyChange(PropertyChangeEvent e){
	String propertyName=e.getPropertyName();
	   if(propertyName.equalsIgnoreCase("page")){
	      URL newUrl = displayEditorPane.getPage();     
              System.out.println("newURL =("+newUrl+")");    
              if (true) {
                 int listSize = pageList.size();
                 if (listSize > 0) {
                    int pageIndex =
                            pageList.indexOf(currentUrl.toString());
                    if (pageIndex < listSize - 1) {
                        for (int i = listSize - 1; i > pageIndex; i--) {
                            pageList.remove(i);
                        }
                    }
                }
                pageList.add(newUrl.toString());
             }        
             locationTextField.setText(newUrl.toString());
             mb.repaint();
	  } 
       }
   }
   class ManejaHyperlinkListener implements HyperlinkListener {
      public void hyperlinkUpdate(HyperlinkEvent event) {
         if (event.getEventType() == 
            HyperlinkEvent.EventType.ACTIVATED) {
            if (event instanceof HTMLFrameHyperlinkEvent) {
                HTMLFrameHyperlinkEvent linkEvent =
                        (HTMLFrameHyperlinkEvent) event;
                HTMLDocument document =
                        (HTMLDocument) displayEditorPane.getDocument();
                document.processHTMLFrameHyperlinkEvent(linkEvent);
            } else {
                showPage(event.getURL(), true);
            }
         }
      } 
   }
}
