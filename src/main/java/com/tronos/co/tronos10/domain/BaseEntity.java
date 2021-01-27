package com.tronos.co.tronos10.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
//@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Serializable
{
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Boolean deleted;

  @Column(name = "created_by", nullable = true, updatable = false)
  private String createdBy;

  @Column(name = "updated_by", nullable = true)
  private String updatedBy;

  @CreationTimestamp
  @Column(name = "creation_date", nullable = true, updatable = false)
  private LocalDateTime creationDate;

  @UpdateTimestamp
  @Column(name = "update_date", nullable = true)
  private LocalDateTime updateDate;

  //public boolean isNew() {
 //   return Optional.ofNullable(getId()).orElse((long) 0) == 0;
  //}

}
