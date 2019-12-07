package src.application.model;

import java.io.*;
import java.util.*;

public class Database extends Observable {

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
    public Database() {
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

    /*
     * evaluation tbd is observed
     */
    public ArrayList<String> evaluate() {

        //new set of question and answers generated
        this.word = words.get((int) (Math.random() * (words.size() + 1)));
        this.correctAnswer = map.get(word);
        this.wrongAnswer1 = words.get((int) (Math.random() * (words.size() + 1)));
        this.wrongAnswer2 = words.get((int) (Math.random() * (words.size() + 1)));
        this.wrongAnswer3 = words.get((int) (Math.random() * (words.size() + 1)));

        //convert to List and shuffle
        String[] shuffleArray = {correctAnswer, wrongAnswer1, wrongAnswer2, wrongAnswer3};
        List<String> shuffleList = Arrays.asList(shuffleArray);
        Collections.shuffle(shuffleList);

        //convert back to array and add word
        ArrayList<String> shuffleArray2 = new ArrayList(shuffleList);
        shuffleArray2.add(word);

        //notify observers
        this.setChanged();
        this.notifyObservers();

        return shuffleArray2;
    }

    /*
     * getter-method for current filename in use
     */
    public String getFilename() {
        String filename = file.getName();
        return filename;
    }
}
