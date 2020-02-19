package project;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for simple App.
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StringCalculatorTest
{
    /**
     * Rigorous Test :-)
     */
    private StringCalculator sut;

    @BeforeAll
    void BeforeAll(){
        sut = new StringCalculator();
    }

    @Test
    public void executeWithNoStringInput(){


        // Test.
        var testValue = sut.add("");

        // Verify.
        Assertions.assertEquals(0, testValue);
    }

    @Test
    public void executeWithOneCharAsStringInput(){


        // Test.
        var testValue = sut.add("2");

        // Verify.
        Assertions.assertEquals(2, testValue);
    }

    @Test
    public void executeWithFourCharAsStringInput(){


        // Test.
        var testValue = sut.add("1,20,5,200");

        // Verify.
        Assertions.assertEquals(226, testValue);
    }

    @Test
    public void executeWithFourCharAndSpacesAsStringInput(){


        // Test.
        var testValue = sut.add("1,20                          , 5,200");

        // Verify.
        Assertions.assertEquals(226, testValue);
    }
}
