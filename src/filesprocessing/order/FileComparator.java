package filesprocessing.order;

import java.io.File;
import java.util.Comparator;


public abstract class FileComparator implements Comparator<File> {

    protected int isReversed;

    /**
     * Constructs a fileComparator using the isReversed argument, and setting it to the right value.
     *
     * @param isReversed - boolean that determines whether or not the order should be reversed.
     */
    protected FileComparator(boolean isReversed) {
        if (isReversed) { this.isReversed = -1; }
        else { this.isReversed = 1; }
    }

    @Override
    public int compare(File file1, File file2) {
        int compare = subCompare(file1, file2);
        if (compare == 0) {return defaultCompare(file1, file2);}
        else {return compare;}
    }

    /**
     * Compares the files by the sub class comparator. If the compare resolved in equal, the compare by
     * default comparator (abs).
     *
     * @param file1 file to compare
     * @param file2 other file to compare
     * @return a negative integer, zero, or a positive integer as the
     * first argument is less than, equal to, or greater than the
     * second.
     */
    protected abstract int subCompare(File file1, File file2);

    /**
     * Compares by abs
     *
     * @param file1 file to compare
     * @param file2 other file to compare
     * @return a negative integer, zero, or a positive integer as the
     *          first argument is less than, equal to, or greater than the
     *          second.
     */
    protected int defaultCompare(File file1, File file2) {
        return isReversed * file1.getAbsolutePath().compareTo(file2.getAbsolutePath());
    }

}
