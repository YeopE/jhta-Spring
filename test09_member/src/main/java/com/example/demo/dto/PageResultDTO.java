package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PageResultDTO<T> {
    private List<T> list;
    private int startPage;
    private int endPage;
    private int totalPageCount;
    private int page;

    public PageResultDTO(List<T> list, int page, int totalPageCount, int blockLimit) {
        this.list = list;
        this.page = page;
        this.totalPageCount = totalPageCount;
        startPage = (page / blockLimit) * blockLimit;
        endPage = Math.min(startPage + blockLimit - 1, totalPageCount - 1);
        if(totalPageCount == 0) endPage = 0;
    }
}
