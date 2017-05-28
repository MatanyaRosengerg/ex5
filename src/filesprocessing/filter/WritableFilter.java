package filesprocessing.filter;

import filesprocessing.exception.Type1Exception;

import java.io.File;


public class WritableFilter extends PropertyFilter {
    private static int numberOfParameters = 1;

    private boolean isWriteable;

    public WritableFilter(String[] filterParameters) throws Type1Exception {super(filterParameters);}

    @Override
    protected boolean matchesSubFilter(File toFilter) {return toFilter.canWrite();}

    @Override
    protected void setCommandParameters(String[] filterLine) throws Type1Exception {
        checkNumberOfParameters(filterLine, numberOfParameters);
    }
}
