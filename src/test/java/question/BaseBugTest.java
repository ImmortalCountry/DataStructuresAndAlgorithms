package question;

import org.junit.Test;

import static org.junit.Assert.*;

public class BaseBugTest {

    @Test
    public void f() {
        int[] a = {2, 3, 1, 6, 7, 2, 12, 20, 50, 15};
        BaseBug.f(0, 0, a, 10, 100);
    }
}