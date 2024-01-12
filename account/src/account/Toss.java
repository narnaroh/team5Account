package account;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import lombok.Data;
@Data
public class Toss implements Serializable {
	
	private static final long serialVersionUID = -7358116161148181349L;
	
	private boolean toss; // 수입, 지출
	private int money; // 금액
	private int num; // 넘버링
	private String details; // 입출금 내역
	private String date; // 날짜 
	
	
	private List<Toss> profitList;// 입출금 리스트


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Toss other = (Toss) obj;
		return num == other.num;
	}


	@Override
	public int hashCode() {
		return Objects.hash(num);
	}


	@Override
	public String toString() {
		return "Toss [toss=" + toss + ", money=" + money + ", num=" + num + ", details=" + details + ", date=" + date
				+ ", profitList=" + profitList + "]";
	}
	
	
	
	
	
	

}
