package com.example.hrms.core.adapter.abstracts;

import com.example.hrms.core.concretes.utilities.DataResult;
import com.example.hrms.core.concretes.utilities.Result;
import com.example.hrms.entities.concretes.CV.CvImages;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public interface ImageService {
    DataResult<Map<String, String>> upload(MultipartFile file) throws IOException;
    DataResult<Map> delete(String id) throws IOException;
}
