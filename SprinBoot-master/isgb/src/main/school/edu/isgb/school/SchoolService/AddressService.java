package edu.isgb.school.SchoolService;

import edu.isgb.school.entities.Address;
import edu.isgb.school.Repository.AddressRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class AddressService {

    private AddressRepository addressRepository;

    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    public List<Address> findAll()
    {
        return addressRepository.findAll();
    }
}
