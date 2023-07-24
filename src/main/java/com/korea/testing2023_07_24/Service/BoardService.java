package com.korea.testing2023_07_24.Service;

import com.korea.testing2023_07_24.Entity.Board;
import com.korea.testing2023_07_24.Repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;
    public List<Board> getList() {
        return this.boardRepository.findAll();
    }
    public Board getId(int id){
        Optional<Board> ob= this.boardRepository.findById(id);
        return ob.get();
    }
    public void modify(int id,String subject,String content){
        Board b= this.getId(id);
        b.setSubject(subject);
        b.setContent(content);
        this.boardRepository.save(b);
    }
    public void create(String subject, String content){
        Board board = new Board();
        board.setSubject(subject);
        board.setContent(content);
        board.setCreateDate(LocalDateTime.now());
        board.setNickname("홍길동");
        board.setVote(0);
        board.setViews(0);
        this.boardRepository.save(board);
    }
    public void deleteBoard(Integer id){
        Board board= this.boardRepository.findById(id).get();
        boardRepository.delete(board);
    }
}
