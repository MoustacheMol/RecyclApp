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
import java.util.ArrayList;

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
    private ArrayList<Convoyeur> m_voisins;
    
    public Equipement(Point p, Dimension d, float capacite, Color c, Image image)
    {
        m_coordonnees = p;
        m_dimensions = d;
        m_capaciteMax = capacite;
        m_couleur = c;
        m_img = image;
        
        m_utilisation = 0;
        m_marqueur = false;
        m_voisins =  new ArrayList<Convoyeur>();
    }
    
    public void ChangerPosition(Point p)
    {
        m_coordonnees = p;
    }
    
    public void AjouterConvoyeur(Equipement dest)
    {
        Convoyeur c = new Convoyeur(this, dest);
        m_voisins.add(c);
    }
    
    public void enleverConvoyeur(Equipement dest)
    {
        for(Convoyeur c : m_voisins)
        {
            if(c.GetDestination() == dest)
            {
                m_voisins.remove(c);
            }
        }
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
    
    public Point GetCoordonnees()
    {
        return m_coordonnees;
    }
    
    public Dimension GetDimensions()
    {
        return m_dimensions;
    }
    
    public Color GetCouleur()
    {
        return m_couleur;
    }
}
