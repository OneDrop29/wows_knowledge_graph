package com.njust.wows_knowledge_graph.domain.node;

import com.njust.wows_knowledge_graph.domain.relationship.BuildIn;
import com.njust.wows_knowledge_graph.domain.relationship.IsType;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.*;

import java.util.List;

@Node(primaryLabel = "Ship")
@Data
@Builder
public class Ship {
    @Id
    @Property(name = "name")
    private String name;

    @Property(name = "tier")
    private int tier;
}
