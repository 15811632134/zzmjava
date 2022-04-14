package com.zzm.serviceImpl;

import com.zzm.domain.Images;
import com.zzm.mapper.ImagesMapper;
import com.zzm.service.ImagesService;
import com.zzm.utils.ProUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ImagesImpl implements ImagesService {

    @Autowired
    ImagesMapper imagesMapper;

    @Override
    public Images add(Images images) {
        Images images2 = new Images();
        BeanUtils.copyProperties(images, images2, ProUtils.getNullPropertyNames(images));
        imagesMapper.insertSelective(images2);
        return images2;
    }


}
