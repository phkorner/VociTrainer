package src.application.model.testing;

import org.junit.Test;
import org.junit.Before;

import src.application.model.Database;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TestDatabase  {

    private Database TestDB;

    @Before
    public void setup() {
        this.TestDB = new Database();
    }

    @Test
    public void initialFilenameShouldBeProfessions() {
        String expected = "Professions.txt";
        String actual = TestDB.getFilename();
        assertEquals(actual, expected);
    }

    @Test
    public void loadDataShouldContainAllRows() {
        //given unchanged size of family.txt vocabulary
        assertTrue(TestDB.getWords().size() == 55);
        assertTrue(TestDB.getAnswers().size() == 55);
    }

    @Test
    public void randomSelectionOfWordShouldUseCorrectRange() {
        int sample[] = new int[1000];
        for (int i=0;i<1000;i++) {
            int randomNr = (int) (Math.random() * TestDB.getWords().size()); //same random formula!
            sample[i] = randomNr;
        }
        boolean resultat = true;
        for (int i : sample) {
            if (i >= 55 || i < 0) { //55 is the size of the default "professions.txt" data
                resultat = false;
            }
        }
        assertTrue(resultat);
    }

    @Test
    public void fillQuestionSetShouldGiveDifferentAnswers() {
        ArrayList<String> verteiler = TestDB.loadNewQuestion();
        String a1 = verteiler.get(0);
        String a2 = verteiler.get(1);
        String a3 = verteiler.get(2);
        String a4 = verteiler.get(3);
        boolean resultat = true;
        if (a1 == a2 || a1 == a3 || a1 == a4 ||
            a2 == a3 || a2 == a4 || a3 == a4) {
            resultat = false;
        }
        assertTrue(resultat);
    }

}
