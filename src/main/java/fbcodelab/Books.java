package fbcodelab;

import java.util.*;

/**
 * Created by Sergii_Zelenin on 1/5/2017.
 */
public class Books {
    public int books(List<Integer> a, int b) {
        if (a.size() < b) {
            return -1;
        }
        int start = 0;
        int booksAvailable = a.size() - b + 1;
        int endBooksIdx = start + booksAvailable;
        Map<Key, Integer> cache = new HashMap<>();
        return findMinMax(start, endBooksIdx, 0, b, a, cache);
    }

    //start - inclusive, end - exclusive
    int findMinMax(int start, int end, int student, int maxStudents, List<Integer> books, Map<Key, Integer> cache) {
        if (cache.containsKey(new Key(start, end))) {
            return cache.get(new Key(start, end));
        }
        if (student == maxStudents - 1) {
            int sum = sum(start, end, books);
            cache.put(new Key(start, end), sum);
            return sum;
        }
        //current student can take N books starting from k position
        //sum(k..k+n) + findMinMax(available - n, student + 1) - find
        int min = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            int sum = sum(start, i + 1, books);
            int booksAvailable = books.size() - (i + 1) - (maxStudents - student -1 -1);
            int endBooksIdx = i + 1 + booksAvailable;
            int max = Math.max(sum, findMinMax(i + 1, endBooksIdx, student + 1, maxStudents, books, cache));
            min = Math.min(min, max);
        }
        cache.put(new Key(start, end), min);
        return min;
    }

    //find sum from start(inclusive) to end (exclusive)
    private int sum(int start, int end, List<Integer> books) {
        int sum = 0;
        for (int i=start;i<end;i++) {
            sum += books.get(i);
        }
        return sum;
    }

    private class Key {
        private final int start;
        private final int end;

        public Key(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int hashCode() {
            return 31*start + end;
        }

        public boolean equals(Object o) {
            Key k = (Key) o;
            return k.start == start && k.end == end;
        }

    }
}
