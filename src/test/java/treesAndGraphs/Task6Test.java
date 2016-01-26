package treesAndGraphs;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by szelenin on 1/25/2016.
 */
public class Task6Test {
    @Test
    public void should(){
        assertNull(Task6.next(null));
        assertNull(Task6.next(new TreeNode(1)));
    }

    @Test
    public void should2(){
        TreeNode one = new TreeNode(1);
        one.parent = new TreeNode(one, null, "2");

        assertEquals("2", Task6.next(one).name);
    }

    @Test
    public void should3(){
        TreeNode three = new TreeNode(3);
        TreeNode two = new TreeNode(null, three, "2");
        three.parent = two;

        assertEquals("3", Task6.next(two).name);
    }

    @Test
    public void should4(){
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(three, null, "4");
        three.parent = four;
        TreeNode two = new TreeNode(null, four, "2");
        four.parent = two;

        assertNull(Task6.next(four));
    }

    @Test
    public void should5(){
        TreeNode three = new TreeNode(3);
        TreeNode two = new TreeNode(null, three, "2");
        three.parent = two;
        TreeNode one = new TreeNode(null, two, "1");
        TreeNode four = new TreeNode(one, null, "4");

        assertNull(Task6.next(four));
    }


}