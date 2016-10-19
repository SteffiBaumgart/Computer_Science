/**
 * Created by Baumgart on 2015/09/16.
 */

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**1. A test that getName() returns the value set using setName().
   2. A test that, if all marks are 0, the final mark is 0.
   3. A test that, if all marks are 100, the final mark is 100.
   4. A test that the final mark is correctly calculated for all marks being between 0 and 100. **/


public class CSC1016STest {

    CSC1016S cs = new CSC1016S();

    public CSC1016STest() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void testGetName() {
        this.cs.setName("Sarah");
        Assert.assertEquals("Sarah", this.cs.getName());
    }

    @Test
    public void testZeroMarks() {
        this.cs.setMark("pracs", 0);
        this.cs.setMark("practests", 0);
        this.cs.setMark("tests", 0);
        this.cs.setMark("exam", 0);
        Assert.assertEquals(0.0D, (double) this.cs.getFinal(), 0.0D);
    }

    @Test
    public void testFullMarks() {
        this.cs.setMark("pracs", 100);
        this.cs.setMark("practests", 100);
        this.cs.setMark("tests", 100);
        this.cs.setMark("exam", 100);
        Assert.assertEquals(100.0D, (double) this.cs.getFinal(), 0.0D);
    }

    @Test
    public void testRest() {
        this.cs.setMark("pracs", 34);
        this.cs.setMark("practests", 66);
        this.cs.setMark("tests", 92);
        this.cs.setMark("exam", 70);
        Assert.assertEquals(67.5D, (double) this.cs.getFinal(), 0.0D);
    }
}

