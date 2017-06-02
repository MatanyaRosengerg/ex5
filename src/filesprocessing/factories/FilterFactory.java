package filesprocessing.factories;


import filesprocessing.CommandSection;
import filesprocessing.exception.Type1Exception;
import filesprocessing.filter.*;
import filesprocessing.filter.contain_string_filters.*;
import filesprocessing.filter.property_filters.*;
import filesprocessing.filter.size_filters.*;

public class FilterFactory {


    /** Filter Names */
    private static final String GREATER_THAN = "greater_than";
    private static final String SMALLER_THAN = "smaller_than";
    private static final String BETWEEN = "between";
    private static final String FILE = "file";
    private static final String CONTAINS = "contains";
    private static final String PREFIX = "prefix";
    private static final String SUFFIX = "suffix";
    private static final String WRITABLE = "writable";
    private static final String EXECUTABLE = "executable";
    private static final String HIDDEN = "hidden";
    private static final String ALL = "all";


    public static Filter getFilterByCommand(String[] filterParameters) throws Type1Exception {

        String filterName = filterParameters[CommandSection.FILTER_NAME_IDX];

        Filter filter;
        switch (filterName) {
            case GREATER_THAN:
                filter = new GreaterThanFilter(filterParameters);
                break;
            case SMALLER_THAN:
                filter = new SmallerThanFilter(filterParameters);
                break;
            case BETWEEN:
                filter = new BetweenFilter(filterParameters);
                break;
            case FILE:
                filter = new FileFilter(filterParameters);
                break;
            case CONTAINS:
                filter = new ContainsFilter(filterParameters);
                break;
            case PREFIX:
                filter = new PrefixFilter(filterParameters);
                break;
            case SUFFIX:
                filter = new SuffixFilter(filterParameters);
                break;
            case WRITABLE:
                filter = new WritableFilter(filterParameters);
                break;
            case EXECUTABLE:
                filter = new ExecutableFilter(filterParameters);
                break;
            case HIDDEN:
                filter = new HiddenFilter(filterParameters);
                break;
            case ALL:
                filter = new AllFilter(filterParameters);
                break;
            default:
                throw new Type1Exception();
        }
        return filter;
    }


}
