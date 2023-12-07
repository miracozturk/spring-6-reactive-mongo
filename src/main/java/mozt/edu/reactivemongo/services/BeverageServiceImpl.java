package mozt.edu.reactivemongo.services;

import lombok.RequiredArgsConstructor;
import mozt.edu.reactivemongo.mappers.BeverageMapper;
import mozt.edu.reactivemongo.model.BeverageDto;
import mozt.edu.reactivemongo.repository.BeverageRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BeverageServiceImpl implements BeverageService {
    private final BeverageMapper beverageMapper;
    private final BeverageRepository beverageRepository;

    @Override
    public Mono<BeverageDto> saveBeverage(Mono<BeverageDto> beverageDto) {
//        return beverageRepository.save(beverageMapper.beverageDtoToBeverage(beverageDto))
//                .map(beverageMapper::beverageToBeverageDto);

        Mono<BeverageDto> rBeverageDto = beverageDto.map(beverageMapper::beverageDtoToBeverage)
                .flatMap(beverageRepository::save)
                .map(beverageMapper::beverageToBeverageDto);
        System.out.println("Is null: " + rBeverageDto.subscribe(
                value -> System.out.println("Beverage Name: " + value.getId()),
                Throwable::printStackTrace,
                () -> System.out.println("completed without a value")
        ));
        return rBeverageDto;
    }

    @Override
    public Mono<BeverageDto> getById(String beerId) {
        return null;
    }
}
