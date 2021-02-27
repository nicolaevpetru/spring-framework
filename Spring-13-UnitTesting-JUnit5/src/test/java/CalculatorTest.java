import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void testCase1() {
        assertEquals(20, 20);

    }

    @Test
    void testCase2() {
//        fail("Not implemented yet");
        assertTrue(Calculator.operator.equals("add"));
    }

    @Test
    void testCase3() {
        assertArrayEquals(new int[]{1, 2, 3}, new int[]{1, 2, 3,});
    }

    @Test
    void testCase4() {
        String nullString = null;
        String notNullString = "not null String";

        assertNull(nullString);
//        assertNotNull(nullString);
        assertNotNull(notNullString);
    }

    @Test
    void testCase5() {
        Calculator c1 = new Calculator();
        Calculator c2 = c1;
        Calculator c3 = new Calculator();

        assertNotSame(c1, c3);
//        assertNotSame(c1, c2);
        assertSame(c1, c2);

    }

    @Test
    void add() {
        int actual = Calculator.add(2, 3);
        assertEquals(5, actual);
    }


}