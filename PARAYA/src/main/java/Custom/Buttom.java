package Custom;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class Buttom extends JButton {

    private Color backgroundHover;
    private Color background;
    private Color actualBackground;

    public void setBackgroundHover(Color background) {
        this.background = background;
    }

    public void setBackgroundExited(Color backgroundHover) {
        this.actualBackground = backgroundHover;
        this.backgroundHover = backgroundHover;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
        repaint();
    }

    private int round = 15;

    public Buttom() {
        actualBackground = getBackground();
        setFont(getFont().deriveFont(Font.BOLD, 15));
        setBorder(new EmptyBorder(10, 12, 15, 12));
        setContentAreaFilled(false);
        setForeground(Color.WHITE);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                setCursor(new Cursor(Cursor.HAND_CURSOR));
                actualBackground = background;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent me) {
                actualBackground = backgroundHover;
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int x = 0;
        int y = 0;
        int width = getWidth();
        int height = getHeight();
        Area area = new Area(new RoundRectangle2D.Double(x, y, width, height, round, round));
        g2.setColor(actualBackground);
        g2.fill(area);
        area.subtract(new Area(new RoundRectangle2D.Double(x, y, width, height - 2, round, round)));
        g2.setColor(actualBackground);
        g2.fill(area);
        g2.dispose();
        super.paintComponent(grphcs);
    }

}
