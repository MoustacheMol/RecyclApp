
package recyclapp.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Color;
import java.awt.Image;

public class CentreDeTri implements Serializable
{
    ArrayList<Equipement> m_listEquipement;
    Dimension m_dimensions;
    
    /*
    * Constructeur par défaut
    */
    public CentreDeTri()
    {
        m_listEquipement = new ArrayList<Equipement>();
        m_dimensions = new Dimension();
    }
    
    /*
    * Constructeur avec dimensions
    */
    public CentreDeTri(Dimension d)
    {
        m_listEquipement = new ArrayList<Equipement>();
        m_dimensions = d;
    }
    
    /*
    * Accesseur dimensions
    */
    public Dimension getDimensions()
    {
        return m_dimensions;
    }
    
    /*
    * Accesseur listEquipement
    */
    public ArrayList<Equipement> getListEquipement()
    {
        return m_listEquipement;
    }
    
    public void ajouterStation(Point p, Dimension d, double capacite, Color c, Image image)
    {
        //Station station = new Station(point, dimension, capacite, couleur, image);
        //ajouterEquipement(station);
    }
    
    public void ajouterEntreeUsine(Point p, Dimension d, double capacite, Color c, Image image)
    {
        //EntreeUsine entree = new EntreeUsine(point, dimension, capacite, couleur, image);
    }
    
    public void ajouterJonction(Point p, Dimension d, double capacite, Color c, Image image)
    {
        
    }
    
    public void ajouterSortieUsine(Point p, Dimension d, double capacite, Color c, Image image)
    {
        
    }
    
    public void supprimerEquipement()
    {
        
    }
    
    public void deplacerEquipement()
    {
        
    }
    
    public Equipement getEquipement(Point point)
    {
        return new EntreeUsine();
    }
    
    public boolean validerPosition(Point point, Dimension dimensions)
    {
        return true;
    }
    
    public void ajouterConvoyeur()
    {
        
    }
    
    public void validerUsine()
    {
        
    }
    
    public void mettreAJourLesCalculs()
    {
        
    }
    
    private boolean equipementCouvrePoint(Equipement equipement, Point point)
    {
        
        return true;
    }
    
    /*
    * Méthode pour trouver les entrées de l'usine
    */
    private ArrayList<EntreeUsine> getEntrees()
    {
        ArrayList<EntreeUsine> entrees = new ArrayList<EntreeUsine>();
        ArrayList<Equipement> equipements = getListEquipement();
        
        for(Equipement equipementCourrant : equipements)
        {
            if(equipementCourrant instanceof EntreeUsine)
                entrees.add((EntreeUsine) equipementCourrant);
        }
        
        return entrees;
    }
    
    private void mettreAJourEntree(EntreeUsine entree)
    {
        
    }
    
    /*
    * Méthode générale pour ajouter un équipement à listEquipement
    */
    private void ajouterEquipement(Equipement equipement)
    {
        m_listEquipement.add(equipement);
    }
}
