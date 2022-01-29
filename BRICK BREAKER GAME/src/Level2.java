import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;


import javax.swing.*;

public class Level2 extends JPanel implements KeyListener,ActionListener{


Random random=new Random();	
Image space,image;

int rectx=300;
double ballx=random.nextInt(680 - 30) + 30;
double bally=random.nextInt(500 - 200) + 200;
double dirx=-2;
double diry=-4;
int brickwidth=55;
int brickheight=20;
int move=20;
int lives=2;
 int play=1;
 boolean start=false;
Timer timer;
int c=0;
int count=0;
int bricks[][] = new int[3][10];
{
	for(int i=0;i<1;i++) {
		  for(int j=0;j<10;j++) {
		  bricks[i][j]=0;
	  }
	  }
	for(int i=1;i<2;i++) {
		  for(int j=0;j<10;j++) {
			  bricks[i][j]=0;
		  }
		  }
	for(int i=2;i<3;i++) {
		  for(int j=0;j<10;j++) {
			  bricks[i][j]=0;
		  }
		  }
	  }

 
 Level2(){
	 	
	
	 
	 image=new ImageIcon("space.png").getImage();
		space= image.getScaledInstance(700, 600,  java.awt.Image.SCALE_SMOOTH);  
	 
	 
	 
	
   this.setPreferredSize(new Dimension(700,600));
  this.setBackground(Color.black);
  
 
  timer=new Timer(12,this);
  timer.start();
  }
 
 public void paint(Graphics g) {

	super.paint(g); 
	
  
  Graphics2D g2 = (Graphics2D) g;
  
  g2.drawImage(space, 0, 0,null);
    
  g2.setPaint(Color.black);
  g2.fillRect(rectx, 550, 130, 12);
    
  g2.setPaint(Color.blue);
  g2.fillOval((int)ballx,(int)bally, 15, 15);
  g2.setPaint(Color.black);
  g2.drawOval((int)ballx, (int)bally, 15, 15);
  
  
  g2.setPaint(new Color(255,50,50));
  g2.fillOval(420, 9, 15, 12);
  g2.fillOval(434, 9, 15, 12);
  int x[]= {421,434,449};
  int y[]= {18,36,18};
  g2.fillPolygon(x, y, 3);
   g2.setFont(new Font("MV Boli",Font.PLAIN,30));
  g2.drawString("- "+lives, 455, 35);
  
  
 g2.setPaint(Color.white);
 g2.setFont(new Font("MV boli",Font.BOLD,30));
  g2.drawString("score-"+count, 520, 33);
  g2.setFont(new Font("MV boli",Font.PLAIN,23));
  g2.drawString(" Space = pause/Resume ", 1, 21);
  g2.drawString(" Esc = Homepage", 1, 48);
 
 
  
  if(bally>580 || count==600) {
	  if(lives==0 || count==600) {
		  dirx=0;
		  diry=0;
		  g2.setFont(new Font("MV boli",Font.BOLD,30));
			g2.drawString("Game over,press enter to restart",90 , 300);
			if(count==600) {
				 g2.setPaint(Color.green);
				g2.drawString( "You Won :)",230, 350);
			}else {
				 g2.setPaint(Color.red);
				g2.drawString( "You Lost :(",230, 350);
			}
		  }else {
			  lives--;
			  ballx=random.nextInt(680 - 30) + 30;
			  bally=random.nextInt(500 - 370) + 370;
			  if(dirx>0)
			dirx=-dirx;
			  if(diry>0)
			diry=-diry;
			  start=false;
		  }
	}
	  
 
  
  
 //first row 
  for(int i=0;i<1;i++) {
	  for(int j=0;j<10;j++) {
		  if(bricks[i][j]==0) {
		  
		  g2.setStroke(new BasicStroke(2));
	  g2.setColor(Color.white);
  g2.drawRect(15+(brickwidth+13)*j, 70+(brickheight+5)*i, brickwidth,brickheight);
  
   g2.setColor(new Color(153,0,0));
  g2.fillRect(15+(brickwidth+13)*j, 70+(brickheight+5)*i, brickwidth-2,brickheight-3);
		  }
		  }
	  }
  for(int i=0;i<1;i++) {
	  for(int j=0;j<10;j++) {
		  if(bricks[i][j]==1) {
		  
		  g2.setStroke(new BasicStroke(2));
	  g2.setColor(Color.white);
  g2.drawRect(15+(brickwidth+13)*j, 70+(brickheight+5)*i, brickwidth,brickheight);
  
   g2.setColor(new Color(255,0,0));
  g2.fillRect(15+(brickwidth+13)*j, 70+(brickheight+5)*i, brickwidth-2,brickheight-3);
		  }
		  }
	  }
  for(int i=0;i<1;i++) {
	  for(int j=0;j<10;j++) {
		  if(bricks[i][j]==2) {
		  
		  g2.setStroke(new BasicStroke(2));
	  g2.setColor(Color.white);
  g2.drawRect(15+(brickwidth+13)*j, 70+(brickheight+5)*i, brickwidth,brickheight);
  
   g2.setColor(new Color(255,204,201));
  g2.fillRect(15+(brickwidth+13)*j, 70+(brickheight+5)*i, brickwidth-2,brickheight-3);
		  }
		  }
	  }
  
  
  //second row
  for(int i=1;i<2;i++) {
	  for(int j=0;j<10;j++) {
		  if(bricks[i][j]==0) {
		  
		  g2.setStroke(new BasicStroke(2));
	  g2.setColor(Color.white);
  g2.drawRect(15+(brickwidth+13)*j, 70+(brickheight+5)*i, brickwidth,brickheight);
  
   g2.setColor(new Color(0,0,204));
  g2.fillRect(15+(brickwidth+13)*j, 70+(brickheight+5)*i, brickwidth-2,brickheight-3);
		  }
		  }
	  }
  for(int i=1;i<2;i++) {
	  for(int j=0;j<10;j++) {
		  if(bricks[i][j]==1) {
		  
		  g2.setStroke(new BasicStroke(2));
	  g2.setColor(Color.white);
  g2.drawRect(15+(brickwidth+13)*j, 70+(brickheight+5)*i, brickwidth,brickheight);
  
   g2.setColor(new Color(51,204,255));
  g2.fillRect(15+(brickwidth+13)*j, 70+(brickheight+5)*i, brickwidth-2,brickheight-3);
		  }
		  }
	  }
  //third row
  for(int i=2;i<3;i++) {
	  for(int j=0;j<10;j++) {
		  if(bricks[i][j]==0) {
		  
		  g2.setStroke(new BasicStroke(2));
	  g2.setColor(Color.white);
  g2.drawRect(15+(brickwidth+13)*j, 70+(brickheight+5)*i, brickwidth,brickheight);
  
   g2.setColor(Color.PINK);
  g2.fillRect(15+(brickwidth+13)*j, 70+(brickheight+5)*i, brickwidth-2,brickheight-3);
		  }
		  }
	  }
  }
  
@Override
 public void actionPerformed(ActionEvent e) {
	
 	timer.start();
	
 	
 	if(new Rectangle((int)ballx,(int)bally, 15, 15).intersects(rectx, 550, 130, 12)) {
 		c++;
 		diry=-diry;
 	
 		if(c%15==0) {
 			if(dirx>0)
 			dirx=dirx+0.3;
 			if(dirx<0)
 			dirx=dirx-0.3;
 			if(diry>0)
 	 		diry=diry+0.3;
 	 		if(diry<0)
 	 		diry=diry-0.3;
 		}
 	
 	}
 	for(int i=0;i<1;i++) {
 		for(int j=0;j<10;j++) {
 			 check1(i,j);	
 		}
 	}
 	for(int i=1;i<2;i++) {
 		for(int j=0;j<10;j++) {
 			 check2(i,j);	
 		}
 	}
 	for(int i=2;i<3;i++) {
 		for(int j=0;j<10;j++) {
 			 check3(i,j);	
 		}
 	}
   
	if(start) {	 	
 	ballx +=dirx;
 	bally +=diry;
 	if(ballx>680) {
 		dirx=-dirx;
 	 	}
 	if(ballx<0) {
 		dirx=-dirx;
 	}
 	if(bally<0) {
 		diry=-diry;
 	}
	}
 	
	
 	  
 	repaint();
 		
 }

@Override
public void keyTyped(KeyEvent e) {}
@Override
public void keyReleased(KeyEvent e) {}

@Override
public void keyPressed(KeyEvent e) {
	if(e.getKeyCode()==KeyEvent.VK_RIGHT ||e.getKeyCode()==KeyEvent.VK_D) {
		start=true;
		if(rectx>560) {
			rectx=570;
		}
		else {
			rectx =rectx+move;
		}
	}
	
	if(e.getKeyCode()==KeyEvent.VK_LEFT ||e.getKeyCode()==KeyEvent.VK_A) {
		start=true;
		if(rectx<10) {
			rectx=0;
		}
		else {
			rectx =rectx-move;
		}
	}
	if(e.getKeyCode()==KeyEvent.VK_ENTER ) {
		
		count=0;
			new Myframe(2);
	}
	if(e.getKeyCode()==KeyEvent.VK_SPACE) {
 		if(play==1) {
 		timer.stop();
 		move=0;
 		
 		play=0;
 		}else {
 			
 			timer.start();
 			move=15;
 			
 			
 	 		play=1;
 		}
 	}
	if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
		play=0;
		timer.stop();
		   Main.main(null);		
		}

