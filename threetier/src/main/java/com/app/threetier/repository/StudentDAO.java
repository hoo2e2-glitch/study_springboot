package com.app.threetier.repository;


import com.app.threetier.domain.dto.StudentDTO;
import com.app.threetier.domain.vo.StudentVO;
import com.app.threetier.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// fm
// mapper / dao optional로 감싸지 않는다.
// 유지보수나 비지니스 로직에 혼란 줄수 있음
@RequiredArgsConstructor
@Repository
public class StudentDAO {

    private final StudentMapper studentMapper;

    // 학생추가
    public void save(StudentVO studentVO) {
        studentMapper.insert(studentVO);
    }

    // 단일조회
    public StudentDTO findById(Long id) {
        return studentMapper.select(id) ;
    }
    // 전체조회
    public List<StudentDTO> findAll() {
        return studentMapper.selectAll();
    }

    // 학생수정
    public void update(StudentVO studentVO) {
        studentMapper.update(studentVO);
    }

    // 삭제
    public void delete(Long id) {
        studentMapper.delete(id);
    }

}
