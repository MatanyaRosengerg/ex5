package filesprocessing.filter;

import filesprocessing.exception.Type1Exception;

import java.io.File;


public abstract class PropertyFilter extends Filter {
    protected static int numberOfParameters = 1;

    private static final String YES = "YES";
    private static final String NO = "NO";
    private static final int CONDITION_IDX = 1;


    protected boolean yesCondition;

    public PropertyFilter(String[] filterParameters) throws Type1Exception {super(filterParameters); }

    /**
     * Determines if a file meets the condition of the filter type of this class's sons.
     *
     * @param toFilter the file to check if meets condition
     * @return true if it meets the condition, false otherwise.
     */
    protected abstract boolean matchesSubFilter(File toFilter);

    @Override
    protected boolean matchesFilter(File toFilter) {return yesCondition == matchesSubFilter(toFilter);}


    @Override
    protected void setCommandParameters(String[] filterLine) throws Type1Exception {
        checkNumberOfParameters(filterLine, numberOfParameters);
        if (!(filterLine[CONDITION_IDX].equals(NO) || filterLine[CONDITION_IDX].equals(YES))) {
            throw new Type1Exception();
        }
        else {setCondition();}
    }

    /** Sets the YES/NO condition for the property filters */
    private void setCondition() {this.yesCondition = filterParameters[CONDITION_IDX].equals(YES);}
}
