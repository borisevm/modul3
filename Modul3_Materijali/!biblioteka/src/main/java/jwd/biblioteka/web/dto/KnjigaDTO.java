package jwd.biblioteka.web.dto;

public class KnjigaDTO {
	
	private Long id;
	private String naslov;
	private String godinaIzdanja;
	private AutorDTO autor;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNaslov() {
		return naslov;
	}
	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}
	public String getGodinaIzdanja() {
		return godinaIzdanja;
	}
	public void setGodinaIzdanja(String godinaIzdanja) {
		this.godinaIzdanja = godinaIzdanja;
	}
	public AutorDTO getAutor() {
		return autor;
	}
	public void setAutor(AutorDTO autor) {
		this.autor = autor;
	}	

}
