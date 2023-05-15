import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Hier mag je je code scrijven voor de hoofd-opdracht
        Integer[] numeric = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String[] alphabetic = {"een", "twee", "drie", "vier", "vijf", "zes", "zeven", "acht", "negen", "nul"};

        Translator translator = new Translator(numeric, alphabetic);
        Generator generator = new Generator();

        boolean play = true;
        String ongeldig = "Ongeldige invoer";
        Scanner scanner = new Scanner(System.in);

        while(play) {
            System.out.println("Type 'x' om te stoppen \nType 'v' om te vertalen");
            String input = scanner.nextLine();
            if(input.equalsIgnoreCase("x")) {
                play = false;
            } else if(input.equalsIgnoreCase("v")) {
                System.out.println("Type een cijfer in van 0 t/m 9");
                int number = scanner.nextInt();
                scanner.nextLine();
                if(number < 10) {
                    String result = translator.translate(number);
                    System.out.println("De vertaling van " + number + " is " + result);
                } else {
                    System.out.println(ongeldig);
                }
            } else {
                System.out.println(ongeldig);
            }

        }

        /*-----------------
        * bonusopdrachten :
        * randomNumberGenerator = te vinden in class 'Generator'
        * HashSet to string = te vinden in class 'Generator'
        * de 4 nummers als parameter bij de methode feedback zie regel 49
        -----------------*/

        /* tests of de methodes werken, blok uit commentaar halen om de resultaten te kunnen zien */
        /*System.out.println(generator.getRandomHashSet());
        System.out.println(generator.getRandomString(translator));
        System.out.println(generator.getRandomNumbers());*/

        feedback(generator.getRandomNumbers());

        /* ik heb voor onderstaand deel eigen code in de class Generator geplaatst */
        /* deze regel mag je weg halen voor de bonus opdracht. Onderstaande code is voor de bonus opdracht.
        HashSet<Integer> secretnumber = randomnumbergenerator();
        String stringnumber =  setToStringConverter(secretnumber);
        System.out.println(stringnumber);
        feedback();
         deze regel mag je weg halen voor de bonus opdracht */

    }

    /*
     Deze methode is voor de bonus opdracht.
     */
    public static void feedback(String stringnumber) {
        Scanner scanner = new Scanner(System.in);

        /* bonus-bonus: in een while loop geplaatst om meerdere keren te kunnen raden */
        boolean play = true;
        while (play) {
            StringBuilder feedback = new StringBuilder();
            System.out.println("take a guess");
            String guess = scanner.nextLine();
            if (Objects.equals(guess, stringnumber)) {
                System.out.println("gefeliciteerd je hebt het goed");
                play = false;
            } else {
                for (int i = 0; i < 4; i++) {
                    if (guess.substring(i, i + 1).equals(stringnumber.substring(i, i + 1))) {
                        feedback.append("+");
                    } else if (stringnumber.contains(guess.substring(i, i + 1))) {
                        feedback.append("0");
                    } else {
                        feedback.append("X");
                    }
                }
            }
            System.out.println(feedback.toString());
        }


    }
}
