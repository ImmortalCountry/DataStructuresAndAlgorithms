package utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringsTest {
    String tag;
    String pth;
    int pos;

    @Before
    public void init() {
        tag = "abcdabcf";
        pth = "b";
    }

    @Test
    public void bf() {
        pos = Strings.bf(tag.toCharArray(), pth.toCharArray());
    }

    @Test
    public void bm() {
        pos = Strings.bm(tag.toCharArray(), pth.toCharArray());
    }

    @After
    public void print() {
        System.out.println(pos);
    }
}