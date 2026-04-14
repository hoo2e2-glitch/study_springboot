package com.app.mybatis.mapper;

import com.app.mybatis.domain.vo.PostVO;
import com.app.mybatis.dto.PostCountDTO;
import com.app.mybatis.dto.PostDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;
import java.util.Optional;

// mapper인거 인식
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
