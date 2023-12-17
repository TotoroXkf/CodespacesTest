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
}
