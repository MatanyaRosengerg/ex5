package GarbageMatanya;

import filesprocessing.exception.Type1Exception;
import filesprocessing.order.AbsCompare;
import filesprocessing.order.Order;

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

    public AbsOrder() {
        comperator = new AbsCompare(false);
    }

}
