package repository;

import model.Customer;
import model.Province;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Long> {

    @Query(value = "Select * from customer where country = ?1 and name = ?2", nativeQuery = true)
    Iterable<Customer> findByCountry(String country, String name);

    Iterable<Customer> findAllByProvince(Province province);
}
