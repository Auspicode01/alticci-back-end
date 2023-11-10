package altice.exercise.alticci.cache;

import java.util.Optional;

public interface AlticciCache {

    Integer getSequenceSize();

    void addSequenceNumber(Integer n);

    Optional<Integer> getSequenceIndex(Integer n);

}
