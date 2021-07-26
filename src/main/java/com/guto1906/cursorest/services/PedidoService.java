package com.guto1906.cursorest.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guto1906.cursorest.domain.Pedido;
import com.guto1906.cursorest.dto.PedidoDto;
import com.guto1906.cursorest.repositories.PedidoRepository;
import com.guto1906.cursorest.services.exceptions.NoSuchElementException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	
    public void teste() throws ParseException {
    	Date instante = sdf.parse("30/09/2017 10:32");
    	System.out.println(instante);
    }
    
    @Transactional
    public List<PedidoDto> findAll(){
    	return repo.findAll().stream().map(entity -> new PedidoDto(entity)).collect(Collectors.toList());
    	
    }
    
    @Transactional
    public PedidoDto finById(Long id){
    	Pedido p = repo.findById(id).orElseThrow(()-> new NoSuchElementException("Elemento de Id " + id + " não encontrado"));
    	
    	return new PedidoDto(p);
    	
    }
    
    
    
    
}
