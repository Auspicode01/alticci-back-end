package altice.exercise.alticci.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.http.ResponseEntity;

import java.math.BigInteger;

@Tag(name = "Alticci", description = "Altice Labs Technical Exercise to Calculate Alticci Sequence")
public interface AlticciController {

    @Operation(
            summary = "Get Number in Sequence",
            description = "Retrieve Alticci Sequence Number Of Index \"n\""
    )
    ResponseEntity<BigInteger> getSequenceNumber(@NotNull @PositiveOrZero @Max(10000) Integer n);
}
