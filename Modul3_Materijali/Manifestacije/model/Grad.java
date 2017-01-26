package jwd17_3.model;

import java.util.ArrayList;


public class Grad {
	
	protected int ptt;
	protected String naziv;
		
	protected ArrayList<Manifestacija> sveManifestacije = new ArrayList<Manifestacija>();
	
	public Grad(int ptt, String naziv) {
		this.ptt = ptt;
		this.naziv = naziv;
	}

	@Override
	public String toString() {
		return "Grad [ptt=" + ptt + ", naziv=" + naziv + "]";
	}

	public int getPtt() {
		return ptt;
	}

	public void setPtt(int ptt) {
		this.ptt = ptt;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	
	
	

}
