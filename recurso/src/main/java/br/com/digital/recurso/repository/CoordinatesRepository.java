package br.com.digital.recurso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import br.com.digital.recurso.model.Coordinate;
import br.com.digital.recurso.model.Pdv;
import br.com.digital.recurso.model.Type;


public interface CoordinatesRepository extends Repository<Coordinate, Integer> {

	@Query("SELECT c FROM Coordinate c WHERE c.type = :type and c.latitude = :lng and c.longitude = :lat")
	Coordinate findTypeLongLat(@Param("type")Type type, @Param("lng") Double lng, @Param("lat") Double lat);
	
	@Query("SELECT c FROM Coordinate c WHERE c.type = ?1 and c.pdv = ?2")
	List<Coordinate> findPdv(Type type, Pdv pdv);

}
