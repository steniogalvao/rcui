package br.com.vsgdev.rcui.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.vsgdev.rcui.model.Pain;

public interface PainRepository extends CrudRepository<Pain, Long> {

	List<Pain> findAllByPainTimeAfter(LocalDateTime painTime);

}
