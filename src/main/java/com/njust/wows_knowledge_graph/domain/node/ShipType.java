package com.njust.wows_knowledge_graph.domain.node;

import com.njust.wows_knowledge_graph.domain.relationship.IsType;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.*;

import java.util.List;

@Node(primaryLabel = "ShipType")
@Data
@Builder
public class ShipType {
    @Id
    @Property(name = "name")
    private String name;

    @Relationship(type = "isType", direction = Relationship.Direction.INCOMING)
    private List<IsType> isType;
}
