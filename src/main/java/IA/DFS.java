package IA;

import java.util.List;

/**
 *
 * @author Xxx TSC KAF xxX
 */
public class DFS {
    
    public static boolean bmeta(int [][] laberinto,int x,int y,
            List<Integer> meta){
        
        //verificacion
        if (laberinto[y][x] == 3 ){
            meta.add(x);
            meta.add(y);
            return true;
        }
        
        
        if (laberinto[y][x] == 0 ){
            laberinto[y][x] = 2; 
            
            //visita al vecino -x
            int  dx = -1;
            int  dy = 0;
            if (bmeta(laberinto, x + dx, y + dy,meta)){
                meta.add(x);
                meta.add(y);
                return true;
            }
            
            //visita al vecino x
            dx = 1;
            dy = 0;
            if (bmeta(laberinto,x + dx, y + dy,meta)){
                meta.add(x);
                meta.add(y);
                return true;
            }
            
            //movimeinto en -y
            dx = 0;
            dy = -1;
            if (bmeta(laberinto,x + dx, y + dy,meta)){
                meta.add(x);
                meta.add(y);
                return true;
            }
            
            //visita al vecino +y
            dx = 0;
            dy = 1;
            if (bmeta(laberinto,x + dx, y + dy,meta)){
                meta.add(x);
                meta.add(y);
                return true;
            } 
         }
        return false;
    }  
    
    
     public static boolean bmeta2(int [][] laberinto,int x,int y,
            List<Integer> meta){
        
        //verificacion
        if (laberinto[y][x] == 3 ){
            meta.add(x);
            meta.add(y);
            return true;
        }
        
        
        if (laberinto[y][x] == 0 ){
            laberinto[y][x] = 2; 
            
            //visita al vecino en -x
            int  dx = -1;
            int  dy = 0;
            if (bmeta2(laberinto, x + dx, y + dy,meta)){
                meta.add(x);
                meta.add(y);
                return true;
            }
            
            //visita al vecino en -y
            dx = 0;
            dy = -1;
            if (bmeta2(laberinto,x + dx, y + dy,meta)){
                meta.add(x);
                meta.add(y);
                return true;
            }
            
            //movimeinto en +x
            dx = 1;
            dy = 0;
            if (bmeta2(laberinto,x + dx, y + dy,meta)){
                meta.add(x);
                meta.add(y);
                return true;
            }
            
             //movimeinto en +y
            dx = 0;
            dy = 1;
            if (bmeta2(laberinto,x + dx, y + dy,meta)){
                meta.add(x);
                meta.add(y);
                return true;
            } 
         }
        return false;
    }    
} //Fin class DFS
