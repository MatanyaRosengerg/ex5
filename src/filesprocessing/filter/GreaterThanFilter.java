package filesprocessing.filter;


import filesprocessing.exception.Type1Exception;

import java.io.File;

public class GreaterThanFilter extends Filter {
    private static int NUM_OF_PARAMS = 1; //TODO change names to fit

    private double minSize;

    public GreaterThanFilter(String[] filterParameters) throws Type1Exception {super(filterParameters);}

    @Override
    protected boolean matchesFilter(File toFilter) {
        return toFilter.length() >= minSize;
    }

    @Override
    protected void setCommandParameters(String[] filterLine) throws Type1Exception {
        checkNumberOfParameters(filterLine, NUM_OF_PARAMS);
        try {
            minSize = Double.parseDouble(filterLine[1]);
            if (minSize < 0) { throw new Type1Exception(); }
        } catch (Exception e) {
            throw new Type1Exception(); //TODO maybe add a message
        }
    }

}
