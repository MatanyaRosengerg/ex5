package filesprocessing.filter;

import filesprocessing.fileFormatExceptions.CommandException;

import java.io.File;


public class WritableFilter extends PropertyFilter {

    public WritableFilter(String[] filterParameters) throws CommandException {super(filterParameters);}

    @Override
    protected boolean matchesSubFilter(File toFilter) {return toFilter.canWrite();}

}
