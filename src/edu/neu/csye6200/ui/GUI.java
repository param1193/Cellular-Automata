package edu.neu.csye6200.ui;


import java.awt.BorderLayout;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public abstract class GUI implements ActionListener {
   
	protected static JFrame frame ;
    protected JPanel mainPanel = null;
    protected JButton btn0 = null;
    protected JButton btn1 = null;
    protected JTextField text=null;
    protected JComboBox<String> comboBox=null;

   
  public  GUI() {
		initGUI();
		
	}
	
	
	
  private void initGUI() {
		frame = new JFrame();
	
		frame.setSize(650,650);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setLayout(new BorderLayout());
		frame.add(getMainPanel(),BorderLayout.NORTH);
		frame.setVisible(true);
	}

  public JPanel getMainPanel() {
		mainPanel = new JPanel();
		mainPanel.setLayout(new FlowLayout());
		btn0 = new JButton("Start");
		btn0.addActionListener(this);
		mainPanel.add(btn0);
		
		btn1 = new JButton("Pause");
		btn1.addActionListener(this);
		mainPanel.add(btn1);
		
		text=new JTextField("Write Generations in Numbers");
		mainPanel.add(text);
		
		comboBox=new JComboBox<String>();
		comboBox.addItem("ruleset-90");
		comboBox.addItem("ruleset-30");
		comboBox.addItem("ruleset-94");	
		comboBox.addItem("ruleset-110");
		comboBox.addItem("ruleset-188");
		comboBox.addItem("ruleset-250");
		comboBox.addItem("ruleset-206");
		comboBox.addItem("ruleset-182");
		comboBox.addItem("ruleset-54");
		
		
		
		mainPanel.add(comboBox);
		
		
		
		
		return mainPanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {}
    public abstract void run();
	
	

	
}
