package filesprocessing.factories;


import filesprocessing.exception.Type1Exception;
import filesprocessing.order.*;

public class ComperatorFactory {


    /** Order Names */
    private static final String ABS = "abs";
    private static final String TYPE = "type";
    private static final String SIZE = "size";


    /** The user format for using the REVERSE suffix */
    private static final String REVERSE = "REVERSE";

    public static Comperator getOrderByCommand(String[] orderParameters) throws Type1Exception {

        String orderName = orderParameters[0];

        Comperator comperator;
        boolean isReversed = isReversed(orderParameters);
        try {
            switch (orderName) {
                case ABS:
                    comperator = new AbsCompare(isReversed);
                    break;
                case TYPE:
                    comperator = new TypeCompare(isReversed);
                    break;
                case SIZE:
                    comperator = new SizeCompare(isReversed);
                    break;
                default:
                    throw new Type1Exception();
            }
            return comperator;

        } catch (Type1Exception ignored) {
            throw new Type1Exception();
        }
    }

    /**
     * Set the REVERSE command according to the suffix. This is done only after verifying the the format of
     * the command line is good.
     * @param orderParameters Parameters of the command
     * @return is reversed
     */
    private static boolean isReversed(String[] orderParameters){
        return orderParameters[orderParameters.length - 1].equals(REVERSE);
    }


}
