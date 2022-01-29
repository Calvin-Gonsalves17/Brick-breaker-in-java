import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Main {
	static JFrame frame=new JFrame();
	static JPanel panel=new JPanel();
	
	
	public static void main(String[] args) {
		//Welcome To Brick Breaker
	JLabel label =new JLabel("<html> <pre>\r\n"
			+ " Welcome To Brick Breaker\r\n"
			+ " \r\n"
			+ " \r\n"
			+ "        Select Level</html>");
	label.setForeground(Color.white);
	label.setBounds(0, 0, 500, 150);
	label.setFont(new Font("MV boli",Font.BOLD,30));
	
	JButton b1=new JButton("Easy");
	b1.setFocusable(false);
	b1.setBackground(new Color(50,3,6));
	b1.setForeground(Color.white);
	b1.setBounds(190, 160, 90,30);
	b1.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
			new Myframe(1);
			
		}
		
	});
	
	JButton b2=new JButton("Medium");
	b2.setFocusable(false);
	b2.setBackground(new Color(50,3,6));
	b2.setForeground(Color.white);
	b2.setBounds(190, 200, 90,30);
	b2.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
			new Myframe(2);
			
		}
		
	});
	
	JButton b3=new JButton("Hard");
	b3.setFocusable(false);
	b3.setBackground(new Color(50,3,6));
	b3.setForeground(Color.white);
	b3.setBounds(190, 240, 90,30);
	b3.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
			new Myframe(3);
			
		}
		
	});
	
	JLabel piclabel = new JLabel(new ImageIcon("bricks.png"));
	piclabel.setBounds(-20, 20, 500, 380);
	
	
	panel.add(b1);
	panel.add(b2);
	panel.add(b3);
	panel.add(label);
	panel.add(piclabel);
    panel.setLayout(null);
	panel.setBackground(new Color(50,50,30));
	
	
	
	frame.add(panel);
	frame.setTitle("BRICK BREAKER");
	frame.setSize(500,400);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    frame.setResizable(false);
   
		
	
	}
	
	
}
