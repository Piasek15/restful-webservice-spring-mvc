package pl.piasecki.restfulwebservicespringmvc.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class VendorDTO {

    @ApiModelProperty(value = "Name of Vendor", required = true)
    private String name;

    @ApiModelProperty(value = "URL for Vendor Object")
    @JsonProperty("vendor_url")
    private String vendorUrl;
}
