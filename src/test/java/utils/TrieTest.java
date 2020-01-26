package utils;

import org.junit.Before;
import org.junit.Test;

public class TrieTest {
    Trie trie;

    @Before
    public void init() {
        trie = new Trie();
        insert();
    }


    @Test
    public void insert() {
        String[] str = {"her", "he", "text", "ok", "love", "you"};
        for (String s : str) {
            trie.insert(s.toCharArray());
        }
    }

    @Test
    public void find() {
        boolean result = trie.find("ok".toCharArray());
        System.out.println(result);
    }
}