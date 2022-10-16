package org.example.binaryTree;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
@Getter@Setter
public class TrieNode {
    private HashMap<Character, TrieNode> children;
    private String content;
    private boolean isWord;
    private boolean endOfWord;


}
