package com.br.gft.gestaoShow.Converter;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


import com.br.gft.gestaoShow.model.*;
import com.br.gft.gestaoShow.repository.*;

@Component
public class StringToShowConverter implements Converter<String, Show> {
	
	@Autowired
	private ReposiShow repositorio;
	
	
	@Override
	public Show convert(String text) {
		if (text.isEmpty()) {
			return null;
		}
		Long codigoShow = Long.valueOf(text);
		return this.repositorio.getOne(codigoShow);

	}
}