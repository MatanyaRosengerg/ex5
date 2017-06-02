package filesprocessing.filter.size_filters;


import filesprocessing.exception.Type1Exception;
import filesprocessing.filter.Filter;

import java.io.File;

public class BetweenFilter extends SizeFilter {

    /** the number of arguments that the filter takes */
    private static int NUM_OF_PARAMS = 2;

    /** the filter arguments */
    private double minSize, maxSize;

    /** the property filter arguments indices */
    private static final int MIN_SIZE_IDX = 1;
    private static final int MAX_SIZE_IDX = 2;


    public BetweenFilter(String[] filterParameters) throws Type1Exception {
        super(filterParameters, NUM_OF_PARAMS);
    }

    @Override
    protected boolean matchesFilter(File toFilter) {
        return (toFilter.length() >= minSize && toFilter.length() <= maxSize);
    }

    @Override
    protected void setCommandParameters() throws Type1Exception {
        minSize = getParameter(MIN_SIZE_IDX);
        maxSize = getParameter(MAX_SIZE_IDX);
        if (minSize > maxSize) {throw new Type1Exception();}
    }

}
