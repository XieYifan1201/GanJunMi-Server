package com.train.dto;

import lombok.Data;

@Data
public class DraftUpdateDTO {
    private String media_id;
    private int index;
    private DraftAddDTO articles;

}
