package org.vb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vb.model.entity.Resenia;

import java.util.UUID;

@Repository
public interface ReseniaRepository extends JpaRepository<Resenia, UUID> {
}
