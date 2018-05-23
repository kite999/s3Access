package com.example.s3Access.Aws.S3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;

@RestController
public class S3Controller {
    private final S3Service s3Service;

    @Autowired
    public S3Controller(S3Service s3Service) {
        this.s3Service = s3Service;
    }

    @GetMapping("/aws/s3/list")
    public String list() throws IOException {
        return this.s3Service.list();
    }

    @GetMapping("/aws/s3/upload")
    public String upload() throws IOException {
        //TODO outputStreamに書き込めればなんでもいいのでファイルから読まなくても別によい。
        //TODO ここでは例なので例ファイルを決め打ちしてinputstreamにしている。
        //TODO 通常ならinputstreamをそのまま扱うと思うのでファイルにしないでそのまま流し込めば良いとおもう
        InputStream pdfStream = ClassLoader
                .getSystemResourceAsStream("source.pdf");
        return this.s3Service.upload(pdfStream);
    }
}
