package pl.piasecki.restfulwebservicespringmvc.api.v1.mapper;

import org.junit.Test;
import pl.piasecki.restfulwebservicespringmvc.api.v1.model.VendorDTO;
import pl.piasecki.restfulwebservicespringmvc.domain.Vendor;

import static org.junit.Assert.*;

public class VendorMapperTest {

    public static final String NAME = "aaa";
    public static final long ID = 1L;

    VendorMapper vendorMapper = VendorMapper.INSTANCE;

    @Test
    public void vendorToVendorDTO() throws Exception {
        Vendor vendor = new Vendor();
        vendor.setId(ID);
        vendor.setName(NAME);

        VendorDTO vendorDTO = vendorMapper.vendorToVendorDTO(vendor);

        assertEquals(NAME, vendorDTO.getName());
    }

    @Test
    public void vendorDTOToVendor() throws Exception {
        VendorDTO vendorDTO = new VendorDTO();
        vendorDTO.setName(NAME);

        Vendor vendor = vendorMapper.vendorDTOToVendor(vendorDTO);

        assertEquals(NAME, vendor.getName());
    }
}