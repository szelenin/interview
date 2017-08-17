package other;

/**
 * Created by Sergii_Zelenin on 7/3/2017.
 */
public class CoderFight2 {

    public static int[] changeRoot(int[] parent, int newRoot) {
        setParent(parent, parent[newRoot], newRoot);
        parent[newRoot] = newRoot;
        return parent;
    }

    private static void setParent(int[] parent, int parentNode, int child) {
        if (parent[parentNode] == parentNode) {
            parent[parentNode] = child;
            return;
        }
        setParent(parent, parent[parentNode], parentNode);
        parent[parentNode] = child;
    }

    public static int[] changeRoot(int[] parent, int newRoot, int prevNewRoot) {
        if (parent[newRoot] == newRoot) {
//            parent[newRoot] = prevNewRoot;
            return parent;
        }
        changeRoot(parent, parent[newRoot], newRoot);
        parent[newRoot] = newRoot;
        return parent;
    }


}
