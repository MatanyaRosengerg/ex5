package filesprocessing.factories;

import filesprocessing.exception.Type2Exception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class FilesToArrayFactory {

    private static final String READ_FILE_ERROR_MESSAGE = "Error in opening COMMANDS file";
    /**
     * Returns the lines of the commands file in an array
     *
     * @param commandsPath - The path of the commands file (may be absolute or relative)
     * @return - The lines of the commands file in an array as String[].
     */
    public static String[] getCommandLines(String commandsPath) throws Type2Exception {
        try {
            // A list for the file's lines
            List<String> commandLinesList = new ArrayList<String>();


            // Create a new reader to read the file's lines
            BufferedReader reader = new BufferedReader(new FileReader(commandsPath));

            //Add file lines to fileContent
            String line = reader.readLine();
            while (line != null) {commandLinesList.add(line); line = reader.readLine();}

            reader.close();

            // Convert the list to a String array and return it
            String[] lines = new String[commandLinesList.size()];
            commandLinesList.toArray(lines);
            return lines;

        } catch (Exception e) {throw new Type2Exception(READ_FILE_ERROR_MESSAGE);}
    }
}
