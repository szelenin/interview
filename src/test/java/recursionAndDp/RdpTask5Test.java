package recursionAndDp;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by szelenin on 2/20/2016.
 */
public class RdpTask5Test {
    @Test
    public void shouldReturnAllPerms(){
        assertEquals("[ba, ab]", RdpTask5.allPermutations("ab").toString());
        assertEquals("[cba, bca, bac, cab, acb, abc]", RdpTask5.allPermutations("abc").toString());
    }

}