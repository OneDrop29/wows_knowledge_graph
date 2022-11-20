package com.njust.wows_knowledge_graph.domain.relationship;

import com.njust.wows_knowledge_graph.domain.node.Ship;
import com.njust.wows_knowledge_graph.domain.node.ShipType;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@RelationshipProperties
@Data
@Builder
public class IsType {
    @Id
    @GeneratedValue
    Long id;

    @TargetNode
    private Ship ship;
}
