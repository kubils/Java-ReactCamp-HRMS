package com.example.hrms.api.controllers;


import com.example.hrms.business.abstracts.CvImageService;
import com.example.hrms.core.concretes.utilities.DataResult;
import com.example.hrms.core.concretes.utilities.Result;
import com.example.hrms.entities.concretes.CV.CvImages;
import com.example.hrms.entities.concretes.Candidates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/images")
public class CvImagesControler {

    private CvImageService imageService;

    @Autowired
    public CvImagesControler(CvImageService imageService) {
        this.imageService = imageService;
    }


    @GetMapping("/getByCandidates_Id")
    public DataResult<List<CvImages>> getByCandidates_Id(int candidateId) {
        return this.imageService.getImagesByCandidates_Id(candidateId);
    }

    @GetMapping("/getAll")
    public DataResult<List<CvImages>> getAll() {
        return this.imageService.getAll();
    }


    @PostMapping("/upload")
    public DataResult<CvImages> upload(@RequestParam MultipartFile multipartFile, @RequestParam Candidates candidateId) throws IOException {
        return this.imageService.upload(multipartFile, candidateId);
    }

    @DeleteMapping("/delete")
    public Result deleteById(@RequestParam int imageId) {return this.imageService.deleteById(imageId);}
}
