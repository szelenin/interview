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
        int[][] cache = new int[a.size()][a.size()];
        return findMinMax(start, endBooksIdx, 0, b, a, cache);
    }

    //start - inclusive, end - exclusive
    int findMinMax(int start, int end, int student, int maxStudents, List<Integer> books, int[][] cache) {
        if (cache[start][end - 1] > 0) {
            return cache[start][end - 1];
        }
        if (student == maxStudents - 1) {
            cache[start][end - 1] = sum(start, end, books);
            return cache[start][end - 1];
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
        cache[start][end - 1] = min;
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

    private int findMaxPages(List<List<Integer>> studentAlloc) {
        int max = 0;
        for (List<Integer> books : studentAlloc) {
            Optional<Integer> sum = books.stream().reduce((i1, i2) -> i1 + i2);
            max = Math.max(sum.get(), max);
        }
        return max;
    }

    private List<List<List<Integer>>> createBookAlloc(List<Integer> books, int total, Map<List<Integer>, List<List<List<Integer>>>> cache) {
        if (cache.containsKey(books)) {
            return cache.get(books);
        }
        List<List<List<Integer>>> result = new ArrayList<>();
        if (total == 1) {
            List<List<Integer>> lastBooks = new ArrayList<>();
            lastBooks.add(books);
            result.add(lastBooks);
            cache.put(books, result);
            System.out.println("books" + books + ":" + result);
            return result;
        }
        List<Integer> availableForMe = books.subList(0, books.size() - total + 1);
        for (int i = 1; i <= availableForMe.size(); i++) {
            List<Integer> booksTaken = availableForMe.subList(0, i);
            List<Integer> booksForOthers = books.subList(i, books.size());
            List<List<List<Integer>>> othersDistribution = createBookAlloc(booksForOthers, total - 1, cache);
            for (List<List<Integer>> others : othersDistribution) {
                //others + booksTaken
                List<List<Integer>> othersCopy = new ArrayList<>(others);
                othersCopy.add(booksTaken);
                result.add(othersCopy);
            }
        }
        cache.put(books, result);
        System.out.println("books" + books + ":" + result);
        return result;
    }
}
