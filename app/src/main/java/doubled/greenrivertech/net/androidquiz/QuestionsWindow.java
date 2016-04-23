package doubled.greenrivertech.net.androidquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class QuestionsWindow extends AppCompatActivity {
    private Button istrue;
    private Question modal;
    private TextView display;
    private TextView corrects;
    private int selection;
    private int score;
    private boolean[] answered;
    private boolean[] selected;
    public static final Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_window);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        istrue = (Button) findViewById(R.id.istrue);
        modal = new Question();
        score = 0;
        display = (TextView) findViewById(R.id.question);
        corrects = (TextView) findViewById(R.id.score);
        selection = rand.nextInt(5);
        display.setText(modal.getQuestion(selection));
        corrects.setText(score + "");
        answered = new boolean[]{false, false, false, false, false};
        selected = new boolean[]{false, false, false, false, false};

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    /**
     * public void answered()
     * @param v - The view clicked on as the answer to the question
     *
     * This method checks if the answer is correct to the given question. The answer is gathered
     * by checking the id of the View given.
     */
    public void answered(View v)
    {
        //If the selected button is the left one (True)
        if (v.getId() == istrue.getId())
        {
            //If answer is correct
            if(modal.check(true, selection))
            {
                Toast.makeText(QuestionsWindow.this, "Correct!", Toast.LENGTH_SHORT).show();
                score++;
                selected[selection] = true;
            }
            else //If answer is incorrect
            {
                Toast.makeText(QuestionsWindow.this, "Incorrect!", Toast.LENGTH_SHORT).show();
            } //End if statement
        }
        else //If the selected button is the right one (False)
        {
            //If answer is correct
            if(modal.check(false, selection))
            {
                Toast.makeText(QuestionsWindow.this, "Correct!", Toast.LENGTH_SHORT).show();
                score++;
                selected[selection] = true;
            }
            else //If answer is incorrect
            {
                Toast.makeText(QuestionsWindow.this, "Incorrect!", Toast.LENGTH_SHORT).show();
            } //End if statement
        }

        //move to the next question, and set answered to true
        corrects.setText(score + "");
        answered[selection] = true;
        skip(v);
    }

    /**
     * public void skip()
     * @param v - the view clicked on to skip the question
     *
     * This method moves to the next available question in the set.
     */
    public void skip(View v)
    {
        //For each question to answer
        int progress = 0;
        for(boolean answer : answered)
        {
            //If it has been answered
            if (answer)
            {
                progress++;
            }//End if statement
        }//End for loop

        //If all questions haven't been answered
        if(progress != 5)
        {
            //If the selection from the question set is at end
            if (selection == 4)
            {
                selection = 0;
            }
            else //If the selection from the question set is not at the end
            {
                selection++;
            }//End if statement

            //While the question has been answered
            while (answered[selection])
            {
                //If the selection from the question set is at end
                if (selection == 4)
                {
                    selection = 0;
                }
                else //If the selection from the question set is not at the end
                {
                    selection++;
                }//End if statement
            }//End while loop

            display.setText(modal.getQuestion(selection));
        }
        else //If all questions have been answered
        {
            Intent results = new Intent(this, ResultScreen.class);
            results.putExtra("Score", score);
            results.putExtra("Answers", selected);
            startActivity(results);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_questions_window, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
