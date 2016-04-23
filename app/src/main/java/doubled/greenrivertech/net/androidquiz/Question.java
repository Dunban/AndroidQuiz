package doubled.greenrivertech.net.androidquiz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class provides a list of questions to ask in the android quiz app.
 *
 */
public class Question {
    private ArrayList<Statement> questions;

    /**
     * Question  constructor for new question list
     */
    public Question()
    {
        questions = new ArrayList<Statement>();
        questions.add(new Statement("Suzy says 2 + 2 = 5", false));
        questions.add(new Statement("Bill says the United State is in North America", true));
        questions.add(new Statement("Dale says that Tomato is a fruit", false));
        questions.add(new Statement("Alex says Yellow is the first color on a rainbow", false));
        questions.add(new Statement("Carl says the creator of this app is the best", true));
    }

    /**
     * This method returns the specific question from the list
     *
     * @param selection - the quesiton to select from the list
     * @return the question
     */
    public String getQuestion(int selection)
    {
        return questions.get(selection).getStatement();
    }

    /**
     * This method checks the given answer for the question and returns correctness
     *
     * @param selected - the selected answer
     * @param selection - the question selected
     * @return if the answer is correct or not
     */
    public boolean check(boolean selected, int selection)
    {
        return questions.get(selection).getAnswer() == selected;
    }
}
