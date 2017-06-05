package filesprocessing.filter.contain_string_filters;

import filesprocessing.exception.Type1Exception;

import java.io.File;


public class FileFilter extends ContainsFilter {

    /**
     * Constructor
     * @param filterParameters Array of splitted command
     * @throws Type1Exception if invalid command
     */
    public FileFilter(String[] filterParameters) throws Type1Exception {super(filterParameters);}

    /**
     * Check if file's name is the same.
     * @param toFilter the file to check
     * @return True if so.
     */
    @Override
    protected boolean matchesFilter(File toFilter) {
        return toFilter.getName().equals(fileNameParameter);
    }

}
