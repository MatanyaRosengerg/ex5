package filesprocessing.filter.size_filters;


import filesprocessing.exception.Type1Exception;
import filesprocessing.filter.Filter;

import java.io.File;

public class GreaterThanFilter extends Filter {

    /** the number of arguments that the filter takes */
    private static int NUM_OF_PARAMS = 1;

    /** the filter argument */
    private double minSize;

    /** the property filter argument index */
    private static final int MIN_SIZE_IDX = 1;

    /** Error message for incorrect usage of filter */
    private final String ARGUMENT_USAGE_ERROR_MESSAGE = "the filter parameter should be positive";
    private final String ARGUMENTS_ERROR_MESSAGE = "error in the filter argument";

    public GreaterThanFilter(String[] filterParameters) throws Type1Exception {super(filterParameters, NUM_OF_PARAMS );}

    @Override
    protected boolean matchesFilter(File toFilter) {
        return toFilter.length() >= minSize;
    }

    @Override
    protected void setCommandParameters() throws Type1Exception {
        try {
            minSize = Double.parseDouble(filterParameters[MIN_SIZE_IDX]);
            if (minSize < 0) { throw new Type1Exception(ARGUMENT_USAGE_ERROR_MESSAGE); }
        } catch (Exception e) {
            throw new Type1Exception(ARGUMENTS_ERROR_MESSAGE);
        }
    }

}
