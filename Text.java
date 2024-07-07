import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Eine Textanzeige
 * 
 * @author Paul
 */
public class Text extends Actor
{
    private String text;
    
    /**
     * Konstruieren der Anzeige.
     * 
     * @param text Der Text der Anzeige (zentriert)
     * @param color Die Farbe
     * @param fontSize Die Schriftgröße
     * @param width Die Breite der Anzeige (überständiger Text wird abgeschnitten)
     */
    public Text(String text, Color color, int fontSize, int width) 
    {
        this.text = text;
        
        this.setImage(new GreenfootImage(width, fontSize+10));
        this.getImage().setColor(color);
        this.getImage().setFont(new Font("Verdana", true, false, fontSize));
        
        this.getImage().drawString(text, 0, fontSize);
    }
    
    /**
     * Methode zum verändern des Textes
     * 
     * @param text Der neue Text
     */
    public void setText(String text) {
        this.text = text;
        
        this.getImage().clear();
        this.getImage().drawString(text, 0, 34);
    }
    
    /**
     * Gibt den aktuellen Textwert zurück
     */
    public String getText() {
        return text;
    }
}
