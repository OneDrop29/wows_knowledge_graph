package com.njust.wows_knowledge_graph.service;

import com.njust.wows_knowledge_graph.domain.node.Country;
import com.njust.wows_knowledge_graph.domain.node.Ship;
import com.njust.wows_knowledge_graph.domain.projection.CountryProjection;
import com.njust.wows_knowledge_graph.domain.relationship.BuildIn;
import com.njust.wows_knowledge_graph.repository.CountryRepository;
import com.njust.wows_knowledge_graph.repository.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private ShipRepository shipRepository;

    public List<Country> getAllCountry(){
        return countryRepository.findAll();
    }

    public Country getCountryByName(String name){
        return countryRepository.findFirstByName(name);
    }

    public List<CountryProjection> getAllCountryProjection(){
        return countryRepository.findAllBy();
    }

    public Country addCountry(String name){
        return countryRepository.save(Country.builder().name(name).build());
    }

//    public void deleteCountry(String name){
//        countryRepository.delete(getCountryByName(name));
//

    public Country addBuildInRelationship(String shipName, String countryName, int year){
        Country country = countryRepository.findFirstByName(countryName);
        Ship ship = shipRepository.findFirstByName(shipName);

        for (BuildIn b : country.getBuildIn()){
            if (b.getShip().getName().equals(shipName)){
                return country;
            }
        }
        country.getBuildIn().add(BuildIn.builder().ship(ship).year(year).build());
        return countryRepository.save(country);
    }
}
