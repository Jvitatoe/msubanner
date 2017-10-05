package edu.msudenver.cs3250.group6.msubanner.section;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Section repository.
 */
@RepositoryRestResource
public interface SectionRepository extends CrudRepository<Section, Long> {
}
