package edu.neu.csye6200.ui;

public class CARule {



private static CARule caRule;
private static int[] ruleset;
private int[] cells;
	
private CARule()
	 {
		cells=new int[84];
		
		ruleset= new int[]{0,1,0,1,1,0,1,0};
		
		
	
		 
		//for 0th generation
		for(int i=0;i<cells.length;i++)
		{
			cells[i]=0;
		}
		cells[cells.length/2]=1;
		
		
		//for adding the zeroth generation
		CAGeneration genCell=new CAGeneration();
		genCell.eachGeneration(cells);
		CAGenerationSet.getCellGenSet().add(genCell);
		 
	 }
	
	
public void CARuleMethod(String comboselected)
	{
		
		 if(comboselected.equals("ruleset-90"))
        {
            ruleset= new int[]{0,1,0,1,1,0,1,0};
        }
        else if(comboselected.equals("ruleset-30"))
        {
        
            ruleset= new int[]{0,0,0,1,1,1,1,0};
            
        }
        else if(comboselected.equals("ruleset-94"))
        {
        
            ruleset= new int[]{0,1,0,1,1,1,1,0};
        }
		 
        else if(comboselected.equals("ruleset-110"))
        {
        	
            ruleset= new int[]{0,1,1,0,1,1,1,0};
        }
		 
        else if(comboselected.equals("ruleset-188"))
        {
        
            ruleset= new int[]{1,0,1,1,1,1,0,0};
        }
		 
        else if(comboselected.equals("ruleset-250"))
        {
        	
            ruleset= new int[]{1,1,1,1,1,0,1,0};
        }
		 
        else if(comboselected.equals("ruleset-206"))
        {
        	
            ruleset= new int[]{1,1,0,0,1,1,1,0};
        }
		 
        else if(comboselected.equals("ruleset-182"))
        {
        	
            ruleset= new int[]{1,0,1,1,0,1,1,0};
        }
		 
        else if(comboselected.equals("ruleset-54"))
        {
        	
            ruleset= new int[]{0,0,1,1,0,1,1,0};
        }
		 
       
	}

public static CARule getInstance()
	{
		if(caRule==null)
		{
			caRule=new CARule();
			
		}
		return caRule;
	}


public int[] populateNextGeneration()
	 
       {
		 
	
		 
		 int[] nextgen=new int[cells.length];
		 for(int i=1;i<cells.length-1;i++)
		 {
			 int left=cells[i-1];
			 int mid=cells[i];
			 int right=cells[i+1];
			 nextgen[i]=rules(left,mid,right);
			 
		 }
		 cells=nextgen;
		 
		return cells;
		 
		
	 }
	 
public int rules(int a,int b,int c)
	 {
		 String s= "" + a + b + c;
		 int index=Integer.parseInt(s,2);
		 return ruleset[index];
		 
	 }
	 
	 public static void setRight()
	 {
		 
		 caRule=null;
	 }
	
	
	


}
