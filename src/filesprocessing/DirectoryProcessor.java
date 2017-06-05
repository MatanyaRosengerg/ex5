package filesprocessing;


import filesprocessing.factories.*;
import filesprocessing.exception.*;


import java.io.File;
import java.util.ArrayList;


public class DirectoryProcessor {

    private static final String ARGS_NUM_ERROR = "number of arguments must be 2";

    public static void main(String[] args) {
        try {
            analyzeArgs(args);
            String commandsPath = args[1];
            String directoryPath = args[0];
            String[] commandLines = FilesToArrayFactory.getCommandLines(commandsPath);
            ArrayList<CommandSection> commandSections = CommandSectionFactory.sectionCommands(commandLines);
            executeAll(commandSections, new File(directoryPath));

        } catch (Type2Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private static void analyzeArgs(String[] args) throws Type2Exception {
        if (args.length != 2) {
            throw new Type2Exception(ARGS_NUM_ERROR);
        }

    }

    private static void executeAll(ArrayList<CommandSection> commandSections, File directory) throws
            Type2Exception {
        for (CommandSection commandSection : commandSections) {
            commandSection.doCommand(directory);
        }
    }

}


