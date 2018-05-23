package com.example.s3Access.Aws.S3;

import com.amazonaws.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.WritableResource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@Service
public class S3Service {
    private final ResourcePatternResolver resolver;
    private final ResourceLoader resourceLoader;
    private static final String AWS_S3_DOC_PRINTER_PATH = "s3://" + System.getenv("S3_BUCKET_NAME");

    @Autowired
    public S3Service(ResourcePatternResolver resourcePatternResolver, ResourceLoader resourceLoader) {
        this.resolver = resourcePatternResolver;
        this.resourceLoader = resourceLoader;
    }

    public String list() throws IOException {
        Resource[] resources = this.resolver.getResources( AWS_S3_DOC_PRINTER_PATH + "/**/*.*");
        StringBuilder builder = new StringBuilder();

        for (Resource resource : resources) {
            builder.append(resource.toString());
            builder.append("<br>");
        }

        return builder.toString();
    }

    public String upload(InputStream pdfStream) throws IOException {
        //TODO テストサンプルなので階層、ファイル名は決め打ちにしている　ここは作成ユーザによって確かフォルダとかをわけるはず
        String awsFilePath = AWS_S3_DOC_PRINTER_PATH + "/kanribu/test.pdf";

        WritableResource resource = (WritableResource) resourceLoader
                .getResource(awsFilePath);

        try (OutputStream outputStream = resource.getOutputStream()) {
            IOUtils.copy(pdfStream, outputStream);
        }
        return resource.getFilename();
    }
}
