package com.busekeklik.seniorfullstack1.data.repository;


import com.busekeklik.seniorfullstack1.data.entity.BlogEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// CrudRepository<BlogCategoryEntity,Long>
// JpaRepository<BlogCategoryEntity,Long>
// PagingAndSortingRepository<BlogCategoryEntity,Long>

@Repository
public interface IBlogRepository extends CrudRepository<BlogEntity,Long> {

}
