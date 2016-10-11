import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

public class Crab extends Actor
{
    /**
     * Act - do whatever the Crab wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       move(4);
       gira();
       come();
    }
    
    public void gira(){
       
       if( Greenfoot.isKeyDown("left")){
        turn(-3);
       } 
       
        if( Greenfoot.isKeyDown("right")){
        turn(3);
        }
       }
    
    void come(){ 
        if(isTouching(Worm.class)){
            Greenfoot.playSound("eating.wav");
            removeTouching(Worm.class);
            World mundo = getWorld(); // hace una referencia al mundo donde vive
            //((CrabWorld)mundo).cangrejoGanador();
            ((CrabWorld)mundo).incrementaGusanos();
            List lista = mundo.getObjects(Worm.class);
            if(lista.size()==0){
                Label etiquetaWinner= new Label("Winner",50);
                mundo.addObject(etiquetaWinner,100,100);
                Greenfoot.stop();
            
            }
            

            
        }
    }
}
 
