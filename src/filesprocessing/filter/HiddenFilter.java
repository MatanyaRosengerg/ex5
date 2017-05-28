package filesprocessing.filter;


import filesprocessing.exception.Type1Exception;

import java.io.File;

public  class HiddenFilter extends PropertyFilter {
    public HiddenFilter(String[] filterLine) throws Type1Exception {super(filterLine);}

    @Override
    protected boolean matchesSubFilter(File toFilter) {return toFilter.isHidden();}
}
