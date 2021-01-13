package com.assignment.nosql.repository;

import com.assignment.nosql.model.Player;
import org.springframework.data.repository.CrudRepository;

public interface playerRepository extends CrudRepository<Player,String> {

//    List<Player> findByRunsMoreThan(int threshHold);

}
