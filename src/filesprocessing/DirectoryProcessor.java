package filesprocessing;


import filesprocessing.factories.*;
import filesprocessing.fileFormatExceptions.*;


import java.io.File;
import java.util.ArrayList;


public class DirectoryProcessor {
    public static void main(String[] args) {
        try {
            analyzeFileErrors(args); //Todo expand to do all
            String[] commandLines = FilesToArrayFactory.getCommandLines(args[1]);
            ArrayList<CommandSegment> commandSegments = CommandSegementFactory.segmentCommands(commandLines);
            executeAll(commandSegments, new File(args[0]));

        } catch (FileInputException e) {System.err.println(e.getMessage());}


    }

    private static void analyzeFileErrors(String[] args) throws FileInputException {
        if (args.length != 2) {throw new FileInputException("ERROR: should be only 2 arguments");}

    }

    private static void executeAll(ArrayList<CommandSegment> commandSegments, File directory) {
        for (CommandSegment commandSegment : commandSegments) {
            commandSegment.doCommands(directory);
            //TODO how not to change the directory files??
        }
    }

}


