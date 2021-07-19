package Day01;

public class Day01_2 {//class start
	
	//main => ctrl + spacebar
	public static void main(String[] args) {//main method start
		
		// tab : 들여쓰기
		// 들여쓰기는 중요하다.
		// syso => ctrl+spacebar
		System.out.println("콘솔에 출력되는 문자");
		
		//출력
		//예1
		System.out.println(123); 		//숫자
		System.out.println("java"); 	//문자
		//System.out.println(java); 		//문자
		System.out.println("java123"); 	//문자+숫자
			// " "처리를 하는 이유.
				// 컴퓨터는 0, 1인 기계어만 사용.
				// 컴퓨터가 모르는 단어(정의되지 않는 문자)는 ""를 한다.
				// 미리 정의된(키워드) 혹은 숫자에는 문자 처리 X
				// 문자 + 숫자 => 문자
		
		//예2
		//System.out.println(); // 출력후 자동 줄바꿈 처리
			System.out.println("단어출력1");
		//System.out.print();		//출력만(줄바꿈x)
			System.out.print("단어출력2\n");
		//System.out.printf();	//형식(format):출력물 꾸미기
			System.out.printf("%s" , "단어출력3\n");
			
			System.out.println("현재 나이는 "+10+"입니다. 그리고 좋아하는 수는 "+7+"입니다."); // +는 연결 연산자
			System.out.printf("현재 나이는 %d 입니다 그리고 좋아하는 수는 %d입니다.\n", 40, 7);
			System.out.printf("현재 실수는 %f \n", 10.5);
			System.out.printf("현재 문자는 %c \n", 'A');
			System.out.printf("현재 문자열은 %s \n", "안녕하세요");
			
			System.out.println("\\");
				// 연산자(기호) 출력시 \연산자
			// " "은 문자열, ' '은 문자
			// 형식문자. 외울 필요는 없다.
				// %d: 정수
				// %f: 실수
				// %s: 문자열
				// %c: 문자
			// 제어문자 :
				// \n은 줄바꿈
				// \t는 들여쓰기 5칸씩
				// \r은 다음줄의 첫칸으로 이동
					// \\, \", \'
		// 예제3
		System.out.println("\t[[[[ 출석부 ]]]]");
		System.out.println("이름 \t1교시\t2교시\t3교시");
		System.out.println("유재석\t출석\t결석\t출석");
		System.out.println("강호동\t결석\t출석\t출석");
		System.out.println("------------------------------");
			
		
		// 문제1
		/*
		  		 \   /\
		  		  ) ( ')
		  		 (	/  )
		  		  \(__)|
		   
		 */
		System.out.println("\t문제1");
		System.out.println("\t\\   /\\");
		System.out.println("\t ) ( ')");
		System.out.println("\t(  /  )");
		System.out.println("\t \\(__)|");
		System.out.println("\t--------------");
		
		// 문제2
		/*
 		 	|\_/|
 		 	|q p|   /}
  			( 0 )"""\
  			|"^"'    |
  			||_/=||__|
		*/
		System.out.println("\t문제2");
		System.out.println("\t|\\_/|");
		System.out.println("\t|q p|   /}");
		System.out.println("\t( 0 )\"\"\"\\");
		System.out.println("\t|\"^\"'    |");
		System.out.println("\t||_/=||__|");
			
			
	}//main method end
	
	
	
}//class end
