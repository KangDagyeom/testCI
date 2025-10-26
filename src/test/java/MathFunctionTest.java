import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.example.test.MathFunction;

public class MathFunctionTest {
    @Test
    public void normalTest() {
        assertEquals(500500, MathFunction.tinhtong());
    }

    @Test
    public void testOnDinh() {
        int result1 = MathFunction.tinhtong();
        int result2 = MathFunction.tinhtong();
        assertEquals(result1, result2);
    }

    @Test
    public void testMaxValue() {
        int result1 = MathFunction.tinhtong();

        assertTrue(result1 < Integer.MAX_VALUE, "Gia tri khong vuot qua kieu int");
    }

    @Test
    public void testMaxBien() {
        int expected = 1000 * (1000 + 1) / 2;
        assertEquals(expected, MathFunction.tinhtong());
    }

    @Test
    public void testMaxBienGauss() {
        int n = 1000;
        int expected = n * (n + 1) / 2;
        assertEquals(expected, MathFunction.tinhtong());
    }

    @Test
    public void testBienMin() {
        assertEquals(1, MathFunction.tinhtong());
    }
}
