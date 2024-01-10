package account.service;

public class PrintServiceImp implements PrintService {

	// 메인메뉴
	@Override
	public void printMainMenu() {
		System.out.println("-------메뉴-------");
		System.out.println("1.입금 관리");
		System.out.println("2.출금 관리");
		System.out.println("3.입출금 조회");
		System.out.println("4.프로그램 종료");
		System.out.println("-----------------");
		System.out.println("메뉴 선택 : ");
	}
	// 수입 메뉴
	@Override
	public void AddMoney() {
		System.out.println("-------수입/지출메뉴-------");
		System.out.println("1.내역 추가"); // 날짜, 금액, 내용, 카테고리(수입/지출)
		System.out.println("2.내역 수정");
		System.out.println("3.내역 삭제");
		System.out.println("4.이전으로");
		System.out.println("-----------------");
		System.out.println("메뉴 선택 : ");
	}
	// 지출 메뉴
	/*@Override
	public void disMoney() {
		System.out.println("-------지출메뉴-------");
		System.out.println("1.출금내용 추가"); // 날짜, 금액, 내용
		System.out.println("2.내용 수정");
		System.out.println("3.내용 삭제");
		System.out.println("4.이전으로");
		System.out.println("-----------------");
		System.out.println("메뉴 선택 : ");	
	}
	*/
	// 조회
	@Override
	public void printMoney() {
		System.out.println("-------조회메뉴-------");
		System.out.println("1.전체 조회");
		System.out.println("2.검색 조회"); // 년월별로 나눠서 검색할 예정
		System.out.println("3.이전으로");
		System.out.println("-----------------");
		System.out.println("메뉴 선택 : ");
	}
	@Override
	public void reviseMoney() {
		// TODO Auto-generated method stub
		
	}

}
