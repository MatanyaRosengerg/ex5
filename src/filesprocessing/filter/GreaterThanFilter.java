package filesprocessing.filter;


import filesprocessing.fileFormatExceptions.CommandException;

import java.io.File;

public class GreaterThanFilter extends Filter {

    public GreaterThanFilter(String[] filterParameters) throws CommandException {super(filterParameters);}

    @Override
    protected boolean matchesFilter(File toFilter) {
        return false;
    }

    @Override
    protected void setCommandParameters(String[] filterLine) {
    }

}
