package pl.piasecki.restfulwebservicespringmvc.services;

import org.springframework.stereotype.Service;
import pl.piasecki.restfulwebservicespringmvc.api.v1.mapper.VendorMapper;
import pl.piasecki.restfulwebservicespringmvc.api.v1.model.VendorDTO;
import pl.piasecki.restfulwebservicespringmvc.controllers.v1.VendorController;
import pl.piasecki.restfulwebservicespringmvc.repositories.VendorRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendorServiceImpl implements VendorService {

    private final VendorMapper vendorMapper;
    private final VendorRepository vendorRepository;

    public VendorServiceImpl(VendorMapper vendorMapper, VendorRepository vendorRepository) {
        this.vendorMapper = vendorMapper;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public List<VendorDTO> getAllVendors() {
        return vendorRepository.findAll()
                .stream()
                .map(vendor -> {
                    VendorDTO vendorDTO = vendorMapper.vendorToVendorDTO(vendor);
                    vendorDTO.setVendorUrl(VendorController.BASE_URL + "/" + vendor.getId());
                    return vendorDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public VendorDTO getVendorById(Long id) {
        return vendorRepository.findById(id)
                .map(vendor -> {
                    VendorDTO vendorDTO = vendorMapper.vendorToVendorDTO(vendor);
                    vendorDTO.setVendorUrl(VendorController.BASE_URL + "/" + vendor.getId());
                    return vendorDTO;
                })
                .orElseThrow(ResourceNotFoundException::new);
    }
}
