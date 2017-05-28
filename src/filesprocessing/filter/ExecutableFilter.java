package filesprocessing.filter;


import filesprocessing.exception.Type1Exception;

import java.io.File;


public class ExecutableFilter extends PropertyFilter {

    public ExecutableFilter(String[] filterParameters) throws Type1Exception {super(filterParameters);}

    @Override
    protected boolean matchesSubFilter(File toFilter) {
        return toFilter.canExecute();
    }

}
