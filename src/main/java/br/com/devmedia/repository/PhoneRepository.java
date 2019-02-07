package br.com.devmedia.repository;

import br.com.devmedia.model.Phone;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends PagingAndSortingRepository<Phone, Long> {

}
