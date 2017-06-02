package filesprocessing;


import filesprocessing.factories.FilterFactory;
import filesprocessing.exception.*;
import filesprocessing.filter.*;
import filesprocessing.order.*;


import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class CommandSection {
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
    public static final int ORDER_NAME_IDX = 0;

    private String[] filterParameters;
    private String[] orderParameters;
    private int headLineIndex;

    private Filter filter;
    private Order order;

    /**
     * Constructs a new CommandSection instance. Throws type II exception (Type2Exception) if there is
     * a format error in the command section.
     *
     * @param stringSegment Array of the lines of the command segment from the commands file
     * @param headLineIndex The line number of the first line  in the commands file
     * @throws Type2Exception throws if the segments is not properly formatted (no FILTER or ORDER
     *                        headlines)
     */
    public CommandSection(String[] stringSegment, int headLineIndex) throws Type2Exception {
        this.headLineIndex = headLineIndex;
        checkSegmentFormatErrors(stringSegment); //@throws Type2Exception
        filterParameters = breakUpCommandLine(stringSegment[FILTER__SUB_IDX]);
        orderParameters = breakUpCommandLine(stringSegment[ORDER__SUB_IDX]); //May be empty!
    }

    /**
     * Checks if a command segment has a FILTER section and an ORDER section. throws a Type2Exception if
     * one is missing (if both are missing, the error is for the FILTER).
     *
     * @param commandSegment Segment to check
     * @throws Type2Exception if one the (supposed) head lines are not in format
     */
    private void checkSegmentFormatErrors(String[] commandSegment) throws Type2Exception {
        if (!commandSegment[FILTER_IDX].equals(FILTER)) {
            throw new Type2Exception(errorMessage(MISSING_FILTER,headLineIndex+FILTER_IDX));
        }
        if (!commandSegment[ORDER_IDX].equals(ORDER)) {
            throw new Type2Exception(errorMessage(MISSING_ORDER,headLineIndex+ORDER_IDX));
        }
    }

    /**
     * Executes the specified commands on the given directory
     *
     * @param directory The directory to sort and print its files
     */
    void doCommand(File directory) throws Type2Exception {

        try {
            filter = FilterFactory.getFilterByCommand(filterParameters);
        } catch (Type1Exception e) {
            printWarningMessage(e, headLineIndex + FILTER__SUB_IDX);
            filter = new AllFilter();
        }

        try {
            order = new Order(orderParameters);
        } catch (Type1Exception e) {
            printWarningMessage(e, headLineIndex + ORDER__SUB_IDX);
            order = new Order();
        }

        ArrayList<File> filteredDirectory = new ArrayList<>();
        File[] files = directory.listFiles();
        if (files == null) {
            throw new Type2Exception("NO FILES IN DIRECTORY"); //TODO - DFUK!! Type2Exception were supposed to
        }
        // be already caught!!
        Collections.addAll(filteredDirectory, files);
        filteredDirectory = filter.doFilter(filteredDirectory);
        filteredDirectory = order.doOrder(filteredDirectory);
        for (File file : filteredDirectory) {System.out.println(file.getName());}

    }

    /**
     * returns an error message of type II errors
     *
     * @param errorMessage - the error message that explains the error
     * @param lineNum      the line in which the error occurred
     * @return A formatted String of an error for the stderr.
     */
    private static String errorMessage(String errorMessage, int lineNum) {
        return (errorMessage + lineNum );
    }

    /**
     * Prints an error message the stdeer with an indication for the line number in which the error occurred
     *
     * @param exception the thrown exception
     * @param lineNum   the line in which the exception occurred
     */
    private static void printWarningMessage(Type1Exception exception, int lineNum) {
        System.err.println("Warning in line " + lineNum + ": " + exception.getMessage());
    }

    /**
     * Breaks up the filter command line into its parameters according to the "#".
     *
     * @param commandline The command to split
     * @return the (potential) parameters of the command line
     */
    private static String[] breakUpCommandLine(String commandline) {return commandline.split(BREAK);}

}
