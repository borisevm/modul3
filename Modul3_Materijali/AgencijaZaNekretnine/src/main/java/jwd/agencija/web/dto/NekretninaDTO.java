package jwd.agencija.web.dto;

public class NekretninaDTO {	
	
	private Long id;	
	private int povrsina;
	private int cena;
	private String adresa;		
	private TipNekretnineDTO tipNekretnine;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getPovrsina() {
		return povrsina;
	}
	public void setPovrsina(int povrsina) {
		this.povrsina = povrsina;
	}
	public int getCena() {
		return cena;
	}
	public void setCena(int cena) {
		this.cena = cena;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public TipNekretnineDTO getTipNekretnine() {
		return tipNekretnine;
	}
	public void setTipNekretnine(TipNekretnineDTO tipNekretnine) {
		this.tipNekretnine = tipNekretnine;
	}
	

}
