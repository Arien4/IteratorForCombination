package practice;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CombinationIterator {
    ArrayDeque<Character> stack;
    Map<Character, Integer> charToIndex;
    String result, str; // str - same as characters. result - the result string representing a combination
    int combinationLength; // same as combinationLength

    public CombinationIterator(String characters, int combinationLength) {

        this.combinationLength = combinationLength;
        charToIndex = new HashMap<>();
        str = characters;
        stack = new ArrayDeque<>();
        result = "";
        // create the first combination
        for (Character ch : characters.toCharArray()) {
            stack.push(ch);
            result = result + ch;
            if (stack.size() == combinationLength) break;
        }
        int idx = 0;
        // set up the mapping between character --> index
        for (Character ch : characters.toCharArray()) {
            charToIndex.put(ch, idx++);
        }
    }

    public String next() {
        String currResult = result;
        // process the next result

        int idx = str.length() - 1;
        // keep on removing the last character from the stack/result till the position where idx can be moved ahead
        while (!stack.isEmpty() && charToIndex.get(stack.peek()) == idx) {
            stack.pop();
            idx--;
            result = result.substring(0, result.length() - 1);
        }
        if (stack.isEmpty()) return currResult; // there is no next result to pre-process

        idx = charToIndex.get(stack.pop()); // we need to add elements after this idx
        result = result.substring(0, result.length() - 1);

        while (stack.size() != combinationLength) {
            Character temp = str.charAt(++idx);
            result += temp;
            stack.push(temp);
        }

        return currResult;
    }

    public boolean hasNext() {
        return !stack.isEmpty();

    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
