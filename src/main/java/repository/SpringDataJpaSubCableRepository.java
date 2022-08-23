package repository;

import com.kuki.Practice_Mk1.domain.SubCable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaSubCableRepository extends JpaRepository<SubCable, Long>, SubCableRepository {
    @Override
    Optional<SubCable> findBySubCableName(String subCableName);
}
