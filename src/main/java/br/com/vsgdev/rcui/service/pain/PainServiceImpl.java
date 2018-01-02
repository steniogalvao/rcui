package br.com.vsgdev.rcui.service.pain;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vsgdev.rcui.enums.ErrorMessage;
import br.com.vsgdev.rcui.exception.EntityNotFoundException;
import br.com.vsgdev.rcui.model.Pain;
import br.com.vsgdev.rcui.repository.PainRepository;

@Service
public class PainServiceImpl implements PainService {

	@Autowired
	private PainRepository painRepository;

	@Override
	public Pain find(Long id) throws EntityNotFoundException {
		Pain pain = painRepository.findOne(id);
		if (pain == null) {
			throw new EntityNotFoundException(String.format(ErrorMessage.ENTITY_NOT_FOUND.getMessage(), id.toString()));
		}
		return pain;
	}

	@Override
	public Pain save(Pain pain) {
		return painRepository.save(pain);
	}

	@Override
	public void delete(Long id) throws EntityNotFoundException {
		painRepository.delete(id);
	}

	@Override
	public List<Pain> findAllAfterDateTime(LocalDateTime dateTime) {
		return painRepository.findAllByPainTimeAfter(dateTime);
	}

}
