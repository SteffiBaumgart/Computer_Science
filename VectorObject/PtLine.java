/**
 * Created by Baumgart on 2015/09/02.
 */
public class PtLine extends VectorObject{
    private int bx;
    private int by;

    PtLine(int id,int x,int y, int bx, int by) {
        super(id, x, y);
        this.bx = bx;
        this.by = by;
    }

    
    @Override
    public void draw(char[][] matrix) {
        int w = bx - super.x;
        int h = by - super.y;
        
        int dx1 = 0, dy1 = 0, dx2 = 0, dy2 = 0;
        
        if (w < 0) 
        {dx1 = -1;}
        else if (w > 0) {dx1 = 1;}
        
        if (h < 0) 
        {dy1 = -1;}
        else if (h > 0) {dy1 = 1;}
        
        if (w < 0) 
        {dx2 = -1;}
        else if (w > 0) {dx2 = 1;}
        
        int longest = Math.abs(w);
        int shortest = Math.abs(h);
        
        if (!(longest > shortest)) {
            longest = Math.abs(h);
            shortest = Math.abs(w);
            if (h < 0) 
            {dy2 = -1;}
            else if (h > 0) {dy2 = 1;
            dx2 = 0;}
        }
        
        int num = longest >> 1;
        for (int i = 0; i <= longest; i++) {
            matrix[super.y][super.x] = '*';
            num += shortest;
            if (!(num < longest)) {
                num -= longest;
                x += dx1;
                y += dy1;
            } else {
                x += dx2;
                y += dy2;
            }
        }


    }
}