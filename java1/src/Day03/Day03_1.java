package Day03;

public class Day03_1 {// class start
	
	public static void main(String[] args) {//main start
		
		// 연산자 [연산시 사용되는 기호]
		//1. 산술연산자 ( +, -, *, /, %)
			//예1
			int num1 = 10; int num2 = 20;
			System.out.println("더하기 : "+num1+num2);// 여기서 +는 연결연산자
			System.out.println("더하기 : "+(num1+num2));// 괄호안의 +는 산술연산자
			System.out.println(num1+num2);//숫자끼리는 잘 나온다. 문자가 들어가면 문제가 생긴다.
			System.out.println("빼기 : "+(num1-num2)); // - : 빼기
			System.out.println("곱하기 : "+ (num1 * num2)); // * : 곱하기
			System.out.println("나누기 : "+ (num1/num2)); // / : 나누기
			System.out.println("나머지 :"+ (num1%num2)); // % : 나머지
			
		//2. 비교연산자 (>=이상, <=이하, >초과, <미만, ==같다, !=같지않다)
			//결과 => true/false로 나온다.
			//예2
			System.out.println("이상 : "+(num1>=num2)); // 10>=20 => false
			System.out.println("이하 : "+(num1<=num2)); // 10<=20 => true
			System.out.println("초과 : "+(num1>num2)); // 10>20 => false
			System.out.println("미만 : "+(num1<num2)); // 10<20 => true
			System.out.println("같다 : "+(num1==num2)); //10==20 => false
			System.out.println("같지않다 : "+(num1!=num2)); //10!=20 => true
			
		//3. 논리(관계)연산자 : 비교연산자 2개 이상일때( and:&&   or:||   not:!)
													//shift+7 shift+\ shift+1
			int num3 = 30; int num4 = 40;
			System.out.println("and : "+ (num1>=num2 && num4>=num3)); // 논리가 모두 true => 결과 true
			System.out.println("or : "+ (num1>=num2 || num4>=num3)); // 논리가 하나라도 true => 결과 true
			System.out.println("not : "+!(num1>=num2 || num4>=num3)); // !true => false
			
			
		//4. 대입연산자 (오른쪽 데이터가 왼쪽으로 데이터 넣기)
			// = 대입	
			// += (오른쪽 데이터가 왼쪽데이터에 더하기한 후에 왼쪽데이터에 대입)
			// -=
			// *=
			// /=    
			// %=
			
			//num1 = num1 + 1; 이것보다 아래에 있는 대입연산자를 쓴다.
			num1 += 1;
			System.out.println("변수에 1증가: "+ num1);
			
		//5. 증감연산자(1씩 증가 혹은 1씩 감소)
			// ++변수 : 선위증가		변수++ : 후위증가
			// --변수 : 선위감소		변수-- : 후위감소
			num1+=1;
			num1++;
			System.out.println("정수1 값은 : "+num1); //14
			System.out.println("선위증가: "+(++num1)); //15
			System.out.println("후위증가: "+(num1++)); //15 => print 후 => 16
			System.out.println("확인 : "+num1); // 16
		
			System.out.println("선위감소: "+(--num1)); //15
			System.out.println("후위감소: "+(num1--)); //15
			System.out.println("확인 : "+num1); //14
		
		
		
	}//main end
}//class end
