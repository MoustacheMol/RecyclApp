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
import java.util.List;

/**
 *
 * @author mblanchet
 */
public class Equipement
{
    private Point m_coordonnees;
    private float m_capaciteMax;
    private float m_utilisation;
    private Dimension m_dimensions;
    private Color m_couleur;
    private boolean m_marqueur;
    private Image m_img;
    private List<Convoyeur> m_voisins;    
    
    public void ChangerPosition(Point p)
    {
        m_coordonnees = p;
    }
    
    public void AjouterConvoyeur(Equipement dest)
    {
        Convoyeur c = new Convoyeur(this, dest);
        m_voisins.add(c);
    }
    
    public boolean EstVoisin(Equipement e)
    {
        for (Convoyeur c : m_voisins)
        {
            if (c.GetDestination() == e)
                return true;
        }
        
        return false;
    }
    
    public void ChangeDestinationConvoyeur(Equipement old, Equipement nouv)
    {
        for(Convoyeur c : m_voisins)
        {
            if (c.GetDestination() == old)
                c.ChangeDestination(nouv);
        }
    }
    
    public int GetNbSorties()
    {
        return m_voisins.size();
    }
    
    public void ResetMarqueur()
    {
        m_marqueur = false;
    }
    
    public void MarquerMarqueur()
    {
        m_marqueur = true;
    }
}
