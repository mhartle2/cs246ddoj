mport javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.JFrame;

public class MovingGraphic {
   
    public static void main(String[] args) {
        Graphic s = new Graphic();
        JFrame f = new JFrame();
        f.add(s);
        f.setVisible(true);
        f.setSize(600, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Moving Ball");
    }
}

public class Graphic extends JPanel implements ActionListener {
    Timer t = new Timer(5, this);
    double x = 0, y = 0, velX = 2, velY = 2;
    double xx = 100, yy = 100, velXX = 1, velYY = 3;
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Ellipse2D circle = new Ellipse2D.Double(x, y, 40, 40);
        Rectangle2D square = new Rectangle2D.Double(xx, yy, 50, 50);
       
        g2.setColor(Color.BLUE);
        g2.fill(circle);
        
        g2.setColor(Color.RED);
        g2.fill(square);
        t.start();
        
    }
    public void actionPerformed(ActionEvent e) {
        if (x < 0 || x > 560) {
            velX = -velX;
        
        }
        if (xx < 0 || xx > 550) {
            velXX = -velXX;
        
        }
        
        if (y < 0 || y > 340) {
            velY = -velY;
        }
        if (yy < 0 || yy > 340) {
            velYY = -velYY;
        }
        x += velX;
        y += velY;
        
        xx += velXX;
        yy += velYY;
        
        repaint();
    }
    
}
