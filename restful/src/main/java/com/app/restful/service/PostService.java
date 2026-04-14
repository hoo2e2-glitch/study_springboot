package com.app.restful.service;

import com.app.restful.domain.dto.PostDTO;
import com.app.restful.repository.PostDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    public List<PostDTO> findPost();

}
