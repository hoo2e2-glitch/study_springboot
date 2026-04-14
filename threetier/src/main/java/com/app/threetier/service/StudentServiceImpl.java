package com.app.threetier.service;

import com.app.threetier.domain.dto.StudentDTO;
import com.app.threetier.domain.vo.StudentVO;
import com.app.threetier.repository.StudentDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(rollbackFor=Exception.class)
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentDAO studentDAO;

    // 학생등록
    @Override
    public void registerStudent(StudentVO studentVO) {
        studentDAO.save(studentVO);
    }

    // 학생단일처리
    // 서비스 단에서 Optional 처리
    @Override
    public Optional<StudentDTO> getStudent(Long id) {
        return Optional.ofNullable(studentDAO.findById(id));
    }

    // 전제조회
    @Override
    public List<StudentDTO> getStudentList() {
        return studentDAO.findAll();
    }

    // 수정
    @Override
    public void updateStudent(StudentVO studentVO) {
        studentDAO.update(studentVO);
    }

    // 삭제
    @Override
    public void  deleteStudent(Long id) {
        studentDAO.delete(id);
    }
}
