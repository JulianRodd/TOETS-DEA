package project;

import java.util.ArrayList;

public class PrimeTestingApp {

    public static final int LENGTH = 4;
    private static final int HIGHEST_NUMBER_TO_TEST = 200;

    public static void main(String[] args) {

       ArrayList<PrimeTester> primeTesters = new ArrayList<PrimeTester>();
        ArrayList<Thread> threads = new ArrayList<Thread>();
       NumberUnderTest nummerOnderTest =  new NumberUnderTest();
      for(int i = 0; i<LENGTH; i++) {
           primeTesters.add(new PrimeTester(nummerOnderTest,HIGHEST_NUMBER_TO_TEST));
        }
        Runnable runnable;

        for(int i = 0; i< LENGTH; i++) {
            int finalI = i;
             runnable = () -> {
                 try {
                     primeTesters.get(finalI).startTesting();
                 } catch (OuchIFoundThirtySevenAndHenceMustDieException e) {
                     System.out.println("Hallo meneer, nummer 37 is niet toegestsaan!!!!!!");
                 }
             };
            threads.add(new Thread(runnable));
        }
        for(int i = 0; i< LENGTH; i++) {
            threads.get(i).start();
        }
    }

    private void startTesting() throws OuchIFoundThirtySevenAndHenceMustDieException {
        var numberUnderTest = new NumberUnderTest();

        var tester = new PrimeTester(numberUnderTest, HIGHEST_NUMBER_TO_TEST);

        tester.startTesting();
    }
}
