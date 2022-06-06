package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.Agent;


@Repository
public interface AgentDao extends JpaRepository<Agent,Long> {

    Agent findByUsername(String username);


@Query("SELECT item FROM Agent item ")
List<Agent> findAll();


    Agent findByReference(String reference);

    int deleteByReference(String reference);



}
