package datastructure.trie.programs;

import datastructure.trie.TrieDS;

public class TrieBasics {

    public static void main(String[] args) {
	TrieDS trie = new TrieDS();
	trie.insertWord("saurabh");
	trie.insertWord("sandy");

	System.out.println(trie.search("sandy"));

    }

}
