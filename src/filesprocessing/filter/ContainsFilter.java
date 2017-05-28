package filesprocessing.filter;

import filesprocessing.exception.Type1Exception;

import java.io.File;


public class ContainsFilter extends Filter {
    private static int numberOfParameters = 1;

    private String fileNameParameter;

    public ContainsFilter(String[] filterParameters) throws Type1Exception {super(filterParameters);}

    @Override
    protected boolean matchesFilter(File toFilter) {
        return toFilter.getName().contains(fileNameParameter);
    }

    @Override
    protected void setCommandParameters(String[] filterLine) throws Type1Exception {
        checkNumberOfParameters(filterLine, numberOfParameters);
        fileNameParameter = filterLine[1];
    }

}
