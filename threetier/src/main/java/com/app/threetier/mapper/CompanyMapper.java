package com.app.threetier.mapper;

import com.app.threetier.domain.dto.PostDTO;
import com.app.threetier.domain.vo.CompanyVO;
import com.app.threetier.domain.vo.PostVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;


@Mapper
public interface CompanyMapper {

    public void insert(CompanyVO companyVO);

//    public List<PostDTO> selectAll();
//    public Optional<PostDTO> select(Long id);
//    public void update(PostVO postVO);
//    // 게시글 조회수 증가
//    public void updateReadCount(Long id);
//    public void delete(Long id);

}
