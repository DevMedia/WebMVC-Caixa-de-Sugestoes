package br.com.devmedia.repository;

import br.com.devmedia.model.Suggestion;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuggestionRepository extends PagingAndSortingRepository<Suggestion, Long> {

}
