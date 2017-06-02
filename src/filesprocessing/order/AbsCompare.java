package filesprocessing.order;

import java.io.File;


public class AbsCompare extends FileComparator {

    public AbsCompare(boolean isReversed) {
        super(isReversed);
    }

    @Override
    public int compare(File file1, File file2) {
        return isReversed * file1.getAbsolutePath().compareTo(file2.getAbsolutePath());
    }

}
