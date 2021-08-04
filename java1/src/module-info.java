module java1 {
	
	// 현재 프로젝트에 라이브러리 추가
	requires activation;
	requires mail;
	
	// 사용할 패키지명 설정
	// opens 패키지명 to 라이브러리명
	opens Day14 to actiavtion, mail;
}