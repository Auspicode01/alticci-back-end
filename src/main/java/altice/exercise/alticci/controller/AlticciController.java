package altice.exercise.alticci.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.http.ResponseEntity;

import java.math.BigInteger;

@Api(produces = "application/json", value = "Altice Labs Technical Exercise to Calculate Alticci Sequence")
public interface AlticciController {

    @ApiOperation(value = "Retreive Sequence Number Of Index \"n\"", response = Integer.class)
    ResponseEntity<BigInteger> getSequenceNumber(@NotNull @PositiveOrZero @Max(10000) Integer n);
}
