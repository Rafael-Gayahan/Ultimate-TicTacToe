//this class is a box object that is empty which is signified by the - mark

public class Box {

    private int row;
    private int col;
    private final static String DASH = "*";
    private String placeHolder = Box.DASH;

    //constructor
    Box(int row, int col) {
        this.row = row;
        this.col = col;
    }

    //get the placeholder which is -
    String getPlaceHolder() {
        return placeHolder;
    }

    //sets placeholder which is -
    boolean setPlaceHolder(String placeHolder) {
        if(isAvailable()) {
            this.placeHolder = placeHolder;
            return true;
        }
        return false;
    }

    //checks if the box has a - in it and if it does have a - then it is available
    boolean isAvailable() {
        return this.placeHolder.equals(Box.DASH);
    }

    //prints whats in the box initially
    void print() {
        System.out.print(placeHolder + " ");
    }
}
