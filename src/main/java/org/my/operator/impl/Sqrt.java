package org.my.operator.impl;

import org.my.operator.OperatorInterface;

import java.util.Queue;
import java.util.Stack;


public class Sqrt implements OperatorInterface {

    @Override
    public Stack operator(Stack stack, Stack undoStack){
        Double s = 0.0;
        if(stack.size()>=1){
            Double d1 = (Double)stack.pop();
            undoStack.push(d1);
            s = Math.sqrt(d1);
            stack.push(s);
            return stack;
        }
        else{
            System.out.println("numbers and operator is not match");
            stack.clear();
            return stack;
        }
    }

    @Override
    public Stack undo(Stack stack,Stack undoStack){
        if(undoStack.size()>=1){
            stack.pop();
            stack.push((Double)undoStack.pop());
//            stack.push((Double)undoStack.pop());
            return stack;
        }
        return null;
    }
}
