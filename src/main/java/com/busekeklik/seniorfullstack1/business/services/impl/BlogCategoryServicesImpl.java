package com.busekeklik.seniorfullstack1.business.services.impl;

import com.busekeklik.seniorfullstack1.bean.ModelMapperBean;
import com.busekeklik.seniorfullstack1.business.dto.BlogCategoryDto;
import com.busekeklik.seniorfullstack1.business.services.IBlogCategoriesServices;
import com.busekeklik.seniorfullstack1.data.entity.BlogCategoryEntity;
import com.busekeklik.seniorfullstack1.data.repository.IBlogCategoryRepository;

import com.busekeklik.seniorfullstack1.exception.BuseKeklikException;
import com.busekeklik.seniorfullstack1.exception.NotFound404Exception;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// LOMBOK
@RequiredArgsConstructor
@Log4j2

// SERVICES
@Service
public class BlogCategoryServicesImpl implements IBlogCategoriesServices<BlogCategoryDto, BlogCategoryEntity> {

    // INJECTION
    private final IBlogCategoryRepository IBlogCategoryRepository;
    private final ModelMapperBean modelMapperBean;

    // MODEL MAPPER
    @Override
    public BlogCategoryDto entityToDto(BlogCategoryEntity blogCategoryEntity) {
        return modelMapperBean.getModelMapperMethod().map(blogCategoryEntity,BlogCategoryDto.class);
    }

    @Override
    public BlogCategoryEntity dtoToEntity(BlogCategoryDto blogCategoryDto) {
        return modelMapperBean.getModelMapperMethod().map(blogCategoryDto,BlogCategoryEntity.class);
    }

    /////////////////////////////////////////////////////////////
    // SPEED DATA
    @Override
    @Transactional
    public String blogCategoryServiceSpeedData(Integer data) {
        if(data!=null){
            for (int i = 0; i <=data ; i++) {
                BlogCategoryEntity blogCategoryEntity=new BlogCategoryEntity();
                blogCategoryEntity.setCategoryName("Category "+ UUID.randomUUID().toString());
                IBlogCategoryRepository.save(blogCategoryEntity);
            }
        }else {
            throw new BuseKeklikException("Speed Data oluşturulmadı");
        }
        return data+" tane veri eklendi";
    }

    // DELETE ALL
    @Override
    public String blogCategoryServiceDeleteAllData() {
        IBlogCategoryRepository.deleteAll();
        return blogCategoryServiceList()+" tane veri silindi";
    }

    ////////////////////////////////////////////////////////////
    // CRUD
    // @Transaction (Create,Delete,Update)

    // CREATE
    @Override
    @Transactional
    public BlogCategoryDto blogCategoryServiceCreate(BlogCategoryDto blogCategoryDto) {
        if(blogCategoryDto!=null){
            BlogCategoryEntity blogCategoryEntity=dtoToEntity(blogCategoryDto);
            IBlogCategoryRepository.save(blogCategoryEntity);
            blogCategoryDto.setCategoryID(blogCategoryEntity.getCategoryID());
            blogCategoryDto.setCategoryName(blogCategoryEntity.getCategoryName());
            return blogCategoryDto;
        }else{
            throw new NullPointerException(BlogCategoryDto.class+" boş ");
        }
    }

    // LIST
    @Override
    public List<BlogCategoryDto> blogCategoryServiceList() {
        Iterable<BlogCategoryEntity> categoryEntityIterable= IBlogCategoryRepository.findAll();
        List<BlogCategoryDto> blogCategoryDtoList=new ArrayList<>();
        for (BlogCategoryEntity entity: categoryEntityIterable){
            BlogCategoryDto blogCategoryDto=entityToDto(entity);
            blogCategoryDtoList.add(blogCategoryDto);
        }
        log.info(" Category Name Listesi: "+blogCategoryDtoList.size());
        //return List.of();
        return blogCategoryDtoList;
    }

    // FIND
    @Override
    public BlogCategoryDto blogCategoryServiceFindById(Long id) {
        BlogCategoryEntity findBlogCategoryEntity=null;
        if(id!=null){
            findBlogCategoryEntity=IBlogCategoryRepository.findById(id)
                    .orElseThrow(()->new NotFound404Exception(id+" nolu veri yoktur"));
        }else if(id==null){
            throw new NullPointerException("blog category id null");
        }
        return entityToDto(findBlogCategoryEntity);
    }

    // UPDATE
    @Transactional
    @Override
    public BlogCategoryDto blogCategoryServiceUpdateById(Long id, BlogCategoryDto blogCategoryDto) {
        BlogCategoryDto findBlogCategoryDto=blogCategoryServiceFindById(id);
        if(findBlogCategoryDto!=null){
            BlogCategoryEntity blogCategoryEntity=dtoToEntity(blogCategoryDto);
            blogCategoryEntity.setCategoryName(blogCategoryDto.getCategoryName());
            IBlogCategoryRepository.save(blogCategoryEntity);
            return findBlogCategoryDto;
        }
        return null;
    }

    // DELETE
    @Transactional
    @Override
    public BlogCategoryDto blogCategoryServiceDeleteById(Long id) {
        BlogCategoryDto findBlogCategoryDto=blogCategoryServiceFindById(id);
        if(findBlogCategoryDto!=null){
            IBlogCategoryRepository.deleteById(id);
            return findBlogCategoryDto;
        }
        return null;
    }
}