package project;

public class Main {

    public static void main(String[] args) {
        final int codeLengte = 4;
        boolean bezig = true;
        MasterMind game = new MasterMind(codeLengte);
        while (bezig) {
            game.genereerCode();
            while (game.aantalCorrect < codeLengte) {
                game.guess();
                game.takeInput();
                game.validateInput();
            }
            System.out.println("Je hebt gewonnen!");
            game.aantalCorrect = 0;
            game.aantalFoutePlek = 0;
        }
    }
}
