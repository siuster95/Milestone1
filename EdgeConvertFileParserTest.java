import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.After;
import java.io.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EdgeConvertFileParserTest {

  private int numberOfTables = 0;
  private int numberOfFields = 0;
  private FileReader fr;
  private BufferedReader br;
  private String fileName = "./Courses.edg";

  
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
	numberOfTables = numberOfTables + 1;
      } 
      else if (line.contains("Attribute")) {
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
  @Test
  public void testFileExists () {
  File file = new File(fileName);
  boolean exists = file.exists();
  assertEquals(true, exists);
  }
  @Test
  public void testFileisnotEmpty () {
  File file = new File(fileName);
  long fileLength = file.length();
  boolean fileLengthBool = fileLength == 0;
  assertEquals(false, fileLengthBool);
  }
  @Test
  public void testGetEdgeTables () {
  File file = new File(fileName);
  EdgeConvertFileParser Converter = new EdgeConvertFileParser(file);
  getTablesandFieldAmounts();
  EdgeTable[] edgeTables = Converter.getEdgeTables();
  assertEquals(numberOfTables, edgeTables.length);
  }
  @Test
  public void testGetEdgeFields () {
  File file = new File(fileName);
  EdgeConvertFileParser Converter = new EdgeConvertFileParser(file);
  getTablesandFieldAmounts();
  EdgeField[] edgeFields = Converter.getEdgeFields();
  assertEquals(numberOfFields, edgeFields.length);
  }
}
