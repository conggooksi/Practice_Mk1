package com.kuki.Practice_Mk1.service;

import com.kuki.Practice_Mk1.domain.SubCable;
import org.springframework.transaction.annotation.Transactional;
import com.kuki.Practice_Mk1.repository.SubCableRepository;

import java.util.List;
import java.util.Optional;

@Transactional
public class SubCableService {

    private final SubCableRepository subCableRepository;

    public SubCableService(SubCableRepository subCableRepository) {
        this.subCableRepository = subCableRepository;
    }

    /**
     * 회원 가입
     */
    public Long join(SubCable subCable) {
        validateDuplicateSubCable(subCable);
        subCableRepository.save(subCable);
        return subCable.getId();
    }

    private void validateDuplicateSubCable(SubCable subCable) {
        subCableRepository.findBySubCableName(subCable.getSubCableName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 케이블입니다.");
                });
    }

    public List<SubCable> findSubCables() {
        return subCableRepository.findAll();
    }

    public Optional<SubCable> findOne(Long id) {
        return subCableRepository.findById(id);
    }
}
