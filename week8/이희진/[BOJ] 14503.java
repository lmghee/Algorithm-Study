import java.io.*;
import java.util.*;

public class Main {

//	0 - ↑ , 1 - ↓ , 2 -  → , 3 - ← 
	static int N, M, r, c, d, cnt = 0;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] map;
	static boolean[][] visit;

	static class Point {
		int r;
		int c;
		int d;

		Point(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visit = new boolean[N][M];

		st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visit[r][c] = true;
		bfs(r, c, d);

		System.out.println(cnt);

	}

	public static boolean isOut(int x, int y) {
		if(x < 0 || x >= N || y < 0 || y >= M) return true;
//		if (x <= M && y <= N && x > 0 && y > 0) {
//			return true;
//		} 
	else 
			return false;
	}

	public static void bfs(int x, int y, int d) {

		if (map[x][y] == 0) {
			cnt++;
		}

		Queue<Point> q = new LinkedList<Point>();
		q.offer(new Point(x, y, d));

		while (!q.isEmpty()) {
			Point p = q.poll();
			x = p.r;
			y = p.c;
			d = p.d;

			int nextX = 0, nextY = 0, nextD = d;
			boolean flag = false;

			for (int i = 0; i < 4; i++) {

				nextD = (nextD + 3) % 4;

				nextX = dx[nextD] + x;
				nextY = dy[nextD] + y; 

				if (!isOut(nextX, nextY)) {
					if (map[nextX][nextY] == 0 && !visit[nextX][nextY]) {
						visit[nextX][nextY] = true;
						++cnt;
						q.add(new Point(nextX, nextY, nextD));
						flag = true;
						break;
					}
				}
			}

			if (!flag) {

				nextD = (d + 2) % 4;

				nextX = x + dx[nextD];
				nextY = y + dy[nextD];

				if (!isOut(nextX, nextY)) {
					if (map[nextX][nextY] == 0) {
						q.add(new Point(nextX, nextY, d));
					}
				}
			}
		} 
	}
}
