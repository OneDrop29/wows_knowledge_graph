package com.njust.wows_knowledge_graph;

import com.njust.wows_knowledge_graph.domain.node.Country;
import com.njust.wows_knowledge_graph.repository.CountryRepository;
import com.njust.wows_knowledge_graph.service.CountryService;
import com.njust.wows_knowledge_graph.service.ShipService;
import com.njust.wows_knowledge_graph.service.ShipTypeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;

import java.io.*;

@SpringBootTest
class WowsKnowledgeGraphApplicationTests {
    @Autowired
    CountryService countryService;
    @Autowired
    ShipService shipService;
    @Autowired
    ShipTypeService shipTypeService;
    @Autowired
    CountryRepository countryRepository;

    @Test
    void contextLoads() throws IOException {
        Example<Country> example = Example.of(Country.builder().name("日本").build());
        System.out.println(countryRepository.exists(example));

        File file = new File("./initGraph.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        int flag = 0;
        while ((line=bufferedReader.readLine()) != null){
            if (line.equals("country")){
                flag = 0;
            }
            else if (line.equals("shipType")){
                flag = 1;
            }
            else if (line.equals("ship")){
                flag = 2;
            }
            else if (line.equals("buildIn")){
                flag = 3;
            }
            else if (line.equals("isType")){
                flag = 4;
            }
            else {
                switch (flag){
                    case 0:{
                        countryService.addCountry(line);
                        break;
                    }
                    case 1:{
                        shipTypeService.addShipType(line);
                        break;
                    }
                    case 2:{
                        String[] s = line.split("-");
                        shipService.addShip(s[0], Integer.parseInt(s[1]));
                        break;
                    }
                    case 3:{
                        String[] s = line.split("-");
                        countryService.addBuildInRelationship(s[0], s[2], Integer.parseInt(s[1]));
                        break;
                    }
                    case 4:{
                        String[] s = line.split("-");
                        shipTypeService.addIsTypeRelationship(s[0], s[1]);
                        break;
                    }
                }
            }
        }
    }

}
