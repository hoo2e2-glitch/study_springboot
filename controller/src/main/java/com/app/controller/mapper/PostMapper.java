package com.app.controller.mapper;

import com.app.controller.domain.vo.MemberVO;
import com.app.controller.domain.vo.PostVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PostMapper {
    public List<PostVO> selectAll();
    public Optional<PostVO> select(Long id);


}
