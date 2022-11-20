package com.njust.wows_knowledge_graph.controller;

import com.njust.wows_knowledge_graph.domain.node.Country;
import com.njust.wows_knowledge_graph.domain.node.Ship;
import com.njust.wows_knowledge_graph.domain.projection.CountryProjection;
import com.njust.wows_knowledge_graph.domain.relationship.BuildIn;
import com.njust.wows_knowledge_graph.repository.ShipRepository;
import com.njust.wows_knowledge_graph.service.CountryService;
import com.njust.wows_knowledge_graph.service.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping("/get_all_country")
    public List<Country> getAllCountry(){
        return countryService.getAllCountry();
    }

    @GetMapping("/get_country")
    public Country getCountry(@RequestParam("name")String name){
        return countryService.getCountryByName(name);
    }

    @GetMapping("/get_all_country_projection")
    public List<CountryProjection> getAllCountryProjection(){
        return countryService.getAllCountryProjection();
    }

    @PostMapping("/add_country")
    public Country addCountry(@RequestParam("name")String name){
        return countryService.addCountry(name);
    }

    @DeleteMapping("/delete_country")
//    public void deleteCountry(@RequestParam("name")String name){
//        countryService.deleteCountry(name);
//    }

    @PostMapping("/add_build_in_relationship")
    public Country addBuildInRelationship(
            @RequestParam("shipName")String shipName,
            @RequestParam("countryName")String countryName,
            @RequestParam("year")int year){
        return countryService.addBuildInRelationship(shipName, countryName, year);
    }
}
