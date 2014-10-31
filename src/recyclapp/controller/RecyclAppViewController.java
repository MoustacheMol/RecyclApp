package recyclapp.controller;

import java.awt.Color;
import recyclapp.domain.CentreDeTri;
import recyclapp.domain.Equipement;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Pierre-Marc Levasseur <pierre-marc.levasseur.1@ulaval.ca>
 */
public class RecyclAppViewController
{
    CentreDeTri centreDeTri;
    Equipement selectionCourrante;
    
    public enum TypeEquipement
    {
        EntreeUsine,
        SortieUsine,
        Jonction,
        Station
    }
    
    public Dimension getDimensionCentreDeTri()
    {
        return centreDeTri.getDimensions();
    }
    
    public ArrayList<Equipement> getEquipements()
    {
        return centreDeTri.getListEquipement();
    }
    
    public void ajouterConvoyeur()
    {
        
    }
    
    public void ajouterEquipement(TypeEquipement t, Point p, Dimension d)
    {
        switch (t)
        {
            case EntreeUsine:
                centreDeTri.ajouterEntreeUsine(p, d, 100, Color.red, null);
                break;
            case SortieUsine:
                centreDeTri.ajouterSortieUsine(p, d, 100, Color.blue, null);
                break;
            case Jonction: 
                centreDeTri.ajouterJonction(p, d, 100, Color.green, null);
                break;
            case Station:
                centreDeTri.ajouterStation(p, d, 100, Color.orange, null);
        }
    }
    
    public void clickUtilisateur(Point p)
    {
        
    }
}
