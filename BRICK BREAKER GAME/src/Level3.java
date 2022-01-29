import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;


import javax.swing.*;

public class Level3 extends JPanel implements KeyListener,ActionListener{


Random random=new Random();	
Image space,image;

int rectx=300;
double ballx=random.nextInt(600 - 100) + 100;
double bally=random.nextInt(500 - 370) + 370;
double dirx=-2;
double diry=-4;
int brickwidth=55;
int brickheight=20;
int move=25;
int c=0;
int lives=2;
 int play=1;
 boolean start=false;
Timer timer;

int count=0;
int bricks[]=new int[35];
{
	for(int i=0;i<35;i++) {
		  bricks[i]=0;  
	  }
}

 
 Level3(){
	 	
	
	 
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
 
 
  
  if(bally>580 || count==700) {
	  if(lives==0 || count==700) {
		  dirx=0;
		  diry=0;
		  g2.setFont(new Font("MV boli",Font.BOLD,30));
			g2.drawString("Game over,press enter to restart",90 , 400);
			if(count==700) {
				 g2.setPaint(Color.green);
				g2.drawString( "You Won :)",230, 450);
			}else {
				 g2.setPaint(Color.red);
				g2.drawString( "You Lost :(",230, 450);
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
	  
 
  
  
 
  for(int i=0;i<30;i++) {
	 
		  if(i<4) {
		  if(bricks[i]<3) {
		  
		  g2.setStroke(new BasicStroke(2));
	  g2.setColor(Color.white);
  g2.drawRect(15+(brickwidth+13)*(i+3), 70+(0), brickwidth,brickheight);
  
  if(bricks[i]==0) {
   g2.setColor(new Color(153,0,0));
  }else if(bricks[i]==1) {
	  g2.setColor(new Color(255,0,0));
  }else {
	  g2.setColor(new Color(255,204,201));
  }
  g2.fillRect(15+(brickwidth+13)*(i+3), 70+(0), brickwidth-2,brickheight-3);
		  }
		  }
		  
		  if(i>3 && i<6) {
			  if(bricks[i]<3) {
			  
			  g2.setStroke(new BasicStroke(2));
		  g2.setColor(Color.white);
	  g2.drawRect(15+(brickwidth+13)*(i+3), 70+(brickheight+5)*(i-3), brickwidth,brickheight);
	  
	  if(bricks[i]==0) {
		   g2.setColor(new Color(153,0,0));
		  }else if(bricks[i]==1) {
			  g2.setColor(new Color(255,0,0));
		  }else {
			  g2.setColor(new Color(255,204,201));
		  }
	  g2.fillRect(15+(brickwidth+13)*(i+3), 70+(brickheight+5)*(i-3), brickwidth-2,brickheight-3);
			  }
			  }
		  
		  
		  
		  if(i>5 && i<9) {
			  if(bricks[i]<3) {
			  
			  g2.setStroke(new BasicStroke(2));
		  g2.setColor(Color.white);
	  g2.drawRect(15+(brickwidth+13)*(i), 70+(brickheight+5)*(12-i), brickwidth,brickheight);
	  
	  if(bricks[i]==0) {
		   g2.setColor(new Color(153,0,0));
		  }else if(bricks[i]==1) {
			  g2.setColor(new Color(255,0,0));
		  }else {
			  g2.setColor(new Color(255,204,201));
		  }
	  g2.fillRect(15+(brickwidth+13)*(i), 70+(brickheight+5)*(12-i), brickwidth-2,brickheight-3);
			  }
			  }
		  
		  g2.setStroke(new BasicStroke(4));
		  g2.setColor(Color.white);
		  g2.drawRect(15+(brickwidth+13)*(9), 70+(brickheight+5)*(3), brickwidth,brickheight);
	  
		  
	  
		  if(i>8 && i<12) {
			  if(bricks[i]<3) {
			  
			  g2.setStroke(new BasicStroke(2));
		  g2.setColor(Color.white);
	  g2.drawRect(15+(brickwidth+13)*(i-6), 70+(brickheight+5)*6, brickwidth,brickheight);
	  
	  if(bricks[i]==0) {
		   g2.setColor(new Color(153,0,0));
		  }else if(bricks[i]==1) {
			  g2.setColor(new Color(255,0,0));
		  }else {
			  g2.setColor(new Color(255,204,201));
		  }
	  g2.fillRect(15+(brickwidth+13)*(i-6), 70+(brickheight+5)*6, brickwidth-2,brickheight-3);
			  }
			  }
		  		  
		  if(i>11 && i<14) {
			  if(bricks[i]<3) {
				  
				  g2.setStroke(new BasicStroke(2));
			  g2.setColor(Color.white);
		  g2.drawRect(15+(brickwidth+13)*(i-11), 70+(brickheight+5)*(i-8), brickwidth,brickheight);
		  
		  if(bricks[i]==0) {
			   g2.setColor(new Color(153,0,0));
			  }else if(bricks[i]==1) {
				  g2.setColor(new Color(255,0,0));
			  }else {
				  g2.setColor(new Color(255,204,201));
			  }
		  g2.fillRect(15+(brickwidth+13)*(i-11), 70+(brickheight+5)*(i-8), brickwidth-2,brickheight-3);
				  }
		  }
		  
		  g2.setStroke(new BasicStroke(4));
		  g2.setColor(Color.white);
		  g2.drawRect(15+(brickwidth+13)*0, 70+(brickheight+5)*(3), brickwidth,brickheight);
		  
		  if(i>13 && i<16) {
			  if(bricks[i]<3) {
				  
				  g2.setStroke(new BasicStroke(2));
			  g2.setColor(Color.white);
		  g2.drawRect(15+(brickwidth+13)*(i-13), 70+(brickheight+5)*(16-i), brickwidth,brickheight);
		  
		  if(bricks[i]==0) {
			   g2.setColor(new Color(153,0,0));
			  }else if(bricks[i]==1) {
				  g2.setColor(new Color(255,0,0));
			  }else {
				  g2.setColor(new Color(255,204,201));
			  }
		  g2.fillRect(15+(brickwidth+13)*(i-13), 70+(brickheight+5)*(16-i), brickwidth-2,brickheight-3);
				  }
		  }
		  
		  if(i>15 && i<20) {
			  if(bricks[i]==0) {
				  
				  g2.setStroke(new BasicStroke(2));
			  g2.setColor(Color.white);
		  g2.drawRect(15+(brickwidth+13)*(i-13), 70+(brickheight+5)*3, brickwidth,brickheight);
		  
		   g2.setColor(Color.pink);
		  g2.fillRect(15+(brickwidth+13)*(i-13), 70+(brickheight+5)*3, brickwidth-2,brickheight-3);
				  }
		  }
		  
		  if(i>19 && i<22) {
               if(bricks[i]<2) {
				  
				  g2.setStroke(new BasicStroke(2));
			  g2.setColor(Color.white);
		  g2.drawRect(49+(brickwidth+13)*4, 70+(brickheight+5)*(22-i), brickwidth,brickheight);
		  
		  if(bricks[i]==0) {
			   g2.setColor(Color.blue);
			  }else if(bricks[i]==1) {
				  g2.setColor(new Color(51,204,255));
			  }
		  g2.fillRect(49+(brickwidth+13)*4, 70+(brickheight+5)*(22-i), brickwidth-2,brickheight-3);
				  }
		  }
		  
		  if(i>21 && i<24) {
              if(bricks[i]<2) {
				  
				  g2.setStroke(new BasicStroke(2));
			  g2.setColor(Color.white);
		  g2.drawRect(49+(brickwidth+13)*4, 70+(brickheight+5)*(27-i), brickwidth,brickheight);
		  
		  if(bricks[i]==0) {
			   g2.setColor(Color.blue);
			  }else if(bricks[i]==1) {
				  g2.setColor(new Color(51,204,255));
			  }
		  g2.fillRect(49+(brickwidth+13)*4, 70+(brickheight+5)*(27-i), brickwidth-2,brickheight-3);
				  }
		  }

		  g2.setStroke(new BasicStroke(4));
		  g2.setColor(Color.white);
		  g2.drawRect(15+(brickwidth+13)*1, 70+(brickheight+5)*(8), brickwidth,brickheight);
		  
		  g2.setStroke(new BasicStroke(4));
		  g2.setColor(Color.white);
		  g2.drawRect(49+(brickwidth+13)*4, 70+(brickheight+5)*(8), brickwidth,brickheight);
		  
		  g2.setStroke(new BasicStroke(4));
		  g2.setColor(Color.white);
		  g2.drawRect(15+(brickwidth+13)*8, 70+(brickheight+5)*(8), brickwidth,brickheight);
		  
		  if(i==24) {
 if(bricks[i]==0) {
				  
				  g2.setStroke(new BasicStroke(2));
			  g2.setColor(Color.white);
		  g2.drawRect(15+(brickwidth+13)*0, 70+(brickheight+5)*7, brickwidth,brickheight);
		  
		   g2.setColor(Color.pink);
		  g2.fillRect(15+(brickwidth+13)*0, 70+(brickheight+5)*7, brickwidth-2,brickheight-3);
				  }
		  }
		  
		  if(i==25) {
			  if(bricks[i]<2) {
			 				  
			 				  g2.setStroke(new BasicStroke(2));
			 			  g2.setColor(Color.white);
			 		  g2.drawRect(49+(brickwidth+13)*4, 70+(brickheight+5)*7, brickwidth,brickheight);
			 		  
			 		 if(bricks[i]==0) {
						   g2.setColor(Color.blue);
						  }else if(bricks[i]==1) {
							  g2.setColor(new Color(51,204,255));
						  }
			 		  g2.fillRect(49+(brickwidth+13)*4, 70+(brickheight+5)*7, brickwidth-2,brickheight-3);
			 				  }
			 		  }
		  
		  if(i==26) {
			  if(bricks[i]==0) {
			 				  
			 				  g2.setStroke(new BasicStroke(2));
			 			  g2.setColor(Color.white);
			 		  g2.drawRect(15+(brickwidth+13)*9, 70+(brickheight+5)*7, brickwidth,brickheight);
			 		  
			 		   g2.setColor(Color.pink);
			 		  g2.fillRect(15+(brickwidth+13)*9, 70+(brickheight+5)*7, brickwidth-2,brickheight-3);
			 				  }
			 		  }
		  
		  if(i==27) {
			  if(bricks[i]<2) {
			 				  
			 				  g2.setStroke(new BasicStroke(2));
			 			  g2.setColor(Color.white);
			 		  g2.drawRect(15+(brickwidth+13)*0, 70+(brickheight+5)*9, brickwidth,brickheight);
			 		  
			 		 if(bricks[i]==0) {
						   g2.setColor(Color.blue);
						  }else if(bricks[i]==1) {
							  g2.setColor(new Color(51,204,255));
						  }
			 		  g2.fillRect(15+(brickwidth+13)*0, 70+(brickheight+5)*9, brickwidth-2,brickheight-3);
			 				  }
			 		  }
		  
		  if(i==28) {
			  if(bricks[i]<2) {
			 				  
			 				  g2.setStroke(new BasicStroke(2));
			 			  g2.setColor(Color.white);
			 		  g2.drawRect(49+(brickwidth+13)*4, 70+(brickheight+5)*9, brickwidth,brickheight);
			 		  
			 		 if(bricks[i]==0) {
						   g2.setColor(Color.blue);
						  }else if(bricks[i]==1) {
							  g2.setColor(new Color(51,204,255));
						  }
			 		  g2.fillRect(49+(brickwidth+13)*4, 70+(brickheight+5)*9, brickwidth-2,brickheight-3);
			 				  }
			 		  }
		  
		  if(i==29) {
			  if(bricks[i]<2) {
			 				  
			 				  g2.setStroke(new BasicStroke(2));
			 			  g2.setColor(Color.white);
			 		  g2.drawRect(15+(brickwidth+13)*9, 70+(brickheight+5)*9, brickwidth,brickheight);
			 		  
			 		 if(bricks[i]==0) {
						   g2.setColor(Color.blue);
						  }else if(bricks[i]==1) {
							  g2.setColor(new Color(51,204,255));
						  }
			 		  g2.fillRect(15+(brickwidth+13)*9, 70+(brickheight+5)*9, brickwidth-2,brickheight-3);
			 				  }
			 		  }
		  
		  
				  
		  
		  
	  }
	  }
 
 
@Override
 public void actionPerformed(ActionEvent e) {
	
 	timer.start();
	
 
 	if(new Rectangle((int)ballx,(int)bally, 15, 15).intersects(rectx, 550, 130, 12)) {
 	
		c++;
		if(bally+14>=550)
 		diry=-diry;
 	
 		if(c%8==0) {
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
 	for(int i=0;i<35;i++) {
 		
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
			new Myframe(3);
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
	//
	/*
	 * if((bally+15>=brick.y || bally<=brick.y+brick.height) && ballx>=brick.x && ballx<=brick.x+brick.width){
				diry=-diry;
			}else {
				dirx=-dirx;
			}
	 */
if(true) {
	 Rectangle brick=new Rectangle(15+(brickwidth+13)*(9), 70+(brickheight+5)*(3), brickwidth,brickheight);
		Rectangle ball=new Rectangle((int)ballx,(int)bally, 15, 15);
		
		if(brick.intersects(ball)) {
			if(ballx+14<=brick.x ||ballx+1>= brick.x + brick.width) {
				dirx=-dirx;
			}else {
				diry=-diry;
			}	
	 }
}	

 if(true) {
	 Rectangle brick=new Rectangle(15+(brickwidth+13)*(0),  70+(brickheight+5)*3, brickwidth,brickheight);
		Rectangle ball=new Rectangle((int)ballx,(int)bally, 15, 15);
		
		if(brick.intersects(ball)) {
			if(ballx+14<=brick.x ||ballx+1>= brick.x + brick.width) {
				dirx=-dirx;
			}else {
				diry=-diry;
			}	
	 }
 }
 
 if(true) {
	 Rectangle brick=new Rectangle(15+(brickwidth+13)*(1),  70+(brickheight+5)*8, brickwidth,brickheight);
		Rectangle ball=new Rectangle((int)ballx,(int)bally, 15, 15);
		
		if(brick.intersects(ball)) {
			if(ballx+14<=brick.x ||ballx+1>= brick.x + brick.width) {
				dirx=-dirx;
			}else {
				diry=-diry;
			}	
	 }
 }
 if(true) {
	 Rectangle brick=new Rectangle(49+(brickwidth+13)*(4),  70+(brickheight+5)*8, brickwidth,brickheight);
		Rectangle ball=new Rectangle((int)ballx,(int)bally, 15, 15);
		
		if(brick.intersects(ball)) {
			if(ballx+14<=brick.x ||ballx+1>= brick.x + brick.width) {
				dirx=-dirx;
			}else {
				diry=-diry;
			}	
	 }
 }
 if(true) {
	 Rectangle brick=new Rectangle(15+(brickwidth+13)*(8),  70+(brickheight+5)*8, brickwidth,brickheight);
		Rectangle ball=new Rectangle((int)ballx,(int)bally, 15, 15);
		
		if(brick.intersects(ball)) {
			if(ballx+14<=brick.x ||ballx+1>= brick.x + brick.width) {
				dirx=-dirx;
			}else {
				diry=-diry;
			}	
	 }
 }
 //
	if(i<4) {
		if(bricks[i]<3) {
			Rectangle brick=new Rectangle(15+(brickwidth+13)*(i+3), 70+(0), brickwidth,brickheight);
			Rectangle ball=new Rectangle((int)ballx,(int)bally, 15, 15);
			
			if(brick.intersects(ball)) {
				bricks[i]++;
				count=count+10;
				if(ballx+14<=brick.x ||ballx+1>= brick.x + brick.width) {
					dirx=-dirx;
				}else {
					diry=-diry;
				}
			
				
			}
		
	}
	
	}
	 if(i>3 && i<6) {
		 if(bricks[i]<3) {
				Rectangle brick=new Rectangle(15+(brickwidth+13)*(i+3), 70+(brickheight+5)*(i-3), brickwidth,brickheight);
				Rectangle ball=new Rectangle((int)ballx,(int)bally, 15, 15);
				
				if(brick.intersects(ball)) {
					bricks[i]++;
					count=count+10;
					if(ballx+14<=brick.x ||ballx+1>= brick.x + brick.width) {
						dirx=-dirx;
					}else {
						diry=-diry;
					}
				
					
				}
	 }
	 }
	 
	
	 
	 if(i>5 && i<9) {
		 if(bricks[i]<3) {
			 Rectangle brick=new Rectangle(15+(brickwidth+13)*(i), 70+(brickheight+5)*(12-i), brickwidth,brickheight);
				Rectangle ball=new Rectangle((int)ballx,(int)bally, 15, 15);
				
				if(brick.intersects(ball)) {
					bricks[i]++;
					count=count+10;
					if(ballx+14<=brick.x ||ballx+1>= brick.x + brick.width) {
						dirx=-dirx;
					}else {
						diry=-diry;
					}
				
					
				}
	 }
	 }
	 
	 if(i>8 && i<12) {
		 
				 if(bricks[i]<3) {
						Rectangle brick=new Rectangle(15+(brickwidth+13)*(i-6), 70+(brickheight+5)*6, brickwidth,brickheight);
						Rectangle ball=new Rectangle((int)ballx,(int)bally, 15, 15);
						
						if(brick.intersects(ball)) {
							bricks[i]++;
							count=count+10;
							if(ballx+14<=brick.x ||ballx+1>= brick.x + brick.width) {
								dirx=-dirx;
							}else {
								diry=-diry;
							}
						
							
						}
			 }
				 }
	 
	  if(i>11 && i<14) {

			 if(bricks[i]<3) {
					Rectangle brick=new Rectangle(15+(brickwidth+13)*(i-11), 70+(brickheight+5)*(i-8), brickwidth,brickheight);
					Rectangle ball=new Rectangle((int)ballx,(int)bally, 15, 15);
					
					if(brick.intersects(ball)) {
						bricks[i]++;
						count=count+10;
						if(ballx+14<=brick.x ||ballx+1>= brick.x + brick.width) {
							dirx=-dirx;
						}else {
							diry=-diry;
						}
					
						
					}
		 }
	  }
	  
	  if(i>13 && i<16) {
		  if(bricks[i]<3) {
				Rectangle brick=new Rectangle(15+(brickwidth+13)*(i-13), 70+(brickheight+5)*(16-i), brickwidth,brickheight);
				Rectangle ball=new Rectangle((int)ballx,(int)bally, 15, 15);
				
				if(brick.intersects(ball)) {
					bricks[i]++;
					count=count+10;
					if(ballx+14<=brick.x ||ballx+1>= brick.x + brick.width) {
						dirx=-dirx;
					}else {
						diry=-diry;
					}
				
					
				}
	 }
	  }
		 
	  if(i>15 && i<20) {
		  if(bricks[i]<1) {
				Rectangle brick=new Rectangle(15+(brickwidth+13)*(i-13), 70+(brickheight+5)*3, brickwidth,brickheight);
				Rectangle ball=new Rectangle((int)ballx,(int)bally, 15, 15);
				
				if(brick.intersects(ball)) {
					bricks[i]++;
					count=count+10;
					if(ballx+14<=brick.x ||ballx+1>= brick.x + brick.width) {
						dirx=-dirx;
					}else {
						diry=-diry;
					}
				
					
				}
	 }
	  }
	
	  if(i>19 && i<22) {
		  if(bricks[i]<2) {
				Rectangle brick=new Rectangle(49+(brickwidth+13)*4, 70+(brickheight+5)*(22-i), brickwidth,brickheight);
				Rectangle ball=new Rectangle((int)ballx,(int)bally, 15, 15);
				
				if(brick.intersects(ball)) {
					bricks[i]++;
					count=count+10;
					if(ballx+14<=brick.x ||ballx+1>= brick.x + brick.width) {
						dirx=-dirx;
					}else {
						diry=-diry;
					}
				
					
				}
	 }
	  }
	  
	  if(i>21 && i<24) {
		  if(bricks[i]<2) {
				Rectangle brick=new Rectangle(49+(brickwidth+13)*4, 70+(brickheight+5)*(27-i), brickwidth,brickheight);
				Rectangle ball=new Rectangle((int)ballx,(int)bally, 15, 15);
				
				if(brick.intersects(ball)) {
					bricks[i]++;
					count=count+10;
					if(ballx+14<=brick.x ||ballx+1>= brick.x + brick.width) {
						dirx=-dirx;
					}else {
						diry=-diry;
					}
				
					
				}
	 }
	  }
	  
	  if(i==24) {
		  if(bricks[i]<1) {
				Rectangle brick=new Rectangle(15+(brickwidth+13)*0, 70+(brickheight+5)*7, brickwidth,brickheight);
				Rectangle ball=new Rectangle((int)ballx,(int)bally, 15, 15);
				
				if(brick.intersects(ball)) {
					bricks[i]++;
					count=count+10;
					if(ballx+14<=brick.x ||ballx+1>= brick.x + brick.width) {
						dirx=-dirx;
					}else {
						diry=-diry;
					}
				
					
				}
	 }
	  }
	  
	  if(i==25) {
		  if(bricks[i]<2) {
				Rectangle brick=new Rectangle(49+(brickwidth+13)*4, 70+(brickheight+5)*7, brickwidth,brickheight);
				Rectangle ball=new Rectangle((int)ballx,(int)bally, 15, 15);
				
				if(brick.intersects(ball)) {
					bricks[i]++;
					count=count+10;
					if(ballx+14<=brick.x ||ballx+1>= brick.x + brick.width) {
						dirx=-dirx;
					}else {
						diry=-diry;
					}
				
					
				}
	 }
	  }
	  
	  if(i==26) {
		  if(bricks[i]<1) {
				Rectangle brick=new Rectangle(15+(brickwidth+13)*9, 70+(brickheight+5)*7, brickwidth,brickheight);
				Rectangle ball=new Rectangle((int)ballx,(int)bally, 15, 15);
				
				if(brick.intersects(ball)) {
					bricks[i]++;
					count=count+10;
					if(ballx+14<=brick.x ||ballx+1>= brick.x + brick.width) {
						dirx=-dirx;
					}else {
						diry=-diry;
					}
				
					
				}
	 }
	  }
	  
	  if(i==27) {
		  if(bricks[i]<2) {
				Rectangle brick=new Rectangle(15+(brickwidth+13)*0, 70+(brickheight+5)*9, brickwidth,brickheight);
				Rectangle ball=new Rectangle((int)ballx,(int)bally, 15, 15);
				
				if(brick.intersects(ball)) {
					bricks[i]++;
					count=count+10;
					if(ballx+14<=brick.x ||ballx+1>= brick.x + brick.width) {
						dirx=-dirx;
					}else {
						diry=-diry;
					}
				
					
				}
	 }
	  }
	  
	  if(i==28) {
		  if(bricks[i]<2) {
				Rectangle brick=new Rectangle(49+(brickwidth+13)*4, 70+(brickheight+5)*9, brickwidth,brickheight);
				Rectangle ball=new Rectangle((int)ballx,(int)bally, 15, 15);
				
				if(brick.intersects(ball)) {
					bricks[i]++;
					count=count+10;
					if(ballx+14<=brick.x ||ballx+1>= brick.x + brick.width) {
						dirx=-dirx;
					}else {
						diry=-diry;
					}
				
					
				}
	 }
	  }
	  
	  if(i==29) {
		  if(bricks[i]<2) {
				Rectangle brick=new Rectangle(15+(brickwidth+13)*9, 70+(brickheight+5)*9, brickwidth,brickheight);
				Rectangle ball=new Rectangle((int)ballx,(int)bally, 15, 15);
				if(brick.intersects(ball)) {
					bricks[i]++;
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


}




