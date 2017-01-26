package jwd.agencija.web.dto;

public class NekretninaDTO {	
	
	private Long id;	
	private double povrsina;	
	private String adresa;	
	private int cena;	
	private TipNekretnineDTO tipNekretnine;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getPovrsina() {
		return povrsina;
	}
	public void setPovrsina(double povrsina) {
		this.povrsina = povrsina;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public int getCena() {
		return cena;
	}
	public void setCena(int cena) {
		this.cena = cena;
	}
	public TipNekretnineDTO getTipNekretnine() {
		return tipNekretnine;
	}
	public void setTipNekretnine(TipNekretnineDTO tipNekretnine) {
		this.tipNekretnine = tipNekretnine;
	}
	
	

}
