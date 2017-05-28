package filesprocessing.order;

import filesprocessing.exception.Type1Exception;

/**
 * Created by Ofri Wienner on 25/05/2017.
 */
public class TypeOrder extends Order {
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
