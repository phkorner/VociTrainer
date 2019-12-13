package src.application.model;

import java.io.*;
import java.util.*;


public class Database {

    private HashMap<String, String> map = new HashMap<>(); // key-value-couple (used for right answers)
    private ArrayList<String> answers = new ArrayList<>(); // list of all translations (used for wrong answers)
    private ArrayList<String> words = new ArrayList<>(); // list of all question words (used for questions)
    private File file; // file read by DB reader
    private String word;
    private String correctAnswer;
    private String wrongAnswer1;
    private String wrongAnswer2;
    private String wrongAnswer3;

    // default constructor
    public Database() {

        loadData();

        this.word = words.get((int) (Math.random() * (words.size() + 1)));
        this.correctAnswer = map.get(word);
        this.wrongAnswer1 = answers.get((int) (Math.random() * (answers.size() + 1)));
        this.wrongAnswer2 = answers.get((int) (Math.random() * (answers.size() + 1)));
        this.wrongAnswer3 = answers.get((int) (Math.random() * (answers.size() + 1)));

    }


    /*
     * method to load map, words and answers from txt-file (database)
     * called by constructor
     */
    public void loadData() {

        this.file = new File("src/application/model/Chapters/Family.txt");

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
                    answers.add(parts[1]); // building arraylist of values from hashmap to access randomly
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Datei nicht gefunden.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void NewChapter(String fileName) {
        this.file = new File("src/application/model/Chapters/" + fileName);
        map.clear();
        words.clear();
        answers.clear();
        loadData();
        this.word = words.get((int) (Math.random() * (words.size() + 1)));
        this.correctAnswer = map.get(word);
        this.wrongAnswer1 = answers.get((int) (Math.random() * (answers.size() + 1)));
        this.wrongAnswer2 = answers.get((int) (Math.random() * (answers.size() + 1)));
        this.wrongAnswer3 = answers.get((int) (Math.random() * (answers.size() + 1)));
    }

    /*
     * loads a new set of word, correctAnswer, wrongAnswer1, wrongAnswer2, wrongAnswer3.
     */
    public ArrayList<String> loadNewQuestion() {

        //new set of question and answers generated
        this.word = words.get((int) (Math.random() * (words.size() + 1)));
        this.correctAnswer = map.get(word);
        this.wrongAnswer1 = answers.get((int) (Math.random() * (answers.size() + 1)));
        this.wrongAnswer2 = answers.get((int) (Math.random() * (answers.size() + 1)));
        this.wrongAnswer3 = answers.get((int) (Math.random() * (answers.size() + 1)));

        //convert to List and shuffle
        String[] shuffleArray = {correctAnswer, wrongAnswer1, wrongAnswer2, wrongAnswer3};
        List<String> shuffleList = Arrays.asList(shuffleArray);
        Collections.shuffle(shuffleList);

        //convert back to array and add word
        ArrayList<String> shuffleArray2 = new ArrayList(shuffleList);
        shuffleArray2.add(word);

        return shuffleArray2;
    }

    /*
     * evaluates the answer given by user
     */
    public boolean evaluateAnswer(String answerGiven) {
        boolean decision = false;
        if (answerGiven == this.correctAnswer) {
            decision = true;
        }
        return decision;
    }

    public String getFilename() {
        String filename = file.getName();
        return filename;
    }
}