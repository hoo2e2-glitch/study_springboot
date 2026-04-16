package com.app.restful.mapper;

import com.app.restful.domain.dto.PostDTO;
import com.app.restful.domain.vo.PostVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
//5. Mapper 인터페이스(xml의 id와 메서드의 이름이 동일)
public interface PostMapper {

    // 게시글 전체 조회 + 정렬
    public List<PostDTO> selectAll(Map<String, String> orders);
    //- 게시글 상세보기 조회 서비스
    public PostDTO selectById(Long id);
    //- 게시글 작성(추가) 서비스
    public void insert(PostVO postVO);
    //- 게시글 수정 서비스
    public void update(PostVO postVO);
    //- 게시글 삭제 서비스
    public void delete(Long id);
    //- 게시글 삭제(탈퇴시) 서비스
    public void deleteByMemberId(Long memberId);





}
