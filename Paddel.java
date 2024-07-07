import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Das Paddel hilft dem Spieler dabei den Ball vor der unteren Kante abzulenken und damit weiterzuspielen.
 * 
 * @author 1MinutePlease
 */
public class Paddel extends Actor
{
    // Horizontale Geschwindikeit
    private int movement = 5;
    
    /**
     * Bewegt sich entsprechend der Mauszeiger auf der horizontalen Achse
     */
    public void act() 
    {
        if (Greenfoot.isKeyDown("left")) {
            setLocation(getX() - movement, getY());
        }
        
        if (Greenfoot.isKeyDown("right")) {
            setLocation(getX() + movement, getY());
        }
    }    
}
