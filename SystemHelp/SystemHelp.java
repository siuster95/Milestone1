import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.filechooser.FileFilter;
import java.io.*;
import java.util.*;
import java.lang.reflect.*;

public class SystemHelp extends JFrame {
	
      JButton test, test2, test3;
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
		      rightCol.setLayout(new GridLayout(3,0));
		      test = new JButton("test");
		      test2 = new JButton("test2");
		      test3 = new JButton("test3");
		      test.addActionListener(
			 new ActionListener(){

			    public void actionPerformed(ActionEvent e){
			       textArea.setText("lalalalalalalallalalalalalalalalalalalalalalalalalala");

			    }

			 });

		      test2.addActionListener(
			 new ActionListener(){

			    public void actionPerformed(ActionEvent e){
			       textArea.setText("djhgushguishguihfiweorajihvniurshbfuabdhjvbhudanfviasjfiewjifasbiusdhushu");

			    }

			 });


		      test3.addActionListener(
			 new ActionListener(){

			    public void actionPerformed(ActionEvent e){
			       textArea.setText("HI Johnny! HI Johnny! HI Johnny! HI Johnny! HI Johnny! HI Johnny! HI Johnny! HI Johnny! HI Johnny! ");

			    }

			 });

		      rightCol.add(test);
		      rightCol.add(test2);
		      rightCol.add(test3);

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
