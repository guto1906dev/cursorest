package com.guto1906.cursorest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guto1906.cursorest.domain.ItemPedido;
import com.guto1906.cursorest.domain.ItemPedidoPk;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, ItemPedidoPk>{

}
