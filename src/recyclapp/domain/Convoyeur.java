/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recyclapp.domain;

import java.awt.Color;

/**
 *
 * @author mblanchet
 */
public class Convoyeur
{
    private Equipement m_origine;
    private Equipement m_destination;
    private float m_capacite;
    private Color m_couleur;
    
    public Convoyeur(Equipement origine, Equipement dest)
    {
        m_origine = origine;
        m_destination = dest;
    }
    
    public void ChangeOrigine(Equipement e)
    {
        m_origine = e;
    }
    
    public void ChangeDestination(Equipement e)
    {
        m_destination = e;
    }
    
    public void SetCouleur(Color c)
    {
        m_couleur = c;
    }
    
    public void SetCapacite(float c)
    {
        m_capacite = c;
    }
    
    public Equipement GetDestination()
    {
        return m_destination;
    }
}
