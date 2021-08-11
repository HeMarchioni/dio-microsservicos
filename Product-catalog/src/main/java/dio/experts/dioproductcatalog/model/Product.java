package dio.experts.dioproductcatalog.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "product", type = "catalog")
@Data
public class Product {


    @Id
    private Long id;
    private String name;
    private Integer amount;


}
