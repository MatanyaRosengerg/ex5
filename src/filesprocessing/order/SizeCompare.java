package filesprocessing.order;

import java.io.File;


public class SizeCompare extends FileComparator {

    public SizeCompare(boolean isReversed) {
        super(isReversed);
    }

    @Override
    protected int subCompare(File file1, File file2) {
        return isReversed * Long.compare(file1.length(), file2.length());
    }

}
