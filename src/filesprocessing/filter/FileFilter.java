package filesprocessing.filter;

import filesprocessing.exception.Type1Exception;

import java.io.File;


public class FileFilter extends ContainsFilter {
    private static int numberOfParameters = 1;


    public FileFilter(String[] filterParameters) throws Type1Exception {super(filterParameters);}

    @Override
    protected boolean matchesFilter(File toFilter) {
        return toFilter.getName().equals(fileNameParameter);
    }

}
