package src.application.model.testing;

import org.junit.Test;
import org.junit.Before;
import src.application.model.view.PrimaryController;
import static org.junit.Assert.*;

public class TestPrimaryController {

    private PrimaryController TestController;

    @Before
    public void setup() {
        this.TestController = new PrimaryController();
    }

    @Test
    public void simulateRatioCalculation() {
        int correctAnswers = TestController.getIntCorrectAnswers();
        int totalQuestions = TestController.getIntQuestions();
        //simulate ratio 66%
        totalQuestions = totalQuestions + 3;
        correctAnswers = correctAnswers + 2;
        int testRatio = (correctAnswers * 100) / totalQuestions; //same calculation as in PrimaryController

        assertEquals(testRatio, 66);
    }

    @Test(expected = ArithmeticException.class)
    public void failedInitialRatioCalculation() {
        int correctAnswers = TestController.getIntCorrectAnswers();
        int totalQuestions = TestController.getIntQuestions();
        int testRatio = correctAnswers / totalQuestions; //fail expected
    }

}
