package recyclapp.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.io.Serializable;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
//import recyclapp.domain.drawing.FruitBasketDrawer;

public class DrawingPanel extends JPanel implements Serializable
{
    public Dimension initialDimension;
    private frmRecyclApp mainWindow;

    public DrawingPanel()
    {
    }

    public DrawingPanel(frmRecyclApp mainWindow)
    {
        this.mainWindow = mainWindow;
        setBorder(new javax.swing.border.BevelBorder(BevelBorder.LOWERED));
        int width = (int) (java.awt.Toolkit.getDefaultToolkit().getScreenSize().width);
        setPreferredSize(new Dimension(width, 1));
        setVisible(true);
        int height = (int) (width * 0.5);
        initialDimension = new Dimension(width, height);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
//        if (mainWindow != null)
//        {
//            super.paintComponent(g);
//            FruitBasketDrawer mainDrawer = new FruitBasketDrawer(mainWindow.controller, initialDimension);
//            mainDrawer.draw(g);
//        }
    }

    public frmRecyclApp getMainWindow()
    {
        return mainWindow;
    }

    public void setMainWindow(frmRecyclApp mainWindow)
    {
        this.mainWindow = mainWindow;
    }

    public Dimension getInitialDimension()
    {
        return initialDimension;
    }

    public void setInitialDimension()
    {
    }
}
