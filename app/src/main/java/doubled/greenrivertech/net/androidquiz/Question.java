package doubled.greenrivertech.net.androidquiz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by sevenson2 on 4/14/2016.
 */
public class Question {
    private String question;
    //private Scanner questions;

    public Question(int selection)
    {
        /*try
        {
            if(selection == 1)
            {
                //questions = new Scanner(new File("easy.txt"));
            }
            else if (selection == 2)
            {
                //questions = new Scanner(new File("medium.txt"));
            }
            else
            {
                //questions = new Scanner(new File("hard.txt"));
            }
        }
        catch(FileNotFoundException ex)
        {
            System.out.println("The file does not exist" + ex.getMessage());
        }*/
        question = "2+2=5, correct?";
    }

    public String getquestion(int number)
    {
        /*int count = 1;
        while (questions.hasNextLine() && count < number)
        {
            questions.nextLine();
            count++;
        }
        return questions.nextLine();*/
        return question;
    }

    public boolean check(String answer, int number)
    {
        /*int count = 1;
        while (questions.hasNextLine() && count < number)
        {
            questions.nextLine();
            count++;
        }
        String[] tokens = questions.nextLine().split(":");
        return tokens[1].equals(answer);*/
        return answer.equals("false");
    }
}
