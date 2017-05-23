package filesprocessing.filter;


import filesprocessing.fileFormatExceptions.CommandException;

import java.io.File;

public  class HiddenFilter extends PropertyFilter {
    public HiddenFilter(String[] filterLine) throws CommandException {super(filterLine);}

    @Override
    protected boolean matchesSubFilter(File toFilter) {return toFilter.isHidden();}
}
