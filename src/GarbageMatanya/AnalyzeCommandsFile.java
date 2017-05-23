package GarbageMatanya;


import java.util.ArrayList;
import java.util.Arrays;


public class AnalyzeCommandsFile { //TODO make a class of CommandSegment
    private static final String FILTER = "FILTER";
    private static final String ORDER = "ORDER";
    private static final String MISSING_FILTER = "ERROR: Missing Filter sub section \n";
    private static final String MISSING_ORDER = "ERROR: Missing order sub section \n";
    private static final String EMPTY = "";


    /** indices of the lines in the sections of the commands file */
    public static final int SECTION_LENGTH = 4;
    public static final int FILTER_IDX = 0;
    public static final int FILTER__SUB_IDX = 1;
    public static final int ORDER_IDX = 2;
    public static final int ORDER__SUB_IDX = 3;


    /**
     * Goes over the command segments and determines if they can be handled. Returns an Error and
     * exists if there was a flaw in the format of the commands.
     *
     * @param commandLines The lines of the commands file
     */
    static void analyzeCommandsFormat(String[] commandLines) {
        String[][] commandSegments = segmentCommands(commandLines);
        for (String[] segment : commandSegments) {checkSegmentFormatErrors(segment);}
    }

    /**
     * Checks if a command segment has a FILTER section and an ORDER section. Returns an error message if
     * one is missing (if both are missing, the error is for the FILTER). Else, returns an empty string.
     *
     * @param commandSegment Segment to check
     * @return message of error if not properly formatted, empty String otherwise.
     */
    private static void checkSegmentFormatErrors(String[] commandSegment) {
        if (!commandSegment[FILTER_IDX].equals(FILTER)) {System.err.println(MISSING_FILTER); System.exit(0);}
        if (!commandSegment[ORDER_IDX].equals(ORDER)) {System.err.println(MISSING_ORDER); System.exit(0);}
    }

    /**
     * Segments the command lines into the different sections. Each segment is of size 4, and may have an
     * empty last line for the ORDER command. in that, case, if the line after ORDER is FILTER, a new
     * section starts.
     *
     * @param commandLines The lines of the commands file
     * @return an array of the segments of the commands (in an array of their lines)
     */
    public static String[][] segmentCommands(String[] commandLines) {

        ArrayList<String[]> sections = new ArrayList<String[]>();
        int i = 0;
        while (i < commandLines.length) {
            String[] currentSection = new String[SECTION_LENGTH];
            Arrays.fill(currentSection, EMPTY);

            for (int j = i, subIdx = 0; j < commandLines.length && subIdx < SECTION_LENGTH; j++, subIdx++) {
                currentSection[subIdx] = commandLines[j];
            }

            if (currentSection[ORDER__SUB_IDX].equals(FILTER)) {
                currentSection[ORDER__SUB_IDX] = EMPTY;
                i--; //Start next section from the "FILTER" line
            }

            sections.add(currentSection);
            i = i + SECTION_LENGTH;
        }

        String[][] returnSections = new String[sections.size()][SECTION_LENGTH];
        for (int secIdx = 0; secIdx < sections.size(); secIdx++) {
            returnSections[secIdx] = sections.get(secIdx);
        }
        return returnSections;
    }


}

