package com.njust.wows_knowledge_graph.repository;

import com.njust.wows_knowledge_graph.domain.node.ShipType;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipTypeRepository extends Neo4jRepository<ShipType, String> {

    ShipType findFirstByName(String name);
}
