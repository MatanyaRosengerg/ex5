package filesprocessing.factories;


import filesprocessing.CommandSegment;
import filesprocessing.fileFormatExceptions.CommandException;
import filesprocessing.filter.*;

public class FilterFactory {


    /** Filter Names */
    private static final String GREATER_THAT = "greater_then";
    private static final String BETWEEN = "between";
    private static final String FILE = "file";
    private static final String CONTAINS = "contains";
    private static final String PREFIX = "prefix";
    private static final String SUFFIX = "suffix";
    private static final String WRITABLE = "writable";
    private static final String EXECUTABLE = "executable";
    private static final String HIDDEN = "hidden";
    private static final String ALL = "all";


    public static Filter getFilterByCommand(String[] filterParameters) throws CommandException {

        String filterName = filterParameters[CommandSegment.FILTER_NAME_IDX];

        Filter filter;
        try {
            switch (filterName) {
                case GREATER_THAT:
                    filter = new GreaterThanFilter(filterParameters);
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
                default:
                    filter = new AllFilter(filterParameters);
                    break;
            }
            return filter;

        } catch (CommandException ignored) {return new AllFilter(filterParameters);}
    }


}
