package filesprocessing.filter.size_filters;


import filesprocessing.exception.Type1Exception;
import filesprocessing.filter.Filter;

import java.io.File;

public class SmallerThanFilter extends Filter {

    /** the number of arguments that the filter takes */
    private static int NUM_OF_PARAMS = 1;

    /** the filter argument */
    private double maxSize;

    /** the property filter argument index */
    private static final int MAX_SIZE_IDX = 1;


    public SmallerThanFilter(String[] filterParameters) throws Type1Exception {
        super(filterParameters,
                NUM_OF_PARAMS);
    }

    @Override
    protected boolean matchesFilter(File toFilter) {
        return toFilter.length() <= maxSize;
    }

    @Override //TODO - Take care of duplicates!!!!!!!!!!!!!!
    protected void setCommandParameters() throws Type1Exception {
        try {
            maxSize = Double.parseDouble(filterParameters[MAX_SIZE_IDX]);
            if (maxSize < 0) { throw new Type1Exception(); }
        } catch (Exception e) {
            throw new Type1Exception();
        }
    }

}
