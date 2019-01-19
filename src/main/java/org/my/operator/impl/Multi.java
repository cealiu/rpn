package org.my.operator.impl;

import org.my.operator.OperatorInterface;

import java.util.Queue;
import java.util.Stack;

public class Multi implements OperatorInterface {
    @Override
    public Stack operator(Stack stack, Stack undoStack){
        Double s = 0.0;
        if(stack.size()>=2){
            Double d1 = (Double)stack.pop();
            undoStack.push(d1);
            Double d2 = (Double)stack.pop();
            undoStack.push(d2);
            stack.push(d1 * d2);
            return stack;
        }
        else{
            throw new IllegalArgumentException("numbers and operator is not match");
        }
    }

    @Override
    public Stack undo(Stack stack,Stack undoStack){
        if(undoStack.size()>=2){
            stack.pop();
            stack.push((Double)undoStack.pop());
            stack.push((Double)undoStack.pop());
            return stack;
        }
        return null;
    }
}
