package repository;

import com.kuki.Practice_Mk1.domain.SubCable;

import java.util.List;
import java.util.Optional;

public interface SubCableRepository {

    SubCable save(SubCable subCable);
    Optional<SubCable> findById(Long id);
    Optional<SubCable> findBySubCableName(String subCableName);
    List<SubCable> findAll();
}
