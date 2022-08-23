package com.kuki.Practice_Mk1;

import com.kuki.Practice_Mk1.service.SubCableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import repository.SubCableRepository;

@Configuration
public class SpringConfig {
    /**
     * 데이터베이스와 연결하려면 데이터소스 해서 써야 됨
     */
//    private DataSource dataSource;
//
//    @Autowired
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
//

    /**
     * Jpa 사용하려면 엔티티 필요함
     */
//    private EntityManager em;
//
//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }

    private final SubCableRepository subCableRepository;

    @Autowired
    public SpringConfig(SubCableRepository subCableRepository) {
        this.subCableRepository = subCableRepository;
    }

    @Bean
    public SubCableService subCableService() {
        return new SubCableService(subCableRepository);
    }

//    @Bean
//    public SubCableRepository subCableRepository() {
//        return new MemorySubCableRepository();
//        return new JdbcTemplateSubCableRepository(dataSource);
//        return new JpaSubCableRepository(em);

//    }

}
