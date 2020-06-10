package app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clients")
public class Clients {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private int id;
	
	@Column(name = "FIRST_NAME", length = 20)
	private String firstName;
	
	@Column(name = "LAST_NAME", length = 20)
	private String lastName;
	
	@Column(name = "PATHER_NAME", length = 20)
	private String patherName;
	
	@Column(name = "PASSPORT_SERIA", length = 20)
	private String passportSeria;
	
	@Column(name = "PASSPORT_NUM", length = 20)
	private String passportNum;
	
	public Clients() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPatherName() {
		return patherName;
	}

	public void setPatherName(String patherName) {
		this.patherName = patherName;
	}

	public String getPassportSeria() {
		return passportSeria;
	}

	public void setPassportSeria(String passportSeria) {
		this.passportSeria = passportSeria;
	}

	public String getPassportNum() {
		return passportNum;
	}

	public void setPassportNum(String passportNum) {
		this.passportNum = passportNum;
	}
	
}
