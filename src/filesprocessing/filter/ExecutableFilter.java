package filesprocessing.filter;


import filesprocessing.fileFormatExceptions.CommandException;

import java.io.File;


public class ExecutableFilter extends PropertyFilter {

    public ExecutableFilter(String[] filterParameters) throws CommandException {super(filterParameters);}

    @Override
    protected boolean matchesSubFilter(File toFilter) {
        return toFilter.canExecute();
    }

}
