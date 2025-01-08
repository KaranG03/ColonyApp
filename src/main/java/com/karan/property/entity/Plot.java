package com.karan.property.entity;


import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "plots")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Plot {
    @Id
    private ObjectId objectId;


    @NonNull

    private int plotNo;
    private boolean sold;
    private String regTo;
    private String note;
    private String owner;
    private int price;
    private Long custAadhar;
    private Long custPhoneNum;
    private String custAdd;
    private String colonyName;

}
