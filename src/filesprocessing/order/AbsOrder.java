package filesprocessing.order;

import filesprocessing.exception.Type1Exception;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Ofri Wienner on 25/05/2017.
 */
public class AbsOrder extends Order {

    public AbsOrder(String[] orderParameters) throws Type1Exception {
        super(orderParameters);
        comperator = new AbsCompare(isReversed);
    }

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


}
