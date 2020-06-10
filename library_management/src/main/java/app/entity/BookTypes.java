package app.entity;

import java.math.BigDecimal;

import javax.persistence.*;

@Entity
@Table(name = "book_types")
public class BookTypes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "NAME", length = 50)
	private String name;
	
	@Column(name = "CNT")
	private Integer cnt;
	
	@Column(name = "FINE")
	private BigDecimal fine;
	
	@Column(name = "DAY_COUNT")
	private Integer dayCount;
	
	public BookTypes() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCnt() {
		return cnt;
	}
	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}
	public BigDecimal getFine() {
		return fine;
	}
	public void setFine(BigDecimal fine) {
		this.fine = fine;
	}
	public Integer getDayCount() {
		return dayCount;
	}
	public void setDayCount(Integer dayCount) {
		this.dayCount = dayCount;
	}
	
}
