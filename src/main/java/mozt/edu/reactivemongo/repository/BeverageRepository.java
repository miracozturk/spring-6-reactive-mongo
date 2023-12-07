package mozt.edu.reactivemongo.repository;

import mozt.edu.reactivemongo.domain.Beverage;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;


public interface BeverageRepository extends ReactiveMongoRepository<Beverage, String> {
}
