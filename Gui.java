package CalculatorApp;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
//import javax.swing.JButton;

public class Gui implements MouseListener {
//decided to make my own implementation of a button since JButton did not work very well

//private JButton [] nums;
private String display="";
private Rectangle [] buttons;
private String [] values;
private int width=160;
private int height=150;
private int buffer =0;
private int rows=3;
private int columns=5;
private Algorithm algorithm;
private JFrame f;
public Gui(JFrame j) {
	this.buttons=new Rectangle[rows*columns+1];
	//nums=new JButton[rows*columns+1];//all numbers and operations(basic) powers, parenthesis,roots, clear all , delete, and execute
	this.values=new String[] {"1","2","3","4","AC","5","6","7","8","9","0","+","-","*","/","EXE"};
	this.f=j;
	
	//args.retainAll(args.subList(1,args.size()));
	this.initialize();
	this.algorithm=new Algorithm();
}




public void initialize() {


		/*for(int i=0;i<nums.length;i++) {
		this.nums[i]=new JButton(values[i]);
		this.nums[i].addMouseListener(this);
		//create the button object
	}*/
		for(int i=0;i<this.rows;i++) {
			for(int j=0;j<this.columns;j++) {//sets the positions
				//Rectangle bounds=new Rectangle(this.width*j+this.buffer,150+this.height*i+this.buffer,this.width,this.height);
				//nums[j+i*this.columns].setBounds(bounds);
				buttons[j+i*this.columns]=new Rectangle(this.width*j,150+this.height*i,this.width,this.height);

			}
		}
	//	 Rectangle bound=new Rectangle(this.buffer,150+(this.height*this.rows)+this.buffer,this.f.getWidth(),this.width);
	//		nums[nums.length-1].setBounds(bound);
		buttons[buttons.length-1]=new Rectangle(this.buffer,150+(this.height*this.rows)+this.buffer,this.f.getWidth(),this.width);
	/*
	 * 
	 * for(int i=0;i<this.nums.length;i++) {
	 
			f.add(this.nums[i]);//add the buttons to the frame
		}*/

}


	
	public void update() {
		//do nothing
				//if(nums[0].
	//System.out.print(display+"\n");
	}
	
	public void draw(Graphics2D win) {
		win.setColor(Color.black);
for(int i=0;i<buttons.length;i++) {
	win.draw(buttons[i]);
	win.drawString(values[i], (int)buttons[i].getCenterX(), (int)buttons[i].getCenterY());
}
	Font font =new Font("TimesNewRoman",Font.BOLD,100);
	win.setFont(font);
	win.setColor(Color.black);
	

	win.drawString(display,60, 110);

		}


	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	
/*for(int i=0;i<nums.length;i++) {
	if(e.getSource()==nums[i]) {
		System.out.print(values[i]+"\n");
	
	}
}*/
		for(int i=0;i<buttons.length;i++) { //start loop
			if((e.getX()>buttons[i].getX() && e.getX()<buttons[i].getX()+buttons[i].getWidth()) && (e.getY()>buttons[i].getY() &&e.getY()<buttons[i].getY()+buttons[i].getHeight())){
				//System.out.print(values[i]+"\n");
			if(values[i].equals(values[4])) {display="";} 
			if(!values[i].equals(values[values.length-1]) && !values[i].equals(values[4])) { 
			if(display.length()<9 && (values[i].equals("/")==false && values[i].equals("*")==false && values[i].equals("+")==false && values[i].equals("-")==false))display+=values[i];
		    if((display.length()>0 && display.length()<8)&&(display.charAt(display.length()-1)!='-'&& display.charAt(display.length()-1)!='+'&& display.charAt(display.length()-1)!='*'&& display.charAt(display.length()-1)!='/') &&(values[i].equals("/")==true || values[i].equals("*")==true || values[i].equals("+")==true || values[i].equals("-")==true) )
		    {display+=values[i];}
			}
			else if(values[i].equals(values[values.length-1])) display=algorithm.update(display);
			}
		}//end loop

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
