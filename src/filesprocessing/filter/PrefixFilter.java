package filesprocessing.filter;

import filesprocessing.fileFormatExceptions.CommandException;

/**
 * Created by t8351813 on 22/05/2017.
 */
public class PrefixFilter extends ContainsFilter {

    public PrefixFilter(String[] filterParameters) throws CommandException {super(filterParameters);}
}
