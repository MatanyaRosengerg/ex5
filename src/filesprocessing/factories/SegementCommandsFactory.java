package filesprocessing.factories;

import filesprocessing.CommandSegment;
import filesprocessing.fileFormatExceptions.FileInputException;

import java.util.ArrayList;
import java.util.Arrays;


public class SegementCommandsFactory {

    /**
     * Segments the command lines into the different sections. Each segment is of size 4, and may have an
     * empty last line for the ORDER command. in that, case, if the line after ORDER is FILTER, a new
     * section starts.
     *
     * @param commandLines The lines of the commands file
     * @return an array of the segments of the commands (in an array of their lines)
     */
    public static ArrayList<CommandSegment> segmentCommands(String[] commandLines) throws FileInputException {
        ArrayList<CommandSegment> allSegements = new ArrayList<CommandSegment>();
        int i = 0;
        while (i < commandLines.length) {
            int headLineIdx = i + 1;//Counts starts at 1

            String[] currentSection = new String[CommandSegment.SECTION_LENGTH];
            Arrays.fill(currentSection, CommandSegment.EMPTY);

            for (int j = i, subIdx = 0; j < commandLines.length && subIdx < CommandSegment.SECTION_LENGTH;
                 j++, subIdx++) {
                currentSection[subIdx] = commandLines[j];
            }

            if (currentSection[CommandSegment.ORDER__SUB_IDX].equals(CommandSegment.FILTER)) {
                currentSection[CommandSegment.ORDER__SUB_IDX] = CommandSegment.EMPTY;
                i--; //Start next section from the "FILTER" line
            }

            allSegements.add(new CommandSegment(currentSection, headLineIdx));
            i = i + CommandSegment.SECTION_LENGTH;
        }
        return allSegements;
    }


}
