import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.io.*;
import java.io.File;
import java.nio.file.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
public class CreateDDLMySQLTest{

private EdgeTable[] edgeTables;
private EdgeField[] edgeFields;
  @Before
  public void Setup() {
  File file = new File("./Courses.edg");
  EdgeConvertFileParser Converter = new EdgeConvertFileParser(file);
  edgeTables = Converter.getEdgeTables();
  for(int i =0; i < edgeTables.length; i++) {
    edgeTables[i].makeArrays();
  }
  edgeFields = Converter.getEdgeFields();
  }

  @Test
 public void test(){
    CreateDDLMySQL mysql = new CreateDDLMySQL(edgeTables, edgeFields);
    mysql.generateDatabaseName();
    assertEquals("test", mysql.getDatabaseName());
  // System.out.print(mysql.getDatabaseName());
 // }
  @Test
  public void test2(){
    CreateDDLMySQL mysql2 = new CreateDDLMySQL(edgeTables, edgeFields);
    //mysql2.createDDL();
    try{
   File file = new File("./file.txt");

    String text = "";

    byte[] encoded  = Files.readAllBytes(Paths.get("./file.txt"));
    text = new String(encoded, StandardCharsets.UTF_8.name());
    
   // File file2 = new File("./file2.txt");
   // FileWriter writer2 = new FileWriter(file2);
   // StringWriter expectedStringWriter = new StringWriter();
  // PrintWriter printWriter = new PrintWriter(expectedStringWriter);
   
    /*
    printWriter.println("CREATE DATABASE test;");
    printWriter.println("USE test;");
    printWriter.println("CREATE TABLE STUDENT (");
    printWriter.println('\t' + "StudentSSN VARCHAR(1),");
    printWriter.println('\t' + "StudentName VARCHAR(1),");
    printWriter.println(");");
    printWriter.println("");
    printWriter.println("CREATE TABLE FACULTY (");
printWriter.println('\t' + "FacultyName VARCHAR(1),");
printWriter.println('\t' + "FacSSN VARCHAR(1),");
printWriter.println(");");
printWriter.println("");
printWriter.println("CREATE TABLE COURSES (");
printWriter.println('\t' + "Grade VARCHAR(1),");
printWriter.println('\t' + "Number VARCHAR(1),");
printWriter.println(");");
printWriter.println("");
 // printWriter.print(mysql2.getSQLString());
 printWriter.close();
*/
/*
String expected = expectedStringWriter.toString();
writer2.write(expectedStringWriter.toString());
writer2.close();
*/

assertEquals(text, mysql2.getSQLString());

//System.out.println(expected + "a");
    }catch(IOException ioe){
      
    }//trycatch
  }//public test2
}

