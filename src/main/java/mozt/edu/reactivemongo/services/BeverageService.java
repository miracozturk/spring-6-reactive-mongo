package mozt.edu.reactivemongo.services;

import mozt.edu.reactivemongo.model.BeverageDto;
import reactor.core.publisher.Mono;

public interface BeverageService {
    Mono<BeverageDto> saveBeverage(Mono<BeverageDto> beverageDto);

    Mono<BeverageDto> getById(String beerId);

}
