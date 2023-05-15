import java.util.HashSet;

public class Generator {
    /* variabelen */
    HashSet<Integer> randomNumbers = new HashSet<>();

    /* constructor, maakt een random HashSet aan met vier nummers onder de 9 (onder de 9 om alles te kunnen blijven koppelen aan de hashmap/Translator) */
    public Generator() {
        while(randomNumbers.size() != 4) {
            randomNumbers.add((int) Math.round(Math.random() * 9));
        }
    }

    /* methodes */
    public HashSet<Integer> getRandomHashSet() {
        return randomNumbers;
    }

    public String getRandomString(Translator translator) { /* gekoppeld aan de translator om hiermee de vertaling van het cijfer uit de Hashmap te halen */
        String s = "";
        for (Integer i : randomNumbers) {
            if(s != ""){
                s += ", ";
            }
            s += translator.translate(i);
        }
        return s;
    }

    public String getRandomNumbers() {
        String s = "";
        for (Integer i : randomNumbers) {
            s += i.toString();
        }
        return s;
    }

}
