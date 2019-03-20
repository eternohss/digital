package br.com.digital.recurso.dto;

import java.util.List;

public class Root {
	private List<Pdvs> pdvs;

	public void setPdvs(List<Pdvs> pdvs) {
		this.pdvs = pdvs;
	}

	public List<Pdvs> getPdvs() {
		return this.pdvs;
	}
}
