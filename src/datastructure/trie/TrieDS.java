package datastructure.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * Ideal for storing Directory/Dictionary data and prefix based searches.
 * 
 * @author skedia
 *
 */
public class TrieDS {

    TrieNode root;

    public TrieDS() {
	root = new TrieNode();
    }

    public TrieDS(String word) {
	insertWord(word);
    }

    public void insertWord(String word) {
	TrieNode temp = root;
	insertHelper(word, 0, temp);
    }

    private void insertHelper(String word, int i, TrieNode temp) {
	if (i >= word.length()) {
	    return;
	}
	boolean eow = i == word.length() - 1;
	char c = word.charAt(i);
	TrieNode next = null;
	if (temp.child.containsKey(c))
	    next = temp.child.get(c);
	else {
	    next = new TrieNode(eow);
	    temp.child.put(c, next);
	}
	insertHelper(word, i + 1, next);
    }

    
    public boolean search(String word) {
	TrieNode temp = root;
	return searchHelper(word, 0, temp);
    }

    private boolean searchHelper(String word, int i, TrieNode temp) {
	if (i >= word.length()) {
	    return true && temp.endOfWord;
	}
	char c = word.charAt(i);
	if (temp.child.containsKey(c)) {
	    temp = temp.child.get(c);
	} else
	    return false;
	return searchHelper(word, i + 1, temp);
    }

    class TrieNode {
	Map<Character, TrieNode> child;
	boolean endOfWord;

	public TrieNode() {
	    this.child = new HashMap<>();
	    this.endOfWord = false;
	}

	public TrieNode(boolean endOfWord) {
	    this();
	    this.endOfWord = endOfWord;
	}

	@Override
	public String toString() {
	    return "TrieNode [child=" + child + ", endOfWord=" + endOfWord + "]";
	}
    }

    @Override
    public String toString() {
	return "TrieDS [root=" + root + "]";
    }
}
