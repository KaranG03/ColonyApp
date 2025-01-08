package com.karan.property.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "colony")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Colony {
    @Id
    private ObjectId objectId;
    private String name;
    @DBRef
    private List<Plot> plots = new ArrayList<>();
    private String location;
    private int numPlots;
    private List<String> partners;
}
