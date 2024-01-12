package account;

import java.util.ArrayList;
import java.util.List;

public class AccountManager {
private List<Profit> list;

// 수입, 지출 리스트를 관리하는 클래스
	private AccountManager(List<Profit>list) {
		if(list == null) {
			list = new ArrayList<Profit>();
		}
		this.list = list;
	}
}
