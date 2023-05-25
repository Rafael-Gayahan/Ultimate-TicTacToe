public abstract class AbstractPlayer {

    private String name;
    private String mark;

    public AbstractPlayer(String name, String mark) {
        setName(name);
        setMark(mark);
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getMark() { return mark; }
    public void setMark(String mark) { this.mark = mark; }

    public abstract int selectBoardNumber(int board);

    public abstract int nextRequiredBoard(int board);

    public abstract int selectAvailableBoard(int board);

    public abstract int selectRowValue(int range);

    public abstract int selectColValue(int range);
    // weenie
}
