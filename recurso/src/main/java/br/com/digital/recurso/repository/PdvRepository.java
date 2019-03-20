package br.com.digital.recurso.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import br.com.digital.recurso.model.Pdv;

public interface PdvRepository extends Repository<Pdv, Integer> {

	void save(Pdv pdv);

	List<Pdv> findAll();

	Pdv findById(Integer id);

}
