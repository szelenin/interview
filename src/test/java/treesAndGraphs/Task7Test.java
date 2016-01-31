package treesAndGraphs;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by szelenin on 1/26/2016.
 */
public class Task7Test {
    @Test
    public void should(){
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode two = new TreeNode(three, four, "2");
        four.parent = two;
        three.parent = two;

        TreeNode five = new TreeNode(5);
        TreeNode one = new TreeNode(two, five, "1");
        two.parent = one;
        five.parent = one;

        TreeNode zero = new TreeNode(one, null, "0");
        one.parent = zero;

        assertEquals(2, Task7.findCommon(three, four).value());
        assertEquals(2, Task7.findCommon(four, three).value());

        assertEquals(1, Task7.findCommon(three, five).value());
        assertEquals(1, Task7.findCommon(four, five).value());
        assertEquals(1, Task7.findCommon(three, two).value());
        assertEquals(1, Task7.findCommon(two, three).value());
        assertNull(Task7.findCommon(zero, five));
        assertNull(Task7.findCommon(five, zero));
    }

    @Test
    public void should_FromBook(){
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode two = new TreeNode(three, four, "2");

        TreeNode five = new TreeNode(5);
        TreeNode one = new TreeNode(two, five, "1");

        TreeNode zero = new TreeNode(one, null, "0");

        assertEquals(2, Task7.commonAncestorBad(zero, three, four).value());
//        assertEquals(2, Task7.commonAncestorBad(zero, four, three).value());
//
//        assertEquals(1, Task7.commonAncestorBad(zero, three, five).value());
        assertEquals(1, Task7.commonAncestorBad(zero, four, five).value());
        assertEquals(1, Task7.commonAncestorBad(zero, three, two).value());
        assertEquals(1, Task7.commonAncestorBad(zero, two, three).value());
        assertNull(Task7.commonAncestorBad(zero, zero, five));
        assertNull(Task7.commonAncestorBad(zero, five, zero));
    }

}