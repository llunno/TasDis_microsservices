package com.ln.microsservice.instituicao.Persistance.Repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ln.microsservice.instituicao.Persistance.Entities.InstituicaoEnsino;

@Repository
public interface InstituicaoRepository extends JpaRepository<InstituicaoEnsino, UUID> {

}
