package com.floresJimenez.productosms.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "product")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product implements Serializable {

    @Id
    private String id;

    @Field
    private String name;

    @Field
    private Double price;

    @Field
    private String type;

    @Field
    private Date CreateAt;

    @Field
    private Date UpdateAt;

    @Field
    private List<String> images;

    @Override
    public String toString () {
        return "Product{" +
                " id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", CreateAt=" + CreateAt +
                ", UpdateAt=" + UpdateAt +
                '}';
    }
}
