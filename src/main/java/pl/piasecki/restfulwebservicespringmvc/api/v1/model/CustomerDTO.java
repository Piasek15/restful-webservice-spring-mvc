package pl.piasecki.restfulwebservicespringmvc.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CustomerDTO {

    @ApiModelProperty(value = "This is the first name", required = true)
    @JsonProperty("firstname")
    private String firstName;

    @ApiModelProperty(required = true)
    @JsonProperty("lastname")
    private String lastName;

    @JsonProperty("customer_url")
    private String customerUrl;
}
