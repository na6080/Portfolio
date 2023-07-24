package model.rec;

public class CardVO {

	String cno, cname, cvc, cdate, membercode;

	public CardVO() {

	}

	public CardVO(String cno, String cname, String cvc, String cdate, String membercode) {
		this.cno = cno;
		this.cname = cname;
		this.cvc = cvc;
		this.cdate = cdate;
		this.membercode = membercode;

	}

	public String getCno() {
		return cno;
	}

	public void setCno(String cno) {
		this.cno = cno;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCvc() {
		return cvc;
	}

	public void setCvc(String cvc) {
		this.cvc = cvc;
	}

	public String getCdate() {
		return cdate;
	}

	public void setCdate(String cdate) {
		this.cdate = cdate;
	}

	public String getMembercode() {
		return membercode;
	}

	public void setMembercode(String membercode) {
		this.membercode = membercode;
	}

}
