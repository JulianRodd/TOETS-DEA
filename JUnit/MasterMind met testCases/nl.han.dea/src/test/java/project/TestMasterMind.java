package project;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestMasterMind {


    private MasterMind sut;

    @BeforeAll
    void BeforeAll(){
        sut = new MasterMind(4);
    }

    @Test
    public void testAlCorrect(){

        // Test.
        sut.code[0] = 'y';
        sut.code[1] ='y';
        sut.code[2] ='y';
        sut.code[3] ='y';
        sut.radende[0] ='y';
        sut.radende[1] ='y';
        sut.radende[2] ='y';
        sut.radende[3] ='y';
        // Verify.
        sut.validateInput();
        Assertions.assertEquals(4, sut.aantalCorrect);
    }
    @Test
    public void test2Correct2WrongPlace(){

        // Test.
        sut.code[0] = 'y';
        sut.code[1] ='y';
        sut.code[2] ='g';
        sut.code[3] ='r';
        sut.radende[0] ='y';
        sut.radende[1] ='y';
        sut.radende[2] ='r';
        sut.radende[3] ='g';
        // Verify.
        sut.validateInput();
        Assertions.assertEquals(2, sut.aantalCorrect);
        Assertions.assertEquals(2, sut.aantalFoutePlek);
    }
    @Test
    public void testNoneCorrectTwoWrongPlace(){

        // Test.
        sut.code[0] = 'b';
        sut.code[1] ='b';
        sut.code[2] ='r';
        sut.code[3] ='r';
        sut.radende[0] ='y';
        sut.radende[1] ='y';
        sut.radende[2] ='b';
        sut.radende[3] ='b';
        // Verify.
        sut.validateInput();
        Assertions.assertEquals(0, sut.aantalCorrect);
        Assertions.assertEquals(2, sut.aantalFoutePlek);
    }
    @Test
    public void testFourWrongPlace(){

        // Test.
        sut.code[0] = 'y';
        sut.code[1] ='r';
        sut.code[2] ='g';
        sut.code[3] ='b';
        sut.radende[0] ='r';
        sut.radende[1] ='g';
        sut.radende[2] ='b';
        sut.radende[3] ='y';
        // Verify.
        sut.validateInput();
        Assertions.assertEquals(0, sut.aantalCorrect);
        Assertions.assertEquals(4, sut.aantalFoutePlek);
    }
    @Test
    public void testNoneCorrect(){

        // Test.
        sut.code[0] = 'y';
        sut.code[1] ='y';
        sut.code[2] ='y';
        sut.code[3] ='y';
        sut.radende[0] ='b';
        sut.radende[1] ='b';
        sut.radende[2] ='b';
        sut.radende[3] ='b';
        // Verify.
        sut.validateInput();
        Assertions.assertEquals(0, sut.aantalCorrect);
        Assertions.assertEquals(0, sut.aantalFoutePlek);
    }


}
