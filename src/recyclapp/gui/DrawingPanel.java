package recyclapp.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JPanel;
import recyclapp.controller.RecyclAppViewController;
import recyclapp.domain.Equipement;

public class DrawingPanel extends JPanel
{
    RecyclAppViewController m_controller;
    
    public DrawingPanel()
    {
        m_controller = null;
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        if (m_controller != null)
        {
            super.paintComponent(g);
            ArrayList<Equipement> equipLst = m_controller.getEquipements();
            
            // dessine tous les équipements
            for (Equipement e : equipLst)
            {
                DrawEquipement(e.GetCouleur(), e.GetCoordonnees(), e.GetDimensions(), g);
                if (e == m_controller.getSelectionCourante())
                    SelectEquipement(e.GetCoordonnees(), e.GetDimensions(), g);
            }
            if(m_controller.getDrawGridEnable())
            {
                Dimension lesDimensions =  m_controller.getDimensionCentreDeTri();
            
                this.drawGrid(lesDimensions, g);
            }
        }
    }
    
    public void SetController(RecyclAppViewController c)
    {
        m_controller = c;
    }
    
    private void DrawEquipement(Color c, Point p, Dimension d, Graphics g)
    {
        g.setColor(c);
        g.fillRect(p.x, p.y, d.width, d.height);
    }
    
    private void SelectEquipement(Point p, Dimension d, Graphics g)
    {
        g.setColor(Color.black);
        Point tlc = new Point(p.x - 2, p.y - 2);
        Dimension selectionDim = new Dimension(d.width + 3, d.height + 3);
        g.drawRect(tlc.x, tlc.y, selectionDim.width, selectionDim.height);
    }
    
    private void drawGrid(Dimension d, Graphics g)
    {
        g.setColor(Color.black);
        int scale = m_controller.getScale(); //Défaut 10
        int i = 0;
        int j = 0;
        while((i <= d.width && j <= d.height) && scale > 0)
        {
            while(j <= d.height)
            {
                 g.drawRect(i , j, 40,40);
                 j += scale;
            }
           j = 0;
           i += scale;
        }
    }
}
