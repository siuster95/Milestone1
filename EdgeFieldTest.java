import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EdgeFieldTest{
    EdgeField testObj;

    @Before
	public void setUp() throws Exception {
        testObj = new EdgeField("1|TestEdgeField");
        //runner();
    }
    
    public void runner() {
        //test functions go here
        testGetNumFigure();
        testGetName();
        testGetTableID();
        testSetTableID();
        testGetTableBound();
        testSetTableBound();
        testGetFieldBound();
        testSetFieldBound();
        testGetDisallowNull();
        testSetDisallowNull();
        testGetIsPrimaryKey();
        testSetIsPrimaryKey();
        testGetDefaultValue();
        testSetDefaultValue();
        testGetVarcharValue();
        testSetVarcharValue();
        testGetDataType();
        testSetDataType();
        testToString();

    }
    
    /*
    @Test
	public void testExample() {
		assertEquals("test description",val1,val2);
    }
    */

    // test all getters and setters in class

    @Test
	public void testGetNumFigure() {
		assertEquals("num figure was initialized to 1 so it should be 1",1,testObj.getNumFigure());
    }
    @Test
	public void testGetName() {
		assertEquals("name was initialized to 1 so it should be 1","TestEdgeField",testObj.getName());
    }
    @Test
	public void testGetTableID() {
		assertEquals("table id is initialized to 0 so it should be 0",0,testObj.getTableID());
    }
    @Test
	public void testSetTableID() {
        testObj.setTableID(1);
		assertEquals("table id should be what you set it to",1,testObj.getTableID());
    }
    @Test
	public void testGetTableBound() {
		assertEquals("table bound was initialized to 0 so it should be 0",0,testObj.getTableBound());
    }
    @Test
	public void testSetTableBound() {
        testObj.setTableBound(1);
		assertEquals("table bound should be what you set it to",1,testObj.getTableBound());
    }
    @Test
	public void testGetFieldBound() {
		assertEquals("field bound was initialized to 0 so it should be 0",0,testObj.getFieldBound());
    }
    @Test
	public void testSetFieldBound() {
        testObj.setFieldBound(1);
		assertEquals("field bound should be what you set it to",1,testObj.getFieldBound());
    }
    @Test
	public void testGetDisallowNull() {
		assertEquals("disallow null was initialized to false so it should be false",false,testObj.getDisallowNull());
    }
    @Test
	public void testSetDisallowNull() {
        testObj.setDisallowNull(true);
		assertEquals("disallow null should be what you set it to",true,testObj.getDisallowNull());
    }
    @Test
	public void testGetIsPrimaryKey() {
		assertEquals("is primary key was initialized to false so it should be false",false,testObj.getIsPrimaryKey());
    }
    @Test
	public void testSetIsPrimaryKey() {
        testObj.setIsPrimaryKey(true);
		assertEquals("is primary key should be what you set it to",true,testObj.getIsPrimaryKey());
    }
    @Test
	public void testGetDefaultValue() {
		assertEquals("default value null was initialized to '' so it should be ''","",testObj.getDefaultValue());
    }
    @Test
	public void testSetDefaultValue() {
        testObj.setDefaultValue("test");
		assertEquals("disallow null should be what you set it to","test",testObj.getDefaultValue());
    }
    @Test
	public void testGetVarcharValue() {
		assertEquals("varchar value was initialized to 1 so it should be 1",1,testObj.getVarcharValue());
    }
    @Test
	public void testSetVarcharValue() {
        testObj.setVarcharValue(2);
		assertEquals("varchar should be what you set it to if greater than 0",2,testObj.getVarcharValue());
    }
    @Test
	public void testGetDataType() {
		assertEquals("data type  was initialized to 0 so it should be 0",0,testObj.getDataType());
    }
    @Test
	public void testSetDataType() {
        testObj.setDataType(1);
		assertEquals("data type should be what you set it to",1,testObj.getDataType());
    }
    @Test
    public void testToString() {
        assertTrue("toString return should not be empty",testObj.toString().length() > 0);
    }


}
