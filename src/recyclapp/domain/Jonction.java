/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recyclapp.domain;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;

/**
 *
 * @author mblanchet
 */
public class Jonction extends Equipement
{
    public final int MAX_ENTREE = Integer.MAX_VALUE;
    public final int MAX_SORTIE = 1;
    
    public Jonction(Point p, Dimension d, float capacite, Color c, Image image)
    {
        super(p, d, capacite, c, image);
    }
    
    public int getMaxEntree()
    {
        return MAX_ENTREE;
    }
    
    public int getMaxSortie()
    {
        return MAX_SORTIE;
    }
}
