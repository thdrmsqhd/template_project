package com.base.template.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Hello {
    @Id
    Long id;
    String content;
}
