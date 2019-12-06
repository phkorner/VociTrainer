package src.application.model;

import java.io.*;
import java.util.*;

public class DBReader extends Observable {

    private HashMap<String, String> map = new HashMap<String, String>(); // key-value-couple (used for right answers)
    private ArrayList<String> words = new ArrayList<String>(); // list of all translations (used for wrong answers)
    private File file; // file read by DB reader
    private String word;
    private String correctAnswer;
    private String wrongAnswer1;
    private String wrongAnswer2;
    private String wrongAnswer3;

    /*
     * constructor to initialize the loading of vocabulary in txt-file.
     */
    public DBReader() {
        loadData();
        this.word = words.get((int) (Math.random() * (words.size() + 1)));
        this.correctAnswer = map.get(word);
        this.wrongAnswer1 = words.get((int) (Math.random() * (words.size() + 1)));
        this.wrongAnswer2 = words.get((int) (Math.random() * (words.size() + 1)));
        this.wrongAnswer3 = words.get((int) (Math.random() * (words.size() + 1)));
    }

    /*
    this method loads the map (HashMap) and words (ArrayList) from the DE-EN.txt file into Object
    it is called in the constructor
     */
    public void loadData() {

        this.file = new File("src/application/model/Chapters/DE-EN.txt");

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
            System.out.println("src/application/model/Chapters/DE-EN.txt nicht gefunden");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getWord() { return word; }
    public String getCorrectAnswer() { return correctAnswer; }
    public String getWrongAnswer1() { return wrongAnswer1; }
    public String getWrongAnswer2() { return wrongAnswer2; }
    public String getWrongAnswer3() { return wrongAnswer3; }

    /*
     * evaluation tbd is observed
     */
    public String[] evaluate() {

        //new set of question and answers generated
        this.word = words.get((int) (Math.random() * (words.size() + 1)));
        this.correctAnswer = map.get(word);
        this.wrongAnswer1 = words.get((int) (Math.random() * (words.size() + 1)));
        this.wrongAnswer2 = words.get((int) (Math.random() * (words.size() + 1)));
        this.wrongAnswer3 = words.get((int) (Math.random() * (words.size() + 1)));

        //shuffle the entries
        String[] shuffleArray = {correctAnswer, wrongAnswer1, wrongAnswer2, wrongAnswer3};
        List<String> shuffleList = Arrays.asList(shuffleArray);
        Collections.shuffle(shuffleList);

        this.setChanged();
        this.notifyObservers();

        return shuffleArray;
    }

    /*
     * getter-method for current filename in use
     */
    public String getFilename() {
        String filename = file.getName();
        return filename;
    }
}
