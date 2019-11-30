package src.application.model;

import java.io.*;
import java.util.*;

public class DBReader {

    // instance variables
    private HashMap<String, String> map = new HashMap<String, String>(); // key-value-couple (used for right answers)
    private ArrayList<String> words = new ArrayList<String>(); // list of all translations (used for wrong answers)
    private File file;
    /*
    constructor to initialize the loading of vocabulary in txt-file.
     */
    public DBReader() {
        loadData();
    }

    /*
    this method loads the map (HashMap) and words (ArrayList) from the DE-EN.txt file into Object
    it is called in the constructor
     */
    public void loadData() {

        this.file = new File("src/application/model/DE-EN.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null)
            {
                if (line.contains(",")) {
                    String[] parts = line.split(",");
                    String key = parts[0];
                    String value = parts[1];
                    map.put(key, value); // building hashmap for pairing (translation)
                    words.add(parts[0]); // building arraylist of keys from hashmap to access randomly
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("src/application/model/DE-EN.txt nicht gefunden");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * randomly choose a new question and fill the reply buttons.
     * @return: String[4] array with 4 answers on index 0,1,2,3 and question word on index 4.
     */
    public String[] getNewQuestion() {

        //obtain all words and answers
        String word, correctAnswer, wrongAnswer1, wrongAnswer2, wrongAnswer3;
        word = words.get((int) (Math.random() * (words.size() + 1)));
        correctAnswer = map.get(word);
        wrongAnswer1 = map.get((int) (Math.random() * (map.size() + 1)));
        wrongAnswer2 = map.get((int) (Math.random() * (map.size() + 1)));
        wrongAnswer3 = map.get((int) (Math.random() * (map.size() + 1)));

        //shuffle the entries
        String[] shuffleArray = {correctAnswer, wrongAnswer1, wrongAnswer2, wrongAnswer3};
        List<String> shuffleList = Arrays.asList(shuffleArray);
        Collections.shuffle(shuffleList);

        //add the correct word and build arr String[] for FX frontend
        String arr[] = new String[4];
        shuffleList.add(word);
        shuffleList.toArray(arr);
        return arr;
    }

    /*
     * TO BE DELETED AFTER IMPLEMENTATION getNewQuestion() !!!
     */
    public String getRandomWrongAnswer() {
        int wordsIndex = (int) (Math.random() * (words.size() + 1));
        return words.get(wordsIndex);
    }

    /*
     * getter-method for current filename in use
     */
    public String getFilename() {
        String filename = file.getName();
        return filename;
    }
}
