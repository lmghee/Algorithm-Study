import java.io.*;
import java.util.*;

public class Main {
	
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	static int[][] map;
	static boolean[][] v;
	static int N;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		int max = 0;
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(map[i][j], max);
				min = Math.min(map[i][j], min);
			}
		}
		
		int ans = 1;
		
		for(int k = min; k < max; k++) {
			v = new boolean[N][N];
			int cnt = 0;
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] > k && !v[i][j]) {
						dfs(i, j, k);
						cnt++;
					}
				}
			}
			ans = Math.max(ans, cnt);
		}
		System.out.println(ans);
	}
	
	public static void dfs(int i, int j, int k) {
		v[i][j] = true;
		
		for(int d = 0; d < 4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			
			if(ni < 0 || nj < 0 || ni >= N || nj >= N) continue;
			if(v[ni][nj] || map[ni][nj] <= k) continue;
			
			dfs(ni, nj, k);
		}
	}
}
