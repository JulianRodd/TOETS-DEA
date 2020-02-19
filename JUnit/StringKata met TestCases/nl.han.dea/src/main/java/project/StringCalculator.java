package project;
import java.util.ArrayList;
/**
 * Hello world!
 *
 */
public class StringCalculator {

    public int add(String numbers) throws JulianException {
        numbers = numbers.replace(" ", "");
        var count = 0;
        if(numbers==""){
            return count;
        }
        String[] nummers;
        nummers = numbers.split(",");
        for (var number : nummers) {
            try {
                count += Integer.parseInt(number.strip());
            } catch (NumberFormatException e) {
                throw new JulianException("Er is een verkeerd nummer gegeven. " + number + " is geen geldig getal.");
            }

        }
        return count;
    }
}
