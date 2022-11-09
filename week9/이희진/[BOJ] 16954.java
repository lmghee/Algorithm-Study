import java.io.*;
import java.util.*;

public class Main {
	
	static class Point {
		int t, i, j;
		
		Point(int t, int i, int j) {
			this.t = t;
			this.i = i;
			this.j = j;
		}
	}

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		char[][] map = new char[8][8];
		int[] di = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
		int[] dj = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
		
		for(int i = 0; i < 8; i++) {
			String temp = br.readLine();
			for(int j = 0; j < 8; j++) {
				map[i][j] = temp.charAt(j);
			}
		}
		
//		for(char[] a : map) {
//			System.out.println(Arrays.toString(a));
//		}
		
		boolean [][][] v = new boolean[9][8][8];
		
		Queue<Point> q = new ArrayDeque<>();
		q.offer(new Point(0, 7, 0));
		v[0][7][0] = true;
		
		int ans = 0;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			if(p.i == 0 && p.j == 7) {
				ans = 1;
				break;
			}
			
			for(int d = 0; d < 9; d++) {
				int ni = p.i+di[d];
				int nj = p.j+dj[d];
				int nt = Math.min(p.t+1, 8);
				
//				System.out.println(ni+"/"+p.t+"/"+nj);
				if(ni < 0 || nj < 0 || ni >= 8 || nj >= 8) continue;
				if(ni-p.t >= 0 && map[ni-p.t][nj] == '#') continue;
				if(ni-p.t -1 >= 0 && map[ni-p.t-1][nj] == '#') continue;
				
				if(!v[nt][ni][nj]) {
					v[nt][ni][nj] = true;
					q.offer(new Point(nt, ni, nj));
				}
			}
		}
		System.out.println(ans);
	}
}
