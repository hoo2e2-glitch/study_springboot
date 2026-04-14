package com.app.threetier.mapper;

import com.app.threetier.domain.dto.StudentDTO;
import com.app.threetier.domain.vo.StudentVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface StudentMapper {

//    추가
    public void insert(StudentVO studentVO);

    //전체조회
    public List<StudentDTO> selectAll();

    // 단일조회
    public StudentDTO select(Long id);

    //수정
    public void update(StudentVO studentVO);

    // 삭제
    public void delete(Long id);


}
