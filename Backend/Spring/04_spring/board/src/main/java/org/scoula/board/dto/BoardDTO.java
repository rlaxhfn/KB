package org.scoula.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.scoula.board.domain.BoardVO;

import java.util.Date;

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

    public static BoardDTO of(BoardVO boardVO) {
        return boardVO == null?null:BoardDTO.builder()
                .no(boardVO.getNo())
                .title(boardVO.getTitle())
                .content(boardVO.getContent())
                .writer(boardVO.getWriter())
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
                .regDate(regDate)
                .updateDate(updateDate)
                .build();
    }
}
