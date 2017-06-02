package filesprocessing.factories;

import filesprocessing.CommandSection;
import filesprocessing.exception.Type2Exception;

import java.util.ArrayList;
import java.util.Arrays;


public class CommandSectionFactory {

    /**
     * Segments the command lines into the different sections. Each segment is of size 4, and may have an
     * empty last line for the ORDER command. in that, case, if the line after ORDER is FILTER, a new
     * section starts.
     *
     * @param commandLines The lines of the commands file
     * @return an array of the segments of the commands (in an array of their lines)
     */
    public static ArrayList<CommandSection> sectionCommands(String[] commandLines) throws Type2Exception {
        ArrayList<CommandSection> allSections = new ArrayList<>();
        int i = 0;
        while (i < commandLines.length) {
            int headLineIdx = i + 1;//Counts starts at 1

            String[] currentSection = new String[CommandSection.SECTION_LENGTH];
            Arrays.fill(currentSection, CommandSection.EMPTY);

            for (int j = i, subIdx = 0; j < commandLines.length && subIdx < CommandSection.SECTION_LENGTH;
                 j++, subIdx++) {
                currentSection[subIdx] = commandLines[j];
            }

            if (currentSection[CommandSection.ORDER__SUB_IDX].equals(CommandSection.FILTER)) {
                currentSection[CommandSection.ORDER__SUB_IDX] = CommandSection.EMPTY;
                i--; //Start next section from the "FILTER" line
            }

            //@throws Type2Exception.
            allSections.add(new CommandSection(currentSection, headLineIdx));
            i = i + CommandSection.SECTION_LENGTH;
        }
        return allSections;
    }


}
