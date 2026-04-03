package com.app.mybatis.mapper;

import com.app.mybatis.domain.vo.PostVO;
import com.app.mybatis.dto.PostCountDTO;
import com.app.mybatis.dto.PostDTO;
import com.app.mybatis.dto.PostKeywordDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.*;

@Mapper
public interface PostMapper {
//    MYBATIS CRUD
    public void insert(PostVO postVO);
    public List<PostDTO> selectAll(Long id);
    public Optional<PostDTO> select(Long id);
    public void updatePostReadCount(Long id);
    public void update(PostVO postVO);
    public void delete(Long id);

    public List<PostDTO> selectAllWithOrder(Map<String, Object> orders);

    public PostCountDTO selectTotalPostCountAndPageCount(int limit);

    public List<PostDTO> selectAllWithKeyword(Map<String, Object> keywords);








}
