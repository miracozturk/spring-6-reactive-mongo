package mozt.edu.reactivemongo.mappers;

import mozt.edu.reactivemongo.domain.Beverage;
import mozt.edu.reactivemongo.model.BeverageDto;
import org.mapstruct.Mapper;

@Mapper
public interface BeverageMapper {
    BeverageDto beverageToBeverageDto(Beverage b);
    Beverage beverageDtoToBeverage(BeverageDto bDto);
}

