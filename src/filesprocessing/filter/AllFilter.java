package filesprocessing.filter;

import filesprocessing.exception.Type1Exception;

import java.io.File;


public class AllFilter extends Filter {
    private static int NUM_OF_PARAMS = 0;

    /**
     * Constructor
     * @param filterParameters Array of splitted command
     * @throws Type1Exception if invalid command
     */
    public AllFilter(String[] filterParameters) throws Type1Exception {
        super(filterParameters, NUM_OF_PARAMS);

    }

    /** default construction of filter, that does't throw exceptions */
    public AllFilter() {this.hasNOTcommand = false;}

    /**
     * Every file passes all filter
     * @param toFilter the file to check
     * @return True
     */
    @Override
    protected boolean matchesFilter(File toFilter) {
        return true;
    }

    /**
     * Set command parameters
     */
    @Override
    protected void setCommandParameters() {}

}