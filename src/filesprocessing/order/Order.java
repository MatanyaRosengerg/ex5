package filesprocessing.order;


import filesprocessing.exception.Type1Exception;
import filesprocessing.factories.FileComparatorFactory;

import java.io.File;
import java.util.ArrayList;

public class Order {

    public static int MAX_PARAMS_NUM = 2;

    /** Error messages */
    private static final String PARAM_NUM_ERROR_MESSAGE = "incorrect number of ORDER parameters";
    public static final String REVERSE_ERROR_MESSAGE = PARAM_NUM_ERROR_MESSAGE + ", or incorrect usage of " +
            "'REVERSE'";


    /** FileComparator that match the order's type. */
    private FileComparator fileComparator;

    /**
     * Constructs the order, verifies the parameters, and sets the command parameters for the order command.
     *
     * @param orderParameters the line of the order sub-section command after being split into by "#"
     * @throws Type1Exception if the command format isn't good
     */
    public Order(String[] orderParameters) throws Type1Exception {
        if (orderParameters.length > MAX_PARAMS_NUM) {
            throw new Type1Exception(PARAM_NUM_ERROR_MESSAGE);
        }
        fileComparator = FileComparatorFactory.getOrderByCommand(orderParameters);
    }


    /**
     * Construct default order.
     */
    public Order() {
        fileComparator = new AbsCompare(false);
    }

    /**
     * Orders the files according to the fileComparator.
     *
     * @param dirFiles the files to order (ArrayList<File>)
     */
    public ArrayList<File> doOrder(ArrayList<File> dirFiles) {
        dirFiles.sort(fileComparator);
        return dirFiles;
    }
}
