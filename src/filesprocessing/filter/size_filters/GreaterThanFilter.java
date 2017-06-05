package filesprocessing.filter.size_filters;


import filesprocessing.exception.Type1Exception;
import filesprocessing.filter.Filter;

import java.io.File;

public class GreaterThanFilter extends SizeFilter {

    /** the number of arguments that the filter takes */
    private static int NUM_OF_PARAMS = 1;

    /** the filter argument */
    private double minSize;

    /** the property filter argument index */
    private static final int MIN_SIZE_IDX = 1;

    /**
     * Constructor
     * @param filterParameters Array of splitted command
     * @throws Type1Exception if invalid command
     */
    public GreaterThanFilter(String[] filterParameters) throws Type1Exception {
        super(filterParameters, NUM_OF_PARAMS);
    }

    /**
     * Check if file's size is larger than min size
     * @param toFilter the file to check
     * @return True if so
     */
    @Override
    protected boolean matchesFilter(File toFilter) {
        return toFilter.length() > minSize;
    }

    /**
     * Set command parameters
     * @throws Type1Exception if invalid command
     */
    @Override
    protected void setCommandParameters() throws Type1Exception {minSize = getParameter(MIN_SIZE_IDX);}

}
