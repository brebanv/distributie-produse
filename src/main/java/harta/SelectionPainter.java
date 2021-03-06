
package harta;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import org.jxmapviewer.painter.Painter;

public class SelectionPainter implements Painter<Object>
{
    private final Color fillColor = new Color(128, 192, 255, 128);
    private final Color frameColor = new Color(0, 0, 255, 128);

    private final SelectionAdapter adapter;

    public SelectionPainter(SelectionAdapter adapter)
    {
        this.adapter = adapter;
    }

    @Override
    public void paint(Graphics2D g, Object t, int width, int height)
    {
        Rectangle rc = adapter.getRectangle();

        if (rc != null)
        {
            g.setColor(frameColor);
            g.draw(rc);
            g.setColor(fillColor);
            g.fill(rc);
        }
    }
}