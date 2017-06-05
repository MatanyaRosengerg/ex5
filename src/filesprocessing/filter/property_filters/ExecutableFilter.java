package filesprocessing.filter.property_filters;


import filesprocessing.exception.Type1Exception;

import java.io.File;


public class ExecutableFilter extends PropertyFilter {

    /**
     * Constructor
     * @param filterParameters Array of splitted command
     * @throws Type1Exception if invalid command
     */
    public ExecutableFilter(String[] filterParameters) throws Type1Exception {super(filterParameters);}

    /**
     * Check if file is executable
     * @param toFilter the file to check if meets condition
     * @return True if so
     */
    @Override
    protected boolean matchesSubFilter(File toFilter) {
        return toFilter.canExecute();
    }

}
