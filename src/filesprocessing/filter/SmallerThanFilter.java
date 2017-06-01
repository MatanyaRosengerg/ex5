package filesprocessing.filter;


import filesprocessing.exception.Type1Exception;

import java.io.File;

public class SmallerThanFilter extends Filter {
    private static int numberOfParameters = 1;

    private double maxSize;

    public SmallerThanFilter(String[] filterParameters) throws Type1Exception {super(filterParameters);}

    @Override
    protected boolean matchesFilter(File toFilter) {
        return toFilter.length() <= maxSize;
    }

    @Override //TODO - Take care of duplicates!!!!!!!!!!!!!!
    protected void setCommandParameters(String[] filterLine) throws Type1Exception {
        checkNumberOfParameters(filterLine, numberOfParameters);
        try {
            maxSize = Double.parseDouble(filterLine[1]);
            if (maxSize < 0) { throw new Type1Exception(); }
        } catch (Exception e) {
            throw new Type1Exception(); //TODO maybe add a message
        }
    }

}
