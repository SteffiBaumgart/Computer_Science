/**
 * Created by Baumgart on 2015/09/02.
 */
public class Rectangle extends VectorObject{
    private int xLen;
    private int yLen;

    Rectangle(int id,int x,int y,int xLen,int yLen){
        super(id,x,y);
        this.xLen = xLen;
        this.yLen = yLen;
    }

    @Override
    public void draw(char[][] matrix) {
        for (int i = super.y; i < super.y + yLen; i++){
            for (int j= super.x; j< super.x + xLen; j++){
                    matrix[i][j] = '*';

                }
            }
        }

    }



