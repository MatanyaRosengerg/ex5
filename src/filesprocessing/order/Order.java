package filesprocessing.order;


import filesprocessing.exception.Type1Exception;
import filesprocessing.factories.FileComparatorFactory;

import java.io.File;
import java.util.ArrayList;

public class Order {

    public static int MAX_PARAMS_NUM = 2;


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
            throw new Type1Exception();
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
