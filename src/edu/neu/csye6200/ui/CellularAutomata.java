package edu.neu.csye6200.ui;



import java.awt.Color;
//import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class CellularAutomata  {
		
	
	
	
 public static void main(String args[])
	{
		
		Run run=new Run();
	
		
	}
	
  }

class  Run extends CAApp {
	
  private int a;
  private String comboselected;
  private boolean flag;
	
	
	
	
  public Run()
	
    {
	  frame.setTitle("Cellular Automata");
    }	
	
	//actionPerformed method
  public void actionPerformed(ActionEvent arg0) 
	
    {
	
	 if(arg0.getSource()==btn0)
		
	    {
		   System.out.println("Start button is pressed");
			
		              //Validation of inputs entered by user.
			try 
			 { 
		        Integer.parseInt(text.getText());
		        
		     } catch(NumberFormatException e) 
			    { 
		        JOptionPane.showMessageDialog(null, "Only number values are accepted!!!");
		        }
			
	 if(text.getText().isEmpty() || Integer.parseInt(text.getText())==0)
			
	        {
				JOptionPane.showMessageDialog(null, "Invalid Value Entered!!");
				return;
			}
			
			        //Taking the inputs from the user-end
			int a1=Integer.parseInt(text.getText());
	
			String comboselected1=comboBox.getSelectedItem().toString();
			this.a=a1;
	
			this.comboselected=comboselected1;
			
			
			flag=true;	
			CAGenerationSet.SetRight();
			CARule.setRight();
			
			//run and generate the 0's and 1's of each generation.
			
			for(int i=0;i<a;i++)
			{
			CAGenerationSet cellGenSet=CAGenerationSet.getInstance();
			cellGenSet.CAGenSet(comboselected);
			}
			
			
			frame.getContentPane().add(new MainPanel(a));
		
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setVisible(true);
		    
	        
			
		}
		else if (arg0.getSource()==btn1){
			
			flag=false;
			System.out.println("\n");
			System.out.println("Pause button is pressed");
			
			MainPanel.setBool(flag);
			
				
			
		}
		else
		{}
	
	   }
	  

}

//this class extends JPanel and uses its methods to paint the pattern	
class MainPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int count;
	private static int counter;
	private static boolean run;
	private int b;
	

	
  MainPanel(int r) {
    	
    	//initializing(no of generations)
    	
    	run=true;
  
    	b=1;
    }
    
    //method to set the boolean value
  public static void setBool(boolean booln)
    {
    	run=booln;
    
    }
    
    public boolean getBool()
    {
    	return run;
    }
    
    
    
    //The following method is automatically called by AWT thread
    
    public void paintComponent(Graphics g1) {
    	
    	//clear prior images drawn in JPanel
    	super.paintComponent(g1);
    	draw(g1);
    	
    }
    
    
    	
    	
    public void draw(Graphics g1)
    	{
    		
    		Graphics2D g2=(Graphics2D) g1;	
    		
    		for(int l=0;l<b;l++)
    		{
    			
	    		CAGeneration caGeneration=CAGenerationSet.getCellGenSet().get(l);
	    		
	    		
	        	count=counter;
	        	counter=counter+5;
    		
	            for(int i=0;i<caGeneration.getCellGen().size();i++)
		        {
	            	
		        	if(caGeneration.getCellGen().get(i).getCellvalue()==0)
		        	{
		        		
		        		g2.setColor(Color.BLACK);
		        		
		        		g2.fillRect(10*i,count,10,10);
		        		
		        		
		        		
		        	}
		        	else
		        	{
		        		
		        		g2.setColor(Color.DARK_GRAY);
		        		g2.fillRect(10*i,count,10,10);
		
		        	}
		         
		        }//for all the cells in each generation
	            
         
	            
    		}//outer for loop ends.
    	  
    	counter=0;
    	
    	
    	 if(b<CAGenerationSet.getCellGenSet().size() && run==true)
    	 {   		 
    		 try {
            	  
    			 
        			Thread.sleep(120);
        		} catch (InterruptedException e) {
        			
        			e.printStackTrace();
        		}
    		 repaint(); //repaints the canvas with each generation. 
    		 b++;
         }
    	 
    		
    	 
    	
    }
    
      
}
