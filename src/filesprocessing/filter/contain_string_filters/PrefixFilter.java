package filesprocessing.filter.contain_string_filters;

import filesprocessing.exception.Type1Exception;

import java.io.File;


public class PrefixFilter extends ContainsFilter {

    /**
     * Constructor
     * @param filterParameters Array of splitted command
     * @throws Type1Exception if invalid command
     */
    public PrefixFilter(String[] filterParameters) throws Type1Exception {super(filterParameters);}

    /**
     * Check if file's prefix is as needed.
     * @param toFilter the file to check
     * @return True if so.
     */
    @Override
    protected boolean matchesFilter(File toFilter) {return toFilter.getName().startsWith(fileNameParameter);}

}
