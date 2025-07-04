package org.scoula.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    final private BoardMapper mapper;

    @Override
    public void create(BoardDTO boardDTO) {
        log.info("create........."+boardDTO);
        mapper.create(boardDTO.toBoardVO());
    }

    @Override
    public List<BoardDTO> getList() {
        log.info("getList.........");
        return mapper.getList().stream()
                .map(BoardDTO::of)
                .toList();
    }

    @Override
    public BoardDTO get(Long no) {
        log.info("get........." + no);
        BoardDTO boardDTO = new BoardDTO().of(mapper.get(no));
        return Optional.ofNullable(boardDTO).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public boolean update(BoardDTO boardDTO) {
        log.info("update........."+boardDTO);
        return mapper.update(boardDTO.toBoardVO())==1;
    }

    @Override
    public boolean delete(Long no) {
        log.info("delete......."+no);
        return mapper.delete(no)==1;
    }
}
