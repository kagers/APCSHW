import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Converter extends JFrame implements ActionListener{
    private container pane;
    private JButton b;
    public Converter() {
        this.setTitle("Fahrenheit to Celsius");
        this.setSize(400,200);
        this.setLocation(100,100);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());
	b = new JButton("Convert!");
    }
    public void actionPerformed(ActionEvent e){

    }
    public static void main(String[] args) {
        Converter g = new Converter();
        g.setVisible(true);
    }
}

