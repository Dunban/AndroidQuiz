package doubled.greenrivertech.net.androidquiz;

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

public class QuestionsWindow extends AppCompatActivity {
    private Button istrue;
    private Button isfalse;
    private Question modal;
    private TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_window);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        istrue = (Button) findViewById(R.id.istrue);
        isfalse = (Button) findViewById(R.id.isfalse);
        modal = new Question(1);
        display = (TextView) findViewById(R.id.question);
        String question = modal.getquestion(3);
        display.setText(question);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void answered(View v)
    {
        if (v.getId() == istrue.getId())
        {
            if(modal.check("true", 3))
            {
                Toast.makeText(QuestionsWindow.this, "Correct!", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(QuestionsWindow.this, "Incorrect!", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            if(modal.check("false", 3))
            {
                Toast.makeText(QuestionsWindow.this, "Correct!", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(QuestionsWindow.this, "Incorrect!", Toast.LENGTH_SHORT).show();
            }
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
