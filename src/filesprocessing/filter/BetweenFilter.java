package filesprocessing.filter;


import filesprocessing.exception.Type1Exception;

import java.io.File;

public class BetweenFilter extends Filter {
    private static int numberOfParameters = 2;

    private double minSize, maxSize;

    public BetweenFilter(String[] filterParameters) throws Type1Exception {super(filterParameters);}

    @Override
    protected boolean matchesFilter(File toFilter) {
        return (toFilter.length() >= minSize && toFilter.length() <= maxSize);
    }

    @Override
    protected void setCommandParameters(String[] filterLine) throws Type1Exception {
        checkNumberOfParameters(filterLine, numberOfParameters);
        try {
            minSize = Double.parseDouble(filterLine[1]);
            maxSize = Double.parseDouble(filterLine[2]);
        }catch (Exception e) {
            throw new Type1Exception(""); //TODO maybe add a message
        }
    }

}
