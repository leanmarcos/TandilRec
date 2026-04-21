package com.tandilrec.TandilRec.modules.adress;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AddressRepository extends CrudRepository<Address , Long> {

    @Query("SELECT a FROM Address a WHERE LOWER(a.city) = LOWER(:city) AND LOWER(a.street) = LOWER(:street) AND a.number = :number")
    public Address searchSimilarAddress(
            @Param("city") String city,
            @Param("street") String street,
            @Param("number") Integer number
    );

}
