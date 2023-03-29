package com.wyhw.pmp.service;

import com.wyhw.pmp.entity.model.PicModel;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author wanyanhw
 * @since 2023/3/27 10:20
 */
public interface PictureService {
    /**
     * 保存文件
     * @param file 文件
     */
    void save(MultipartFile file);

    /**
     * 遍历图片
     * @return 图片集合
     */
    List<PicModel> list();

    /**
     * 遍历优选图片
     * @return 图片集合
     */
    List<PicModel> listTop();
}
