package filesprocessing.order;

import java.io.File;


public class AbsCompare extends FileComparator {

    /**
     * Constructor
     * @param isReversed True if REVERSE is on
     */
    public AbsCompare(boolean isReversed) {
        super(isReversed);
    }

    /**
     * Compare absolute name of the files
     * @param file1 file to compare
     * @param file2 other file to compare
     * @return Comparation result
     */
    @Override
    protected int subCompare(File file1, File file2) {
        return defaultCompare(file1, file2);
    }

}
