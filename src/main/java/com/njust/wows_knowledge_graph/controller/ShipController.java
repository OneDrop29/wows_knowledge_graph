package com.njust.wows_knowledge_graph.controller;

import com.njust.wows_knowledge_graph.domain.node.Ship;
import com.njust.wows_knowledge_graph.service.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ship")
public class ShipController {
    @Autowired
    private ShipService shipService;

    @GetMapping("/get_all_ship")
    public List<Ship> getAllShip(){
        return shipService.getAllShip();
    }

    @GetMapping("/get_ship")
    public Ship getShip(@RequestParam("name")String name){
        return shipService.getShipByName(name);
    }

    @PostMapping("/add_ship")
    public Ship addShip(@RequestParam("name")String name, @RequestParam("tier")int tier){
        return shipService.addShip(name, tier);
    }

    @DeleteMapping("/delete_ship")
    public void deleteShip(@RequestParam("name")String name){
        shipService.deleteShip(name);
    }

    @GetMapping("/get_relationship_by_name")
    public Object getRelationshipByName(@RequestParam("name")String name){
        return shipService.getRelationshipByName(name);
    }
}
