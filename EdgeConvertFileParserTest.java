import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.After;
import java.io.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import java.util.*;

public class EdgeConvertFileParserTest {

  private int numberOfTables = 0;
  private int numberOfFields = 0;
  private FileReader fr;
  private BufferedReader br;
  private String fileName = "./Courses.edg";
  private ArrayList figure1IntArray = new ArrayList();
  private ArrayList figure2IntArray = new ArrayList();
  private ArrayList figure1TableIntArray = new ArrayList();
  private ArrayList figure2TableIntArray = new ArrayList();

  
  private void getTablesandFieldAmounts() {
    // I am going to make sure that it finds all the
    // entities in the file
  File file = new File(fileName);
  try {
  fr = new FileReader(file);
  br = new BufferedReader(fr);
  String line;
  while ((line = br.readLine()) !=null) {
   line = line.trim();
   if(line.startsWith ("Figure ")) {
    line = br.readLine().trim();
    line = br.readLine().trim();
    if (line.contains("Style")) {
      if (line.contains("Entity")) {
	// if the Figure is an Entity, add one to the
	// amount of Tables
	numberOfTables = numberOfTables + 1;
      } 
      else if (line.contains("Attribute")) {
	// if the Figures is an Attribute, add one to
	// the amount of Fields
	numberOfFields = numberOfFields + 1;
      }
     }
    }
   }
  }
  catch (FileNotFoundException ex) {
   System.out.println("Cannot find file");
  }
  catch (IOException ioe) {
    System.out.println(ioe);
  }
  }
  private void getTableandFieldNumfromConnectors() {
  
    File file = new File(fileName);
    try{
    fr = new FileReader(file);
    br = new BufferedReader(fr);
    String line;
    while ((line = br.readLine()) != null) {
      line = line.trim();
      if(line.startsWith("Connector ")) {
	line = br.readLine().trim();
	line = br.readLine().trim();
	line = br.readLine().trim();
	int tempFigure1Int = new Integer(line.substring(line.indexOf(" ") + 1));
	line = br.readLine().trim();
	int tempFigure2Int = new Integer(line.substring(line.indexOf(" ") + 1));
	line = br.readLine().trim();
	line = br.readLine().trim();
	line = br.readLine().trim();
	line = br.readLine().trim();
	line = br.readLine().trim();
	String EndStyle1 = line.substring(line.indexOf("\"") + 1, line.lastIndexOf("\""));
	line = br.readLine().trim();
	String EndStyle2 = line.substring(line.indexOf("\"") + 1, line.lastIndexOf("\""));
	int hasMany = 0;
	if (EndStyle1.indexOf("many") >= 0) {
	  hasMany++;
	}
	if (EndStyle2.indexOf("many") >= 0) {
	  hasMany++;
	}
	if(hasMany < 2 && !EndStyle1.equals("null") && !EndStyle2.equals("null"))
	{
	  figure1TableIntArray.add(tempFigure1Int);
	  figure2TableIntArray.add(tempFigure2Int);
	}
	else if (tempFigure1Int > 0 && tempFigure2Int > 0 && EndStyle1.equals("null") && EndStyle2.equals("null"))
	{
	  figure1IntArray.add(tempFigure1Int);
	  figure2IntArray.add(tempFigure2Int);
	}
      }
     }
    }
    catch (FileNotFoundException ex) {
    System.out.println("Cannot find file");
    }
    catch (IOException ioe) {
      System.out.println(ioe);
    }

  }
  // Test to test that the parser is able to parse Edge
  // Tables from EDG File
  @Test
  public void testGetEdgeTables () {
  File file = new File(fileName);
  EdgeConvertFileParser Converter = new EdgeConvertFileParser(file);
  getTablesandFieldAmounts();
  EdgeTable[] edgeTables = Converter.getEdgeTables();
  assertEquals(numberOfTables, edgeTables.length);
  }
  // Test to test that the parser is able to parse the
  // Edge Fields from EDG File
  @Test
  public void testGetEdgeFields () {
  File file = new File(fileName);
  EdgeConvertFileParser Converter = new EdgeConvertFileParser(file);
  getTablesandFieldAmounts();
  EdgeField[] edgeFields = Converter.getEdgeFields();
  assertEquals(numberOfFields, edgeFields.length);
  }

