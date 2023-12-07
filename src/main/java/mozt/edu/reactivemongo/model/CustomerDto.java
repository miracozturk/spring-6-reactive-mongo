package mozt.edu.reactivemongo.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDto {
    private String id;
    @NotNull
    @Size(min = 3, max = 255)
    private String customerName;

    private Integer version;
    @CreatedDate
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;


}
