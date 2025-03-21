package shop.ninescent.mall.address.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.ninescent.mall.address.domain.Address;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    Optional<Address> findByUserUserNoAndIsDefaultTrue(Long userNo);

    List<Address> findAllByUserUserNo(Long userNo);

    Optional<Address> findByAddrNo(Long addrNo);
}

