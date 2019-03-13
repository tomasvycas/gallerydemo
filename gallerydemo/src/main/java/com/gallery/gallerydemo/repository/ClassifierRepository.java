package com.gallery.gallerydemo.repository;

import com.gallery.gallerydemo.model.Classifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassifierRepository  extends CrudRepository<Classifier, Long> {

    Classifier getById(Long id);
}
