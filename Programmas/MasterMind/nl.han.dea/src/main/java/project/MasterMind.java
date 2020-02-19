package project;

import java.util.Scanner;
import java.util.Random;
import java.util.Scanner;

public class MasterMind {
    public char[] code;
    public char[] radende;
    private int codeLengte;
    Scanner sc;
    int aantalCorrect;
    int aantalFoutePlek;
    String invoerRadende;
public MasterMind(int codeLengte) {
    sc = new Scanner(System.in);
    this.codeLengte = codeLengte;
    code = new char[codeLengte];
    radende = new char[codeLengte];
}
        public void genereerCode() {
            Random rand = new Random();
            int random;
            for (int i = 0; i < codeLengte; i++) {
                random = rand.nextInt(codeLengte);
                if(random<=codeLengte/codeLengte) {
                    code[i]='y';
                }
                else if(random<=codeLengte/codeLengte+1) {
                    code[i]='b';
                }
                else if(random<=codeLengte/codeLengte+2) {
                    code[i]='g';
                }
                else if(random<=codeLengte/codeLengte+3) {
                    code[i]='r';
                }
            }
        }
        public void guess() {
            System.out.println("Voor de code in: ");
            invoerRadende = sc.nextLine();
            System.out.println("Invoer: " + invoerRadende);
        }

    public void takeInput() {
            if(invoerRadende.length()==codeLengte) {
                for (int i = 0; i < codeLengte; i++) {
                    if(invoerRadende.charAt(i)!='y'&&invoerRadende.charAt(i)!='b'&&invoerRadende.charAt(i)!='g'&&invoerRadende.charAt(i)!='r') {
                        System.out.println("Je charactar op nummer "+(i+1)+" is niet correct");
                    }
                    radende[i] = invoerRadende.charAt(i);
                }
            }
            else {
                System.out.println("Je hebt teveel characters ingevuld");
                for (int i = 0; i < codeLengte; i++) {

                    radende[i] = 'a';
                }
            }
        }

    public void validateInput() {
            aantalCorrect = 0;
            aantalFoutePlek = 0;
            for (int i = 0; i < codeLengte; i++) {
                if (radende[i] == code[i]) {
                    aantalCorrect += 1;
                } else {
                    for (int a = 0; a < codeLengte; a++) {
                        if (radende[i] == code[a]) {
                            aantalFoutePlek += 1;
                            a = codeLengte;
                        }
                    }
                }
            }

        textUitvoer uitvoer1 = (a) -> "Aantaal kleuren correct en op de juiste plek: " + a;
        textUitvoer uitvoer2 = (a) -> "Aantaal kleuren correct en niet op de juiste plek:" + a;
        System.out.println(uitvoer1.uitvoerer(aantalCorrect));
        System.out.println(uitvoer2.uitvoerer(aantalFoutePlek));
        }

}
