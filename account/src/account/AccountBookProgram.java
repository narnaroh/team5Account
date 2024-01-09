package account;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import account.program.Program;
import account.service.AccountBookService;

public class AccountBookProgram implements Program {
	private Scanner scan = new Scanner(System.in);
	
	//private AccountBookService accountBookService = new AccountBookServiceImp();
	//private FileService fileService = new FileServiceImp();
	
	// 수입, 지출내역
	private final int EXIT = 4; // 임시번호
		
	
	List<AccountBookManager> list;
	
	
	
	@Override
	public void run() {
		int menu = 0;
		String fileName = "src/account/accountList.txt";
	
		do {
			
			try {
				printMenu();
				
				menu = scan.nextInt();
				runMenu(menu);
			}catch(InputMismatchException e) {
				System.out.println();
				scan.nextLine();
			}
		}while(menu != EXIT);
	}

	@Override
	public void printMenu() {
		AccountBookService.printMainMenu();

	}
	
	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1:
			break;
			
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
