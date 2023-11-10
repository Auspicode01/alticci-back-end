package altice.exercise.alticci.service;

import altice.exercise.alticci.cache.AlticciCache;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.stream.IntStream;

@Service
@AllArgsConstructor
public class AlticciService {

    private static final Integer COMPUTING_INDEX_A = 3;
    private static final Integer COMPUTING_INDEX_B = 2;

    private final AlticciCache alticciCache;

    public BigInteger getSequenceNumber(Integer n) {
        return alticciCache.getSequenceNumber(n).orElseGet(() ->
                alticciCache.getSequenceNumber(calculateSequenceNumber(n)).get());
    }

    private Integer calculateSequenceNumber(Integer n) {
        IntStream.rangeClosed(alticciCache.getSequenceSize(), n)
                .forEach(i -> alticciCache.addSequenceNumber(alticciCache.getSequenceNumber(i - COMPUTING_INDEX_A).get().add(alticciCache.getSequenceNumber(i - COMPUTING_INDEX_B).get())));
        return n;
    }

}
