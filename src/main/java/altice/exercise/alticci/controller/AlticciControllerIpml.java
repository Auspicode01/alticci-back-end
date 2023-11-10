package altice.exercise.alticci.controller;

import altice.exercise.alticci.service.AlticciService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
@AllArgsConstructor
@Validated
@RequestMapping("/alticci")
public class AlticciControllerIpml implements AlticciController {

    private final AlticciService alticciService;

    @GetMapping("/{n}")
    @Override
    public ResponseEntity<BigInteger> getSequenceNumber(@PathVariable Integer n) {
        return new ResponseEntity<>(alticciService.getSequenceNumber(n), HttpStatus.OK);
    }
}
