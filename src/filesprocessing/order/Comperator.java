package filesprocessing.order;

import java.io.File;
import java.util.Comparator;

/**
 * Created by t8307673 on 28/05/2017.
 */
public abstract class Comperator implements Comparator<File> {

    protected int isReversed;

    public Comperator(boolean isReversed){
        if (isReversed)
            this.isReversed = -1;
        else
            this.isReversed = 1;
    }

    @Override
    public abstract int compare(File file1, File file2);

}
