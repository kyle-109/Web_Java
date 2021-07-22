package Day07;

public class Day07_1 {
	//배열: 동일한 자료형/클래스의 여러개 메모리를 할당받아 사용하는 것
		// 기준이 인덱스 : 대괄호[] 사용
	// 1차원 배열
	
	// 2차원 배열
	
	public static void main(String[] args) {
		// 예1) 반복문을 이용한 0~99까지 int형 배열에 각 인덱스 저장하고 출력
			// 1. 배열 선언
		int[] arr1 = new int[100]; // 100개 int형 배열 선언
		 	// 2. 반복문을 이용한 각 인덱스에 값 대입
		for(int i =0; i<100; i++) {
			arr1[i] = i;
		}
			//3. 반복문을 이용한 호출
		for(int i =0; i<100; i++) {
			System.out.print(arr1[i] + " ");
		}
		System.out.println();
			// 3. 반복문과 배열의 활용
		for(int temp : arr1) {
			// for(임시변수 : 배열/리스트)
				// 배열/리스트내 모든 요소를 하나씩 임시변수에 대입
			System.out.print(temp+" ");
		}
		System.out.println();
		
		//2차원 배열
			// 첫번째 대괄호가 행=가로=row
			// 두번째 대괄호가 열=세로=column
		int[][] arr2 = new int[2][3];
		
		int[][] arr3 = {{20,30,40},{40,50,60}};
						  //1행        2행
						  // {{열1, 열2}, {열1, 열2},{열1,열2}}
		
		arr2[0][0] = 80;
		arr2[0][1] = 90;
		arr2[0][2] = 100;
		arr2[1][0] = 40;
		arr2[1][1] = 50;
		arr2[1][2] = 60;
		System.out.println("2차원배열 호출 : "+arr2);
		System.out.println("2차원배열 [1행,1열] : "+arr2[0][0]);
		System.out.println("2차원배열 [1행,2열] : "+arr2[0][1]);
		System.out.println("2차원배열 [1행,3열] : "+arr2[0][2]);
		System.out.println("2차원배열 [2행,1열] : "+arr2[1][0]);
		System.out.println("2차원배열 [2행,2열] : "+arr2[1][1]);
		System.out.println("2차원배열 [2행,3열] : "+arr2[1][2]);	
		
		// 문제 1 : 0~49까지는 첫번째행에 저장
			// 50 ~ 99까지는 두번째 행에 저장하는 2차원배열 선언하고 출력
		int arr4[][] = new int[2][50];
		for(int i = 0; i<50;i++) {
			arr4[0][i]=i;
			arr4[1][i]=i+50;
		}
		for(int i = 0; i<100;i++) {
			if(i<50) {
				System.out.print(arr4[0][i]+" ");
			}
			else {
				System.out.print(arr4[1][i-50]+" ");
			}
		}
		
		//3차원 배열
		int[][][] arr5 = new int[2][3][3];
							//[가로][세로][높이]
	}
		
		
}

