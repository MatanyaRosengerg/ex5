package filesprocessing.filter.contain_string_filters;

import filesprocessing.exception.Type1Exception;
import filesprocessing.filter.Filter;

import java.io.File;


public class ContainsFilter extends Filter {
    private static int NUM_OF_PARAMS = 1;

    protected String fileNameParameter;

    public ContainsFilter(String[] filterParameters) throws Type1Exception {super(filterParameters,
            NUM_OF_PARAMS);}

    @Override
    protected boolean matchesFilter(File toFilter) {
        return toFilter.getName().contains(fileNameParameter);
    }

    @Override
    protected void setCommandParameters() throws Type1Exception {fileNameParameter = filterParameters[1];}

}
