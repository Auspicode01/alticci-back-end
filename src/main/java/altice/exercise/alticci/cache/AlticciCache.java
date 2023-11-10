package altice.exercise.alticci.cache;

import java.math.BigInteger;
import java.util.Optional;

public interface AlticciCache {

    Integer getSequenceSize();

    void addSequenceNumber(BigInteger n);

    Optional<BigInteger> getSequenceNumber(Integer n);

}
