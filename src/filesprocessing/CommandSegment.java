package filesprocessing;


import filesprocessing.factories.FilterFactory;
import filesprocessing.fileFormatExceptions.*;
import filesprocessing.filter.*;
import filesprocessing.order.*;


import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class CommandSegment {
    public static final String FILTER = "FILTER";
    private static final String ORDER = "ORDER";
    public static final String EMPTY = "";
    private static final String BREAK = "#";

    //Todo move to exception class
    private static final String MISSING_FILTER = "ERROR: Missing FILTER sub section heading in line ";
    private static final String MISSING_ORDER = "ERROR: Missing ORDER sub section heading in line ";


    /** indices of the lines in the sections of the commands file */
    public static final int SECTION_LENGTH = 4;
    private static final int FILTER_IDX = 0;
    private static final int FILTER__SUB_IDX = 1;
    private static final int ORDER_IDX = 2;
    public static final int ORDER__SUB_IDX = 3;

    public static final int FILTER_NAME_IDX = 0;

    private String[] filterParameters;
    private String[] orderParameters;
    private int headLineIndex;

    private Filter filter;
    private Order order;

    /**
     * Constructs a new CommandSegment instance. Throws type II exception (FileInputException) if there is
     * a format error in the command section.
     *
     * @param stringSegment Array of the lines of the command segment from the commands file
     * @param headLineIndex The line number of the first line  in the commands file
     * @throws FileInputException throws if the segments is not properly formatted (no FILTER or ORDER
     *                            headlines)
     */
    public CommandSegment(String[] stringSegment, int headLineIndex) throws FileInputException {
        this.headLineIndex = headLineIndex;
        checkSegmentFormatErrors(stringSegment); //@throws FileInputException
        filterParameters = breakUpCommandLine(stringSegment[FILTER__SUB_IDX]);
        orderParameters = breakUpCommandLine(stringSegment[ORDER__SUB_IDX]); //May be empty!
    }

    /**
     * Checks if a command segment has a FILTER section and an ORDER section. throws a FileInputException if
     * one is missing (if both are missing, the error is for the FILTER).
     *
     * @param commandSegment Segment to check
     * @throws FileInputException if one the (supposed) head lines are not in format
     */
    private void checkSegmentFormatErrors(String[] commandSegment) throws FileInputException {
        if (!commandSegment[FILTER_IDX].equals(FILTER)) {
            throw new FileInputException(errorMessage(MISSING_FILTER, headLineIndex + FILTER_IDX));
        }
        if (!commandSegment[ORDER_IDX].equals(ORDER)) {
            throw new FileInputException(errorMessage(MISSING_ORDER, headLineIndex + ORDER_IDX));
        }
    }

    /**
     * Executes the specified commands on the given directory
     *
     * @param directory The directory to sort and print its files
     */
    public void doCommands(File directory) {//TODO finish other classes and then write this method!...?
        try {
            filter = FilterFactory.getFilterByCommand(filterParameters);
        } catch (CommandException e) {
            printWarningMessage(e, headLineIndex + FILTER__SUB_IDX);
            filter = new AllFilter();
        }
        //try and same shit with Order

        ArrayList<File> filteredDirectory = new ArrayList<>();//TODO = DO somthing - this is not good
        File[] files = directory.listFiles();

        Collections.addAll(filteredDirectory, files);
        filteredDirectory = filter.doFilter(filteredDirectory);
        //TODO same Shit with order

        for(File file: filteredDirectory){System.out.println(file.getName());}

    }


    /**
     * Prints an error message the stdeer with an indication for the line number in which the error occurred
     *
     * @param exception the thrown exception
     * @param lineNum   the line in which the exception occurred
     */
    private static void printWarningMessage(CommandException exception, int lineNum) {
        System.err.println(exception.getMessage() + lineNum);//TODO properly format the error messages!
    }

    /**
     * returns an error message of type II errors
     *
     * @param errorMessage - the error message that explains the error
     * @param lineNum      the line in which the error occurred
     * @return A formatted String of an error for the stderr.
     */
    private static String errorMessage(String errorMessage, int lineNum) {
        return (errorMessage + lineNum + "\n");//TODO make it in a new exception class!!?
    }

    /**
     * Breaks up the filter command line into its parameters according to the "#".
     *
     * @param commandline The command to split
     * @return the (potential) parameters of the command line
     */
    private static String[] breakUpCommandLine(String commandline) {return commandline.split(BREAK);}

}
