package filesprocessing.order;

import filesprocessing.exception.Type1Exception;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Ofri Wienner on 25/05/2017.
 */
public class SizeOrder extends Order {
    /**
     * Convert text to parameters
     *
     * @param orderLine String[] of parameters' text
     * @throws Type1Exception Throw Type1 Exception if the parameters are wrong
     */
    @Override
    protected void setCommandParameters(String[] orderLine) throws Type1Exception {
        //TODO implement
    }

    /**
     * Orders the files according to wheather or not they match the order command line conditions.
     *
     * @param dirFiles the files to order (ArrayList<File>)
     */
    @Override
    public ArrayList<File> doOrder(ArrayList<File> dirFiles) {
        return null;
    }
}
