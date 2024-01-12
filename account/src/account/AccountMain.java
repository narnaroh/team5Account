package account;

public class AccountMain {

	public static void main(String[] args) {
		/* 가계부 프로그램을 작성하세요
		 * 수입과 지출을 나눠서 관리
		 * 수입관리
		 * 	- 수입 추가
		 * 		- 번호를 부여하여 관리
		 * 		- 수입 입력 날짜를 추가
		 * 		- 수입금 추가
		 * 		- 수입 내용 추가
		 * 		- 잔금 (수입금 합계)
		 * 	- 수입 조회
		 * 		- 수입이 입력된 리스트 출력
		 * 		- 남은 잔고 출력
		 * 	- 수입 수정
		 * 		- 부여된 번호를 선택하여 수정
		 * 		- 중복인지 확인
		 * 		- 수정전 수입내용 삭제
		 * 		- 수정후 수입을 저장
		 * 	- 수입 삭제
		 * 		- 부여된 번호를 선택하여 삭제
		 *  
		 * 지출관리
		 * 		- 지출 추가
		 * 		- 번호를 부여하여 관리
		 * 		- 지출 입력 날짜를 추가
		 * 		- 지출금 추가
		 * 		- 지출 내용 추가
		 * 		- 잔금 (수입금 합계에서 뺀 금액)
		 * 	- 지출 조회
		 * 		- 지출이 입력된 리스트 출력
		 * 		- 남은 잔고 출력
		 * 	- 지출 수정
		 * 		- 부여된 번호를 선택하여 수정
		 * 		- 중복인지 확인
		 * 		- 수정전 지출내용 삭제
		 * 		- 수정후 지출을 저장
		 * 	- 지출 삭제
		 * 		- 부여된 번호를 선택하여 삭제
		 * 입출금 조회
		 * 	- 전체조회
		 * 	- 검색조회
		 * 		- 수입 / 지출 로 분류하여 조회
		 * 
		 */
		AccountProgram ap = new AccountProgram();
		ap.run();
	}

}
