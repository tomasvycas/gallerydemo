package com.gallery.gallerydemo.controller;

import com.gallery.gallerydemo.model.Classifier;
import com.gallery.gallerydemo.service.ClassifierService;
import com.gallery.gallerydemo.service.impl.ClassifierServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/classifier")
@CrossOrigin
public class ClassifierController {

    @Autowired
    private ClassifierServiceImpl classifierService;

    @PostMapping(value = {"", "/"})
    public ResponseEntity<?> addQuestion(@Valid @RequestBody Classifier classifier, BindingResult result) {

        if (result.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }

            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }

        Classifier newClassifier = classifierService.saveOrUpdate(classifier);
        return new ResponseEntity<Classifier>(newClassifier, HttpStatus.CREATED);
    }

    @GetMapping(value = {"/all","/all/"})
    public Iterable<Classifier> findAll(){
        return classifierService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getQuestionById(@PathVariable Long id) {

        Classifier classifier = classifierService.findById(id);
        if (classifier == null ){
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("error", "Search question not found");
            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Classifier>(classifier, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteQuestion(@PathVariable Long id){
        classifierService.delete(id);
        return new ResponseEntity<String>("Question deleted", HttpStatus.OK);
    }
}
