package filesprocessing.order;

import java.io.File;

/**
 * Created by t8307673 on 28/05/2017.
 */
public class TypeCompare extends Comperator {

    public TypeCompare(boolean isReversed) {
        super(isReversed);
    }

    @Override
    public int compare(File file1, File file2) {
        return getType(file1).compareTo(getType(file2));
    }

    private String getType(File file){
        String[] split = file.getName().split(".");
        if (split.length == 1){
            return null;
        }
        return split[split.length - 1];
    }
}
