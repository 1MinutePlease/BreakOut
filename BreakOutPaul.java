import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Die abstrakte Klasse für die Level.
 * Enthält die allgemeine Logik für die Level, die mithilfe des Konstruktors (Parameter) verändert werden kann.
 * 
 * Verlangt bei der Vererbung die Implementierung der `nextLevel()`-Methode.
 * 
 * @author 1MinutePlease
 */
public abstract class BreakOutPaul extends World
{
    private Text points;
    private int velocity;
    
    /**
     * Konstruiert die Welt nach den gegebenen Parametern des Levels.
     * 
     * @param name Name des Levels
     * @param verticalAmount Die Anzahl an Reihen Steinen
     * @param probability Die Wahrscheinlichkeit, dass ein Stein gesetzt wird
     * @param velocity Die horizontale Geschwindigkeit
     */
    public BreakOutPaul(String name, int verticalAmount, int probability, int velocity)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(640, 480, 1);
        
        // Geschwindigkeitsfaktor
        this.velocity = velocity;
        
        // Levelanzeige
        addObject(new Text(name, Color.BLUE, 34, 150), 80, 460);
        
        // Punktanzeige
        points = new Text("0", Color.RED, 34, 50);
        addObject(points, 620, 460);
        
        // Paddel
        addObject(new Paddel(), 310, 400);
        
        // Bricks
        for (int y = 8; y < 15*verticalAmount+8; y+=15) {
            for (int i = 16; i <= 32*19+16; i+=32) {
                if (Greenfoot.getRandomNumber(99) < probability) {
                    addObject(new Brick(), i, y);
                }
            }
        }
    }
    
    /**
     * Die immer wieder ausgeführte Methode.
     * 
     * Wenn noch kein Ball erstellt wurde und die Leertaste gedrückt wird, wird ein neuer Ball erstellt.
     */
    public void act() {
        if (Greenfoot.isKeyDown("space") &&
                getObjects(Ball.class).size() == 0) {
            addObject(new Ball(velocity), 320, 300);
        }
    }
    
    /**
     * Wenn ein Stein entfernt wird, wird...
     * 
     * ...der Punktestand geändert und
     * ...falls keine Steine mehr vorhanden sind, ein neues Level nach einer Gewinnanzeige gestartet.
     */
    public void onBrickBreak() {
        points.setText(String.valueOf(Integer.parseInt(points.getText()) + 1));
        
        if (getObjects(Brick.class).size() == 0) {
            removeObject(getObjects(Ball.class).get(0));
            
            Text successMsg = new Text("You won!", Color.GREEN, 56, 320);
            addObject(successMsg, 340, 240);
            Greenfoot.delay(5);
            nextLevel();
        }
    }
    
    /**
     * Wenn der Ball an der unteren Kante der Welt herausfliegt, wird eine Verliereranzeige gezeigt und das Spiel gestoppt.
     */
    public void onBallDeath() {
        addObject(new Text("You lost!", Color.RED, 56, 320), 340, 240);
        Greenfoot.stop();
    }
    
    
    /**
     * Die abstrakte Methode, die von den Level-Klassen implementiert werden muss.
     * 
     * Wird beim Gewinn ausgeführt.
     */
    abstract void nextLevel();
}
