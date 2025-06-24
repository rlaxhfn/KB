package org.scoula.board.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.board.dto.BoardDTO;
import org.scoula.config.RootConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j2
class BoardServiceTest {
    @Autowired
    private BoardService boardService;

    @Test
    void getList() {
        for(BoardDTO boardDTO : boardService.getList()) {
            log.info(boardDTO);
        }
    }

    @Test
    void get() {
        log.info(boardService.get(1L));
    }

    @Test
    void create() {
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setTitle("새로 작성하는 글");
        boardDTO.setContent("새로 작성하는 내용");
        boardDTO.setWriter("user1");
        boardService.create(boardDTO);
        log.info("생성된 게시물의 번호: "+boardDTO.getNo());
    }

    @Test
    void update() {
        BoardDTO boardDTO = boardService.get(1L);
        boardDTO.setTitle("제목 수정합니다.");
        log.info("update Result: "+boardService.update(boardDTO));
    }

    @Test
    void delete() {
        log.info("delete Result: "+boardService.delete(2L));
    }
}