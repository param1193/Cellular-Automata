package edu.neu.csye6200.ui;

import java.util.ArrayList;




public class CAGenerationSet {
	
private static CAGenerationSet cellGen;
private static ArrayList<CAGeneration> cellGenArray;

	
private CAGenerationSet()
	
	{
		cellGenArray=new ArrayList<>();
		
	}
	

public static CAGenerationSet getInstance()

{
	if(cellGen==null)
	{
		cellGen=new CAGenerationSet();
	}
	return cellGen;
}

	
public void CAGenSet(String comboselected)
	{
		
		
		
		
		CARule caRule=CARule.getInstance();
		
		//this method will override the ruleSet.
		caRule.CARuleMethod(comboselected);
		int[] b=caRule.populateNextGeneration();
		
		
		
		CAGeneration caGen=new CAGeneration();
		
		caGen.eachGeneration(b);
		cellGenArray.add(caGen);
		
		
    }

public static void SetRight()
{
	cellGen=null;
}

public static ArrayList<CAGeneration> getCellGenSet() 
    
   {
       return cellGenArray;
    }
	



}

