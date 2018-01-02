package br.com.vsgdev.rcui.service.pain;

import java.time.LocalDateTime;
import java.util.List;

import br.com.vsgdev.rcui.exception.EntityNotFoundException;
import br.com.vsgdev.rcui.model.Pain;

public interface PainService {

	Pain find(Long id) throws EntityNotFoundException;

	Pain save(Pain pain);

	void delete(Long id) throws EntityNotFoundException;

	List<Pain> findAllAfterDateTime(LocalDateTime dateTime);

}
