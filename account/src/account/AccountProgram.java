package account;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import account.program.Program;
import account.service.FileService;
import account.service.FileServiceImp;
import account.service.PrintService;
import account.service.PrintServiceImp;

public class AccountProgram implements Program {
	// 기능별 종료 선택지를 모아둠
	private final int EXIT = 4;// 메인메뉴의 종료
	private final int PROFIT_EXIT = 4;
	private final int EXPENSE_EXIT = 4;
	private final int PRINT_EXIT = 3;
	
	private Scanner scan = new Scanner(System.in);// 입력을 위한 Scanner
	
	private PrintService printService = new PrintServiceImp();// 메뉴관리 Service
	private FileService fileService = new FileServiceImp(); //저장 List 관리	
	
	private AccountManager accountManager = new AccountManager(null);
	
	@Override
	public void run() {
		int menu = 0;
		String accountName1 = "src/account/profitList";// 수입 저장소 주소
		String accountName2 = "src/account/expenseList";// 지출 저장소 주소
		do { 
		// do 문을 사용하여 작업진행
			try {
				// 메인메뉴 출력
				ptintMainMenu();
				// 메뉴선택
				menu = scan.nextInt();
				// 메인메뉴 선택에 따른 기능실행
				runMenu();
			}catch(InputMismatchException e) {// Scanner 의 입력오류를 위한 예외코드
				System.out.println("잘못된 메뉴 입니다.");
				scan.nextLine();
			}
		}while(menu != EXIT);// 메인메뉴 종료 메뉴인 '4'번을 선택하면 종료	
	}
	private void ptintMainMenu() {
		printService.printMainMenu();	
	}
	public void runMenu() {
	// switch 문을 사용하여 각 case 별로 작업을 진행시킨다
		// 메인 메뉴에 따른 기능의 실행
		/* 1. 수입 관리
		 * 2. 지출 관리
		 * 3. 입출금 조회
		 * 4. 프로그램 종료
		 */
		int menu;
		switch(menu) {
		case 1:
				profitManager();
				break;
		case 2:
				expenseManager();
				break;
		case 3:
			 	printManager();
			 	break;
		case 4:
				System.out.print("프로그램을 종료합니다.");
				break;
		default:
				throw new InputMismatchException();	
		}
	}
	private void printManager() {
		// 입출금 조회
		int menu;
		do {
			// 조회 메뉴 출력
			printService.printManager();
			// 메뉴선택
			menu = scan.nextInt();
			// 메뉴 실행
			runPreintMenu();
		}while(menu != PRINT_EXIT);
		
	}
	private void runPreintMenu(int menu) {
		// switch 문을 사용하여 각 case 별로 작업을 진행시킨다
		switch(menu){
			/* 입출금 조회 기능
			 *  1. 전체 조회
			 *  2. 검색 조회
			 *  3. 이전 으로
			 */
		case 1: 
				printAll();
				break;
		case 2:
				printSearch();
				break;
		case 3:
				System.out.print("이전 메뉴로 돌아갑니다.");
				break;
		default:
				throw new InputMismatchException();
		}
	}
	private void printSearch() {
		//검색할 입출금 내용 입력 - 아직 기준 미정
				System.out.print("검색어 : ");
				scan.nextLine();//엔터 처리
				String profit = scan.nextLine();
				String expense = scan.nextLine();
				//내역에 검색어를 주면서 검색어를 포함하는 입출금들을 출력하라고 요청
				accountManager.print(profit);
				accountManager.print(expense);
		
	}
	private void printAll() {
		// 전체 메뉴 조회
		accountManager.print();
		
	}
	private void expenseManager() {
		// 지출 관리 메서드
		int menu;
		do {
			// 지출 매뉴 출력
			printService.printExpenseMenu();
			// 메뉴 선택
			menu = scan.nextInt();
			// 수입메뉴 실행
			runExpenseMenu(menu);
		}while(menu != EXPENSE_EXIT);	
	}
	private void runExpenseMenu(int menu) {
		switch(menu) {
		/* 지출관리
		 * - 지출 추가
		 * - 지출 수정
		 * - 지출 삭제
		 * - 이전으로	
		 */
		case 1:
				addExpense();
				break;
		case 2:
				setExpense();
				break;
		case 3:
				removeExpense();
				break;
		case 4:
				System.out.print("이전 메뉴로 돌아갑니다.");
				break;
		default:
				throw new InputMismatchException();
		}	
	}
	private void removeExpense() {
		// 삭제할 지출 입력
		System.out.print("삭제할 지출 : ");
		scan.nextLine();// 엔터처리
		String expesnse = scan.nextLine();
		// 지출삭제
		if(accountMenager.removeExpense(expesnse)) {
			System.out.println("지출내역을 삭제하였습니다.");
		}else {
			System.out.println("존재하지 않는 지출내역 입니다.");
		}
	}
	private void setExpense() {
		// 수정할 지출 내역 입력
		System.out.print("지출수정 수입 : ");
		scan.nextLine();// 엔터처리
		String oldExpense = scan.nextLine();// 기준조건 : 날짜, 금액, 내용
		System.out.println();
		
		System.out.println("새 지출 : ");
		String newExpense = scan.nextLine();
		
		// 지출 수정
		if(accountMenager.setExpense(oldExpense, newExpense)) {
			System.out.println("지출을 수정하였습니다.");
		}else {
			System.out.println("지출을 수정하는데 실패했습니다.");
		}
	}
	private void addExpense() {
		// 지출 카테고리 안에서 날짜, 금액, 내용 순으로 입력
		System.out.print("카테고리(수입/지출): ");
		scan.nextLine();
		String expense = scan.nextLine();
		
		// 날짜, 금액, 내용을 저장할 리스트
		List<Expense> expenseList = new ArrayList<Expense>();
		char isContinnue = 'n';
		do {
			System.out.print("날짜(yy/mm/dd) : ");
			String date = scan.next();
			System.out.print("지출금액(원) : ");
			String expenseMoney = scan.next();
			System.out.print("내용 : ");
			String expenseHistory = scan.next();
			
			expenseList.add(new Expense(date, expenseMoney, expenseHistory));
			System.out.print("지출 내역을 추가하시겠습니까?(y/n) : ");
			isContinnue = scan.next().charAt(0);
		
		}while(isContinnue == 'y');
		// 지출 내역이 비워져 있다면
		if(accountMenager == null) {
			System.out.println("지출 내역이 공백입니다.");
			return;
		}
		// 잔고에 추가
		if(accountMenager.addProfit(expense, expenseList)) {
			System.out.println("지출 내역을 추가했습니다.");
		}else {
			System.out.println("중복된 지출 내역입니다.");
		}	
	}
	private void profitManager() {
		//수입 관리 메서드
		int menu;
		do {
			// 수입 메뉴 출력
			printService.printProfitMenu();
			// 메뉴 선택
			menu = scan.nextInt();
			// 수입메뉴 실행
			runProfitMenu(menu);
		}while(menu != PROFIT_EXIT);	
	}
	private void runProfitMenu(int menu) {
		switch(menu) {
		/* 수입관리
		 * - 수입 추가
		 * - 수입 수정
		 * - 수입 삭제
		 * - 이전으로	
		 */
		case 1:
				addProfit();
				break;
		case 2:
				setProfit();
				break;
		case 3:
				removeProdit();
				break;
		case 4:
				System.out.print("이전 메뉴로 돌아갑니다.");
				break;
		default:
				throw new InputMismatchException();
		}	
	}
	private void removeProdit() {
		// 삭제할 수입 입력
		System.out.print("삭제할 수입 : ");
		scan.nextLine();// 엔터처리
		String profit = scan.nextLine();
		// 수입삭제
		if(accountMenager.removeProfit(profit)) {
			System.out.println("수입내역을 삭제하였습니다.");
		}else {
			System.out.println("존재하지 않는 수입내역 입니다.");
		}
	}
	private void setProfit() {
		// 수정할 수입 내역 입력
		System.out.print("수입수정 : ");
		scan.nextLine();// 엔터처리
		String oldProfit = scan.nextLine();// 기준조건 : 날짜, 금액, 내용
		System.out.println();
		
		System.out.println("새 수입 : ");
		String newProfit = scan.nextLine();
		
		// 수입을 수정
		if(accountMenager.setProfit(oldProfit, newProfit)) {
			System.out.println("수입을 수정하였습니다.");
		}else {
			System.out.println("수입을 수정하는데 실패했습니다.");
		}
	}
	private void addProfit() {
		// 수입 카테고리 안에서 날짜, 금액, 내용 순으로 입력
		System.out.print("카테고리(수입/지출): ");
		scan.nextLine();
		String profit = scan.nextLine();
		
		// 날짜, 금액, 내용을 저장할 리스트
		List<Profit> profitList = new ArrayList<Profit>();
		char isContinnue = 'n';
		do {
			System.out.print("날짜(yy/mm/dd) : ");
			String date = scan.next();
			System.out.print("수입금액(원) : ");
			String profitMoney = scan.next();
			System.out.print("내용 : ");
			String profitHistory = scan.next();
			
			profitList.add(new Profit(date, profitMoney, profitHistory));
			System.out.print("수입 내역을 추가하시겠습니까?(y/n) : ");
			isContinnue = scan.next().charAt(0);
		
		}while(isContinnue == 'y');
		// 수입 내역이 비워져 있다면
		if(accountManager == null) {
			System.out.println("수입 내역이 공백입니다.");
			return;
		}
		// 잔고에 추가
		if(accountMenager.addProfit(profit, profitList)) {
			System.out.println("수입 내역을 추가했습니다.");
		}else {
			System.out.println("중복된 수입 내역입니다.");
		}
		
	}

}
