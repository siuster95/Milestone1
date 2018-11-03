import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.io.*;
public class MainTester{


public static void main(String[] args) {
boolean helpBool = false;
boolean commandBool = false;
boolean fileBool = false;
boolean txtBool = false;
for (int x =0; x < args.length; x++)
{
  if (args[x].equals("-h")) 
  {
    helpBool = true;
  }
  if (args[x].equals("-n")) 
  {
    commandBool = true;
  }
  if (args[x].equals("-f"))
  {
    fileBool = true;
  }
  if (args[x].contains(".txt"))
  {
    txtBool = true;
  }
}
if (commandBool == true && fileBool == true)
{
  System.out.println("Error: Cannot grab parameters from both command line and file. Pick one or the other");
}
else if(helpBool == false) {
JUnitCore junitCore = new JUnitCore();
String defaultTestObj1 = "5|Hello";
String defaultTestObj2 = "1|TestEdgeField";
if (commandBool == false && fileBool == false)
{
  System.setProperty("EdgeTableTestParams", defaultTestObj1);
  System.setProperty("EdgeFieldTestParams", defaultTestObj2);
} else if (commandBool == true && txtBool == false) 
{
  String TestObj1 = args[1];
  String TestObj2 = args[2];
  System.setProperty("EdgeTableTestParams", TestObj1);
  System.setProperty("EdgeFieldTestParams", TestObj2);
} else if (fileBool == true && txtBool == true)
{
  String TestObj1 = "";
  String TestObj2 = "";
  int x = 1;
  try{
  File file = new File(args[1]);
  FileReader fileReader = new FileReader(file);
  BufferedReader bufferedReader = new BufferedReader(fileReader);
  String line;
  while ((line = bufferedReader.readLine()) != null)
  {
    if (x == 1)
    {
      TestObj1 = line;
    }
    else if (x ==2)
    {
      TestObj2 = line;
    }
  }
  }
  catch (FileNotFoundException ex) {
    System.out.println(ex);
  }
  catch (IOException ex) {
    System.out.println(ex);
  }
  System.setProperty("EdgeTableTestParams", TestObj1);
  System.setProperty("EdgeFieldTestParams", TestObj2);
}
Result result = junitCore.runClasses(NewEdgeFieldTest.class);
Result result2 = junitCore.runClasses(NewEdgeTableTest.class);
System.out.println(result.wasSuccessful());
System.out.println(result2.wasSuccessful());
  for (Failure failure : result2.getFailures()) {
   // System.out.println(failure.getMessage());
   // System.out.println(failure.getTrace());
}
}
else  if (helpBool == true)
  {
    System.out.println("input -h on the command line to get more info of commands");
    System.out.println("input -n follow by 2 strings to input the parameters needed for both test through the command line (first one for EdgeTableTest, second one for EdgeFieldTest)");
    System.out.println("input -f follow by a text file name to input the parameters needed for both test through a text file");
  }
  }
}
