package com.rocketseat.register_course.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "course")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "name", nullable = false, length = 265)
    private String name;

    @Column(name = "category", nullable = false, length = 265)
    private String category;

    @CreationTimestamp
    @Column(name = "created_at", length = 265)
    private LocalDateTime createdAt;

    @Column(name = "update_at", length = 265)
    private LocalDateTime updateAt;
}
