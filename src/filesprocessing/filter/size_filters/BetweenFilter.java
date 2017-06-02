package filesprocessing.filter.size_filters;


import filesprocessing.exception.Type1Exception;
import filesprocessing.filter.Filter;

import java.io.File;

public class BetweenFilter extends Filter {

    /** the number of arguments that the filter takes */
    private static int NUM_OF_PARAMS = 2;

    /** the filter arguments */
    private double minSize, maxSize;

    /** the property filter arguments indices */
    private static final int MIN_SIZE_IDX = 1;
    private static final int MAX_SIZE_IDX = 2;

    /** Error message for incorrect usage of filter */
    private final String ARGUMENTS_USAGE_ERROR_MESSAGE = "filter parameters should be positive, in ascending order";
    private final String ARGUMENTS_ERROR_MESSAGE = "error in the filter arguments";

    public BetweenFilter(String[] filterParameters) throws Type1Exception {super(filterParameters,
            NUM_OF_PARAMS);}

    @Override
    protected boolean matchesFilter(File toFilter) {
        return (toFilter.length() >= minSize && toFilter.length() <= maxSize);
    }

    @Override
    protected void setCommandParameters() throws Type1Exception {
        try {
            minSize = Double.parseDouble(filterParameters[MIN_SIZE_IDX]);
            maxSize = Double.parseDouble(filterParameters[MAX_SIZE_IDX]);
            if (minSize < 0 || maxSize < 0 || minSize > maxSize) {
                throw new Type1Exception(ARGUMENTS_USAGE_ERROR_MESSAGE);
            }
        } catch (Exception e) {
            throw new Type1Exception(ARGUMENTS_ERROR_MESSAGE);
        }
    }

}
