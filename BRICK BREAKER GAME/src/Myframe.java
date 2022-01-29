 import javax.swing.*;
public class Myframe extends JFrame{
	
	Level1 l1;
	Level2 l2;
	Level3 l3;
	
	Myframe(int c){
		if(c==1) {
			
			l1=new Level1();
			this.setTitle("BRICK BREAKER");
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.add(l1);
			this.pack();
			this.setLocationRelativeTo(null);
		    this.setVisible(true);
		    this.setResizable(false);
		    this.addKeyListener(l1);	
		    
			
		}else if(c==2) {
			
			l2=new Level2();
			this.setTitle("BRICK BREAKER");
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.add(l2);
			this.pack();
			this.setLocationRelativeTo(null);
		    this.setVisible(true);
		    this.setResizable(false);
		    this.addKeyListener(l2);	
		    
		}else if(c==3) {
			l3=new Level3();
			this.setTitle("BRICK BREAKER");
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.add(l3);
			this.pack();
			this.setLocationRelativeTo(null);
		    this.setVisible(true);
		    this.setResizable(false);
		    this.addKeyListener(l3);	
			
		}else if(c==4) {
			this.removeAll();
		}
		
		
		
	}
	
	
}
