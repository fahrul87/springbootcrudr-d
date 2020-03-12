package io.github.julianjupiter.springbootcrud.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Artikel {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
  
 
    private String judul;
    
    private String isi;
    
    private String tangggal;    
   
    private String penulis;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getJudul() {
		return judul;
	}

	public void setJudul(String judul) {
		this.judul = judul;
	}

	public String getIsi() {
		return isi;
	}

	public void setIsi(String isi) {
		this.isi = isi;
	}

	public String getTangggal() {
		return tangggal;
	}

	public void setTangggal(String tangggal) {
		this.tangggal = tangggal;
	}

	public String getPenulis() {
		return penulis;
	}

	public void setPenulis(String penulis) {
		this.penulis = penulis;
	}
    
    

}
