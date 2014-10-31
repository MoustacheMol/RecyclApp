
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
    public boolean ajouterStation(Point p, Dimension d, float capacite, Color c, Image image)
    {
        if(validerPosition(p, d))
        {
            Station station = new Station(p, d, capacite, c, image);
            ajouterEquipement(station);
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /*
    * méthode pour ajouter une entrée à l'usine
    * précondition: la position et la dimension doit être valide
    */
    public boolean ajouterEntreeUsine(Point p, Dimension d, float capacite, Color c, Image image)
    {
        if(validerPosition(p, d))
        {
            EntreeUsine entree = new EntreeUsine(p, d, capacite, c, image);
            ajouterEquipement(entree);
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /*
    * méthode pour ajouter une jonction
    * précondition: la position et la dimension doit être valide
    */
    public boolean ajouterJonction(Point p, Dimension d, float capacite, Color c, Image image)
    {
        if(validerPosition(p,d))
        {
            Jonction jonction = new Jonction(p, d, capacite, c, image);
            ajouterEquipement(jonction);
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /*
    * méthode pour ajouter une sortie à l'usine
    * précondition: la position et la dimension doit être valide
    */
    public boolean ajouterSortieUsine(Point p, Dimension d, float capacite, Color c, Image image)
    {
        if(validerPosition(p, d))
        {
            SortieUsine sortie = new SortieUsine(p, d, capacite, c, image);
            ajouterEquipement(sortie);
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /*
    * méthode pour retirer un équipement du centre de tri.
    */
    public boolean supprimerEquipement(Equipement equipement)
    {
        // On doit tout d'abord enlever les convoyeurs qui pointe vers l'équipement passé en arg.
        for(Equipement currentEquip : getListEquipement())
        {
            if(currentEquip.EstVoisin(equipement))
            {
                currentEquip.enleverConvoyeur(equipement);
            }
        }
        return getListEquipement().remove(equipement);
    }
    
    public boolean deplacerEquipement(Equipement equipement, Point p)
    {
        // on valide la nouvelle position avec la dimension de l'équipement et le nouveau point.
        if(validerPosition(p, equipement.getDimensions()))
        {
            equipement.ChangerPosition(p);
            return true;
        }
        return false;
    }
    
    /*
    * méthode pour donner l'équipement au point fourni en arg. S'il n'y a pas
    * d'équipement au point donné, la méthode renvoie null.
    */
    public Equipement getEquipement(Point point)
    {
        ArrayList<Equipement> listEquipement = getListEquipement();
        for(int i = 0; i < listEquipement.size(); i++)
        {
            Equipement equipement = listEquipement.get(i);
            if(equipement.getCoordonnees().x == point.x && equipement.getCoordonnees().y == point.y)
                return equipement;
        }
        // Il n'y a pas d'équipement au point donnée
        return null;
    }
    
    /*
    * Renvoie true si une position est libre pour placer un équipement à partir
    * d'un point et d'une dimension donné.
    */
    public boolean validerPosition(Point p, Dimension d)
    {
        // On renvoie false si une des coordonnées est négative
        if(p.x < 0 || p.y < 0)
            return false;
        // On renvoie false si la largeur ou la longueur passé en arg. est plus 
        // grande que la largeur ou la longueur du centre de tri
        if(d.height > getDimensions().height || d.width > getDimensions().width)
            return false;
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
