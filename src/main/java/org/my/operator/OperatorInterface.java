package org.my.operator;

import java.util.Stack;

public interface OperatorInterface {

    Stack operator(Stack numberStack,Stack queue);

    Stack undo(Stack stack,Stack queue);

}
