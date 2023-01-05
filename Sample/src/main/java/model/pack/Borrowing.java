package model.pack;

public class Borrowing {

	private int id;
	private String memberid;
	private String bookid;
	private String currentdate;
	private String returndate;
	private String note;
	
	
	public Borrowing(String memberid, String bookid, String currentdate, String returndate, String note) {
		super();
		this.memberid = memberid;
		this.bookid = bookid;
		this.currentdate = currentdate;
		this.returndate = returndate;
		this.note = note;
	}

	public Borrowing(int id, String memberid, String bookid, String currentdate, String returndate, String note) {
		super();
		this.id = id;
		this.memberid = memberid;
		this.bookid = bookid;
		this.currentdate = currentdate;
		this.returndate = returndate;
		this.note = note;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getMemberid() {
		return memberid;
	}
	
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	
	
	public String getBookid() {
		return bookid;
	}
	
	public void setBookid(String bookid) {
		this.bookid = bookid;
	}
	
	
	public String getCurrentdate() {
		return currentdate;
	}
	public void setTitle(String email) {
		this.currentdate = email;
	}
	
	
	public String getReturndate() {
		return returndate;
	}
	public void setReturndate(String country) {
		this.returndate = country;
	}
	
	
	public String getNote() {
		return note;
	}
	public void setNote(String country) {
		this.note = country;
	}

}
