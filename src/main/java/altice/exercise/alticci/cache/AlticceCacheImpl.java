package altice.exercise.alticci.cache;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AlticceCacheImpl implements AlticciCache {

    private static List<Integer> alticciSequence;

    @Autowired
    public void AlticciService() {
        alticciSequence = new ArrayList<>();
        alticciSequence.add(0);
        alticciSequence.add(1);
        alticciSequence.add(1);
    }

    @Override
    public Integer getSequenceSize() {
        return alticciSequence.size();
    }

    @Override
    public void addSequenceNumber(Integer n) {
        alticciSequence.add(n);
    }

    @Override
    public Optional<Integer> getSequenceIndex(Integer n) {
        return n < alticciSequence.size() ? Optional.of(alticciSequence.get(n)) : Optional.empty();
    }
}
