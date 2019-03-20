package br.com.digital.recurso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.digital.recurso.model.Coordinate;
import br.com.digital.recurso.model.Pdv;
import br.com.digital.recurso.model.Type;
import br.com.digital.recurso.repository.CoordinatesRepository;
import br.com.digital.recurso.repository.PdvRepository;

@Service
public class PdvService {
	
	@Autowired
	private PdvRepository pdvRepository;
	
	@Autowired
	private CoordinatesRepository coordinatesRepository;
	
	public void save(Pdv pdv){
		pdvRepository.save(pdv);
	}
	
	public Pdv searchPdv(double lng, double lat){
	
		List<Coordinate> coordinates = buscaCoordinate(lng, lat);
		
		double a = 0, maior = 0, menor = 0;
		
		Coordinate coordinateMaisProxima = null;
		
		for (Coordinate coordinate : coordinates) {
			
			double distance = coordinate.getDistance(lng, lat);
			
			if(a == 0){
				maior = distance;
				menor = distance;
			}
			if(a > maior){
				maior = distance;
			}
			if(a < menor){
				menor = distance;
				coordinateMaisProxima = coordinate;
			}
			a++;
		}
		
		
		
		return coordinateMaisProxima.getPdv();
	}

	private List<Coordinate> buscaCoordinate(double lng, double lat) {
		Coordinate coordinate = coordinatesRepository.findTypeLongLat(Type.POINT, lng, lat);
		Pdv pdv = coordinate.getPdv();
		List<Coordinate> coordinates = coordinatesRepository.findPdv(Type.MULTIPOLYGON, pdv);
		return coordinates;
	}

	public Pdv findId(Integer id){
		
		Pdv pdv = pdvRepository.findById(id);
		
		return pdv;
	}
	
}
