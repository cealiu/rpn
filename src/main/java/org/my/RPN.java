package org.my;

import java.util.*;

public class RPN {

    public static void main(String[] args){

        System.out.println("please input:");
        Stack stack = new Stack();
        Queue queue = new LinkedList();
        Stack undoStack = new Stack();
        Stack undoStackCommands = new Stack();

        Scanner scan = new Scanner(System.in);
        System.out.print("% ");
        while(scan.hasNextLine()) {
            String s = scan.nextLine();
            Operator.exec(s,stack,queue,undoStack,undoStackCommands);
            System.out.print("% ");
        }
    }
}
