package altice.exercise.alticci.cache;


import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AlticceCacheImpl implements AlticciCache {

    private static List<BigInteger> alticciSequence;

    @PostConstruct
    public void PostConstruct() {
        alticciSequence = new ArrayList<>();
        alticciSequence.add(BigInteger.ZERO);
        alticciSequence.add(BigInteger.ONE);
        alticciSequence.add(BigInteger.ONE);
    }

    @Override
    public Integer getSequenceSize() {
        return alticciSequence.size();
    }

    @Override
    public void addSequenceNumber(BigInteger n) {
        alticciSequence.add(n);
    }

    @Override
    public Optional<BigInteger> getSequenceNumber(Integer n) {
        return n < alticciSequence.size() ? Optional.of(alticciSequence.get(n)) : Optional.empty();
    }
}
