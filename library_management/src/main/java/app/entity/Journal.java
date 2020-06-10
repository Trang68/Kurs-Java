package app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "journal")
public class Journal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "BOOK_ID")
	private Integer bookId;
	
	@Column(name = "CLIENT_ID")
	private Integer clientId;
	
	@Column(name = "DATE_BEG")
	private Long dateBeg;
	
	@Column(name = "DATE_END")
	private Long dateEnd;
	
	@Column(name = "DATE_RET")
	private Long dateRet;
	
	public Journal() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public Integer getClientId() {
		return clientId;
	}
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}
	public Long getDateBeg() {
		return dateBeg;
	}
	public void setDateBeg(Long dateBeg) {
		this.dateBeg = dateBeg;
	}
	public Long getDateEnd() {
		return dateEnd;
	}
	public void setDateEnd(Long dateEnd) {
		this.dateEnd = dateEnd;
	}
	public Long getDateRet() {
		return dateRet;
	}
	public void setDateRet(Long dateRet) {
		this.dateRet = dateRet;
	}
	
}
