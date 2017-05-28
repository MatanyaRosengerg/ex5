package filesprocessing.order;

import java.io.File;
import java.util.Comparator;

/**
 * Created by t8307673 on 28/05/2017.
 */
public class AbsCompare extends Comperator {

    public AbsCompare(boolean isReversed) {
        super(isReversed);
    }

    @Override
    public int compare(File file1, File file2) {
        return super.isReversed * file1.getAbsolutePath().compareTo(file2.getAbsolutePath());
    }

}
