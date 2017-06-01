package filesprocessing.filter;

import filesprocessing.exception.Type1Exception;

import java.io.File;


public class PrefixFilter extends ContainsFilter {
    protected static int numberOfParameters = 1;


    public PrefixFilter(String[] filterParameters) throws Type1Exception {super(filterParameters);}


    @Override
    protected boolean matchesFilter(File toFilter) {
        return toFilter.getName().startsWith(fileNameParameter);
    }

}
