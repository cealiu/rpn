package org.my.operator.impl;

import org.my.operator.OperatorInterface;

import java.util.Queue;
import java.util.Stack;

public class Clear implements OperatorInterface {

    @Override
    public Stack operator(Stack stack, Stack undoStack) {
        undoStack.clear();
        while (!stack.isEmpty()){
            undoStack.push(stack.pop());
        }
        stack.clear();
        return stack;
    }

    @Override
    public Stack undo(Stack stack,Stack undoStack){
        stack.clear();
        while (!undoStack.isEmpty()){
            stack.push(undoStack.pop());
        }
        return stack;
    }
}
