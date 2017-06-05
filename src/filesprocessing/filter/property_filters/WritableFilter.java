package filesprocessing.filter.property_filters;


import filesprocessing.exception.Type1Exception;

import java.io.File;


public class WritableFilter extends PropertyFilter {

    /**
     * Constructor
     * @param filterParameters Array of splitted command
     * @throws Type1Exception if invalid command
     */
    public WritableFilter(String[] filterParameters) throws Type1Exception {super(filterParameters);}

    /**
     * Check if the file is writable.
     * @param toFilter the file to check if meets condition
     * @return True if so.
     */
    @Override
    protected boolean matchesSubFilter(File toFilter) {return toFilter.canWrite();}

}
