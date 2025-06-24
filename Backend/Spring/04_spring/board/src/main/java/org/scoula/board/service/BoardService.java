package org.scoula.board.service;

import org.scoula.board.dto.BoardDTO;

import java.util.List;

public interface BoardService {
    public List<BoardDTO> getList();
    public BoardDTO get(Long no);
    public void create(BoardDTO boardDTO);
    public boolean update(BoardDTO boardDTO);
    public boolean delete(Long no);
}
