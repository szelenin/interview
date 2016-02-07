package bitManipulation;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by szelenin on 2/7/2016.
 */
public class BmTask8Test {
    @Test
    public void should() {
        assertEquals((byte) 0b11110000, draw(0, 3, 0, 2)[0]);
        byte[] bytes = draw(8, 10, 0, 2);
        assertEquals(0, bytes[0]);
        assertEquals((byte) 0b11100000, bytes[1]);
    }

    @Test
    public void should2() {
        byte[] bytes = draw(5, 10, 0, 2);
        assertEquals((byte) 0b00000111, bytes[0]);
        assertEquals((byte) 0b11100000, bytes[1]);
    }

    @Test
    public void should3() {
        byte[] bytes = BmTask8.drawLine(5, 18, 0, 3, new byte[]{0, 0, 0, 0, 0, 0});
        assertEquals((byte) 0b00000111, bytes[0]);
        assertEquals((byte) 0b11111111, bytes[1]);
        assertEquals((byte) 0b11100000, bytes[2]);
    }

    private byte[] draw(int x1, int x2, int y, int w) {
        return BmTask8.drawLine(x1, x2, y, w, new byte[]{0, 0, 0, 0});
    }

}