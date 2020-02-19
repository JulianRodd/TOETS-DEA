package project;

import org.apache.commons.math3.primes.Primes;

public class PrimeTester {

    NumberUnderTest numberUnderTest;
    int highestNumberToTest;

    public PrimeTester(NumberUnderTest numberUnderTest, int highestNumberToTest) {
        this.numberUnderTest = numberUnderTest;
        this.highestNumberToTest = highestNumberToTest;
    }

    public void startTesting() throws OuchIFoundThirtySevenAndHenceMustDieException {
            while (true) {
                var number = numberUnderTest.getNumber();
                if (number == 37) {
                    throw new OuchIFoundThirtySevenAndHenceMustDieException("Het nummer mag geen 37 zijn.");
                }
                if (number > highestNumberToTest) {
                    break;
                }

                boolean isPrime = Primes.isPrime(number);

                if (isPrime) {
                    System.out.println(Thread.currentThread().getId() + " found a prime number: " + number);
                }
            }

    }
}
