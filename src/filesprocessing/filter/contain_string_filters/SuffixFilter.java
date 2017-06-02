package filesprocessing.filter.contain_string_filters;

import filesprocessing.exception.Type1Exception;

import java.io.File;


public class SuffixFilter extends ContainsFilter {

    public SuffixFilter(String[] filterParameters) throws Type1Exception {super(filterParameters);}

    @Override
    protected boolean matchesFilter(File toFilter) {
        return toFilter.getName().endsWith(fileNameParameter);
    }

}