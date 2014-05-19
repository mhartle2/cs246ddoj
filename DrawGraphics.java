import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.JFrame;

public class DrawGraphics {    
    public static void main(String[] args) {
        second s = new second();
        JFrame f = new JFrame();
        f.add(s);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(600, 400);
    }       
}

public class second extends JPanel{
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        Line2D line = new Line2D.Double(100, 30, 400, 70);
        Rectangle2D rectangle = new Rectangle2D.Double(200, 120, 350, 200);
        
        Rectangle2D mouth = new Rectangle2D.Double(240, 270, 270, 20);
        Ellipse2D eye1 = new Ellipse2D.Double(240, 150, 60, 60);
        Ellipse2D eye2 = new Ellipse2D.Double(450, 150, 60, 60);
        Ellipse2D nose = new Ellipse2D.Double(365, 200, 30, 30);
        g2.setPaint(Color.GREEN);
        g2.draw(line);
        g2.setPaint(Color.RED);
        g2.fill(rectangle);
        
        g2.setPaint(Color.ORANGE);
        g2.fill(eye1);
        g2.setPaint(Color.BLACK);
        g2.draw(eye1);
        g2.setPaint(Color.ORANGE);
        g2.fill(eye2);
        g2.setPaint(Color.BLACK);
        g2.draw(eye2);
        
        g2.setPaint(Color.ORANGE);
        g2.fill(nose);
        g2.setPaint(Color.BLACK);
        g2.draw(nose);
        
        g2.setPaint(Color.ORANGE);
        g2.fill(mouth);
        g2.setPaint(Color.BLACK);
        g2.draw(mouth);
        
    
    }
    
}
