package filesprocessing.filter.size_filters;


import filesprocessing.exception.Type1Exception;
import filesprocessing.filter.Filter;

import java.io.File;

public class SmallerThanFilter extends SizeFilter {

    /** the number of arguments that the filter takes */
    private static int NUM_OF_PARAMS = 1;

    /** the filter argument */
    private double maxSize;

    /** the property filter argument index */
    private static final int MAX_SIZE_IDX = 1;

    /**
     * Constructor
     * @param filterParameters Array of splitted command
     * @throws Type1Exception if invalid command
     */
    public SmallerThanFilter(String[] filterParameters) throws Type1Exception {
        super(filterParameters, NUM_OF_PARAMS);
    }

    /**
     * Check if file is smaller then the max size
     * @param toFilter the file to check
     * @return True if so
     */
    @Override
    protected boolean matchesFilter(File toFilter) {
        return toFilter.length() < maxSize;
    }

    /**
     * Set command parameters
     * @throws Type1Exception if invalid parameters
     */
    @Override
    protected void setCommandParameters() throws Type1Exception {maxSize = getParameter(MAX_SIZE_IDX);}

}
