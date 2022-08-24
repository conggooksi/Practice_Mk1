package com.kuki.Practice_Mk1.service;

import com.kuki.Practice_Mk1.domain.SubCable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import com.kuki.Practice_Mk1.repository.SubCableRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class SubCableServiceIntegrationTest {


    @Autowired
    SubCableService subCableService;

    @Autowired
    SubCableRepository subCableRepository;

    @Test
    void 회원가입() {
        //given
        SubCable subCable = new SubCable();
        subCable.setSubCableName("spring");

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
    }

}