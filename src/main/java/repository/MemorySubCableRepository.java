package repository;

import com.kuki.Practice_Mk1.domain.SubCable;
import org.springframework.stereotype.Repository;

import java.util.*;

public class MemorySubCableRepository implements SubCableRepository{

    private static Map<Long, SubCable> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public SubCable save(SubCable subCable) {
        subCable.setId(++sequence);
        store.put(subCable.getId(), subCable);
        return subCable;
    }

    @Override
    public Optional<SubCable> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<SubCable> findBySubCableName(String subCableName) {
        return store.values().stream()
                .filter(subCable -> subCable.getSubCableName().equals(subCableName))
                .findAny();
    }

    @Override
    public List<SubCable> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
