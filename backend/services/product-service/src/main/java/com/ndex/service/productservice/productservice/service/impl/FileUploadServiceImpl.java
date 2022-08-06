package com.ndex.service.productservice.productservice.service.impl;

import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.ndex.service.productservice.productservice.service.FileUploadService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

@Service
public class FileUploadServiceImpl implements FileUploadService {

    private static final String DOWNLOAD_URL = "https://firebasestorage.googleapis.com/v0/b/ndex-b79cd.appspot.com/o/%s?alt=media";


    @Override
    public String upload(File file) throws IOException {

        BlobId blobId = BlobId.of("ndex-b79cd.appspot.com", file.getName());
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("media").build();
        Credentials credentials = GoogleCredentials.fromStream(new FileInputStream("ndex-b79cd-firebase-adminsdk-avhk2-df0ef97489.json"));
        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
        storage.create(blobInfo, Files.readAllBytes(file.toPath()));
        return String.format(DOWNLOAD_URL, URLEncoder.encode(file.getName(), StandardCharsets.UTF_8));

    }
}