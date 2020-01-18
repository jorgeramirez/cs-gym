package datastructures;

// Leetcode problem: https://leetcode.com/problems/implement-trie-prefix-tree/

class Trie {
    Node root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node current = root;

        for(Character ch: word.toCharArray()) {
            current = current.getChild(ch);
        }
        current.val = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node current = root;

        for(Character ch: word.toCharArray()) {
            if(!current.hasChild(ch)){
                return false;
            }
            current = current.getChild(ch);
        }
        return current.val;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node current = root;

        for(Character ch: prefix.toCharArray()) {
            if(!current.hasChild(ch)){
                return false;
            }
            current = current.getChild(ch);
        }
        return true;
    }


    class Node {
        boolean val = false;
        Node[] children = new Node[26];

        Node getChild(char child) {
            if(!hasChild(child)){
                children[child - 'a'] = new Node();
            }
            return children[child - 'a'];
        }

        boolean hasChild(char child) {
            return children[child - 'a'] != null;
        }
    }
}

