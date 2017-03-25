package edu.neu.csye6200.ui;

import java.util.ArrayList;


public class CAGeneration {
	
private ArrayList<CACell> cellArray;
	
public CAGeneration()
	{
		cellArray=new ArrayList<>();
		
	}

public ArrayList<CACell> getCellGen() {
		return cellArray;
	}

public void setCellArray(ArrayList<CACell> cellArray) {
		this.cellArray = cellArray;
	}
	
		
public void eachGeneration(int[] c)
	{
		
	for(int i=0;i<c.length;i++)
		
	    {
			CACell a= new CACell();
			a.setCellvalue(c[i]);
			cellArray.add(a);
		}
		
		//printing each generation
		
	    System.out.print("\n");
		
	for(int i=0;i<cellArray.size();i++)
		
	    {
			System.out.print(cellArray.get(i).getCellvalue());
		}
		
	 }
	
	

}

