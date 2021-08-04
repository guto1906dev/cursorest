package com.guto1906.cursorest.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.guto1906.cursorest.controllers.exceptions.FieldMessage;
import com.guto1906.cursorest.domain.enums.TipoClient;
import com.guto1906.cursorest.dto.ClientInsertDto;
import com.guto1906.cursorest.repositories.ClientRepository;
import com.guto1906.cursorest.services.validation.utils.BR;

public class ClientInsertValidator implements ConstraintValidator<ClientInsert, ClientInsertDto> {

	@Autowired
	private ClientRepository repo;
	
	@Override
	public void initialize(ClientInsert constraintAnnotation) {
		
	}
	
	@Override
	public boolean isValid(ClientInsertDto insertDto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		
		if(insertDto.getTipo().equals(TipoClient.PESSOAFISICA.getCod())
				&& !BR.isValidCPF(insertDto.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj", "CPF inválido"));
		}
		
		if(insertDto.getTipo().equals(TipoClient.PESSOAJURIDICA.getCod())
				&& !BR.isValidCNPJ(insertDto.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj", "CNPJ inválido"));
		}
		
		if(repo.findByEmail(insertDto.getEmail()) != null) {
			list.add(new FieldMessage("email", "Email já cadastrado"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage())
			.addPropertyNode(e.getField()).addConstraintViolation();
		}
		return list.isEmpty();
	}

}
