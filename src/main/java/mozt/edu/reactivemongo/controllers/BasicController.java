package mozt.edu.reactivemongo.controllers;

import mozt.edu.reactivemongo.domain.Beverage;
import mozt.edu.reactivemongo.model.BeverageDto;
import mozt.edu.reactivemongo.services.BeverageService;
import lombok.RequiredArgsConstructor;
import mozt.edu.reactivemongo.mappers.BeverageMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
public class BasicController {
    public static final String BEVERAGE_PATH = "/api/v1/beverage";
    private final BeverageService bs;
    private final BeverageMapper beverageMapper;

    @PostMapping(BEVERAGE_PATH)
    public ResponseEntity handlePost(@RequestBody BeverageDto beverage) {
//        Beverage beverage = this.getTestBeverage();
//        BeverageDto beverageDto = beverageMapper.beverageToBeverageDto(getTestBeverage());
        Mono<BeverageDto> savedMono = bs.saveBeverage(Mono.just(beverage));
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.add(HttpHeaders.LOCATION, "/api/v1/beverage" + bRet.getId());

        return new ResponseEntity(HttpStatus.CREATED);
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

}
