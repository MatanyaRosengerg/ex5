package filesprocessing.order;


import filesprocessing.exception.Type1Exception;
import filesprocessing.factories.ComperatorFactory;

import java.io.File;
import java.util.ArrayList;

public class Order {

    private static int numberOfParameters = 0;

    /**
     * Comperator that match the order's type.
     */
    Comperator comperator;

    /**
     * Constructs the order, verifies the parameters, and sets the command parameters for the order command.
     *
     * @param orderParameters the line of the order sub-section command after being split into by "#"
     * @throws Type1Exception if the command format isn't good
     */
    public Order(String[] orderParameters) throws Type1Exception {
        if (orderParameters.length != numberOfParameters + 1 && orderParameters.length != numberOfParameters + 2){
            throw new Type1Exception();
        }
        comperator = ComperatorFactory.getOrderByCommand(orderParameters);
    }//TODO are you sure that an *empty* line should cause an exception??

    /**
     * Construct default order.
     */
    public Order(){
        comperator = new AbsCompare(false);
    }

    /**
     * Orders the files according to wheather or not they match the order command line conditions.
     *
     * @param dirFiles the files to order (ArrayList<File>)
     */
    public ArrayList<File> doOrder(ArrayList<File> dirFiles){
        dirFiles.sort(comperator);
        return dirFiles;
    }
}
