import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Converter extends JFrame implements ActionListener{
    private Container pane,io,but;
    private JButton b;
    private JRadioButton c,f;
    private JTextField text;
    private JLabel info,output;

    public Converter() {
        this.setTitle("Temperature Converter");
        this.setSize(500,200);
        this.setLocation(100,100);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());

	b = new JButton("Convert!");
	b.setActionCommand("convert");
	b.addActionListener(this);
	
	text = new JTextField(10);
	output = new JLabel("<html>Input a number into the text field <br> Feel the  mathgic happen</html>",JLabel.CENTER);

	c = new JRadioButton("to Celsius",true);
	f = new JRadioButton("to Fahrenheit");
	
	ButtonGroup unit = new ButtonGroup();
	unit.add(c);
	unit.add(f);

	io = new Container();
	io.setLayout(new FlowLayout());
	io.add(text);
	io.add(output);

	but = new Container();
	but.setLayout(new FlowLayout());
	but.add(c);
	but.add(f);
	but.add(b);

	pane.add(io);
	pane.add(but);

    }
    public void actionPerformed(ActionEvent e){
	String action = e.getActionCommand();
	if (action.equals("convert")){
	    try {
		double s = Double.parseDouble(text.getText());
		if (c.isSelected()){
		    output.setText(((5/9.0)*(s-32))+" \u00b0C");
		}
		else{
		    output.setText((((9/5.0)*s)+32)+" \u00b0F");
		}
	    }
	    catch (Exception f){
		output.setText("Sure about that?");
	    }
	}
    }
    public static void main(String[] args) {
        Converter g = new Converter();
        g.setVisible(true);
    }
}

