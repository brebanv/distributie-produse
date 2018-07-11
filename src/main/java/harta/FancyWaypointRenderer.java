package harta;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.viewer.WaypointRenderer;

public class FancyWaypointRenderer implements WaypointRenderer<MyWaypoint> {

    private static final Log log = LogFactory.getLog(FancyWaypointRenderer.class);

    private final Map<Color, BufferedImage> map = new HashMap<Color, BufferedImage>();

    private BufferedImage origImage;

    public FancyWaypointRenderer() throws FileNotFoundException, IOException {
        String resource = "waypoint_white.png";

        origImage = ImageIO.read(new FileInputStream(resource));

    }

    private BufferedImage convert(BufferedImage loadImg, Color newColor) {
        int w = loadImg.getWidth();
        int h = loadImg.getHeight();
        BufferedImage imgOut = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        BufferedImage imgColor = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g = imgColor.createGraphics();
        g.setColor(newColor);
        g.fillRect(0, 0, w + 1, h + 1);
        g.dispose();

        Graphics2D graphics = imgOut.createGraphics();
        graphics.drawImage(loadImg, 0, 0, null);
        graphics.setComposite(MultiplyComposite.Default);
        graphics.drawImage(imgColor, 0, 0, null);
        graphics.dispose();

        return imgOut;
    }

    @Override
    public void paintWaypoint(Graphics2D g, JXMapViewer viewer, MyWaypoint w) {
        g = (Graphics2D) g.create();

        if (origImage == null) {
            return;
        }

        BufferedImage myImg = map.get(w.getColor());

        if (myImg == null) {
            myImg = convert(origImage, w.getColor());
            map.put(w.getColor(), myImg);
        }

        Point2D point = viewer.getTileFactory().geoToPixel(w.getPosition(), viewer.getZoom());

        int x = (int) point.getX();
        int y = (int) point.getY();

        g.drawImage(myImg, x - myImg.getWidth() / 2, y - myImg.getHeight(), null);

        String label = w.getLabel();

        FontMetrics metrics = g.getFontMetrics();
        int tw = metrics.stringWidth(label);
        int th = 1 + metrics.getAscent();

        g.drawString(label, x - tw / 2, y + th - myImg.getHeight());

        g.dispose();
    }
}
