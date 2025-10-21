package com.example.lab7.dto;

import java.io.Serializable;

public interface Report extends Serializable {
    Object getGroup(); // sẽ trả về Category (serializable)
    Double getSum();
    Long getCount();
}
