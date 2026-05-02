package edu.isgb.school.Repository;

import edu.isgb.school.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository; //Elle fournit automatiquement les opérations CRUD
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository //Indique que cette interface gère la base de données

public interface AddressRepository extends JpaRepository<Address, Integer>
{

    List<Address> findByCity(String city);
    List<Address> findByPostalCode(String postalCode);
}
