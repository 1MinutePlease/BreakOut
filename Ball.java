import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Der Ball, mit dem die Steine zerstört werden und der vom Paddel abgelenkt wird, und somit im Spiel gehalten wird.
 * 
 * @author 1MinutePlease
 */
public class Ball extends Actor
{
    private int dx;
    private int dy;
    
    /**
     * Der Konstruktor des Balls
     * 
     * Setzt die Geschwindigkeiten
     * 
     * @param velocity Die horizontale Geschwindigkeit
     */
    public Ball(int velocity) {
        dx = velocity;
        
        // Setzt die vertikale Geschwindikeit auf einen Wert zwischen -1 und -5
        // Negative Werte, da der Nullpunkt oben links der Welt ist
        dy = -1 * Greenfoot.getRandomNumber(5);
        if (dy == 0) dy = -3;
    }
    
    /**
     * Bewegt sich mit den gesetzten Geschwindikeiten.
     * 
     * Schaut nach Kontakt mit Stein oder Paddel, in dem Fall er umgelenkt wird.
     * Außerdem wird geschaut, ob es Wandkontakt gibt: Ball wird abgelenkt außer an der Unterkante der Welt
     */
    public void act() 
    {
        setLocation(getX() + dx, getY() + dy);
        
        checkBrickContact();
        checkPaddelContact();
        checkBoundaries();
    }
    
    /**
     * Prüft auf Wandkontakt:
     * 
     * oben: abgelenkt
     * seitlich: abgelenkt
     * unten: Ende des Spiels
     */
    private void checkBoundaries() {
        if (getX() >= 626 || getX() <= 14) { // rechts || links
            dx = -dx;
        }
        
        if (getY() <= 14) { // oben
            dy = -dy;
        }
        
        if (getY() >= 478) { // unten
            ((BreakOutPaul) getWorld()).onBallDeath();
            getWorld().removeObject(this);
        }
    }
    
    /**
     * Bei Kontakt zu einem Stein wird der Stein entfernt und der Ball abgelenkt
     */
    private void checkBrickContact() {
        Actor brick = getOneIntersectingObject(Brick.class);
        if (brick != null) {
            dy = -dy;
            getWorld().removeObject(brick);
            ((BreakOutPaul) getWorld()).onBrickBreak();
        }
    }
    
    /**
     * Bei Kontakt mit dem Paddel wird der Ball abgelenkt
     */
    private void checkPaddelContact() {
        Actor paddel = getOneIntersectingObject(Paddel.class);
        if (paddel != null) {
            dy = -dy;
        }
    }
}
