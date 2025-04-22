package com.example.demo.dto;

import com.example.demo.entity.FileInfomation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FileInfomationDTO {
    private Long filenum;
    private String title;
    private String orgfilename;
    private String savefilename;
    private long filesize;
    private Date regdate;
    private Date update;

    public FileInfomationDTO(FileInfomation fileInfomation) {
        this.filenum = fileInfomation.getFilenum();
        this.title = fileInfomation.getTitle();
        this.orgfilename = fileInfomation.getOrgfilename();
        this.savefilename = fileInfomation.getSavefilename();
        this.filesize = fileInfomation.getFilesize();
        this.regdate = fileInfomation.getRegdate();
        this.update = fileInfomation.getUpdate();
    }
    public FileInfomation toEntity() {
        FileInfomation fileInfomation = FileInfomation.builder()
                .filenum(filenum)
                .title(title)
                .orgfilename(orgfilename)
                .savefilename(savefilename)
                .filesize(filesize)
                .regdate(regdate)
                .update(update)
                .build();
        return fileInfomation;
    }
}
