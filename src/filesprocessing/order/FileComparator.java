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
    public abstract int compare(File file1, File file2);

}
