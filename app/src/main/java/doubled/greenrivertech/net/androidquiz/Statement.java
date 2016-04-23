package doubled.greenrivertech.net.androidquiz;

/**
 * Created by Scott E on 4/21/2016.
 */
public class Statement
{
    private String statement;
    private boolean answer;

    /**
     * Statement constructor
     *
     * @param statement - the string statement
     * @param answer - the answer to the statemnt
     */
    public Statement(String statement, boolean answer)
    {
        this.statement = statement;
        this.answer = answer;
    }

    /**
     * Statement Getter
     *
     * @return the statement string
     */
    public String getStatement()
    {
        return statement;
    }

    /**
     * Answer Getter
     *
     * @return the answer to the statement
     */
    public boolean getAnswer()
    {
        return answer;
    }
}

