package src.application.model;

import java.io.*;
import java.util.*;

public class DBReader {

    // instance variables
    private HashMap<String, String> map = new HashMap<String, String>(); // key-value-couple (used for right answers)
    private ArrayList<String> words = new ArrayList<String>(); // list of all translations (used for wrong answers)

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

        File file = new File("src/application/model/DE-EN.txt");

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
     * @return: ArrayList(0 = word, 1-4 = buttons)
     */
    public String[] getNewQuestion() {

        //declare variables
        String word, correctAnswer, wrongAnswer1, wrongAnswer2, wrongAnswer3;

        //randomly choose a word from words ArrayList
        int wordIndex = (int) (Math.random() * (words.size() + 1));
        word = words.get(wordIndex);

        //obtain the correctAnswer from hashMap
        correctAnswer = map.get(word);

        //gather three random wrong answers
        wrongAnswer1 = map.get((int) (Math.random() * (map.size() + 1)));
        wrongAnswer2 = map.get((int) (Math.random() * (map.size() + 1)));
        wrongAnswer3 = map.get((int) (Math.random() * (map.size() + 1)));

        //shuffle the entries (tbd)
        String[] shuffleArray = {correctAnswer, wrongAnswer1, wrongAnswer2, wrongAnswer3};
        List<String> shuffleList = Arrays.asList(shuffleArray);
        Collections.shuffle(shuffleList);
        shuffleList.toArray(shuffleArray);

        //todo: shuffleList überführen in arr[] durch hinzufügen des "word" hinten oder vorne....

        //fill String[] for all five elements in javafx
        String arr[] = {word, correctAnswer, wrongAnswer1, wrongAnswer2, wrongAnswer3};
        return arr;
    }

    /*
    getter-method to load a random new word.
     */
    public String getQuestionWord() {
        int mapIndex = (int) (Math.random() * (map.size() + 1));
        return map.get(mapIndex);
    }

    /*
    used to obtain the correct Answer
     */
    public String getCorrectAnswer() {
        //todo: CorrectAnswer is dependent from QuestionWord. To implement!
        return map.get(0); //default to be implemented
    }

    /*
    used to fill up the wrong answer buttons from ArrayList
     */
    public String getRandomWrongAnswer() {
        int wordsIndex = (int) (Math.random() * (words.size() + 1));
        return words.get(wordsIndex);
    }

    /*
     * todo: getter method for file name
     */
    public String getFilename() {

        String filename = "test";
        return filename;
    }
}
