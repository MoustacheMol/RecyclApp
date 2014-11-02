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
    private CentreDeTri m_centreDeTri;
    private Equipement m_selectionCourrante;
    
    public enum TypeEquipement
    {
        EntreeUsine,
        SortieUsine,
        Jonction,
        Station
    }
    
    public RecyclAppViewController()
    {
        // TO DO : valider envoie de bon paramètre
        m_centreDeTri = new CentreDeTri(new Dimension(500, 500));
    }
    
    public Dimension getDimensionCentreDeTri()
    {
        return m_centreDeTri.getDimensions();
    }
    
    public ArrayList<Equipement> getEquipements()
    {
        return m_centreDeTri.getListEquipement();
    }
    
    public void ajouterConvoyeur()
    {
        
    }
    
    public void ajouterEquipement(TypeEquipement t, Point p, Dimension d)
    {
        switch (t)
        {
            case EntreeUsine:
                m_centreDeTri.ajouterEntreeUsine(p, d, 100, Color.red, null);
                break;
            case SortieUsine:
                m_centreDeTri.ajouterSortieUsine(p, d, 100, Color.blue, null);
                break;
            case Jonction: 
                m_centreDeTri.ajouterJonction(p, d, 100, Color.green, null);
                break;
            case Station:
                m_centreDeTri.ajouterStation(p, d, 100, Color.orange, null);
        }
    }
    
    public boolean clickUtilisateur(Point p)
    {
        Equipement e = m_centreDeTri.getEquipement(p);        
        m_selectionCourrante = e;
            
        return (e != null);
    }
    
    public Equipement getSelectionCourante()
    {
        return m_selectionCourrante;
    }
}
