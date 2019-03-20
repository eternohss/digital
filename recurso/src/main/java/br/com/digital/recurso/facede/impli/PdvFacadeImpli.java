package br.com.digital.recurso.facede.impli;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Component;

import br.com.digital.recurso.dto.Address;
import br.com.digital.recurso.dto.Pdvs;
import br.com.digital.recurso.dto.Root;
import br.com.digital.recurso.facede.PdvFacade;
import br.com.digital.recurso.model.Coordinate;
import br.com.digital.recurso.model.Pdv;
import br.com.digital.recurso.model.Type;
import br.com.digital.recurso.service.PdvService;

@Component
public class PdvFacadeImpli implements PdvFacade{
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PdvService pdvService;
	
	
	@Override
	public void save(Root root) {

		List<Pdv> pdvs = this.convertToEntity(root);
		
		for (Pdv pdv : pdvs) {
			pdvService.save(pdv);
			
		}
		
	}

	@Override
	public Root findById(Integer id) {
		
		Pdv pdv = pdvService.findId(id);
		
		Root Root = this.convertToDto(pdv);
		
		return Root;
	}
	
	@Override
	public Root searchPDV(double lng, double lat) {
		pdvService.searchPdv(lng, lat);
		
		return null;
	}

    private Root convertToDto(Pdv pdv) {
    	
    	Root root = new Root();
    	List<Pdvs> pdvs = new ArrayList<>();
    	Pdvs pdvsnew = new Pdvs();
    	
    	List<Coordinate> coordinates = pdv.getCoordinates();
    	
    	for (Coordinate coordinate : coordinates) {
    		
    	    if(coordinate.getType().equals(Type.POINT)){
    	    	
    	    	Pdv pdv2 = coordinate.getPdv();
    	    	pdvsnew.setDocument(pdv2.getDocument());
    	    	pdvsnew.setId(pdv2.getId());
    	    	pdvsnew.setOwnerName(pdv2.getOwnerName());
    	    	pdvsnew.setTradingName(pdv2.getTradingName());
    	    	Address address = new Address();
    	    	
    	    	address.setType(Type.POINT.getValor());
    	    	pdvs.add(pdvsnew);
    	    }
    		
		}
    	root.setPdvs(pdvs);
        return root;
    }
    
    private List<Pdv> convertToEntity(Root root) throws ParseException {
    	List<Pdvs> pdvs = root.getPdvs();
    	
    	List<Pdv> pdvList = new ArrayList<>();
    	
    	for (Pdvs pdv : pdvs) {
    		
    		Pdv pdvNew = new Pdv();
    		pdvNew.setId(pdv.getId());
    		pdvNew.setDocument(pdv.getDocument());
    		pdvNew.setOwnerName(pdv.getOwnerName());
    		pdvNew.setTradingName(pdv.getTradingName());
    		Address address = pdv.getAddress();
    		
    		List<Coordinate> coordinates = new ArrayList<>();
    		
    		Coordinate coordinate = new Coordinate();
    		coordinate.setType(Type.POINT);
    		coordinate.setLatitude(address.getCoordinates().get(0));
    		coordinate.setLongitude(address.getCoordinates().get(1));
    		coordinates.add(coordinate);
    		
    		List<List<Double>> cordenateMult = pdv.getCoverageArea().getCoordinates().get(0).get(0);
    		
    		for (List<Double> pontos : cordenateMult) {
    			coordinate = new Coordinate();
        		coordinate.setType(Type.MULTIPOLYGON);
        		coordinate.setLatitude(pontos.get(0));
        		coordinate.setLongitude(pontos.get(1));
        		coordinates.add(coordinate);
			}
    		
    		pdvList.add(pdvNew);
    		
		}
        return pdvList;
    }

}
