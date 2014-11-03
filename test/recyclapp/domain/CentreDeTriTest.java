package recyclapp.domain;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PM
 */
public class CentreDeTriTest {
    
    private CentreDeTri cdt;
    
    public CentreDeTriTest() {
    }
    
    @Before
    public void setUp()
    {
        cdt = new CentreDeTri(new Dimension(500,700));
        cdt.ajouterEntreeUsine(new Point(60,80), new Dimension(5,5), 1000.0F, Color.red, null);
        cdt.ajouterSortieUsine(new Point(100,150), new Dimension(5,5), 1000.0F, Color.red, null);
    }
    
    @After
    public void tearDown() {
        cdt = null;
    }

    /**
     * Test of getDimensions method, of class CentreDeTri.
     */
    @Test
    public void testGetDimensions() {
        System.out.println("getDimensions");        
        Dimension expResult = new Dimension(500,700);
        Dimension result = cdt.getDimensions();
        assertEquals(expResult, result);
    }

    /**
     * Test of ajouterStation method, of class CentreDeTri.
     */
    @Test
    public void testAjouterStation() {
        System.out.println("ajouterStation");
        Point p = new Point(50,50);
        Dimension d = new Dimension(5,5);
        float capacite = 1000.0F;
        Color c = new Color(1.0F,1.0F,1.0F);
        Image image = null;
        boolean expResult = true;
        boolean result = cdt.ajouterStation(p, d, capacite, c, image);
        assertEquals(expResult, result);
    }

    /**
     * Test of ajouterEntreeUsine method, of class CentreDeTri.
     */
    @Test
    public void testAjouterEntreeUsine() {
        System.out.println("ajouterEntreeUsine");
        Point p = new Point(50,50);
        Dimension d = new Dimension(5,5);
        float capacite = 1000.0F;
        Color c = new Color(1.0F,1.0F,1.0F);
        Image image = null;
        boolean expResult = true;
        boolean result = cdt.ajouterEntreeUsine(p, d, capacite, c, image);
        assertEquals(expResult, result);
    }

    /**
     * Test of ajouterJonction method, of class CentreDeTri.
     */
    @Test
    public void testAjouterJonction() {
        System.out.println("ajouterJonction");
        Point p = new Point(50,50);
        Dimension d = new Dimension(5,5);
        float capacite = 1000.0F;
        Color c = new Color(1.0F,1.0F,1.0F);
        Image image = null;
        boolean expResult = true;
        boolean result = cdt.ajouterJonction(p, d, capacite, c, image);
        assertEquals(expResult, result);
    }

    /**
     * Test of ajouterSortieUsine method, of class CentreDeTri.
     */
    @Test
    public void testAjouterSortieUsine() {
        System.out.println("ajouterSortieUsine");
        Point p = new Point(50,50);
        Dimension d = new Dimension(5,5);
        float capacite = 1000.0F;
        Color c = new Color(1.0F,1.0F,1.0F);
        Image image = null;
        boolean expResult = true;
        boolean result = cdt.ajouterSortieUsine(p, d, capacite, c, image);
        assertEquals(expResult, result);
    }

    /**
     * Test of supprimerEquipement method, of class CentreDeTri.
     */
    @Test
    public void testSupprimerEquipement() {
        System.out.println("supprimerEquipement");
        Equipement equipement = cdt.getListEquipement().get(0);
        boolean expResult = true;
        boolean result = cdt.supprimerEquipement(equipement);
        assertEquals(expResult, result);
        assertEquals(1, cdt.getListEquipement().size());
    }

    /**
     * Test of deplacerEquipement method, of class CentreDeTri.
     */
    @Test
    public void testDeplacerEquipement() {
        System.out.println("deplacerEquipement");
        Equipement equipement = cdt.getListEquipement().get(0);
        Point p = new Point(10,10);
        boolean expResult = true;
        boolean result = cdt.deplacerEquipement(equipement, p);
        assertEquals(expResult, result);
    }

    /**
     * Test of getEquipement method, of class CentreDeTri.
     */
    @Test
    public void testGetEquipement() {
        System.out.println("getEquipement");
        Point point = new Point(60,80);
        Equipement expResult = cdt.getListEquipement().get(0);
        Equipement result = cdt.getEquipement(point);
        assertEquals(expResult, result);
    }

    /**
     * Test of ajouterConvoyeur method, of class CentreDeTri.
     */
    @Test
    public void testAjouterConvoyeur() {
        System.out.println("ajouterConvoyeur");
        Equipement sortie = cdt.getListEquipement().get(0);
        Equipement destination = cdt.getListEquipement().get(1);
        cdt.ajouterConvoyeur(sortie, destination);
    }

    /**
     * Test of nbEquipEnAmont method, of class CentreDeTri.
     */
    @Test
    public void testNbEquipEnAmont() {
        System.out.println("nbEquipEnAmont");
        Equipement e = cdt.getListEquipement().get(0);
        int expResult = 0;
        int result = cdt.nbEquipEnAmont(e);
        assertEquals(expResult, result);
    }
}
