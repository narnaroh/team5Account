package account.service;

public class PrintServiceImp implements PrintService {

	@Override
	public void printMainMenu() {
		System.out.println("-------메인 메뉴-------");
		System.out.println("1. 수입 관리");
		System.out.println("2. 지출 관리");
		System.out.println("3. 입출금 조회");
		System.out.println("4. 프로그램 종료");
		System.out.println("---------------------");
		System.out.print("메뉴 선택 : ");
		/* print 와 println 의 차이 
		 * print : 괄호안의 내용을 단순출력
		 * println : 괄호 안의 내용을 출력 후 개행문자를 포함하여 출력
         */		
	}
	@Override
	public void printProfitMenu() {
		/* 수입관리
		 * - 수입 추가
		 * - 수입 수정
		 * - 수입 삭제
		 * - 이전으로	
		 */
		System.out.println("-------수입 메뉴-------");
		System.out.println("1. 수입 추가");
		System.out.println("2. 수입 수정");
		System.out.println("3. 수입 삭제");
		System.out.println("4. 이전 으로");
		System.out.println("---------------------");
		System.out.print("메뉴 선택 : ");
	}
	@Override
	public void printExpenseMenu() {
		/* 지출관리
		 * - 지출 추가
		 * - 지출 수정
		 * - 지출 삭제
		 * - 이전으로	
		 */
		System.out.println("-------수입 메뉴-------");
		System.out.println("1. 지출 추가");
		System.out.println("2. 지출 수정");
		System.out.println("3. 지출 삭제");
		System.out.println("4. 이전 으로");
		System.out.println("---------------------");
		System.out.print("메뉴 선택 : ");
	}
	@Override
	public void printManager() {
		/*입출금 조회
		 * - 전체조회
		 * - 검색조회
		 * 	- 수입 / 지출 로 분류하여 조회
		 */
		System.out.println("-------조회 메뉴-------");
		System.out.println("1. 전체 조회");
		System.out.println("2. 검색 조회");
		System.out.println("3. 이전 으로");
		System.out.println("---------------------");
		System.out.print("메뉴 선택 : ");
	}



}
