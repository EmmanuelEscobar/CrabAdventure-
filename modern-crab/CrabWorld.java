import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class CrabWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CrabWorld extends World
{
    //Constante 
    public final int TIEMPO_NIVEL=30;
    //si no es estatica se duplica es para todo el mundo
    private Counter contGusanos;
    private Counter contVidas; 
    private Counter contObjetoGusano;
    private Crab cangrejo;
    private Lobster langosta;
    private Worm gusano;
   
    private Counter contTiempo;
    private SimpleTimer reloj;
    
    
    /**
     * Constructor for objects of class CrabWorld.
     * 
     */
    public CrabWorld()
    {    
        super(560, 560, 1);
        contGusanos = new Counter ("Gusanos: ");
        contVidas = new Counter ("Vidas: ");
        contObjetoGusano = new Counter ("Objeto gusano: ");
        contTiempo = new Counter("Tiempo:");
        
        contTiempo.setValue(TIEMPO_NIVEL);
        reloj = new SimpleTimer();
        
        addObject(contTiempo,50,110);
        addObject(contObjetoGusano,70,80);
        addObject(contGusanos,50,20);
        addObject(contVidas,40,50);
        prepare();
        
    }
    
    public void started()
    {
        reloj.mark();
        System.out.println("Boton pausa");        
    }
    
    public void stopped()
    {
        reloj.mark();
        System.out.println("Boton detener");
    }

    public void incrementaGusanos()
    {
        contGusanos.add(1);
        Greenfoot.playSound("eating.wav");
    }
    
    public void drecrementaVidas(){
        contVidas.add(-1);
    }
    
    public void reiniciaPosicionCangrejo(){
        cangrejo.setLocation(300,300);
    }
    
    public void tiempo(){
        if(reloj.millisElapsed() > 1000){
        contTiempo.add(-1);
        reloj.mark();
        }
        
    }
    public void timeUp(){
       if(contTiempo.getValue()==0){
        Label etiquetaTimeUp = new Label("Time Over",50);
        addObject(etiquetaTimeUp,150,150);
        Greenfoot.stop();
       }
    }
    
    public void moreGusanos(){
        int x=Greenfoot.getRandomNumber(200);;
        int y=Greenfoot.getRandomNumber(150);;
        if(contTiempo.getValue()% 2 == 0){
        Worm wormAl1 = new Worm();
        addObject(wormAl1,312,359);
        System.out.println("Mod de 3");
        
        }
    }

   public void act()
    {
        tiempo();
        timeUp();
        moreGusanos();
    }
    
    public void cangrejoGanador(){
        if (contGusanos.getValue()==20){
            Label etiquetaWin = new Label("WINNER", 50);
            addObject(etiquetaWin,150,150);
            Greenfoot.stop();
            
        }
    }
    
    public void cangrejoAtrapado(){
        langosta.setLocation(50,50);
        cangrejo.setLocation(100,100);
        if (contVidas.getValue()==0){
        Label etiquetaFin = new Label("GAME OVER", 50);
        addObject(etiquetaFin,150,150);
        Greenfoot.stop();
        }
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        //Tiene sus desventajas por que hace que las variables sean locales
        //a veces es mejor sacar las variables

        //        contGusanos.add(1);
        //gusanos=getObjetcs(Worm.class);


        cangrejo = new Crab();
        langosta = new Lobster();
        addObject(cangrejo,404,184);
        Worm worm = new Worm();
        addObject(worm,312,359);

        Worm worm2 = new Worm();
        //gusanos.add(worm2);
        addObject(worm2,141,226);

        Worm worm3 = new Worm();

        addObject(worm3,281,277);

        Worm worm4 = new Worm();
        addObject(worm4,400,305);
        //gusanos.add(worm4);

        Worm worm5 = new Worm();
        addObject(worm5,198,422);
        //gusanos.add(worm5);

        Worm worm6 = new Worm();
        addObject(worm6,231,217);
        //gusanos.add(worm6);

        Worm worm7 = new Worm();
        addObject(worm7,422,470);
        //gusanos.add(worm7);

        Worm worm8 = new Worm();
        addObject(worm8,212,127);
        //gusanos.add(worm8);

        Worm worm9 = new Worm();
        addObject(worm9,80,257);
        //gusanos.add(worm9);

        Worm worm10 = new Worm();
        addObject(worm10,92,343);
        //gusanos.add(worm10);

        Worm worm11 = new Worm();
        addObject(worm11,129,497);
        //gusanos.add(worm11);

        Worm worm12 = new Worm();
        addObject(worm12,537,353);
        //gusanos.add(worm12);

        Worm worm13 = new Worm();
        addObject(worm13,489,136);
        //gusanos.add(worm13);

        Worm worm14 = new Worm();
        addObject(worm14,226,86);
        //gusanos.add(worm14);

        Worm worm15 = new Worm();
        addObject(worm15,84,125);
        //gusanos.add(worm15);

        Worm worm16 = new Worm();
        addObject(worm16,61,311);
        //gusanos.add(worm16);

        Worm worm17 = new Worm();
        addObject(worm17,216,311);
        //gusanos.add(worm17);

        Worm worm18 = new Worm();
        addObject(worm18,32,515);
        //gusanos.add(worm18);

        Worm worm19 = new Worm();
        addObject(worm19,38,434);
        //gusanos.add(worm19);

        Lobster lobster = new Lobster();
        addObject(lobster,380,75);

        //cont = getObjects(Worm.class).size();
        
        
        contVidas.setValue(1);

        worm15.setLocation(87,162);
    }
}
