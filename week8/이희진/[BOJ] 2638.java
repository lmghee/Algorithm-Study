import java.io.*;
import java.util.*;

public class Main {

	static class Point {
		int i, j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	
	static int N, M, time;
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	static int[][] grid;
	static boolean[][] v;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		time = 0;
		grid = new int[N][M];
						
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(!check()) {
			v = new boolean[N][M];
			bfs();
			time++;
//			for(int[] a : grid) System.out.println(Arrays.toString(a));
//			System.out.println("---------------------------");
		}
		
		System.out.println(time);
	}

	private static void bfs() {
		int[][] newGrid = new int[N][M]; 
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				newGrid[i][j] = grid[i][j];				
			}
		}
		
		Queue<Point> q = new ArrayDeque<>();
		
		q.add(new Point(0, 0));
		v[0][0] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int ni = p.i + di[d];
				int nj = p.j + dj[d];
				
				if(ni < 0 || nj < 0 || ni >= N || nj >= M) continue;
				if(v[ni][nj]) continue;
				if(grid[ni][nj] >= 1) grid[ni][nj]++;
				if(grid[ni][nj] == 0) {
					v[ni][nj] = true;
					q.add(new Point(ni, nj));
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(grid[i][j] >= 3) {
					newGrid[i][j] = 0;				
				}
				grid[i][j] = newGrid[i][j];
			}
		}
//		for(int[] a : newGrid) System.out.println(Arrays.toString(a));
//		System.out.println("-------------?---------");
		
	}
		
	private static boolean check() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(grid[i][j] == 1) return false;
			}
		}
		return true;
	}
}
