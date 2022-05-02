package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class firstTest {
    @Test
    public void monPremierTest() {
        // OK
        Assertions.assertEquals(2, 1+1);
    }
    @Test
    public void monSecondTest() {
        // KO
        Assertions.assertEquals(3, 5-1);
    }
    public void monTroisTest() {

    }
}