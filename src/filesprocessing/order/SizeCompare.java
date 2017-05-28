package filesprocessing.order;

import java.io.File;

/**
 * Created by t8307673 on 28/05/2017.
 */
public class SizeCompare extends Comperator {


    public SizeCompare(boolean isReversed) {
        super(isReversed);
    }

    @Override
    public int compare(File file1, File file2) {
        return Long.compare(file1.length(), file2.length());
    }
}
