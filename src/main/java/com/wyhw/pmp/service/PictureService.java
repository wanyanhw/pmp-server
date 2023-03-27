package com.wyhw.pmp.service;

import com.wyhw.pmp.entity.model.PicModel;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author wanyanhw
 * @since 2023/3/27 10:20
 */
public interface PictureService {
    void save(MultipartFile file);

    List<PicModel> list();
}
