import java.util.Arrays;

public class FloodFill {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     int[][] a = {
    		 {1,1,1,2,1,1,1},
    		 {2,2,1,2,2,1,1},
    		 {0,2,2,2,1,1,1},
    		 {1,1,0,2,1,2,2},
    		 {1,1,2,2,1,0,0}
     };
     floodfill(a,2,3,3,2);
     System.out.println(Arrays.deepToString(a));
	}
	
	static void floodfill(int[][] a,int r,int c,int toFill,int prevFill) {
		int rows = a.length;
		int cols = a[0].length;
		
		if(r>=rows || c>=cols || r<0 || c<0)
			return;
		if(a[r][c] != prevFill)
			return;
		else {
			a[r][c]=toFill;
			floodfill(a,r-1,c,toFill,prevFill);
			floodfill(a,r,c-1,toFill,prevFill);
			floodfill(a,r+1,c,toFill,prevFill);
			floodfill(a,r,c+1,toFill,prevFill);
		}
	}

}
