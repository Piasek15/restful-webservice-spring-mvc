package pl.piasecki.restfulwebservicespringmvc.api.v1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.piasecki.restfulwebservicespringmvc.api.v1.model.VendorDTO;
import pl.piasecki.restfulwebservicespringmvc.domain.Vendor;

@Mapper
public interface VendorMapper {
    VendorMapper INSTANCE = Mappers.getMapper(VendorMapper.class);
    VendorDTO vendorToVendorDTO(Vendor vendor);
    Vendor vendorDTOToVendor(VendorDTO vendorDTO);
}
