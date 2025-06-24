package org.scoula.board.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Log4j2
public class BoardAttachmentVO {
    private Long no;
    private Long bno;
    private String filename;
    private String path;
    private String contentType;
    private Long size;
    private Date regDate;
    public static BoardAttachmentVO of(MultipartFile part, Long bno, String path) {
        return builder()
                .bno(bno)
                .filename(part.getOriginalFilename())
                .path(path)
                .contentType(part.getContentType())
                .size(part.getSize())
                .build();
    }
}
