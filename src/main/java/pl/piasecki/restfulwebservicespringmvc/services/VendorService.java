package pl.piasecki.restfulwebservicespringmvc.services;


import pl.piasecki.restfulwebservicespringmvc.api.v1.model.VendorDTO;

import java.util.List;

public interface VendorService {
    List<VendorDTO> getAllVendors();
    VendorDTO getVendorById(Long id);
    VendorDTO createNewVendor(VendorDTO vendorDTO);
}