  // Test to test that the parser is able to parse the
  // connection between the tables and fields from EDG
  // File
  @Test
  public void testCheckConnectionsTableField () {
  File file = new File(fileName);
  EdgeConvertFileParser Converter = new EdgeConvertFileParser(file);
  getTableandFieldNumfromConnectors();
  EdgeTable[] edgeTables = Converter.getEdgeTables();
  EdgeField[] edgeFields = Converter.getEdgeFields();
  // Make arrays for EdgeTables
  for (int g =0; g < edgeTables.length; g++) {
    edgeTables[g].makeArrays();
  }
  for (int y =0; y < figure1IntArray.size(); y++) {
    int Figure1 = (Integer)figure1IntArray.get(y);
    int Figure2 = (Integer)figure2IntArray.get(y);
    EdgeTable edgeTable = null;
    EdgeField edgeField = null;
    //These check which one of the two figures are
    //tables
    boolean figure1isTable = false;
    boolean figure2isTable = false;
    //get the EdgeTable or EdgeField from both Figures
    for(int z =0; z < edgeTables.length; z++) {
      if (edgeTables[z].getNumFigure() == Figure1)
      {
	// check both Figures to see which one would get
	// the table
	if (edgeTable == null) {
	  figure1isTable = true;
	  edgeTable = edgeTables[z];
	} else {
	  fail("Both Figures in Connector were Tables");
	}
      } else if (edgeTables[z].getNumFigure() == Figure2) {
	if (edgeTable == null) {
	  figure2isTable = true;
	  edgeTable = edgeTables[z];
	} else {
	  fail("Both Figures in Connector were Tables");
	}
      }
    }
    for(int a =0; a < edgeFields.length; a++) {
      if (edgeFields[a].getNumFigure() == Figure1) {
	//Check both Figures to see which one would get
	//the field
	if (edgeField == null) {
	  edgeField = edgeFields[a];
	} else {
	    fail("Both Figures in Connector were Fields");
	}
      } else if (edgeFields[a].getNumFigure() == Figure2) {
	if (edgeField == null) {
	  edgeField = edgeFields[a];
	} else {
	    fail("Both Figures in Connector were Fields");
	}
      }
    }

    if (figure1isTable) {
      int[] fieldsinTable = edgeTable.getNativeFieldsArray();
      boolean isinfieldTable = false;
      for (int j = 0; j < fieldsinTable.length; j++) {
	if (fieldsinTable[j] == Figure2) {
	  isinfieldTable = true;
	}
      }
      assertEquals(true, isinfieldTable);
      assertEquals(Figure1, edgeField.getTableID());

    } else if (figure2isTable) {
      int[] fieldsinTable = edgeTable.getNativeFieldsArray();
      boolean isinfieldTable = false;
      for (int j = 0; j < fieldsinTable.length; j++) {
	if (fieldsinTable[j] == Figure1) {
	  isinfieldTable = true;
	}
      }
      assertEquals(true, isinfieldTable);
      assertEquals(Figure2, edgeField.getTableID());
    }
    }
  }

  //Test that the connection between Tables are made
  //from the Connectors
  @Test
  public void testCheckConnectionTableTable()
  {
    // look at the connection between the tables
    File file = new File(fileName);
    EdgeConvertFileParser Converter = new EdgeConvertFileParser(file);
    getTableandFieldNumfromConnectors();
    EdgeTable [] edgeTables = Converter.getEdgeTables();
    // make arrays for edgeTables
    for (int c = 0;c < edgeTables.length; c++) {
      edgeTables[c].makeArrays();
    }
    for(int e = 0; e < figure1TableIntArray.size(); e++) {
      int numFigForTable1 = (Integer)figure1TableIntArray.get(e);
      int numFigForTable2 = (Integer)figure2TableIntArray.get(e);
      EdgeTable edgeTable1;
      EdgeTable edgeTable2;
      boolean isIntable1 = false;
      boolean isIntable2 = false;
      for (int h =0; h < edgeTables.length; h++) {
      if (edgeTables[h].getNumFigure() == numFigForTable1) {
	edgeTable1 = edgeTables[h];
	int[] relatedTablesArray = edgeTable1.getRelatedTablesArray();
	for(int l = 0; l < relatedTablesArray.length; l++) {
	  // see if the relatedTablesArray has the num
	  // in it 
	  if (relatedTablesArray[l] == numFigForTable2) {
	    isIntable1 = true;
	  }
	}
	
      }
      if (edgeTables[h].getNumFigure() == numFigForTable2) {
	edgeTable2 = edgeTables[h];
	int[] relatedTablesArray = edgeTable2.getRelatedTablesArray();
	for(int p =0; p < relatedTablesArray.length; p++) {
	  if (relatedTablesArray[p] == numFigForTable1) {
	  isIntable2 = true;
	  }
	}
      }
    }
    assertEquals(true, isIntable1);
    assertEquals(true, isIntable2);
  }
  }
}
