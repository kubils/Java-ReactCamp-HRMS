package com.example.hrms.core.adapter.concretes;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;
import com.example.hrms.core.adapter.abstracts.ImageService;
import com.example.hrms.core.concretes.utilities.DataResult;
import com.example.hrms.core.concretes.utilities.SuccessDataResult;
import com.example.hrms.entities.concretes.CV.CvImages;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class CloudinaryAdapterService implements ImageService {

    private Cloudinary cloudinary;

    private Map<String, String> valuesMap = new HashMap<>();

    public CloudinaryAdapterService() {
        valuesMap.put("cloud_name", "dp3iwc0ug");
        valuesMap.put("api_key", "351919314235771");
        valuesMap.put("api_secret", "V4dXichasWN1OTf85g9kJTBRpFQ");
        cloudinary = new Cloudinary(valuesMap);
    }


    @Override
    public DataResult<Map<String, String>> upload(MultipartFile multipartFile) throws IOException {
        File file = convert(multipartFile);
        Map result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
        file.delete();
        return new SuccessDataResult<Map>(result);
    }

    @Override
    public DataResult<Map> delete(String id) throws IOException {
        Map result = cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());
        return new SuccessDataResult<Map>(result);
    }

    public File convert(MultipartFile multipartFile) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(multipartFile.getBytes());
        fileOutputStream.close();

        return file;
    }
}
