package altice.exercise.alticci.service;

import altice.exercise.alticci.cache.AlticciCache;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.IntStream;

@Service
@AllArgsConstructor
public class AlticciService {

    private static final Integer COMPUTING_INDEX_A = 3;
    private static final Integer COMPUTING_INDEX_B = 2;

    private final AlticciCache alticciCache;

    public Integer getSequenceNumber(Integer n) {
        return alticciCache.getSequenceIndex(n).orElseGet(() ->
                alticciCache.getSequenceIndex(calculateSequenceNumber(n)).get());
    }

    private Integer calculateSequenceNumber(Integer n) {
        IntStream.rangeClosed(alticciCache.getSequenceSize(), n)
                .forEach(i -> alticciCache.addSequenceNumber(alticciCache.getSequenceIndex(i - COMPUTING_INDEX_A).get() + alticciCache.getSequenceIndex(i - COMPUTING_INDEX_B).get()));
        return n;
    }

}
