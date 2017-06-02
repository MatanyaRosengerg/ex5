package filesprocessing.order;

import java.io.File;


public class AbsCompare extends FileComparator {

    public AbsCompare(boolean isReversed) {
        super(isReversed);
    }

    @Override
    protected int subCompare(File file1, File file2) {
        return defaultCompare(file1, file2);
    }

}
