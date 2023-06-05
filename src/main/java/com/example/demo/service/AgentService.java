package com.example.demo.service;


import com.example.demo.dto.AgentDTO;
import com.example.demo.dto.Dto;
import com.example.demo.entity.Agent;
import com.example.demo.repository.AgentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;

@Service
public class AgentService {


    @Autowired
    private AgentRepo agentRepo;

    public List<Agent> getList(){
       return agentRepo.findAll();
    }


    public BigInteger create(AgentDTO dto){
        Agent entity = new Agent();
        entity.setDoj(dto.getDateOfjoin());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity  = agentRepo.save(entity);
        return entity.getId();
    }
}
