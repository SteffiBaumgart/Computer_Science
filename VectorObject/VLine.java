/**
 * Created by Baumgart on 2015/09/02.
 */
public class VLine extends VectorObject {
    private int yLen;

    VLine(int id, int x, int y, int yLen) {
        super(id, x, y);
        this.yLen = yLen;
    }


    @Override
    public void draw(char[][] matrix) {
        for (int i = y; i < y + yLen; i++) {
            matrix[i][x]= '*';
            }


        }
    }


