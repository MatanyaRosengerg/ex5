package filesprocessing.factories;


import filesprocessing.CommandSection;
import filesprocessing.exception.Type1Exception;
import filesprocessing.order.*;

//TODO - document class
public class FileComparatorFactory {


    /** Order Names */
    private static final String ABS = "abs";
    private static final String TYPE = "type";
    private static final String SIZE = "size";
    private static final String EMPTY = CommandSection.EMPTY;


    /** The user format for using the REVERSE suffix */
    private static final String REVERSE = "REVERSE";

    public static FileComparator getOrderByCommand(String[] orderParameters) throws Type1Exception {

        //assert that the line isn't empty (from the way the factory constructed it...)
        String orderName = orderParameters[CommandSection.ORDER_NAME_IDX];

        //This line verifies the 'REVERSE' suffix, and may throw Type1Exception.
        boolean isReversed = isReversed(orderParameters);

        FileComparator fileComparator;
        switch (orderName) {
            case ABS:
                fileComparator = new AbsCompare(isReversed);
                break;
            case TYPE:
                fileComparator = new TypeCompare(isReversed);
                break;
            case SIZE:
                fileComparator = new SizeCompare(isReversed);
                break;
            case EMPTY:
                fileComparator = new AbsCompare(isReversed);
                break;
            default:
                throw new Type1Exception();
        }
        return fileComparator;
    }

    /**
     * Set the REVERSE command according to the suffix. This is done only after verifying the the format of
     * the command line is good. If there are 2 parameters, then if the last is 'REVERSE', the return true,
     * else throw an exception of the format. if there are less than 2 parameters, then there isn't
     * 'REVERSE' - so return false.
     *
     * @param orderParameters Parameters of the command
     * @return is reversed
     */
    private static boolean isReversed(String[] orderParameters) throws Type1Exception {
        if (orderParameters.length == Order.MAX_PARAMS_NUM) {
            if (!orderParameters[orderParameters.length - 1].equals(REVERSE)) {
                throw new Type1Exception();
            }
            else {return true;}
        }
        else {return false;}
    }

}
