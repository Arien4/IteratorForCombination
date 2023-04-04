package practice;

// Design the CombinationIterator class:
// CombinationIterator(string characters, int combinationLength) Initializes the object with a string
// characters of sorted distinct lowercase English letters and a number combinationLength as arguments.
// next() Returns the next combination of length combinationLength in lexicographical order.
// hasNext() Returns true if and only if there exists a next combination.

// Example:
// Input
// ["CombinationIterator", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
// [["abc", 2], [], [], [], [], [], []]
// Output
// [null, "ab", true, "ac", true, "bc", false]

// Explanation
// CombinationIterator itr = new CombinationIterator("abc", 2);
// itr.next();    // return "ab"
// itr.hasNext(); // return True
// itr.next();    // return "ac"
// itr.hasNext(); // return True
// itr.next();    // return "bc"
// itr.hasNext(); // return False

// Constraints:
// 1 <= combinationLength <= characters.length <= 15
// All the characters of characters are unique.
// At most 104 calls will be made to next and hasNext.
// It is guaranteed that all calls of the function next are valid.

public class Main {

    public static void main(String[] args) {
        String characters = "abc";
        int combinationLength = 2;
        CombinationIterator obj = new CombinationIterator(characters, combinationLength);
//        String param_1 = obj.next();
//        boolean param_2 = obj.hasNext();
        while (obj.hasNext()) System.out.println(obj.next());
    }
}
