package com.example.demo.controller;

import com.example.demo.dto.AgentDTO;
import com.example.demo.dto.Dto;
import com.example.demo.entity.Agent;
import com.example.demo.service.AgentService;
import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "agent/")
public class AgentController {


    @Autowired
    AgentService service;


    @RequestMapping(value = "list")
    public List<Agent> getAgentList( ){
        return service.getList();
    }

    @PostMapping
    @RequestMapping(value = "create")
    public BigInteger create(@RequestBody AgentDTO dto){
        return service.create(dto);
    }

}
