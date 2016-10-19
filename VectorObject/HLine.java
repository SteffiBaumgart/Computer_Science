/**
 * Created by Baumgart on 2015/09/02.
 */
public class HLine extends VectorObject {
    private int xLen;

    HLine(int id,int x,int y,int xLen){
        super(id,x,y);
        this.xLen = xLen;
    }

    @Override
    public void draw(char[][] matrix) {
        for (int i = x; i < x+ xLen; i++) {
            matrix[y][i]= '*';
            }


        }
    }

