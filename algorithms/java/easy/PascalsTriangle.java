package easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        List<List<Integer>> expectedOutput = new ArrayList<>();
        expectedOutput.add(List.of(1));
        expectedOutput.add(List.of(1, 1));
        expectedOutput.add(List.of(1, 2, 1));
        expectedOutput.add(List.of(1, 3, 3, 1));
        expectedOutput.add(List.of(1, 4, 6, 4, 1));
        assert expectedOutput.equals(new PascalsTriangle().first(5));
        assert expectedOutput.equals(new PascalsTriangle().second(5));
    }

    public List<List<Integer>> first(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(List.of(1));
        if (numRows == 1) {
            return result;
        }
        Deque<List<Integer>> deque = new ArrayDeque<>();
        deque.push(result.get(0));
        for (int i = 1; i < numRows; i++) {
            var pop = deque.pop();
            var pushedList = new ArrayList<Integer>();
            pushedList.add(pop.get(0));
            for (int j = 0; j < pop.size() - 1; j++) {
                pushedList.add(pop.get(j) + pop.get(j + 1));
            }
            pushedList.add(pop.get(pop.size() - 1));
            result.add(pushedList);
            deque.push(pushedList);
        }
        return result;
    }

    public List<List<Integer>> second(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows <= 0) {
            return result;
        }
        ArrayList<Integer> prev = new ArrayList<>();
        prev.add(1);
        result.add(prev);
        for (int i = 2; i <= numRows; i++) {
            ArrayList<Integer> curr = new ArrayList<>();
            curr.add(1);
            for (int j = 0; j < prev.size() - 1; j++) {
                curr.add(prev.get(j) + prev.get(j + 1));
            }
            curr.add(1);
            result.add(curr);
            prev = curr;
        }
        return result;
    }
}
