package src.application.model;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/*
 * required is a multimap: one key and four values.
 * i.e. Tisch --> table, sun, moon, cloud
 *
 * Library from:
 * https://www.baeldung.com/guava-multimap (suggestion?)
 *
 * ==> or even better: read hashmap (1-1) and randomly map other words to it!!
 *
 *
 * Die Wörterliste haben wir grösstenteils von:
 * https://www.wordbeat.com/englisch-grundwortschatz-vokabelliste/
 *
 */
public class DBReader {

    public static void main(String[] args) {

        File file = new File("src/application/model/DE-EN.txt");
        HashMap<String, String> map = new HashMap<String, String>(); // key-value-couple (used for right answers)
        ArrayList<String> words = new ArrayList<String>(); // list of all translations (used for wrong answers)

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null)
            {
                if (line.contains(",")) {
                    String[] parts = line.split(",");
                    String key = parts[0];
                    String value = parts[1];
                    map.put(key, value); // building hashmap for correct answers
                    words.add(parts[1]);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("src/application/model/DE-EN.txt nicht gefunden");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //output on console to check. delete later
        System.out.println("Alle Schlüssel-Wert-Paare lauten: ");
        System.out.println("**********************************");
        for (String key : map.keySet())
        {
            System.out.println(key + " = " + map.get(key));
        }
        System.out.println();
        System.out.println("Alle Wörter für die falschen Optionen sind: ");
        System.out.println("********************************************");
        for (String options : words) {
            System.out.print(options + " ");
        }
    }
}
