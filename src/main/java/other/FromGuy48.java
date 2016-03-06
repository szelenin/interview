package other;

import org.junit.runner.manipulation.Sortable;

import java.util.*;

/**
 * Created by szelenin on 2/19/2016.
 */
public class FromGuy48 {

    public static List<Integer> lis(List<Integer> seq) {
        LinkedList<Integer>[] paths = new LinkedList[seq.size()];
        paths[0] = new LinkedList<>(Collections.singletonList(seq.get(0)));

        for (int i = 1; i < seq.size(); i++) {
            Integer current = seq.get(i);
            LinkedList<List<Integer>> potentialPaths = new LinkedList<>();
            potentialPaths.add(Collections.singletonList(current));
            for (int j = 0; j < i; j++) {
                if (current > paths[j].getLast()) {
                    LinkedList<Integer> potentialPath = new LinkedList<>(paths[j]);
                    potentialPath.add(current);
                    potentialPaths.add(potentialPath);
                }
            }
            paths[i] = new LinkedList<>(potentialPaths.stream().max((p1, p2) -> p1.size() - p2.size()).get());
        }
        Optional<LinkedList<Integer>> maxPath = Arrays.asList(paths).stream().max((path1, path2) -> path1.size() - path2.size());
        return maxPath.get();
    }
}
