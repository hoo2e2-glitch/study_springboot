package com.app.restful.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.models.examples.Example;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class CongestionDTO {

    @JsonProperty("page")
    public Integer page;
    public Integer perPage;
    public Integer totalCount;
    public Integer currentCount;
    public Integer matchCount;

    @JsonProperty("data")
    public List<CongestionDataDTO> data;






}
