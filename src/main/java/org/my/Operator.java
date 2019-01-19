package org.my;

import org.my.operator.OperatorInterface;

import java.util.*;

public class Operator {

    public final static boolean isNumeric(String s) {
        if (s != null && !"".equals(s.trim()))
            return s.matches("^[0-9]*$");
        else
            return false;
    }

    public final static boolean isOperator(String s) {
        if (Commands.contains(s)) {
            return true;
        }
        else
            return false;
    }


    public static Queue getStack(String s,Queue allQueue){

        ArrayList<String> input = new ArrayList<String>();
        Collections.addAll(input, s.trim().split(" "));
        input.removeAll(Arrays.asList(null, ""));
        Map map = new HashMap();
        for(int i = 0;i<input.size();i++) {
            if (!isOperator(input.get(i))&&!isNumeric(input.get(i))&&!input.get(i).equals("undo")) {
                System.out.println(input.get(i) + " not number or operator");
//                throw new IllegalArgumentException("input include illegal arguments is "+ input.get(i));
            }
            else {
                allQueue.offer(input.get(i));
            }

        }
        map.put("allQueue",allQueue);
        return allQueue;
    }

    public static void exec(String s,Stack numberStack,Queue allqueue,Stack undoStack,Stack undoStackCommands){

        Queue queue = getStack(s,allqueue);
        OperatorFactory operatorFactory = new OperatorFactory();
        try {
            while (!queue.isEmpty()){
                String pop = (String) allqueue.poll();
                if(isOperator(pop)){
                    undoStackCommands.push(pop);
                    OperatorInterface operatorInterface = operatorFactory.operatorInterface(Commands.getOperator(pop));
                    Stack tempstack = operatorInterface.operator(numberStack,undoStack);
                    if(tempstack.isEmpty()){
                        numberStack.clear();
                    }
                }
                if(isNumeric(pop)){
                    undoStackCommands.push(pop);
                    numberStack.push(Double.valueOf(pop));
                }
                if(pop.equals("undo")){
                    String uncommad = (String)undoStackCommands.pop();
                    if(isNumeric(uncommad)){
                        undoStack.push(numberStack.pop());
                    }
                    else {
                        OperatorInterface operatorInterface = operatorFactory.operatorInterface(Commands.getOperator(uncommad));
                        operatorInterface.undo(numberStack, undoStack);
                    }
                }
            }
        }
        catch (IllegalArgumentException e){
//            numberStack.clear();
            undoStack.clear();
            undoStackCommands.clear();
            System.out.println(e);
        }

        System.out.println(numberStack);

    }

}
