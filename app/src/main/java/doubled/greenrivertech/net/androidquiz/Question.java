package doubled.greenrivertech.net.androidquiz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 *
 */
public class Question {
    private String[] questions;
    private boolean answer;

    public Question()
    {
        questions = new String[5];
        questions[0] = "Suzy says 2 + 2 = 5 is correct.:false";
        questions[1] = "Bill says that the United States is in North America.:true";
        questions[2] = "Kevin says two quarters is worth more than four dimes:true";
        questions[3] = "Alex says that the sky is orange when the sun is down:false";
        questions[4] = "Helen says a rabbit is a type of rodent:false";
    }

    public String getQuestion(int selection)
    {
        String[] statement = questions[selection].split(":");
        answer = Boolean.parseBoolean(statement[1]);
        return statement[0];
    }

    public boolean check(boolean selected, int selection)
    {
        return answer == selected;
    }
}
