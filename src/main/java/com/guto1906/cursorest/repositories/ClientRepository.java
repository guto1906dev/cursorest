package com.guto1906.cursorest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guto1906.cursorest.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
