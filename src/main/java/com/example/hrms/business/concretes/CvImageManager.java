package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.CvImageService;
import com.example.hrms.core.adapter.abstracts.ImageService;
import com.example.hrms.core.concretes.utilities.*;
import com.example.hrms.dataAccess.abstracts.CvImageDao;
import com.example.hrms.entities.concretes.CV.CvImages;
import com.example.hrms.entities.concretes.CV.CvLanguages;
import com.example.hrms.entities.concretes.Candidates;
import com.example.hrms.entities.concretes.Resumes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class CvImageManager implements CvImageService {

    private CvImageDao cvImageDao;
    private ImageService imageService;

    @Autowired
    public CvImageManager(CvImageDao cvImageDao, ImageService imageService) {
        this.cvImageDao = cvImageDao;
        this.imageService = imageService;
    }

    @Override
    public Result add(CvImages cvImages) {
        if(this.cvImageDao.save(cvImages) != null) {
            return new SuccessResult();
        }
        return new ErrorResult();
    }

    @Override
    public Result deleteById(int imageId) {
        this.cvImageDao.deleteById(imageId);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<CvImages>> getAll() {
        return new SuccessDataResult<CvImages>(this.cvImageDao.findAll(), "images listed");
    }

    @Override
    public DataResult<List<CvImages>> getImagesByCandidates_Id(int candidateId) {
        return new SuccessDataResult<List<CvImages>>
                (this.cvImageDao.getByCandidatesId(candidateId), "listed images");

    }

    @Override
    public DataResult<CvImages> upload(MultipartFile multipartFile, Candidates candidate) throws IOException {

        DataResult<Map<String, String>> result  = imageService.upload(multipartFile);

        if (result.isSuccess()) {

            CvImages image = new CvImages();
            image.setCandidates(candidate);
            image.setPhotoUrl(result.getData().get("url"));
            image.setName(result.getData().get("public_id"));

            Result addingResult = this.add(image);
            if (addingResult.isSuccess()) {
                return new SuccessDataResult<CvImages>(image, "image uploaded");
            }
        }
        return new ErrorDataResult<CvImages>(null,"file did not uploaded");
    }

}
