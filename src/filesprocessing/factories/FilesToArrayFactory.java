package filesprocessing.factories;


import filesprocessing.exception.Type2Exception;

import java.io.File;
import java.util.ArrayList;

public class FilesToArrayFactory {

    /**
     * Returns the names of the files in the directory.
     *
     * @param sourceDirPath the directory of the files
     * @return array of the file's names
     * @throws Type2Exception - if there is something wrong with the directory
     */
    public static String[] getSourceNames(String sourceDirPath) throws Type2Exception {
        File source = new File(sourceDirPath);
        if (!source.exists()) {throw new Type2Exception();}
        if (!source.isDirectory()) {throw new Type2Exception();}

        File[] sourceFiles = source.listFiles();
        if (sourceFiles == null) {throw new Type2Exception();}//TODO

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
