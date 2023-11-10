package altice.exercise.alticci.service;

import altice.exercise.alticci.cache.AlticciCache;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class AlticciServiceTest {

    @Autowired
    AlticciCache alticciCache;

    @Autowired
    AlticciService alticciService;

    @Test
    void WhenGetExistingSequenceNumber_ReturnResult() {
        //Arrange
        Integer input = 1;
        //Act
        BigInteger result = alticciService.getSequenceNumber(input);
        //Assert
        assertThat(result).isEqualTo(BigInteger.valueOf(1));
    }

    @Test
    void WhenGetNonExistentSequenceNumber_CalculateNewValueAndReturnResult() {
        //Arrange
        Integer input = 5;
        Integer cacheSize = alticciCache.getSequenceSize();
        //Act
        BigInteger result = alticciService.getSequenceNumber(input);
        //Assert
        assertThat(cacheSize).isEqualTo(3);
        assertThat(result).isEqualTo(BigInteger.valueOf(2));
        assertThat(alticciCache.getSequenceSize()).isEqualTo(6);
    }
}