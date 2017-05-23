package filesprocessing.filter;


import filesprocessing.fileFormatExceptions.CommandException;

import java.io.File;
import java.util.ArrayList;

public abstract class Filter {
    protected String[] filterParameters;
    protected boolean hasNOTcommand;
    static final String NOT = "NOT";


    Filter(String[] filterParameters) throws CommandException {
        this.filterParameters = filterParameters;
        setCommandParameters(filterParameters);
        setNOTCommand();
    }


    protected abstract boolean matchesFilter(File toFilter);

    protected abstract void setCommandParameters(String[] filterLine) throws CommandException;

    /**
     * Filteres the files according to wheather or not they match the filter command line conditions.
     *
     * @param dirFiles the files to filter (ArrayList<File>)
     */
    public void doFilter(ArrayList<File> dirFiles) {//TODO consider making and returning a new list
        filterDirectories(dirFiles);
        for (File file : dirFiles) {if (!matchesFilter(file)) {dirFiles.remove(file);}}
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

    private void setNOTCommand() {
        this.hasNOTcommand = filterParameters[filterParameters.length - 1].equals(NOT);
    }
}

