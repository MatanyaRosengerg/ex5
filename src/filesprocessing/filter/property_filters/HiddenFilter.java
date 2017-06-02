package filesprocessing.filter.property_filters;


import filesprocessing.exception.Type1Exception;

import java.io.File;


public class HiddenFilter extends PropertyFilter {

    public HiddenFilter(String[] filterParameters) throws Type1Exception {super(filterParameters);}

    @Override
    protected boolean matchesSubFilter(File toFilter) {return toFilter.isHidden();}
}
