package filesprocessing.filter.contain_string_filters;

import filesprocessing.exception.Type1Exception;

import java.io.File;


public class PrefixFilter extends ContainsFilter {

    public PrefixFilter(String[] filterParameters) throws Type1Exception {super(filterParameters);}

    @Override
    protected boolean matchesFilter(File toFilter) {return toFilter.getName().startsWith(fileNameParameter);}

}
