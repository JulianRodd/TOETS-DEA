package project;

import java.util.ArrayList;

public class PrimeTestingApp {

    private static final int HIGHEST_NUMBER_TO_TEST = 200;

    public static void main(String[] args) {

       ArrayList<PrimeTester> primeTesters = new ArrayList<PrimeTester>();
       NumberUnderTest nummerOnderTest =  new NumberUnderTest();
      for(int i = 0; i<4; i++) {
           primeTesters.add(new PrimeTester(nummerOnderTest,HIGHEST_NUMBER_TO_TEST));
        }
        Runnable runnable;
        for(int i = 0; i<4; i++) {
            int finalI = i;
             runnable = () -> {
                 try {
                     primeTesters.get(finalI).startTesting();
                 } catch (OuchIFoundThirtySevenAndHenceMustDieException e) {
                     System.out.println("Hallo meneer, nummer 37 is niet toegestsaan!!!!!!");
                 }
             };
            var thread1 = new Thread(runnable);
            thread1.start();
        }
    }

    private void startTesting() throws OuchIFoundThirtySevenAndHenceMustDieException {
        var numberUnderTest = new NumberUnderTest();

        var tester = new PrimeTester(numberUnderTest, HIGHEST_NUMBER_TO_TEST);

        tester.startTesting();
    }
}
