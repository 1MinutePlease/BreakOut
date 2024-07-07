import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Das zweite Level!
 * 
 * Parameter:
 * - 5 Steinreihen
 * - 50% der Steine werden statistisch gesetzt
 * - Horizontale Geschwindigkeit von 8px
 * 
 * @author 1MinutePlease
 */
public class Level2 extends BreakOutPaul
{

    public Level2()
    {
        super("Level 2", 5, 50, 8);
    }
    
    /**
     * Startet das dritte Level nach einem Sieg
     */
    public void nextLevel() {
        Greenfoot.setWorld(new Level3());
    }
}
