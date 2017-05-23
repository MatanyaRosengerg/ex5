package filesprocessing.filter;

import filesprocessing.fileFormatExceptions.CommandException;

import java.io.File;


public class AllFilter extends Filter {


    public AllFilter(String[] filterParameters) throws CommandException {
        super(filterParameters);

    }
    //TODO check null validity in AllFilter

    public AllFilter() {
        //Check line to throw exeptions
        //throw new CommandException("From filterFactory: Not A filter Name in line ");
        this.hasNOTcommand = false;
    }


    @Override
    protected boolean matchesFilter(File toFilter) {
        return true;
    }

    @Override
    protected void setCommandParameters(String[] filterLine) {}//Todo?

}
