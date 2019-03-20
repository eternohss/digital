package br.com.digital.recurso.facede;

import br.com.digital.recurso.dto.Root;

public interface PdvFacade {
	
	public void save(Root pdvDto);

	public Root searchPDV(double lng, double lat);
	
	Root findById(Integer id);
	
}
