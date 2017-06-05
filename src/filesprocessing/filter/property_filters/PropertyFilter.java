package filesprocessing.filter.property_filters;

import filesprocessing.exception.Type1Exception;
import filesprocessing.filter.Filter;

import java.io.File;


public abstract class PropertyFilter extends Filter {

    /** the number of arguments that the filter takes */
    private static int NUM_OF_PARAMS = 1;

    /** The user format for the property arguments */
    private static final String YES = "YES";
    private static final String NO = "NO";

    /** the property filter argument index */
    private static final int CONDITION_IDX = 1;

    /** determines if the filter argument is "YES" or "NO" */
    private boolean yesCondition;

    /**
     * Constructor
     * @param filterParameters Array of splitted command
     * @throws Type1Exception if invalid command
     */
    PropertyFilter(String[] filterParameters) throws Type1Exception {super(filterParameters, NUM_OF_PARAMS); }

    /**
     * Determines if a file meets the condition of the filter type of this class's sons.
     *
     * @param toFilter the file to check if meets condition
     * @return true if it meets the condition, false otherwise.
     */
    protected abstract boolean matchesSubFilter(File toFilter);

    /**
     * Check if the file is filtered.
     * @param toFilter the file to check.
     * @return True if passed the filter.
     */
    @Override
    protected boolean matchesFilter(File toFilter) {return yesCondition == matchesSubFilter(toFilter);}

    /**
     * Set the command parameters.
     * @throws Type1Exception if invalid parameters.
     */
    @Override
    protected void setCommandParameters() throws Type1Exception {
        if (!(filterParameters[CONDITION_IDX].equals(NO) || filterParameters[CONDITION_IDX].equals(YES))) {
            throw new Type1Exception();
        }
        else {setCondition();}
    }

    /**
     * Sets the YES/NO condition for the property filters
     */
    private void setCondition() {this.yesCondition = filterParameters[CONDITION_IDX].equals(YES);}
}
