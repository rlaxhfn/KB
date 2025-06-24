package org.scoula.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.scoula.board.domain.BoardVO;
import org.scoula.board.domain.BoardAttachmentVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
    private Long no;
    private String title;
    private String content;
    private String writer;
    private Date regDate;
    private Date updateDate;

    public List<BoardAttachmentVO> attaches;
    List<MultipartFile> files = new ArrayList<>();

    public static BoardDTO of(BoardVO boardVO) {
        return boardVO == null?null:BoardDTO.builder()
                .no(boardVO.getNo())
                .title(boardVO.getTitle())
                .content(boardVO.getContent())
                .writer(boardVO.getWriter())
                .attaches(boardVO.getAttaches())
                .regDate(boardVO.getRegDate())
                .updateDate(boardVO.getUpdateDate())
                .build();
    }
    public BoardVO toBoardVO() {
        return BoardVO.builder()
                .no(no)
                .title(title)
                .content(content)
                .writer(writer)
                .attaches(attaches)
                .regDate(regDate)
                .updateDate(updateDate)
                .build();
    }
}
