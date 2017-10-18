package Sprint3;
/**
 * Created by sjjo15 on 2017-09-20.
 */
public class BitWiseCoord {
    private short coord;

    public BitWiseCoord(int x, int y){
        coord = 0;
        setHigh(x);
        setLow(y);
    }

    public void setHigh(int x){
        coord = (short)((coord & 0xFF | (x<<8)));
    }

    public void setLow(int y){
        coord = (short)(coord & 0xFF00 | y);
    }

    public int getHigh(){
        return ((coord>>8) & 0xFF);
    }

    public int getLow(){
        return (coord & 0xFF);
    }

    public String toString(){
        return "(" + getHigh() + "," + getLow() + ")";
    }
}
