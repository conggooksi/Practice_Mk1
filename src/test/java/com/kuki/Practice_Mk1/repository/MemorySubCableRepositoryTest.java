package com.kuki.Practice_Mk1.repository;

import com.kuki.Practice_Mk1.domain.SubCable;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemorySubCableRepositoryTest {

    MemorySubCableRepository subCableRepository = new MemorySubCableRepository();

    @AfterEach
    public void afterEach() {
        subCableRepository.clearStore();
    }

    @Test
    public void save() {
        SubCable subCable = new SubCable();
        subCable.setSubCableName("spring");

        subCableRepository.save(subCable);

        SubCable result = subCableRepository.findById(subCable.getId()).get();
        assertThat(subCable).isEqualTo(result);
    }

    @Test
    public void findBySubCableName() {
        SubCable subCable1 = new SubCable();
        subCable1.setSubCableName("spring1");
        subCableRepository.save(subCable1);

        SubCable subCable2 = new SubCable();
        subCable2.setSubCableName("spring2");
        subCableRepository.save(subCable2);

        SubCable result = subCableRepository.findBySubCableName("spring1").get();

        assertThat(result).isEqualTo(subCable1);
    }

    @Test
    public void findAll(){
        SubCable subCable1 = new SubCable();
        subCable1.setSubCableName("spring1");
        subCableRepository.save(subCable1);

        SubCable subCable2 = new SubCable();
        subCable2.setSubCableName("spring2");
        subCableRepository.save(subCable2);

        List<SubCable> result = subCableRepository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}
