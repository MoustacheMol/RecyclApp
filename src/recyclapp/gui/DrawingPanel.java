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
            for (Equipement e : equipLst)
                DrawEquipement(e.GetCouleur(), e.GetCoordonnees(), e.GetDimensions(), g);
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
}
