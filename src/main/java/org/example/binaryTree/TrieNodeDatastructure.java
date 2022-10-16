package org.example.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class TrieNodeDatastructure {
    private TrieNode root;

  /*  1) Set a current node as a root node
    2) Set the current letter as the first letter of the word
    3) If the current node has already an existing reference to the current letter (through one of the elements in the “children” field),
    then set current node to that referenced node. Otherwise, create a new node, set the letter equal to the current letter,
    and also initialize current node to this new node
    4) Repeat step 3 until the key is traversed
    */
    public void insert(String word) {
        TrieNode current = root;

        for (char l : word.toCharArray()) {
            current = current.getChildren().computeIfAbsent(l, c -> new TrieNode());
        }
        current.setEndOfWord(true);
    }


/*    Get children of the root
    Iterate through each character of the String
    Check whether that character is already a part of a sub-trie. If it isn't present anywhere in the trie, then stop the search and return false
    Repeat the second and the third step until there isn't any character left in the String. If the end of the String is reached, return true*/
    public boolean find(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.getChildren().get(ch);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return current.isEndOfWord();
    }



    public void delete(String word) {
        delete(root, word, 0);
    }

/*    Check whether this element is already part of the trie
    If the element is found, then remove it from the trie*/
    private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.isEndOfWord()) {
                return false;
            }
            current.setEndOfWord(false);
            return current.getChildren().isEmpty();
        }
        char ch = word.charAt(index);
        TrieNode node = current.getChildren().get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1) && !node.isEndOfWord();

        if (shouldDeleteCurrentNode) {
            current.getChildren().remove(ch);
            return current.getChildren().isEmpty();
        }
        return false;
    }
    public List<String> suggest(String prefix) {
        List<String> list = new ArrayList<>();
        TrieNode lastNode = root;
        StringBuffer curr = new StringBuffer();
        for (char c : prefix.toCharArray()) {
            lastNode = lastNode.getChildren().get(c);
            if (lastNode == null)
                return list;
            curr.append(c);
        }
        suggestHelper(lastNode, list, curr);
        return list;
    }

    public void suggestHelper(TrieNode root, List<String> list, StringBuffer curr) {
        if (root.isWord()) {
            list.add(curr.toString());
        }

        if (root.getChildren() == null || root.getChildren().isEmpty())
            return;

        for (TrieNode child : root.getChildren().values()) {
            suggestHelper(child, list, curr.append(child.getChildren()));
            curr.setLength(curr.length() - 1);
        }
    }
}
