package account;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import account.program.Program;
import account.service.FileService;
import account.service.FileServiceImp;
import account.service.PrintService;
import account.service.PrintServiceImp;

public class AccountProgram implements Program {
	// 기능을 담당하는 클래스
	private final int EXIT = 5;
	private final int ADD_EXIT = 5; // 임시번호
	private final int DIS_EXIT = 5; // 임시번호
	private final int PRINT_EXIT = 5; // 임시번호
	private final int REVISE_EXIT = 5; // 임시번호
	
	private Scanner scan = new Scanner(System.in);
	
	private PrintService printService = new PrintServiceImp();
	// private FileService fileService = new FileServiceImp();
	
	// 수입, 지출내역
	List<AccountManager>list;
	
	

	@Override
	public void run() {
		int menu = 0;
		String fileName = "src/toss/tossList";
		
		//accountManager = new AccountManager(list);

	}

	@Override
	public void printMenu() {
		printService.printMainMenu();

	}

	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1:
				addMoney(); // 수입
			break;
		case 2:
				disMoney(); // 지출
			break;
		case 3:
				printMoney();
			break;
		case 4:
				reviseMoney();
			break;
		case 5:
			break;
		default:
			throw new InputMismatchException();		
		}
	}
	private void reviseMoney() {
		// 입출금 수정
		int menu;
		do {
			printService.reviseMoney();
			
			menu = scan.nextInt();
			
			reviseMoney(menu);
		}while(menu != REVISE_EXIT);	
	}
	private void reviseMoney(int menu) {
		// TODO Auto-generated method stub
		
	}
	private void printMoney() { 
		// 조회 메뉴출력
		int menu;
		do {
			printService.printMoney();
			
			menu = scan.nextInt();
			
			runPrintMenu(menu);
		}while(menu != PRINT_EXIT);
		
	}
	private void runPrintMenu(int menu) {
		// 조회메뉴 기능출력
		switch(menu) {
		case 1:
			printAll();
			break;
		case 2:
			printSearch();
			break;
		case 3: 
			System.out.println("이전 메뉴로 돌아갑니다.");
			break;
		default:
			throw new InputMismatchException();
		}
		
	}
	private void printSearch() {
		// TODO Auto-generated method stub
		
	}
	private void printAll() {
		// TODO Auto-generated method stub
		
	}
	private void disMoney() {
		int menu = 0;
		do {
			// 지출 메뉴 출력
			printService.disMoney();
		}while(menu != DIS_EXIT);
		
	}
	private void addMoney() {
		int menu = 0;
		do {
			// 수입 메뉴 출력
			printService.AddMoney();
		
		
		}while(menu != ADD_EXIT);
		
	}

}
