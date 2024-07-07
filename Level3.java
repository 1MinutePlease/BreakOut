import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Das dritte Level!
 * 
 * Parameter:
 * - 6 Steinreihen
 * - 20% der Steine werden statistisch gesetzt
 * - Horizontale Geschwindigkeit von 15px
 * 
 * @author 1MinutePlease
 */
public class Level3 extends BreakOutPaul
{

    /**
     * Constructor for objects of class Level3.
     * 
     */
    public Level3()
    {
        super("Level 3", 6, 20, -15);
    }
    
    public void nextLevel() {
        Greenfoot.stop();
    }
}
