package com.guto1906.cursorest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guto1906.cursorest.domain.State;

@Repository
public interface StateRepository extends JpaRepository<State, Long>{

}
