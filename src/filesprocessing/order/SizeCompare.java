package filesprocessing.order;

import java.io.File;


public class SizeCompare extends FileComparator {

    /**
     * Constructor
     * @param isReversed True if REVERSE is on
     */
    public SizeCompare(boolean isReversed) {
        super(isReversed);
    }

    /**
     * Compare size fo the files
     * @param file1 file to compare
     * @param file2 other file to compare
     * @return Comparation result
     */
    @Override
    protected int subCompare(File file1, File file2) {
        return isReversed * Long.compare(file1.length(), file2.length());
    }

}
