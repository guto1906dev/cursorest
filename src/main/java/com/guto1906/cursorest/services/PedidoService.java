package com.guto1906.cursorest.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PedidoService {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	
    public void teste() throws ParseException {
    	Date instante = sdf.parse("30/09/2017 10:32");
    	System.out.println(instante);
    }
    
    
}
