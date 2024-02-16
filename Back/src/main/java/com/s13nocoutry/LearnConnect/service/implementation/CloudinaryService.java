package com.s13nocoutry.LearnConnect.service.implementation;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class CloudinaryService {
    private Cloudinary cloudinary;
    private Map<String, String> values = new HashMap<>();

    public CloudinaryService() {
        this.values.put("cloud_name", "dlv3mg6uk");
        this.values.put("api_key", "283466621357762");
        this.values.put("api_secret", "UhfsjqmHM_1mML4vZ2BUIArRQ3o");
        this.cloudinary = new Cloudinary(values);
    }
    public Map upPhoto(MultipartFile multipartFile) throws IOException {
        File file = convert(multipartFile);
        Map response = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
        file.delete();
        return response;
    }
    private File convert(MultipartFile multipartFile) throws IOException {
        File file = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(multipartFile.getBytes());
        fileOutputStream.close();
        return file;
    }
    public Map deletePhoto(String id) throws IOException {
        return cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());
    }
}
