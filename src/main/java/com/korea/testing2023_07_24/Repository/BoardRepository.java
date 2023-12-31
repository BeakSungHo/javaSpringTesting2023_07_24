package com.korea.testing2023_07_24.Repository;

import com.korea.testing2023_07_24.Entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Integer> {

    Page<Board> findAll(Specification<Board> spec, Pageable pageable);
}
