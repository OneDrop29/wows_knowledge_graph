package com.njust.wows_knowledge_graph.service;

import com.google.common.collect.Lists;
import com.njust.wows_knowledge_graph.domain.node.Ship;
import com.njust.wows_knowledge_graph.repository.ShipRepository;
import org.neo4j.driver.internal.value.PathValue;
import org.neo4j.driver.types.Node;
import org.neo4j.driver.types.Path;
import org.neo4j.driver.types.Relationship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShipService {
    @Autowired
    private ShipRepository shipRepository;

    public List<Ship> getAllShip(){
        return shipRepository.findAll();
    }

    public Ship getShipByName(String name){
        return shipRepository.findFirstByName(name);
    }

    public Ship addShip(String name, int tier){
        return shipRepository.save(Ship.builder().name(name).tier(tier).build());
    }

    public void deleteShip(String name){
        shipRepository.delete(getShipByName(name));
    }

    public List<String> getRelationshipByName(String name){
        List<String> pathStrings = new ArrayList<>();

        for (PathValue p : shipRepository.getRelationshipByName(name)){
            Path path = p.asPath();
            List<Node> nodes = Lists.newArrayList(path.nodes());
            List<Relationship> relationships = Lists.newArrayList(path.relationships());

            String s = nodes.get(0).get("name").toString().substring(1, nodes.get(0).get("name").toString().length()-1) +
                    "-" +
                    relationships.get(0).type() +
                    "-" +
                    nodes.get(1).get("name").toString().substring(1, nodes.get(1).get("name").toString().length()-1);

            pathStrings.add(s);
        }
        return pathStrings;
    }
}
