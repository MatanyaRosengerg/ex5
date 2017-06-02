package filesprocessing.filter.size_filters;


import filesprocessing.exception.Type1Exception;
import filesprocessing.filter.Filter;

import java.io.File;

public abstract class SizeFilter extends Filter {

    public static final int BYTE_TO_KB = 1024;

    protected SizeFilter(String[] filterParameters, int numOfParams) throws Type1Exception {
        super(filterParameters, numOfParams);
    }

    @Override
    protected abstract boolean matchesFilter(File toFilter);

    @Override
    protected abstract void setCommandParameters() throws Type1Exception;

    /**
     * Returns the user parameter in the line of the filter in the  'paramIdx' place.
     *
     * @param paramIdx the index in which the parameter is.
     * @return the parameter (a double - which is a bound in k-bytes)
     * @throws Type1Exception in case the bound is negative.
     */
    protected double getParameter(int paramIdx) throws Type1Exception {
        try {
            double param = Double.parseDouble(filterParameters[paramIdx]);
            if (param < 0) { throw new Type1Exception(); }
            return BYTE_TO_KB * param;
        } catch (Exception e) {
            throw new Type1Exception();
        }
    }
}
