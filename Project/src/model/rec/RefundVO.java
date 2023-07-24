package model.rec;

public class RefundVO {

	String rdate, buycode, rfreasoncode, rfdetail;

	public RefundVO() {

	}

	public RefundVO(String rdate, String buycode, String rfreasoncode, String rfdetail) {
		this.rdate = rdate;
		this.buycode = buycode;
		this.rfreasoncode = rfreasoncode;
		this.rfdetail = rfdetail;

	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	public String getBuycode() {
		return buycode;
	}

	public void setBuycode(String buycode) {
		this.buycode = buycode;
	}

	public String getRfreasoncode() {
		return rfreasoncode;
	}

	public void setRfreasoncode(String rfreasoncode) {
		this.rfreasoncode = rfreasoncode;
	}

	public String getRfdetail() {
		return rfdetail;
	}

	public void setRfdetail(String rfdetail) {
		this.rfdetail = rfdetail;
	}
}