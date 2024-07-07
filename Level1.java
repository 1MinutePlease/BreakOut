import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Das erste Level!
 * 
 * Parameter:
 * - 3 Steinreihen
 * - 70% der Steine werden statistisch gesetzt
 * - Horizontale Geschwindigkeit von 5px
 * 
 * @author 1MinutePlease
 */
public class Level1 extends BreakOutPaul
{

    public Level1()
    {
        super("Level 1", 3, 70, 5);
    }
    
    /**
     * Startet das zweite Level bei einem Sieg.
     */
    public void nextLevel() {
        Greenfoot.setWorld(new Level2());
    }
}
