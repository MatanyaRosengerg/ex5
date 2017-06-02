package filesprocessing;


import filesprocessing.factories.*;
import filesprocessing.exception.*;


import java.io.File;
import java.util.ArrayList;


public class DirectoryProcessor {
    public static void main(String[] args) {
        try {
            analyzeFileErrors(args); //Todo expand to do all
            String[] commandLines = FilesToArrayFactory.getCommandLines(args[1]);
            ArrayList<CommandSection> commandSections = CommandSectionFactory.sectionCommands(commandLines);
            executeAll(commandSections, new File(args[0]));

        } catch (Type2Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private static void analyzeFileErrors(String[] args) throws Type2Exception {
        if (args.length != 2) {
            throw new Type2Exception("number of arguments must be 2");//todo - magic
        }

    }

    private static void executeAll(ArrayList<CommandSection> commandSections, File directory) throws
            Type2Exception {
        for (CommandSection commandSection : commandSections) {
            commandSection.doCommand(directory);
        }
    }

}


