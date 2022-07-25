import java.util.Scanner;

public class d21974 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner p = new Scanner(System.in);

		int T = p.nextInt();

		int[][] a = new int[9][9];

		for (int g = 0; g < T; g++) {

			int count = 0;

			// 스도쿠 입력
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					a[i][j] = p.nextInt();
				}
			}

			int[] b = new int[10];

			for (int i = 0; i < 10; i++) {
				b[i] = i;
			}

			// 가로 확인
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					// System.out.println(a[i][j]);
					switch (a[i][j]) {
					case 1: {
						b[1] = 0;
						break;
					}
					case 2: {
						b[2] = 0;
						break;
					}
					case 3: {
						b[3] = 0;
						break;
					}
					case 4: {
						b[4] = 0;
						break;
					}
					case 5: {
						b[5] = 0;
						break;
					}
					case 6: {
						b[6] = 0;
						break;
					}
					case 7: {
						b[7] = 0;
						break;
					}
					case 8: {
						b[8] = 0;
						break;
					}
					case 9: {
						b[9] = 0;
						break;
					}
					}
				}
				for (int k = 0; k < 10; k++) {
					if (b[k] != 0) {
						count++;
						b[k] = k;
					} else
						b[k] = k;
				}
			}

			// 세로 확인
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					switch (a[j][i]) {
					case 1: {
						b[1] = 0;
						break;
					}
					case 2: {
						b[2] = 0;
						break;
					}
					case 3: {
						b[3] = 0;
						break;
					}
					case 4: {
						b[4] = 0;
						break;
					}
					case 5: {
						b[5] = 0;
						break;
					}
					case 6: {
						b[6] = 0;
						break;
					}
					case 7: {
						b[7] = 0;
						break;
					}
					case 8: {
						b[8] = 0;
						break;
					}
					case 9: {
						b[9] = 0;
						break;
					}
					}
				}
				for (int k = 0; k < 10; k++) {
					if (b[k] != 0) {
						count++;
						b[k] = k;
					} else
						b[k] = k;
				}
			}

			// 3x3 확인
			for (int i = 0; i < 9; i += 3) {
				for (int j = 0; j < 3; j += 3) {
					for (int k = 0; k < 3; k++) {
						for (int h = 0; h < 3; h++) {
							switch (a[i + k][j + h]) {
							case 1: {
								b[1] = 0;
								break;
							}
							case 2: {
								b[2] = 0;
								break;
							}
							case 3: {
								b[3] = 0;
								break;
							}
							case 4: {
								b[4] = 0;
								break;
							}
							case 5: {
								b[5] = 0;
								break;
							}
							case 6: {
								b[6] = 0;
								break;
							}
							case 7: {
								b[7] = 0;
								break;
							}
							case 8: {
								b[8] = 0;
								break;
							}
							case 9: {
								b[9] = 0;
								break;
							}
							}
						}
					}
					for (int k = 0; k < 10; k++) {
						if (b[k] != 0) {
							count++;
							b[k] = k;
						} else
							b[k] = k;
					}
				}
			}
			if (count == 0)
				System.out.println("#" + (g + 1) + " 1");
			else
				System.out.println("#" + (g + 1) + " 0");
		}

	}

}
