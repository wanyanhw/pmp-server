package com.wyhw.pmp.service.impl;

import com.wyhw.pmp.dao.PictureDao;
import com.wyhw.pmp.dao.TopPictureDao;
import com.wyhw.pmp.entity.Picture;
import com.wyhw.pmp.entity.TopPicture;
import com.wyhw.pmp.entity.model.PicModel;
import com.wyhw.pmp.service.FileService;
import com.wyhw.pmp.service.PictureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wanyanhw
 * @since 2023/3/27 10:21
 */
@Service
@Slf4j
public class PictureServiceImpl implements PictureService {

    @Resource
    private PictureDao pictureDao;
    @Resource
    private TopPictureDao topPictureDao;
    @Resource
    private FileService fileService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(MultipartFile file) {
        String path = null;
        try {
            String name = file.getOriginalFilename();
            String fileType = name.substring(name.lastIndexOf("."));
            path = fileService.upload(file.getInputStream(), System.currentTimeMillis() + fileType);
            Picture picture = new Picture();
            picture.setPath(path);
            picture.setType(fileType.substring(1));
            picture.setName(file.getOriginalFilename());
            pictureDao.save(picture);
        } catch (Exception e) {
            if (path != null) {
                boolean deleted = fileService.delete(path);
                if (!deleted) {
                    log.error("文件 {} 未删除", path);
                }
            }
            log.error("上传图片异常", e);
        }
    }

    @Override
    public List<PicModel> list() {
        List<Picture> list = pictureDao.lambdaQuery().list();
        return parse2Model(list);
    }

    @Override
    public List<PicModel> listTop() {
        List<TopPicture> topLicList = topPictureDao.list();
        if (topLicList.isEmpty()) {
            return Collections.emptyList();
        }
        List<Picture> list = pictureDao.lambdaQuery().in(Picture::getId, topLicList.stream().map(TopPicture::getId)).list();
        return parse2Model(list);
    }

    private List<PicModel> parse2Model(List<Picture> list) {
        return list.stream().map(entity -> {
            PicModel picModel = new PicModel();
            picModel.setId(String.valueOf(entity.getId()));
            picModel.setName(entity.getName());
            picModel.setPath(entity.getPath());
            return picModel;
        }).collect(Collectors.toList());
    }
}
