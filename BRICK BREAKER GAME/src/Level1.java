import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;


import javax.swing.*;

public class Level1 extends JPanel implements KeyListener,ActionListener{


Random random=new Random();	
Image space,image;

int rectx=300;
int ballx=random.nextInt(680 - 30) + 30;
int bally=random.nextInt(500 - 370) + 370;
int dirx=-2;
int diry=-4;
int brickwidth=55;
int brickheight=20;
int move=15;
int lives=2; 
int play=1;
 boolean start=false;
Timer timer;

int count=0;
int bricks[]=new int[30];
{
	for(int i=0;i<30;i++) {
		  bricks[i]=0;  
	  }
}

 
 Level1(){
	 	
	
	 
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
  g2.fillOval(ballx,bally, 15, 15);
  g2.setPaint(Color.black);
  g2.drawOval(ballx, bally, 15, 15);
  
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
  g2.drawString(" score-"+count, 520, 33);
  g2.setFont(new Font("MV boli",Font.PLAIN,23));
  g2.drawString(" Space = pause/Resume ", 1, 21);
  g2.drawString(" Esc = Homepage", 1, 48);
 
  
  
  if(bally>580 || count==300) {
	  if(lives==0 || count==300) {
	  dirx=0;
	  diry=0;
	  g2.setFont(new Font("MV boli",Font.BOLD,30));
		g2.drawString("Game over,press enter to restart",90 , 300);
		if(count==300) {
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
		  try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  if(dirx>0)
		dirx=-dirx;
		  if(diry>0)
		diry=-diry;
		  start=false;
		  
		
	  }
	}
	  
 
  
  
 //first row 
  for(int i=0;i<30;i++) {
	 
		  if(i<3) {
		  if(bricks[i]==0) {
		  
		  g2.setStroke(new BasicStroke(2));
	  g2.setColor(Color.white);
  g2.drawRect(15+(brickwidth+13)*i, 70+(brickheight+5), brickwidth,brickheight);
  
   g2.setColor(new Color(0,128,128));
  g2.fillRect(15+(brickwidth+13)*i, 70+(brickheight+5), brickwidth-2,brickheight-3);
		  }
		  }
		  
		  if(i>2 && i<6) {
			  if(bricks[i]==0) {
			  
			  g2.setStroke(new BasicStroke(2));
		  g2.setColor(Color.white);
	  g2.drawRect(15+(brickwidth+13)*(i+4), 70+(brickheight+5), brickwidth,brickheight);
	  
	   g2.setColor(new Color(0,128,128));
	  g2.fillRect(15+(brickwidth+13)*(i+4), 70+(brickheight+5), brickwidth-2,brickheight-3);
			  }
			  }
		  
		  if(i>5 && i<10) {
			  if(bricks[i]==0) {
			  
			  g2.setStroke(new BasicStroke(2));
		  g2.setColor(Color.white);
	  g2.drawRect(15+(brickwidth+13)*(i-3), 70+(brickheight+5)*2, brickwidth,brickheight);
	  
	   g2.setColor(new Color(0,128,128));
	  g2.fillRect(15+(brickwidth+13)*(i-3), 70+(brickheight+5)*2, brickwidth-2,brickheight-3);
			  }
			  }
		  
		  if(i>9 && i<18) {
			  if(bricks[i]==0) {
			  
			  g2.setStroke(new BasicStroke(2));
		  g2.setColor(Color.white);
	  g2.drawRect(15+(brickwidth+13)*(i-9), 70+(brickheight+5)*3, brickwidth,brickheight);
	  
	   g2.setColor(new Color(0,128,128));
	  g2.fillRect(15+(brickwidth+13)*(i-9), 70+(brickheight+5)*3, brickwidth-2,brickheight-3);
			  }
			  }
		  
		  if(i>17 && i<24) {
			  if(bricks[i]==0) {
				  
				  g2.setStroke(new BasicStroke(2));
			  g2.setColor(Color.white);
		  g2.drawRect(15+(brickwidth+13)*(i-16), 70+(brickheight+5)*4, brickwidth,brickheight);
		  
		   g2.setColor(new Color(0,128,128));
		  g2.fillRect(15+(brickwidth+13)*(i-16), 70+(brickheight+5)*4, brickwidth-2,brickheight-3);
				  }
		  }
		  
		  if(i>23 && i<27) {
			  if(bricks[i]==0) {
				  
				  g2.setStroke(new BasicStroke(2));
			  g2.setColor(Color.white);
		  g2.drawRect(15+(brickwidth+13)*(i-24), 70+(brickheight+5)*5, brickwidth,brickheight);
		  
		   g2.setColor(new Color(0,128,128));
		  g2.fillRect(15+(brickwidth+13)*(i-24), 70+(brickheight+5)*5, brickwidth-2,brickheight-3);
				  }
		  }
		  
		  if(i>26 && i<30) {
			  if(bricks[i]==0) {
				  
				  g2.setStroke(new BasicStroke(2));
			  g2.setColor(Color.white);
		  g2.drawRect(15+(brickwidth+13)*(i-20), 70+(brickheight+5)*5, brickwidth,brickheight);
		  
		   g2.setColor(new Color(0,128,128));
		  g2.fillRect(15+(brickwidth+13)*(i-20), 70+(brickheight+5)*5, brickwidth-2,brickheight-3);
				  }
		  }

		  
		  
	  }
	  }
 
 
@Override
 public void actionPerformed(ActionEvent e) {
	
 	timer.start();
	
 	
 	
 	
 	
 	if(new Rectangle(ballx,bally, 15, 15).intersects(rectx, 550, 130, 12)) {
 		if(bally+15>=550 && ballx>=rectx && ballx<=rectx+130) {
			diry=-diry;
		}else {
			dirx=-dirx;
		}
 	
 	}
 	
 	for(int i=0;i<30;i++) {
 		
 			 check(i);	
 		
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
			new Myframe(1);
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

public void check(int i) {
	if(i<3) {
		if(bricks[i]<1) {
			Rectangle brick=new Rectangle(15+(brickwidth+13)*i, 70+(brickheight+5), brickwidth,brickheight);
			Rectangle ball=new Rectangle(ballx,bally, 15, 15);
			
			if(brick.intersects(ball)) {
				bricks[i]++;
				count=count+10;
				if(ballx+15==brick.x ||ballx== brick.x + brick.width) {
					dirx=-dirx;
				}else {
					diry=-diry;
				}
			
				
			}
		
	}
	
	}
	 if(i>2 && i<6) {
		 if(bricks[i]<1) {
				Rectangle brick=new Rectangle(15+(brickwidth+13)*(i+4), 70+(brickheight+5), brickwidth,brickheight);
				Rectangle ball=new Rectangle(ballx,bally, 15, 15);
				
				if(brick.intersects(ball)) {
					bricks[i]++;
					count=count+10;
					if(ballx+15==brick.x ||ballx== brick.x + brick.width){
						dirx=-dirx;
					}else {
						diry=-diry;
					}
				
					
				}
	 }
	 }
	 
	 if(i>5 && i<10) {
		 if(bricks[i]<1) {
				Rectangle brick=new Rectangle(15+(brickwidth+13)*(i-3), 70+(brickheight+5), brickwidth,brickheight);
				Rectangle ball=new Rectangle(ballx,bally, 15, 15);
				
				if(brick.intersects(ball)) {
					bricks[i]++;
					count=count+10;
					if(ballx+15==brick.x ||ballx== brick.x + brick.width) {
						dirx=-dirx;
					}else {
						diry=-diry;
					}
				
					
				}
	 }
	 }
	 
	 if(i>9 && i<18) {
		 
				 if(bricks[i]<1) {
						Rectangle brick=new Rectangle(15+(brickwidth+13)*(i-9), 70+(brickheight+5)*3, brickwidth,brickheight);
						Rectangle ball=new Rectangle(ballx,bally, 15, 15);
						
						if(brick.intersects(ball)) {
							bricks[i]++;
							count=count+10;
							if(ballx+15==brick.x ||ballx== brick.x + brick.width) {
								dirx=-dirx;
							}else {
								diry=-diry;
							}
						
							
						}
			 }
				 }
	 
	  if(i>17 && i<24) {

			 if(bricks[i]<1) {
					Rectangle brick=new Rectangle(15+(brickwidth+13)*(i-16), 70+(brickheight+5)*4, brickwidth,brickheight);
					Rectangle ball=new Rectangle(ballx,bally, 15, 15);
					
					if(brick.intersects(ball)) {
						bricks[i]++;
						count=count+10;
						if(ballx+15==brick.x ||ballx== brick.x + brick.width) {
							dirx=-dirx;
						}else {
							diry=-diry;
						}
					
						
					}
		 }
	  }
	  
	  if(i>23 && i<27) {
		  if(bricks[i]<1) {
				Rectangle brick=new Rectangle(15+(brickwidth+13)*(i-24), 70+(brickheight+5)*5, brickwidth,brickheight);
				Rectangle ball=new Rectangle(ballx,bally, 15, 15);
				
				if(brick.intersects(ball)) {
					bricks[i]++;
					count=count+10;
					if(ballx+15==brick.x ||ballx== brick.x + brick.width) {
						dirx=-dirx;
					}else {
						diry=-diry;
					}
				
					
				}
	 }
	  }
		 
	  if(i>26 && i<30) {
		  if(bricks[i]<1) {
				Rectangle brick=new Rectangle(15+(brickwidth+13)*(i-20), 70+(brickheight+5)*5, brickwidth,brickheight);
				Rectangle ball=new Rectangle(ballx,bally, 15, 15);
				
				if(brick.intersects(ball)) {
					bricks[i]++;
					count=count+10;
					if(ballx+15==brick.x ||ballx== brick.x + brick.width) {
						dirx=-dirx;
					}else {
						diry=-diry;
					}
				
					
				}
	 }
	  }
	
	
}


}



