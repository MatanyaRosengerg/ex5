package filesprocessing.order;

import java.io.File;
import java.util.regex.Pattern;


public class TypeCompare extends FileComparator {
    private static final String SPLIT_DOT = ".";
    private static final String NO_TYPE = "";

    /**
     * Constructor
     * @param isReversed True if REVERSE is on
     */
    public TypeCompare(boolean isReversed) {
        super(isReversed);
    }

    /**
     * Compare the types of the files
     * @param file1 file to compare
     * @param file2 other file to compare
     * @return Comparation result
     */
    @Override
    protected int subCompare(File file1, File file2) {
        return isReversed * getType(file1).compareTo(getType(file2));
    }

    /*
    * Get the type of a file
     */
    private String getType(File file) {
        String[] split = file.getName().split(Pattern.quote(SPLIT_DOT));
        if (split.length == 1) {
            return NO_TYPE;
        }
        return split[split.length - 1];
    }
}
