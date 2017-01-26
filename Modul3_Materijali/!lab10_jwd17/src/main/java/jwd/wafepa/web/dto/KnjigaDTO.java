package jwd.wafepa.web.dto;


public class KnjigaDTO {

	Long id;
	
	String title;
	
	String godinaIzdanja;

	AutorDTO autor;
	
	public AutorDTO getAutor() {
		return autor;
	}

	public void setAutor(AutorDTO autor) {
		this.autor = autor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGodinaIzdanja() {
		return godinaIzdanja;
	}

	public void setGodinaIzdanja(String godinaIzdanja) {
		this.godinaIzdanja = godinaIzdanja;
	}

}
