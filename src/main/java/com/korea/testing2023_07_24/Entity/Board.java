package com.korea.testing2023_07_24.Entity;

import java.time.LocalDateTime;

        import jakarta.persistence.Column;
        import jakarta.persistence.Entity;
        import jakarta.persistence.GeneratedValue;
        import jakarta.persistence.GenerationType;
        import jakarta.persistence.Id;

        import lombok.Getter;
        import lombok.Setter;
import org.hibernate.Length;

@Getter
@Setter
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //번호

    @Column(length = 200)
    private String subject; //제목

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(length = 20)
    private String nickname;
    private LocalDateTime createDate;
    private Integer views;
    private Integer vote;
}