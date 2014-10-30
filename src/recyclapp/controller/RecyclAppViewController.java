package recyclapp.controller;

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
    
    public boolean ajouterEquipement(Point p, Dimension d)
    {
        return true;
    }
    
    public void clickUtilisateur(Point p)
    {
        
    }
}
