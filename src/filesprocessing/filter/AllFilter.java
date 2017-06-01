package filesprocessing.filter;

import filesprocessing.exception.Type1Exception;

import java.io.File;


public class AllFilter extends Filter {


    public AllFilter(String[] filterParameters) throws Type1Exception {
        super(filterParameters);

    }
    //TODO check null validity in AllFilter

    public AllFilter() {
        //TODO Check line to throw exeptions
        //throw new Type1Exception("From filterFactory: Not A filter Name in line ");
        this.hasNOTcommand = false;
    }


    @Override
    protected boolean matchesFilter(File toFilter) {
        return true;
    }

    @Override
    protected void setCommandParameters(String[] filterLine) {

    }//Todo?

}
