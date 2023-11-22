package com.sis.rest.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Setter
@Getter
public class MoviePojo {

    @NotBlank(message = "title harus diisi!")
    private String title;

    private String description;

    private Float rating;

    private String image;

    private Date createdt;

    private Date updatedAt;
}
