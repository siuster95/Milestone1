import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NewEdgeTableTest{

  EdgeTable testET;
  int NumFig;
  String Name;

  @Before
  public void setUp()throws Exception{
    String input = System.getProperty("EdgeTableTestParams");
    String[] stArray = input.split("\\|");
    NumFig = Integer.parseInt(stArray[0]);
    Name = stArray[1];
    testET = new EdgeTable(input);
  }

  @Test
  public void testGetNumFigure(){
    int expected = NumFig;
    assertEquals("getNumFigure should be " + expected,expected,testET.getNumFigure());
  }
  @Test
  public void testGetname(){
    String expected = Name;
    assertEquals("getName should be " + expected,expected,testET.getName());
  }

  

 @Test 
 public void testGetNativeFieldsArray(){
      testET.addNativeField(10);
      testET.makeArrays();
      int[] expected = new int[1];
      expected[0] = 10;
      assertEquals("NativeFields should be 10",expected[0], testET.getNativeFieldsArray()[0]);
 }

  @Test
  public void testGetRelatedTablesArray(){
    testET.addRelatedTable(5);
    testET.makeArrays();
    int[] expected = new int[1];
    expected[0] = 5;
    System.out.println(expected[0] +" and "+testET.getRelatedTablesArray()[0]);
    System.out.println(expected.length + " and "+testET.getRelatedTablesArray().length);
    assertEquals(" GetRelatedTable should be 5",expected[0],testET.getRelatedTablesArray()[0]);
    //Expected number is 1 and actual number is 2
  }

  @Test
  public void testGetRelatedFieldsArray(){
    testET.addNativeField(5);
    testET.makeArrays();
    testET.setRelatedField(0,5);
    int[] expected = new int[1];
    expected[0] = 5;
    assertEquals("Field should be 5",expected[0],testET.getRelatedFieldsArray()[0]);

  }

  @Test
  public void testToString(){
    final String DELIM = "|";
    testET.addNativeField(5);
    testET.addRelatedTable(6);
    testET.makeArrays();
    testET.setRelatedField(0,6);
    StringBuffer sb = new StringBuffer();
    sb.append("Table: "+testET.getNumFigure()+"\r\n");
    sb.append("{\r\n");
    sb.append("TableName: "+testET.getName()+"\r\n");
    sb.append("NativeFields: ");
      for(int i = 0; i< testET.getNativeFieldsArray().length;i++){
	sb.append(testET.getNativeFieldsArray()[i]);
	  if(i < (testET.getNativeFieldsArray().length-1)){
	    sb.append(DELIM);
	  }
      }

    sb.append("\r\nRelatedTables: ");
    for(int i = 0;i< testET.getRelatedTablesArray().length;i++){
      sb.append(testET.getRelatedTablesArray()[i]);
      if(i < (testET.getRelatedTablesArray().length-1)){
	  sb.append(DELIM);
      }
    }

    sb.append( "\r\nRelatedFields: ");
    for(int i = 0; i < testET.getRelatedFieldsArray().length;i++){
      sb.append(testET.getRelatedFieldsArray()[i]);
      if(i < (testET.getRelatedFieldsArray().length-1)){
	sb.append(DELIM);
      }
    }

    sb.append( "\r\n}\r\n");
			
  assertEquals("This string should be matched with original toString()",sb.toString(),testET.toString());

 
  }

  @Test
  public void testMoveFieldUp(){
      testET.addNativeField(5);
      testET.addNativeField(7);
      testET.addNativeField(8);
      testET.addNativeField(9);
      testET.addNativeField(10);
      testET.addRelatedTable(3);
      testET.makeArrays();
      testET.setRelatedField(0,3);
      testET.moveFieldUp(2);
      int[] expected = new int[2];
      expected[0] = 5;
      expected[1] = 3;
      assertEquals(expected[0],testET.getNativeFieldsArray()[0]);
      assertEquals(expected[1],testET.getRelatedFieldsArray()[0]);

  }

  public void  testMoveFieldDown(){
      testET.addNativeField(8);
      testET.addNativeField(78);
      testET.addNativeField(4);
      testET.addNativeField(89);
      testET.addNativeField(1);
      testET.addRelatedTable(5);
      testET.addRelatedTable(8);
      testET.makeArrays();
      testET.setRelatedField(1,8);
      testET.moveFieldDown(3);
      int[]  expected =  new int[5];
      int[]  expectedField = new int [3];
      expected[3] = 4;
      expectedField[1] = 8;
      assertEquals(expected[3],testET.getNativeFieldsArray()[3]);
      assertEquals(expected[1],testET.getRelatedFieldsArray()[1]);

  }   
}
