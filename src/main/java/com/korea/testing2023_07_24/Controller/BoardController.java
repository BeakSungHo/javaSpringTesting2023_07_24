package com.korea.testing2023_07_24.Controller;


import com.korea.testing2023_07_24.Entity.Board;
import com.korea.testing2023_07_24.Service.BoardService;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("Board")
@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardService boardService;
    //메인화면
    @GetMapping("/list")
    public String  TestBoardList(Model model) {
        List<Board> boardList = this.boardService.getList();
        model.addAttribute("boardList", boardList);

        return "testBoardMain";
    }
    @GetMapping("detail/{id}")
    public String TestBoardDetail(Model model, @PathVariable("id") Integer id){
        Board board=this.boardService.getId(id);

        model.addAttribute("board",board);
        return "testBoardDetail";
    }

    @GetMapping("/create")
    public String  TestBoardCreateGet(){
        return "TestBoardCreate";
    }
    @PostMapping("/create")
    public String  TestBoardCreatePost(
            @RequestParam String subject,
            @RequestParam String content) {
        this.boardService.create(subject,content);
        return "redirect:/Board/list";
    }
    @GetMapping("/modify/{id}")
    public  String TestBoardModifyGet(Model model, @PathVariable("id") Integer id){
        Board board=this.boardService.getId(id);
        model.addAttribute("board",board);
        return  "testBoardModify";
    }
    @PostMapping("/modify/{id}")
    public  String TestBoardModifyPost(
            @PathVariable("id") Integer id,
            @RequestParam String subject,
            @RequestParam String content){
        this.boardService.modify(id,subject,content);
        return String.format("redirect:/Board/detail/%d",id);
    }
    @PostMapping("/delete/{id}")
    public String TestBoardDelete(@PathVariable("id") Integer id){
        this.boardService.deleteBoard(id);
        return "redirect:/Board/list";
    }
}
