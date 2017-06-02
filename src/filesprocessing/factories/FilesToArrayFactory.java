package filesprocessing.factories;

//TODO - merge with file2array
public class FilesToArrayFactory {


    /**
     * Returns the lines of the commands file in an array
     *
     * @param commandsPath - The path of the commands file (may be absolute or relative)
     * @return - The lines of the commands file in an array
     */
    public static String[] getCommandLines(String commandsPath) {
        return file2array.file2array(commandsPath);
    }

}
