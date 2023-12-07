package mozt.edu.reactivemongo.services;

import mozt.edu.reactivemongo.domain.Beverage;
import mozt.edu.reactivemongo.mappers.BeverageMapper;
import mozt.edu.reactivemongo.model.BeverageDto;
import mozt.edu.reactivemongo.services.BeverageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@SpringBootTest
class BeverageServiceImplTest {
    @Autowired
    BeverageService beverageService;
    @Autowired
    BeverageMapper beverageMapper;

    BeverageDto beverageDto;

    @BeforeEach
    public void setUp(){
        beverageDto = beverageMapper.beverageToBeverageDto(getTestBeverage());
    }

    private Beverage getTestBeverage() {
        return Beverage.builder()
                .beverageName("Ayran")
                .beverageStyle("Still sulu")
                .price(BigDecimal.TEN)
                .quantityOnHand(123)
                .upc("1231234")
                .build();
    }

    @Test
    public void saveBeverage() throws InterruptedException{
        Mono<BeverageDto> savedMono = beverageService.saveBeverage(Mono.just(beverageDto));
        savedMono.subscribe(savedDto -> System.out.println("Saved Beverage Id: " + savedDto.getId()));
        Thread.sleep(1000l);
    }


}
