package filesprocessing.filter;

import filesprocessing.exception.Type1Exception;

import java.io.File;


public class ContainsFilter extends Filter {
    private static int numberOfParameters = 1;

    protected String fileNameParameter;

    public ContainsFilter(String[] filterParameters) throws Type1Exception {super(filterParameters);}

    @Override
    protected boolean matchesFilter(File toFilter) {
        return toFilter.getName().contains(fileNameParameter);
    }

    @Override
    protected void setCommandParameters(String[] filterLine) throws Type1Exception {
        //Todo - why put argument of 'NUM_OF_PARAMS'??
        checkNumberOfParameters(filterLine, numberOfParameters);
        fileNameParameter = filterLine[1];
        //Todo - what about checking if the 'NOT' suffix is valid??
    }

}