	repaint();
	
}

public void check1(int i,int j) {
	
		if(bricks[i][j]<3) {
		Rectangle brick=new Rectangle(15+(brickwidth+13)*j, 70+(brickheight+5)*i, brickwidth,brickheight);
		Rectangle ball=new Rectangle((int)ballx,(int)bally, 15, 15);
		
		if(brick.intersects(ball)) {
			bricks[i][j]++;
			count=count+10;
			if(ballx+14<=brick.x ||ballx+1>= brick.x + brick.width) {
				dirx=-dirx;
			}else {
				diry=-diry;
			}
		
			
		}
	}
	
}
public void check2(int i,int j) {
	
	if(bricks[i][j]<2) {
	Rectangle brick=new Rectangle(15+(brickwidth+13)*j, 70+(brickheight+5)*i, brickwidth,brickheight);
	Rectangle ball=new Rectangle((int)ballx,(int)bally, 15, 15);
	
	if(brick.intersects(ball)) {
		bricks[i][j]++;
		count=count+10;
		if(ballx+14<=brick.x ||ballx+1>= brick.x + brick.width) {
			dirx=-dirx;
		}else {
			diry=-diry;
		}
	
		
	}
}

}
public void check3(int i,int j) {
	
	if(bricks[i][j]<1) {
	Rectangle brick=new Rectangle(15+(brickwidth+13)*j, 70+(brickheight+5)*i, brickwidth,brickheight);
	Rectangle ball=new Rectangle((int)ballx,(int)bally, 15, 15);
	
	if(brick.intersects(ball)) {
		bricks[i][j]++;
		count=count+10;
		if(ballx+14<=brick.x ||ballx+1>= brick.x + brick.width) {
			dirx=-dirx;
		}else {
			diry=-diry;
		}
	
		
	}
}

}
}



