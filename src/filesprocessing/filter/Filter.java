package filesprocessing.filter;


import filesprocessing.exception.Type1Exception;

import java.io.File;
import java.util.ArrayList;

public abstract class Filter {
    /** number of valid parameters */
    private static int numberOfParameters; //TODO - Change all to protected?? No. but do something or delete.

    /** the line of the filter sub-section command after being split into by "#" */
    protected String[] filterParameters;

    /** the parameter that determines if the NOT suffix is in the command */
    protected boolean hasNOTcommand = false;

    /** The user format for using the NOT suffix */
    static final String NOT = "NOT";


    /**
     * Constructs the filter, verifies the parameters, and sets the command prameters for the filter.
     *
     * @param filterParameters the line of the filter sub-section command after being split into by "#"
     * @throws Type1Exception if the command format isn't good
     */
    Filter(String[] filterParameters) throws Type1Exception {
        this.filterParameters = filterParameters;
        setCommandParameters(filterParameters);
        setNOTCommand();
    }

    /**
     * default constructor to avoid exceptions
     */
    protected Filter() {}


    /**
     * This method determines weather a file meets the filter *FULL-command* condition
     *
     * @param toFilter the file to check
     * @return true iff file meets condition
     */
    protected abstract boolean matchesFilter(File toFilter);

    /**
     * Convert text to parameters
     *
     * @param filterLine String[] of parameters' text
     * @throws Type1Exception Throw Type1 Exception if the parameters are wrong
     */
    protected abstract void setCommandParameters(String[] filterLine) throws Type1Exception;
    //TODO - no need for arguments filterLine because it's protected

    /**
     * Filteres the files according to wheather or not they match the filter command line conditions.
     *
     * @param dirFiles the files to filter (ArrayList<File>)
     */
    public ArrayList<File> doFilter(ArrayList<File> dirFiles) {
        ArrayList<File> filteredFiles = new ArrayList<>();
        filterDirectories(dirFiles);
        for (File file : dirFiles) {
            if (!file.isDirectory() && (matchesFilter(file) == !hasNOTcommand)) {filteredFiles.add(file);}
        }
        return filteredFiles;
    }

    /**
     * Initial filter to remove all directories and leave only files in the directory.
     *
     * @param directoryFiles the files and directories in the directory
     * @throws NullPointerException //TODO check the case of empty directory!!
     */
    private void filterDirectories(ArrayList<File> directoryFiles) throws NullPointerException {
        for (File file : directoryFiles) {if (file.isDirectory()) {directoryFiles.remove(file);}}
    }

    /**
     * Set the NOT command according to the suffix. This is done only after verifying the the format of
     * the command line is good.
     */ //TODO - make it throw and check the length == numOfParams+2 && suffix == 'NOT'
    private void setNOTCommand() throws Type1Exception {
        if (filterParameters.length == numberOfParameters + 2) {
            String commandSuffix = filterParameters[filterParameters.length - 1];
            if (!commandSuffix.equals(NOT)) {throw new Type1Exception();}
            else {this.hasNOTcommand = true;}
        }//Otherwise, assert that there is no NOT command, and leave it false.
    }

    /**
     * Check if the number of parameters is valid.
     *
     * @param filterLine         The parameters as String array
     * @param numberOfParameters Valid number of parameters.
     * @throws Type1Exception Throw Exception if invalid
     */
    static void checkNumberOfParameters(String[] filterLine, int numberOfParameters) throws Type1Exception {
        if (filterLine.length != numberOfParameters + 1 && filterLine.length != numberOfParameters + 2) {
            throw new Type1Exception();
        }
    }

}
