package filesprocessing.filter.contain_string_filters;

import filesprocessing.exception.Type1Exception;

import java.io.File;


public class SuffixFilter extends ContainsFilter {

    /**
     * Constructor
     * @param filterParameters Array of splitted command
     * @throws Type1Exception if invalid command
     */
    public SuffixFilter(String[] filterParameters) throws Type1Exception {super(filterParameters);}

    /**
     * Check if file's suffix is as needed.
     * @param toFilter the file to check
     * @return True if so.
     */
    @Override
    protected boolean matchesFilter(File toFilter) {
        return toFilter.getName().endsWith(fileNameParameter);
    }

}