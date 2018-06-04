package test.jlabel;
import javax.swing.*;
import static java.awt.GraphicsDevice.*;
/**
 *
 * @author femio23
 */
public class Venta {
    JFrame marco;
    JPanel p1,p2;
    JButton b,b1,b2;
    JLabel l1;
    public Venta (){
    p1=new JPanel();
    p2=new JPanel();
    b=new JButton("1");
    b1=new JButton("2");
    b2=new JButton("3");
    b.setBounds(200,200,60,60);
    b1.setBounds(300,200,60,60);
    b2.setBounds(400,200,60,60);
    
    
    l1=new JLabel("hola");
    l1.setIcon(new ImageIcon("submarino.jpg"));
    l1.setBounds(0,0, 705,375);
    marco=new JFrame();
    marco.setLayout(null);
    marco.add(b);
    marco.add(b1);
    marco.add(b2);
    marco.add(l1);
    
    
    marco.setSize(800,600);
    marco.setVisible(true);
    marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
