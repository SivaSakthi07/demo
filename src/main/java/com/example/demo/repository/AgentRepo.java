package com.example.demo.repository;

import com.example.demo.entity.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface AgentRepo extends JpaRepository<Agent, BigInteger> {
}
