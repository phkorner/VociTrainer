package src.application.model;

import java.io.*;
import java.util.*;

public class Database extends Observable {

    private HashMap<String, String> map = new HashMap<>(); // key-value-couple (used for right answers)
    private ArrayList<String> answers = new ArrayList<>(); // list of all translations (used for wrong answers)
    private ArrayList<String> words = new ArrayList<>(); // list of all question words (used for questions)
    private File file;
    private String word;
    private String correctAnswer;
    private String wrongAnswer1;
    private String wrongAnswer2;
    private String wrongAnswer3;

    public Database() {
        this.file = new File("src/application/model/Chapters/Professions.txt");
        loadData();
        fillQuestionSet();
    }

    /**
     * method to load map, words and answers from txt-file (database).
     * called by constructor.
     */
    public void loadData() {

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

    /**
     * private method used to fill the instance variables: word, correctAnswer, wrongAnswer1, wrongAnswer2, wrongAnswer3
     */
    private void fillQuestionSet() {
        //randomly select a new question and matching correctAnswer
        this.word = words.get((int) (Math.random() * words.size()));
        this.correctAnswer = map.get(word);
        //making sure that no answer appears twice with do-while loop
        do {
            this.wrongAnswer1 = answers.get((int) (Math.random() * answers.size()));
            this.wrongAnswer2 = answers.get((int) (Math.random() * answers.size()));
            this.wrongAnswer3 = answers.get((int) (Math.random() * answers.size()));
        } while (correctAnswer == wrongAnswer1 || correctAnswer == wrongAnswer2 || correctAnswer == wrongAnswer3
                || wrongAnswer1 == wrongAnswer2 || wrongAnswer2 == wrongAnswer3 || wrongAnswer1 == wrongAnswer3);
    }

    /**
     * is called when user chooses a new chapter from primary stage via chapter.
     * clears current database and fills it again with the new vocabulary.
     * @param fileName
     */
    public void newChapter(String fileName) {
        this.file = new File("src/application/model/Chapters/" + fileName);
        map.clear();
        words.clear();
        answers.clear();
        loadData();
        fillQuestionSet();
        this.setChanged();
        this.notifyObservers();
    }

    /**
     * called whenever a new question set is needed at frontend.
     * loads a new set of word, correctAnswer, wrongAnswer1, wrongAnswer2, wrongAnswer3.
     */
    public ArrayList<String> loadNewQuestion() {

        fillQuestionSet();

        //convert to List and shuffle
        String[] shuffleArray = {correctAnswer, wrongAnswer1, wrongAnswer2, wrongAnswer3};
        List<String> shuffleList = Arrays.asList(shuffleArray);
        Collections.shuffle(shuffleList);

        //convert back to array and add word
        ArrayList<String> shuffleArray2 = new ArrayList(shuffleList);
        shuffleArray2.add(word);

        return shuffleArray2;
    }

    /**
     * evaluates the answer given by user
     */
    public boolean evaluateAnswer(String answerGiven) {
        boolean decision = false;
        if (answerGiven == this.correctAnswer) {
            decision = true;
        }
        return decision;
    }

    /**
     * required to display current chapter in primary stage. (getter).
     * @return name of file
     */
    public String getFilename() {
        return file.getName();
    }

    public ArrayList<String> getWords() {
        return words;
    }

    public ArrayList<String> getAnswers() { return answers; }

}