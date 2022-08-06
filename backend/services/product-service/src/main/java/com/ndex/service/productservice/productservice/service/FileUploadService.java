package com.ndex.service.productservice.productservice.service;

import java.io.File;
import java.io.IOException;

public interface FileUploadService {
    String upload(File file) throws IOException;
}
