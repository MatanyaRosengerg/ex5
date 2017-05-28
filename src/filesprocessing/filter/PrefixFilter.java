package filesprocessing.filter;

import filesprocessing.exception.Type1Exception;

import java.io.File;

/**
 * Created by t8351813 on 22/05/2017.
 */
public class PrefixFilter extends ContainsFilter {
    private static int numberOfParameters = 1;

    private String fileNameParameter;

    public PrefixFilter(String[] filterParameters) throws Type1Exception {super(filterParameters);}


    @Override
    protected boolean matchesFilter(File toFilter) {
        return toFilter.getName().startsWith(fileNameParameter);
    }

    @Override
    protected void setCommandParameters(String[] filterLine) throws Type1Exception {
        checkNumberOfParameters(filterLine, numberOfParameters);
        fileNameParameter = filterLine[1];
    }
}
