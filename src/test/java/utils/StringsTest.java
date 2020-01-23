package utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringsTest {
    Strings strings;
    String tag;
    String pth;
    int pos;
    @Before
    public void init(){
        strings = new Strings();
        tag = "abcdabcf";
        pth = "dab";
    }
    @Test
    public void bf() {
        pos = strings.bf(tag, pth);
    }

    @After
    public void print(){
        System.out.println(pos);
    }
}