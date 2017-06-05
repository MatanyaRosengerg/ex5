package filesprocessing.filter.contain_string_filters;

import filesprocessing.exception.Type1Exception;
import filesprocessing.filter.Filter;

import java.io.File;


public class ContainsFilter extends Filter {
    private static int NUM_OF_PARAMS = 1, NAME_PARAMETER_LOCATION = 1;

    protected String fileNameParameter;

    /**
     * Constructor
     * @param filterParameters Command's parameters array
     * @throws Type1Exception Exception if invalid command
     */
    public ContainsFilter(String[] filterParameters) throws Type1Exception {super(filterParameters,
            NUM_OF_PARAMS);}

    /**
     * Check if file's name contains filter's parameter
     * @param toFilter the file to check
     * @return True if file's name contains the filter parameter
     */
    @Override
    protected boolean matchesFilter(File toFilter) {
        return toFilter.getName().contains(fileNameParameter);
    }

    /**
     * Save the filter parameter
     * @throws Type1Exception if the array is too short
     */
    @Override
    protected void setCommandParameters() throws Type1Exception {fileNameParameter =
            filterParameters[NAME_PARAMETER_LOCATION];}

}
