package pl.piasecki.restfulwebservicespringmvc.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.piasecki.restfulwebservicespringmvc.api.v1.mapper.VendorMapper;
import pl.piasecki.restfulwebservicespringmvc.api.v1.model.VendorDTO;
import pl.piasecki.restfulwebservicespringmvc.domain.Vendor;
import pl.piasecki.restfulwebservicespringmvc.repositories.VendorRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

public class VendorServiceImplTest {

    public static final String NAME = "aaa";
    public static final long ID = 1L;

    VendorService vendorService;

    @Mock
    VendorRepository vendorRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        vendorService = new VendorServiceImpl(VendorMapper.INSTANCE, vendorRepository);
    }

    @Test
    public void getAllVendors() throws Exception {
        List<Vendor> vendors = Arrays.asList(new Vendor(), new Vendor(), new Vendor());
        when(vendorRepository.findAll()).thenReturn(vendors);

        List<VendorDTO> vendorDTOS = vendorService.getAllVendors();

        assertEquals(3, vendorDTOS.size());
    }

    @Test
    public void getVendorById() throws Exception {
        Vendor vendor = new Vendor();
        vendor.setId(ID);
        vendor.setName(NAME);

        when(vendorRepository.findById(anyLong())).thenReturn(java.util.Optional.ofNullable(vendor));

        VendorDTO vendorDTO = vendorService.getVendorById(ID);

        assertEquals(NAME, vendorDTO.getName());
    }

}