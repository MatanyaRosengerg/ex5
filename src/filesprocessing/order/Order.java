package filesprocessing.order;


import filesprocessing.exception.Type1Exception;

import java.io.File;
import java.util.ArrayList;

public abstract class Order {

    /** the line of the order sub-section command after being split into by "#" */
    protected String[] orderParameters;

    /** the parameter that determines if the REVERSE suffix is in the command */
    protected boolean isReversed;

    /** The user format for using the REVERSE suffix */
    private static final String REVERSE = "REVERSE";


    /**
     * Constructs the order, verifies the parameters, and sets the command parameters for the order command.
     *
     * @param orderParameters the line of the order sub-section command after being split into by "#"
     * @throws Type1Exception if the command format isn't good
     */
    Order(String[] orderParameters) throws Type1Exception {
        this.orderParameters = orderParameters;
        setCommandParameters(orderParameters);
        setReversed();
    }

    /**
     * default constructor to avoid exceptions
     */
    protected Order() {}

    /**
     * Convert text to parameters
     * @param orderLine String[] of parameters' text
     * @throws Type1Exception Throw Type1 Exception if the parameters are wrong
     */
    protected abstract void setCommandParameters(String[] orderLine) throws Type1Exception;

    /**
     * Orders the files according to wheather or not they match the order command line conditions.
     *
     * @param dirFiles the files to order (ArrayList<File>)
     */
    public ArrayList<File> doOrder(ArrayList<File> dirFiles) {
        //TODO implement!
        return null;
    }

    /**
     * Set the REVERSE command according to the suffix. This is done only after verifying the the format of
     * the command line is good.
     */
    private void setReversed()
    {
        this.isReversed = orderParameters[orderParameters.length - 1].equals(REVERSE);
    }
}
