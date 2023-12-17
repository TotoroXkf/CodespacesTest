import org.junit.Test;

public class Tester {
    private Solution solution = new Solution();

    @Test
    public void tes1() {
        assert solution.calculate("1 + 1") == 2;
    }

    @Test
    public void tes2() {
        assert solution.calculate(" 2-1 + 2 ") == 3;
    }

    @Test
    public void tes3() {
        assert solution.calculate("(1+(4+5+2)-3)+(6+8)") == 23;
    }

    @Test
    public void test4() {
        assert solution.calculate("1-(     -2)") == 3;
    }

    @Test
    public void test5() {
        assert solution.calculate("2-(5-6)") == 3;
    }

    @Test
    public void test6() {
        assert solution.calculate("(6)-(8)-(7)+(1+(6))") == -2;
    }
}
