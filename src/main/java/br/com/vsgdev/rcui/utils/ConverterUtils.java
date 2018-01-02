package br.com.vsgdev.rcui.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.omg.PortableServer.POAPackage.ObjectNotActive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * class to help to make convertions
 */
@Service
public class ConverterUtils {

	private ModelMapper modelMapper;
	private final static String MSG = "msg";

	@PostConstruct
	public void init() {
		modelMapper = new ModelMapper();
	}

	/**
	 * Convert an Object or a list of objects to a object or list of objects of the
	 * given class
	 * 
	 * @param object
	 * @param objectClass
	 * 
	 * @return Object or list converted to the given class
	 */
	public Object mapTo(Object object, Class<?> objectClass) {
		if (object instanceof List<?>) {
			List<Object> list = new ArrayList<>();
			for (Object o : (List<?>) object) {
				list.add(modelMapper.map(o, objectClass));
			}
			return list;
		} else {
			return modelMapper.map(object, objectClass);
		}
	}

	/**
	 * Method to return an error message
	 * @param msg
	 * @param httpStatus
	 * 
	 * */
	public ResponseEntity<Object> errorReturn(String msg, HttpStatus httpStatus) {
		ObjectNode json = JsonNodeFactory.instance.objectNode();
		json.put(MSG, msg);
		return new ResponseEntity<Object>(json.toString(), httpStatus);
	}

}
