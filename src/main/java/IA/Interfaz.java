package IA;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;




/**
 *
 * @author Xxx TSC KAF xxX
 */
public class Interfaz extends JFrame {
   
    //Matriz del laberinto
    // 1 = Muro
    // 0 = Vacio
    // 3 = Meta
    int iniciox=4;
    int inicioy=6;
    int finalx=8;
    int finaly=2;
    private int [][] laberinto =
    { 
    
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//1
        {1,0,0,1,1,0,1,1,0,0,0,0,0,0,0,1},//2
        {1,0,0,0,0,0,0,0,3,0,0,0,0,0,0,1},//3   G = "3" 8,2
        {1,0,0,1,1,0,1,1,0,1,1,1,1,1,0,1},//4
        {1,1,1,1,1,0,1,1,0,1,0,0,0,0,0,1},//5
        {1,0,1,1,1,0,1,1,1,1,0,1,1,1,0,1},//6
        {1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1},//7   S = "2" 4,6
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}//8
    };
    
    private final List<Integer> meta =  new ArrayList<Integer>(); 
    private int ruta;
  
    public Interfaz(){
        setTitle ("LABERINTO DFS");
        setSize (640,480);
        setLocationRelativeTo (null);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        
        //lista de DFS
       DFS.bmeta2(laberinto, 4, 6, meta);
       
       ruta = meta.size()-2;
       System.out.println(meta);
       
       
       new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
               actualizar();
               repaint();
           }
   }, 100, 500);    
    }  
    
     public void actualizar() {
        ruta -= 2;
        if (ruta < 0) {
            ruta = 0;
        }
    }

    
    
    //Dibujar el laberinto
      @Override
      public void paint (Graphics g){
          super.paint(g);
          g.translate(75, 75);
          for (int fila=0; fila <laberinto.length; fila++){
              for (int columna=0; columna <laberinto[0].length; columna++){
                  Color color;
                  switch (laberinto[fila][columna]){
                      case 1: color = Color.DARK_GRAY; break;
                      case 2: color = Color.BLUE; break;
                      case 3: color = Color.RED; break;
                      default : color = Color.WHITE;
                  }
              g.setColor(color);
              g.fillRect(30*columna, 30*fila, 30, 30);
              g.setColor(Color.BLACK);
              g.drawRect(30*columna, 30*fila, 30, 30);
          }   
          }
          
          //Lista recorrido pintada
          for (int i=0; i<meta.size(); i+=2){
              int metax = meta.get(i);
              int metay = meta.get(i+1);
              g.setColor(Color.ORANGE);
              g.fillRect(metax*30, metay*30, 30, 30);
          }  
          
        //Pintar inicio 
        g.setColor(Color.CYAN);
        g.fillRect(iniciox * 30, inicioy * 30, 30, 30);
        
        //Pintar final
        g.setColor(Color.GREEN);
        g.fillRect(finalx * 30, finaly * 30, 30, 30);
        
         //Pintar circulo
        int rutax = meta.get(ruta);
        int rutay = meta.get(ruta + 1);
        g.setColor(Color.BLUE);
        g.fillOval(rutax * 30, rutay * 30, 30, 30);
      }
       
      //PRincipal
      public static void main (String [] args){
          SwingUtilities.invokeLater(new Runnable(){
              @Override
              public void run (){
                 Interfaz vista = new Interfaz();
                 vista.setVisible(true);
              }
          });
      }
    
}
