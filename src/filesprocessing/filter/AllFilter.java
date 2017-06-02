package filesprocessing.filter;

import filesprocessing.exception.Type1Exception;

import java.io.File;


public class AllFilter extends Filter {
    private static int NUM_OF_PARAMS = 0;

    public AllFilter(String[] filterParameters) throws Type1Exception {
        super(filterParameters, NUM_OF_PARAMS);

    }

    /** default construction of filter, that does't throw exceptions */
    public AllFilter() {this.hasNOTcommand = false;}


    @Override
    protected boolean matchesFilter(File toFilter) {
        return true;
    }

    @Override
    protected void setCommandParameters() {}

}