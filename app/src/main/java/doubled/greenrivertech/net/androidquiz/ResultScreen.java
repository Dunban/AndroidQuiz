package doubled.greenrivertech.net.androidquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ResultScreen extends AppCompatActivity {
    private Question modal;
    private TextView correct;
    private TextView resulting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        modal = new Question();
        correct = (TextView) findViewById(R.id.score);
        resulting = (TextView) findViewById(R.id.answers);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent results = getIntent();
        int score = results.getIntExtra("Score", -1);
        boolean[] answers = results.getBooleanArrayExtra("Answers");

        correct.setText(score + "");
        String questions = "";
        for(int i = 0; i < answers.length; i++)
        {
            questions += modal.getQuestion(i);
            if (modal.check(answers[i], i))
            {
                questions +=": Correct! \n";
            }
            else
            {
                questions +=": Incorrect! \n";
            }
        }

        resulting.setText(questions);
    }
}
