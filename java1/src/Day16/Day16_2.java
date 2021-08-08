package Day16;

import java.util.Arrays;

public class Day16_2 {
	public static void main(String[] args) {
		
		// 제네릭
			// 자체적으로 new 연산자 불가능
			// 1. 슈퍼클래스 할당된 제네릭에는 서브클래스도 사용가능
			// 2. 서브클래스 할당된 제네릭에는 슈퍼클래스는 사용불가
		
		// 1. 제네릭 이용한 객체 생성
		Course<Person> personCourse = new Course<>("일반인과정", 5);
			// <제네릭타입>
			personCourse.add(new Person("강호동"));
			personCourse.add(new Worker("유재석"));
			personCourse.add(new Student("신동엽"));
			personCourse.add(new HighSchool("서장훈"));
		
		Course<Worker> workerCourse = new Course<>("직장인과정", 5);
			//workerCourse.add(new Person("강호동"));
			workerCourse.add(new Worker("유재석"));
			//workerCourse.add(new Student("신동엽"));
			//workerCourse.add(new HighSchool("서장훈"));
		
		Course<Student> studentCourse = new Course<>("학생과정", 5);
			//studentCourse.add(new Person("강호동"));
			//studentCourse.add(new Worker("유재석"));
			studentCourse.add(new Student("신동엽"));
			studentCourse.add(new HighSchool("서장훈"));
			
		Course<HighSchool> highschoolCourse = new Course<>("고등학생과정", 5);
			//highschoolCourse.add(new Person("강호동"));
			//highschoolCourse.add(new Worker("유재석"));
			//highschoolCourse.add(new Student("신동엽"));
			highschoolCourse.add(new HighSchool("서장훈"));
/////////////////////////////////////////////////////////////////////////////////////////////////
			enrollOut(personCourse);
			enrollOut(workerCourse);
			enrollOut(studentCourse);
			enrollOut(highschoolCourse);
			
System.out.println("============================================================");			
			//studentEnrollOut(personCourse);
			//studentEnrollOut(workerCourse);
			studentEnrollOut(studentCourse);
			studentEnrollOut(highschoolCourse);
			
System.out.println("============================================================");			
			workerEnrollOut(personCourse);
			workerEnrollOut(workerCourse);
			//workerEnrollOut(studentCourse);
			//workerEnrollOut(highschoolCourse);
			
	} // main 메소드 끝
	
		//코스 인원 명단 출력 메소드 // ? : 와일드카드 [모든 클래스 대응], 어떤 제네릭이 들어와도 상관없다.
		public static void enrollOut(Course<?> course) { // 여기서 ?는 인수로 들어오는 제네릭
			// static : 정적할당[프로그램 시작시 메모리 할당 / 프로그램 종료시 메모리 초기화] 
				// static 사용 안하면 해당 메소드를 main에서 인식불가
			System.out.println(course.getCourseName()+" 수강생명단: "+
				Arrays.toString(course.getMemberList()) );
					// Arrays : 배열에 관련된 메소드 제공
						// Arrays.toString(배열) : 배열내 전체 요소들의 정보 출력
							// .toString() : 객체의 메모리 주소[Object 클래스]
		}
		
		// 학생 목록 출력 메소드// ? extends 학생: 학생클래스 또는 학생클래스로부터 상속받은 클래스들만 가능
		public static void studentEnrollOut(Course<? extends Student> course) {
			
			System.out.println(course.getCourseName()+"수강생 명단: "+
					Arrays.toString(course.getMemberList()));
		}
		// 직장인 목록 출력 메소드 // ? super 직장인 : 직장인 클래스 또는 직장인클래스에게 상속주는 모든 클래스 대응
		public static void workerEnrollOut(Course<? super Worker> course) {
			System.out.println(course.getCourseName()+"수강생 명단: "+
					Arrays.toString(course.getMemberList()));
		}
}