package org.scoula.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.mapper.BoardMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.scoula.util.UploadFiles;

@Log4j2
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    final private BoardMapper mapper;

    private final static String BASE_DIR = "uploads/board/";

    @Transactional
    @Override
    public void create(BoardDTO boardDTO) {
        log.info("Creating board: " + boardDTO);
        BoardVO boardVO = boardDTO.toVo();
        mapper.create(boardVO);
        List<MultipartFile> files = boardDTO.getFiles();
        if(files != null && !files.isEmpty()) {
            upload(boardVO.getNo(), files);
        }
    }
    private void upload(Long bno, List<MultipartFile> files) {
        for(MultipartFile part: files) {
            if(part.isEmpty()) continue;
            try {
                String uploadPath = UploadFiles.upload(BASE_DIR, part);
                BoardAttachmentVO attach = BoardAttachmentVO.of(part, bno, uploadPath);
                mapper.createAttachment(attach);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    //    @Override
//    public void create(BoardDTO boardDTO) {
//        log.info("create........."+boardDTO);
//        mapper.create(boardDTO.toBoardVO());
//    }

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

    // 첨부파일 한 개 얻기
    @Override
    public BoardAttachmentVO getAttachment(Long no) {
        return mapper.getAttachment(no);
    }

    // 첨부파일 삭제
    @Override
    public boolean deleteAttachment(Long no) {
        return mapper.deleteAttachment(no) == 1;
    }
}
