package com.app.mybatis.mapper;

import com.app.mybatis.domain.vo.PostVO;
import com.app.mybatis.dto.PostDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

// mapper인거 인식
@Mapper
public interface PostMapper {
    public void insert(PostVO postVO);
    public List<PostDTO> selectAll();
    public Optional<PostDTO> select(Long id);
    public List<PostVO> selectByDesc();
    public void updatePostReadCount(Long id);

}
