package filesprocessing.filter;

import filesprocessing.fileFormatExceptions.CommandException;

import java.io.File;


public class AllFilter extends Filter {


    public AllFilter(String[] filterParameters) throws CommandException {
        super(null);
        //Check line to throw exeptions
        //throw new CommandException("From filterFactory: Not A filter Name in line ");
    }
    //TODO check null validity in AllFilter


    @Override
    protected boolean matchesFilter(File toFilter) {
        return false;
    }

    @Override
    protected void setCommandParameters(String[] filterLine) {
    }//Todo

}
