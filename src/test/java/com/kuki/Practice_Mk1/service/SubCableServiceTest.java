package com.kuki.Practice_Mk1.service;

import com.kuki.Practice_Mk1.domain.SubCable;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.MemorySubCableRepository;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class SubCableServiceTest {

    SubCableService subCableService;
    MemorySubCableRepository subCableRepository;

    @BeforeEach
    public void beforeEach() {
        subCableRepository = new MemorySubCableRepository();
        subCableService = new SubCableService(subCableRepository);
    }

    @AfterEach
    public void afterEach() {
        subCableRepository.clearStore();
    }


    @Test
    void 회원가입() {
        //given
        SubCable subCable = new SubCable();
        subCable.setSubCableName("hello");

        //when
        Long saveId = subCableService.join(subCable);

        //then
        SubCable findSubCable = subCableService.findOne(saveId).get();
        assertThat(subCable.getSubCableName()).isEqualTo(findSubCable.getSubCableName());
    }

    @Test
    public void 중복_회원_예외() {
        //given
        SubCable subCable1 = new SubCable();
        subCable1.setSubCableName("spring1");

        SubCable subCable2 = new SubCable();
        subCable2.setSubCableName("spring2");

        //when
        subCableService.join(subCable1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> subCableService.join(subCable1));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 케이블입니다.");

/*

        try {
            subCableService.join(subCable2);
            fail();
        } catch (IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 케이블입니다.");
        }
*/

        //then
    }

    @Test
    void findSubCables() {
    }

    @Test
    void findOne() {
    }
}