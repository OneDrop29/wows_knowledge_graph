package com.njust.wows_knowledge_graph.service;

import com.njust.wows_knowledge_graph.domain.node.Country;
import com.njust.wows_knowledge_graph.domain.node.Ship;
import com.njust.wows_knowledge_graph.domain.node.ShipType;
import com.njust.wows_knowledge_graph.domain.relationship.BuildIn;
import com.njust.wows_knowledge_graph.domain.relationship.IsType;
import com.njust.wows_knowledge_graph.repository.ShipRepository;
import com.njust.wows_knowledge_graph.repository.ShipTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipTypeService {
    @Autowired
    private ShipTypeRepository shipTypeRepository;

    @Autowired
    private ShipRepository shipRepository;

    public List<ShipType> getAllShipType(){
        return shipTypeRepository.findAll();
    }

    public ShipType getShipTypeByName(String name){
        return shipTypeRepository.findFirstByName(name);
    }

    public ShipType addShipType(String name){
        return shipTypeRepository.save(ShipType.builder().name(name).build());
    }

    public void deleteShipType(String name){
        shipTypeRepository.delete(getShipTypeByName(name));
    }

    public ShipType addIsTypeRelationship(String shipName, String shipTypeName){
        ShipType shipType = shipTypeRepository.findFirstByName(shipTypeName);
        Ship ship = shipRepository.findFirstByName(shipName);

        for (IsType i : shipType.getIsType()){
            if (i.getShip().getName().equals(shipName)){
                return shipType;
            }
        }
        shipType.getIsType().add(IsType.builder().ship(ship).build());
        return shipTypeRepository.save(shipType);
    }
}
