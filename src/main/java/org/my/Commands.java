package org.my;

public enum Commands {

//    // Commands
//    public static final String CLEAR = "clear";
//    public static final String UNDO = "undo";
//    public static final String SQRT = "sqrt";
//    clear("clear"),undo("undo"),sqrt("sqrt"),plus("+"),sub("-"),multi("*"),divide("/") ;
    clear("clear"),sqrt("sqrt"),plus("+"),sub("-"),multi("*"),divide("/") ;

    private String name;
    private Commands(String name) {
        this.name = name;
    }

    public static boolean contains(String type) {
        for (Commands commands : Commands.values()) {
            if (type.equals(commands.getName())) {
                return true;
            }
        }
        return false;
    }

    public static Commands getOperator(String s){
        for (Commands commands : Commands.values()) {
            if (s.equals(commands.getName())) {
                return commands;
            }
        }
        throw new IllegalArgumentException("operator not exist");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
