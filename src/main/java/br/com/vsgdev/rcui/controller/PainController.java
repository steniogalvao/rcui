package br.com.vsgdev.rcui.controller;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vsgdev.rcui.exception.EntityNotFoundException;
import br.com.vsgdev.rcui.model.Pain;
import br.com.vsgdev.rcui.service.pain.PainService;
import br.com.vsgdev.rcui.utils.ConverterUtils;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/pain")
public class PainController {

	@Autowired
	private PainService painService;
	@Autowired
	private ConverterUtils converterUtils;

	@GetMapping("/{painId}")
	public Pain getPain(@Valid @PathVariable Long painId) throws EntityNotFoundException {
		return painService.find(painId);
	}

	@PostMapping()
	public Pain postPain(@Valid @RequestBody Pain pain) {
		return painService.save(pain);
	}

	@DeleteMapping("/{painId} ")
	public void deletePain(@Valid @PathVariable Long painId) throws EntityNotFoundException {
		painService.delete(painId);
	}

	@PutMapping("/{painId}")
	public Pain putPain(@Valid @RequestBody Pain pain) {
		return painService.save(pain);
	}

	@ExceptionHandler
	private ResponseEntity<Object> handleException(MethodArgumentNotValidException exception) {
		String msg = exception.getBindingResult().getFieldErrors().stream().map(o -> o.getField())
				.collect(Collectors.joining(", "));
		return converterUtils.errorReturn(msg, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler
	private ResponseEntity<Object> handleException(EntityNotFoundException exception) {
		String msg = exception.getMessage();
		return converterUtils.errorReturn(msg, HttpStatus.NOT_FOUND);
	}

}
