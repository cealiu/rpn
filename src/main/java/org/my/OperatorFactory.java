package org.my;

import org.my.operator.OperatorInterface;
import org.my.operator.impl.*;

public class OperatorFactory {

    public OperatorInterface operatorInterface(Commands commands){
        switch (commands){
            case sub:
                return new Sub();
            case sqrt:
                return new Sqrt();
            case plus:
                return new Add();
            case multi:
                return new Multi();
            case divide:
                return new Divide();
            case clear:
                return new Clear();
            default:
                return null;
        }
    }

}
