
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
    
    /*
    * méthode pour ajouter une station dans le centre de tri.
    * précondition: la position et la dimension doit être valide
    */
    public void ajouterStation(Point p, Dimension d, float capacite, Color c, Image image)
    {
        if(validerPosition(p, d))
        {
            Station station = new Station(p, d, capacite, c, image);
            ajouterEquipement(station);
        }
        else
        {
            // exception : la position de l'équipement à ajouter n'est pas valide
        }
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
    
    public void deplacerEquipement(Equipement equipement, Point p)
    {
        
    }
    
    public Equipement getEquipement(Point point)
    {
        return new EntreeUsine();
    }
    
    /*
    * Renvoie true si une position est libre pour placer un équipement à partir
    * d'un point et d'une dimension donné.
    */
    public boolean validerPosition(Point p, Dimension d)
    {
        
        for(Equipement equipement : getListEquipement())
        {
            boolean chevauchementHorizontal = false;
            boolean chevauchementVertical = false;
            Point currentCoord = equipement.getCoordonnees();
            Dimension currentDimensions = equipement.getDimensions();
            // Vérification si la position donnée chevauche horizontalement
            // la position de l'équipement courrant
            if( (p.x >= currentCoord.x && p.x <= currentCoord.x + currentDimensions.width) 
                    || (p.x + d.width >= currentCoord.x && p.x + d.width <= currentCoord.x + currentDimensions.width)
                    || (p.x <= currentCoord.x && p.x + d.width >= currentCoord.x + currentDimensions.width))
                chevauchementHorizontal = true;
            // Vérification si la position donnée chevauche verticalement la
            // position de l'équipement courrant
            if( (p.y >= currentCoord.y && p.y <= currentCoord.y + currentDimensions.height)
                    || (p.y + d.height >= currentCoord.y && p.y + d.height <= currentCoord.y + currentDimensions.height)
                    || (p.y <= currentCoord.y && p.y + d.height >= currentCoord.y + currentDimensions.height))
                chevauchementVertical = true;
            // S'il y a chevauchement vertical et horizontal, la position n'est pas valide
            if(chevauchementHorizontal && chevauchementVertical)
                return false;
        }
        // la position donnée ne chevauche aucun équipement
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
