package com.gallery.gallerydemo.service;

import com.gallery.gallerydemo.model.Classifier;

public interface ClassifierService {

    Iterable<Classifier> findAll();

    Classifier findById(Long id);

    Classifier saveOrUpdate(Classifier classifier);

    void delete(Long id);


}
