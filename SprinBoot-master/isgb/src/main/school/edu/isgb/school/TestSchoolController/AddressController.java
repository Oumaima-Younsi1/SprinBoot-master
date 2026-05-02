package edu.isgb.school.TestSchoolController;

import edu.isgb.school.entities.Address;
import edu.isgb.school.Repository.AddressRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    private final AddressRepository addressRepository;

    public AddressController(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @GetMapping
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @GetMapping("/{id}")
    public Address getAddressById(@PathVariable Integer id) {
        return addressRepository.findById(id).orElse(null);
    }

    @GetMapping("/city")
    public List<Address> getByCity(@RequestParam String city) {
        return addressRepository.findByCity(city);
    }

    @GetMapping("/postalcode")
    public List<Address> getByPostalCode(@RequestParam String postalCode) {
        return addressRepository.findByPostalCode(postalCode);
    }

    @PostMapping
    public Address createAddress(@RequestBody Address address) {
        return addressRepository.save(address);
    }

    @PutMapping("/{id}")
    public Address updateAddress(@PathVariable Integer id,
                                 @RequestBody Address updated) {

        Address address = addressRepository.findById(id).orElse(null);

        if (address == null) return null;

        address.setStreet(updated.getStreet());
        address.setCity(updated.getCity());
        address.setPostalCode(updated.getPostalCode());

        return addressRepository.save(address);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Integer id) {
        addressRepository.deleteById(id);
    }
}