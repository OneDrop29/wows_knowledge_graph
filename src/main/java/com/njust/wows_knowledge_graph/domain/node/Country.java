package com.njust.wows_knowledge_graph.domain.node;

import com.njust.wows_knowledge_graph.domain.relationship.BuildIn;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.*;

import java.util.ArrayList;
import java.util.List;

@Node(primaryLabel = "Country")
@Data
@Builder
public class Country {
    @Id
    @Property(name = "name")
    private String name;

    @Relationship(type = "buildIn", direction = Relationship.Direction.INCOMING)
    private List<BuildIn> buildIn;
}
