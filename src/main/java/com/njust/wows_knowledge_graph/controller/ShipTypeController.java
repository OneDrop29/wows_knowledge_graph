package com.njust.wows_knowledge_graph.controller;

import com.njust.wows_knowledge_graph.domain.node.ShipType;
import com.njust.wows_knowledge_graph.service.ShipTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ship_type")
public class ShipTypeController {
    @Autowired
    private ShipTypeService shipTypeService;

    @GetMapping("/get_all_ship_type")
    public List<ShipType> getAllShipType(){
        return shipTypeService.getAllShipType();
    }

    @GetMapping("/get_ship_type")
    public ShipType getShipType(@RequestParam("name") String name){
        return shipTypeService.getShipTypeByName(name);
    }

    @PostMapping("/add_ship_type")
    public ShipType addShipType(@RequestParam("name") String name){
        return shipTypeService.addShipType(name);
    }

    @DeleteMapping("/delete_ship_type")
    public void deleteShipType(@RequestParam("name") String name){
        shipTypeService.deleteShipType(name);
    }

    @PostMapping("/add_is_type_relationship")
    public ShipType addIsTypeRelationship(@RequestParam("shipname") String shipname, @RequestParam("shipTypeName") String shipTypeName){
        return shipTypeService.addIsTypeRelationship(shipname, shipTypeName);
    }
}
