package com.example.hrms.business.abstracts;

import com.example.hrms.core.concretes.utilities.DataResult;
import com.example.hrms.core.concretes.utilities.Result;
import com.example.hrms.entities.concretes.CV.CvImages;
import com.example.hrms.entities.concretes.Candidates;
import com.example.hrms.entities.concretes.Resumes;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CvImageService {
    Result add(CvImages cvImages);
    Result deleteById(int imageId);
    DataResult<List<CvImages>> getAll();

    DataResult<List<CvImages>> getImagesByCandidates_Id(int candidateId);

    DataResult<CvImages> upload(MultipartFile photo, Candidates candidate) throws IOException;

}
