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


    public GreaterThanFilter(String[] filterParameters) throws Type1Exception {
        super(filterParameters, NUM_OF_PARAMS);
    }

    @Override
    protected boolean matchesFilter(File toFilter) {
        return toFilter.length() > minSize;
    }

    @Override
    protected void setCommandParameters() throws Type1Exception {minSize = getParameter(MIN_SIZE_IDX);}

}
