package com.guto1906.cursorest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guto1906.cursorest.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
