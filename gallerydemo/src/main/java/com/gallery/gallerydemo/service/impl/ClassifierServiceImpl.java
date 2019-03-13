package com.gallery.gallerydemo.service.impl;

import com.gallery.gallerydemo.model.Classifier;
import com.gallery.gallerydemo.repository.ClassifierRepository;
import com.gallery.gallerydemo.service.ClassifierService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassifierServiceImpl implements ClassifierService {

    @Autowired
    private ClassifierRepository classifierRepository;


    @Override
    public Iterable<Classifier> findAll() {
        return classifierRepository.findAll();
    }

    @Override
    public Classifier findById(Long id) {
        return classifierRepository.getById(id);
    }

    @Override
    public Classifier saveOrUpdate(Classifier classifier) {

        return classifierRepository.save(classifier);
    }

    @Override
    public void delete(Long id) {
        Classifier classifier = findById(id);
        classifierRepository.delete(classifier);

    }
}
