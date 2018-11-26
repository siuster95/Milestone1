import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.filechooser.FileFilter;
import java.io.*;
import java.util.*;
import java.lang.reflect.*;

public class SystemHelp extends JFrame {

      JButton test, test2, test3, test4, test5;
      JTextArea textArea;
      JScrollPane scrollPane;
      JPanel rightCol, leftCol;

	public SystemHelp(){
		super("System Help");
		GUI();
		setSize(1000,700);
		pack();
		setVisible(true);
	}
	
	public static void main(String [] args){
      
        SystemHelp sh = new SystemHelp();
   
   	}
	
	public void GUI(){
      
   
		      rightCol = new JPanel();
		      rightCol.setLayout(new GridLayout(5,0));
		      test = new JButton("How to createDDL");
		      test2 = new JButton("How to define Relations");
		      test3 = new JButton("How to open the edge file");
		      test4 = new JButton("How to set output file definition location");
		      test5 = new JButton("How to show database products available");
		      test.addActionListener(
			 new ActionListener(){

			    public void actionPerformed(ActionEvent e){
			       textArea.setText("1. Select the type of tables\n"+ 
					    "2. Click \"Create DDL\" button\n"+
					    "3. Select a product: MySQL and press OK\n"+ 
					    "4. Enter the database name and press OK\n"+ 
					    "5. Save the output file in the \"outputfiles\" directory under the root directory and press SAVE");

			    }

			 });

		      test2.addActionListener(
			 new ActionListener(){

			    public void actionPerformed(ActionEvent e){
			       textArea.setText("1. Press \"Define Relations\" button\n"+
					    "2. Select the type of tables with relations\n"+
					    "3. Select the related tables\n"+ 
					    "4. Press Create DDL button (Same thing as above)\n");

			    }

			 });


		      test3.addActionListener(
			 new ActionListener(){

			    public void actionPerformed(ActionEvent e){
			       textArea.setText("1. Go to the File from the top menu\n"+
					    "2. Click \"Open Edge File\n"+
					    "3. Go to the folder \"inputFiles\" and click \"Courses.edg\n"+ 
					    "4. Press OPEN button\n"+
				              "5. All tables will display in the \"All Tables\" text area\n");

			    }

			 });

		      test4.addActionListener(
			 new ActionListener(){

			    public void actionPerformed(ActionEvent e){
			       textArea.setText("1. Select \"Options\" from the top menu\n"+
				              "2. Select \"Set Output File Definition Location\n"+
					    "3. Navigate to the root project directory\n"+
					    "4. Then click on the folders: out -> production -> FinalProject_422 -> com -> example -> finalproject422.\n"+
					    "5. Click \"open\" in the file explorer menu.");

			    }

			 });

		      test5.addActionListener(
			 new ActionListener(){

			    public void actionPerformed(ActionEvent e){
			       textArea.setText("1. After you set the output file definition\n"+ 
					    "2. Press Options from the top menu\n"+ 
					    "3. Select \"Show Database Products available\n"+
					    "4. Message dialog will pop up that show the available products to create DDL statements.");

			    }

			 });



		      rightCol.add(test);
		      rightCol.add(test2);
		      rightCol.add(test3);
		      rightCol.add(test4);
		      rightCol.add(test5);

		      add(rightCol, BorderLayout.WEST);

		      leftCol = new JPanel();
		      String texta = "Hello";
		      textArea = new JTextArea(texta, 20,20);
		      scrollPane = new JScrollPane(textArea);
		      textArea.setEditable(false);
		      textArea.setLineWrap(true);
		      textArea.setWrapStyleWord(true);
		      leftCol.add(scrollPane);

		      add(leftCol,BorderLayout.CENTER);
	}
}
