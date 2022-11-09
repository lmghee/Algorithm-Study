import java.io.*;
import java.util.*;

public class Main {

	static class Shark{
		int r, c, s, d, z, n;

//		위치(r, c) 속력(s) 이동 방향(d) 크기(z)
		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}

		@Override
		public String toString() {
			return "Shark [r=" + r + ", c=" + c + "]";
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Shark[][] map = new Shark[R][C];
		
//		0 : -, 1 : ↑ , 2 : ↓ , 3 :  → , 4 : ←
		int[] di = {0, -1, 1, 0, 0};
		int[] dj = {0, 0, 0, 1, -1};
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			map[r-1][c-1] = new Shark(r-1, c-1, s, d, z);
		}
		
//		for(Shark[] a : map) System.out.println(Arrays.toString(a));
//		System.out.println("-----------------");
		
		int sum = 0;
		
//		낚시꾼 이동
		for(int j = 0; j < C; j++) {
			
//			상어잡기
			for(int i = 0; i < R; i++) {
				if(map[i][j] != null) {
//					System.out.println(map[i][j].z);
					sum += map[i][j].z;
					map[i][j] = null;
					break;
				}
			}
			
//			상어 이동 준비
			Queue<Shark> q = new ArrayDeque<>();
			
			for(int ir = 0; ir < R; ir++) {
				for(int jc = 0; jc < C; jc++) {
					if(map[ir][jc] != null) {
						q.add(map[ir][jc]);
						map[ir][jc] = null;
					}
				}
			}
			
//			상어 이동
			while(!q.isEmpty()) {
				Shark s = q.poll();
				
				int dir = s.s;
				
				if(s.d < 3) dir = dir % ((R-1)*2);
				else dir = dir % ((C-1)*2);
				
//				System.out.println(s+" : "+ s.s+" / " + dir);

				while(dir > 0) {
					int ni = s.r + di[s.d];
					int nj = s.c + dj[s.d];
					
					if(ni < 0 || ni >= R || nj < 0 || nj >= C) {
						ni = s.r - di[s.d];
						nj = s.c - dj[s.d];
						if(s.d == 1) s.d = 2;
						else if(s.d == 2) s.d = 1;
						else if(s.d == 3) s.d = 4;
						else if(s.d == 4) s.d = 3;
						
						continue;
					}
					s.r = ni;
					s.c = nj;
					dir--;
				}
				
//				상어 있는지 확인
				if(map[s.r][s.c] != null) {
					if(map[s.r][s.c].z < s.z) {
						map[s.r][s.c] = s;
					} 
				} else map[s.r][s.c] = s;
			}
//			for(Shark[] a : map) System.out.println(Arrays.toString(a));
//			System.out.println("-----------------");
		}
		System.out.println(sum);
	}
}
