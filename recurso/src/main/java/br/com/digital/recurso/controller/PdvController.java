package br.com.digital.recurso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.digital.recurso.dto.Root;
import br.com.digital.recurso.facede.PdvFacade;
import br.com.digital.recurso.model.ResponseModel;

@RestController
@RequestMapping("/service")
public class PdvController {
	
	@Autowired
	private PdvFacade pdvFacade;
	
		
	/**
	 * ATUALIZAR O REGISTRO DE UM Pdv
	 * @param PdvDto
	 * @return
	 */
	@RequestMapping(value="/pdv", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseModel create(@RequestBody Root root){
 
		try {
 
			this.pdvFacade.save(root);		
 
			return new ResponseModel(1,"Registro atualizado com sucesso!");
 
		}catch(Exception e) {
 
			return new ResponseModel(0,e.getMessage());
		}
	}
	
	
	/**
	 * CONSULTAR TODAS AS Pdvs
	 * @return
	 */
	@RequestMapping(value="/pdv/api/{lng}/{lat}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Root consultarLocalizao(@PathVariable("lng")double lng, @PathVariable("lat")double lat){
 
		return this.pdvFacade.searchPDV(lng, lat);
	}
	
	/**
	 * BUSCAR UMA CLIENTE PELO ID
	 * @param ID
	 * @return
	 */
	@RequestMapping(value="/pdv/{id}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Root buscar(@PathVariable("id") Integer id){
 
		return this.pdvFacade.findById(id);
    }

 

}
