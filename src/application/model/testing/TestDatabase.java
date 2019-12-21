package src.application.model.testing;

import org.junit.Test;
import org.junit.Before;

import src.application.model.Database;

import static org.junit.Assert.*;

public class TestDatabase  {

    private Database TestDB;

    @Before
    public void setup() {
        this.TestDB = new Database();
    }

    @Test
    public void testGetFilename() {
        String expected = "Family.txt";
        String actual = TestDB.getFilename();

        assertEquals(actual, expected);
    }
}
