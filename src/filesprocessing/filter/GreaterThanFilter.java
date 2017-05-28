package filesprocessing.filter;


import filesprocessing.exception.Type1Exception;

import java.io.File;

public class GreaterThanFilter extends Filter {
    private static int numberOfParameters = 1;

    private double minSize;

    public GreaterThanFilter(String[] filterParameters) throws Type1Exception {super(filterParameters);}

    @Override
    protected boolean matchesFilter(File toFilter) {
        return toFilter.length() >= minSize;
    }

    @Override
    protected void setCommandParameters(String[] filterLine) throws Type1Exception {
        checkNumberOfParameters(filterLine, numberOfParameters);
        try {
            minSize = Double.parseDouble(filterLine[1]);
        }catch (Exception e) {
            throw new Type1Exception(""); //TODO maybe add a message
        }
    }

}
