import java.io.*;
import java.util.*;

public class Main {

	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };
	static int N;
	static int[][] map;
	static int[][] dist;

	static class Point {
		int i, j;

		Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		dist = new int[N][N];

		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < N; j++) {
				dist[i][j] = Integer.MAX_VALUE;
				map[i][j] = temp.charAt(j) - '0';

				if (map[i][j] == 0)
					map[i][j] = 1;
				else
					map[i][j] = 0;

			}
		}

//		for(int[] a : map) {
//			System.out.println(Arrays.toString(a));
//		}

		bfs();
		
//		for(int[] a : dist) {
//			System.out.println(Arrays.toString(a));
//		}
		
		System.out.println(dist[N-1][N-1]);
	}

	public static void bfs() {
		Queue<Point> q = new ArrayDeque<Point>();
		Queue<Integer> dq = new ArrayDeque<>();
		
		q.offer(new Point(0, 0));
		dq.offer(0);

		while (!q.isEmpty()) {
			Point p = q.poll();
			int dp = dq.poll();

			for (int d = 0; d < 4; d++) {
				int ni = p.i + di[d];
				int nj = p.j + dj[d];

				if (ni < 0 || nj < 0 || ni >= N || nj >= N)	continue;
				
				int nd = dp + map[ni][nj];
				
				if (nd < dist[ni][nj]) {
					dist[ni][nj] = nd;
					q.offer(new Point(ni, nj));
					dq.offer(nd);
				}				
			}
		}
	}
}
