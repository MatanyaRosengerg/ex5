package filesprocessing.factories;


import filesprocessing.fileFormatExceptions.FileInputException;

import java.io.File;
import java.util.ArrayList;

public class FilesToArrayFactory {

    /**
     * Returns the names of the files in the directory.
     *
     * @param sourceDirPath the directory of the files
     * @return array of the file's names
     * @throws FileInputException - if there is something wrong with the directory
     */
    public static String[] getSourceNames(String sourceDirPath) throws FileInputException {
        File source = new File(sourceDirPath);
        if (!source.exists()) {throw new FileInputException("Source Does Not Exist" + sourceDirPath);}
        if (!source.isDirectory()) {throw new FileInputException("Source is Not a Directory");}

        File[] sourceFiles = source.listFiles();
        if (sourceFiles == null) {throw new FileInputException("Source is Empty");}//TODO

        String[] sourceFileNames = new String[sourceFiles.length];
        for (int i = 0; i < sourceFiles.length; i++) {sourceFileNames[i] = sourceFiles[i].getName();}

        return sourceFileNames;
    }

    /**
     * Returns the lines of the commands file in an array
     *
     * @param commandsPath - The path of the commands file (may be absolute or relative)
     * @return - The lines of the commands file in an array
     */
    public static String[] getCommandLines(String commandsPath) {
        return file2array.file2array(commandsPath);
    }

    public static void printFileNames(ArrayList<File> filtered) {
        for (File file : filtered) {System.out.println(file.getName());}
    }
}
