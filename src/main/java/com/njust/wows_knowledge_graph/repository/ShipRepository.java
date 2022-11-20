package com.njust.wows_knowledge_graph.repository;

import com.njust.wows_knowledge_graph.domain.node.Ship;
import com.njust.wows_knowledge_graph.domain.relationship.BuildIn;
import org.neo4j.driver.internal.value.PathValue;
import org.neo4j.driver.types.Relationship;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipRepository extends Neo4jRepository<Ship, String> {

    Ship findFirstByName(String name);

    @Query(value = "match p=(s:Country)-[r:buildIn]-() where s.name={0} return p")
    List<PathValue> getRelationshipByName(String name);
}
