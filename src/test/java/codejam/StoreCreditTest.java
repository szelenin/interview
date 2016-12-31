package codejam;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Created by Sergii_Zelenin on 12/30/2016.
 */
public class StoreCreditTest {
    @Test
    public void testRunSolutions() throws IOException {
        ByteArrayOutputStream bytesOut = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(bytesOut);
        StoreCredit.runSolutions(new ByteArrayInputStream("3\n100\n3\n5 75 25\n200\n7\n150 24 79 50 88 345 3\n8\n8\n2 1 9 4 4 56 90 3".getBytes()), out);
        out.flush();
        assertEquals("Case #1: 2 3\r\nCase #2: 1 4\r\nCase #3: 4 5", bytesOut.toString().trim());
    }

    @Test
    public void testSolution1(){
        int[] result = StoreCredit.solve(100, new int[]{5, 75, 25});
        assertEquals(2, result[0]);
        assertEquals(3, result[1]);
    }

}