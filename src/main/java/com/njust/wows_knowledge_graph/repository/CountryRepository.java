package com.njust.wows_knowledge_graph.repository;

import com.njust.wows_knowledge_graph.domain.node.Country;
import com.njust.wows_knowledge_graph.domain.projection.CountryProjection;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends Neo4jRepository<Country, String> {
    /*
    按照name查询国家
     */
    Country findFirstByName(String name);

    List<CountryProjection> findAllBy();
}
