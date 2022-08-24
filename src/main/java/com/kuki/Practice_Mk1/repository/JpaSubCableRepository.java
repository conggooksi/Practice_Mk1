package com.kuki.Practice_Mk1.repository;

import com.kuki.Practice_Mk1.domain.SubCable;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaSubCableRepository implements SubCableRepository{

    private final EntityManager em;

    public JpaSubCableRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public SubCable save(SubCable subCable) {
        em.persist(subCable);
        return subCable;
    }

    @Override
    public Optional<SubCable> findById(Long id) {
        SubCable subCable = em.find(SubCable.class, id);
        return Optional.ofNullable(subCable);
    }

    @Override
    public Optional<SubCable> findBySubCableName(String subCableName) {
        List<SubCable> result = em.createQuery("select m from SubCable m where m.subCableName = :subCableName", SubCable.class)
                .setParameter("subCableName", subCableName)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<SubCable> findAll() {
        return em.createQuery("select m from SubCable m", SubCable.class)
                .getResultList();
    }
}
