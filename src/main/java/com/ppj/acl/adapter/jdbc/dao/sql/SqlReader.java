package com.ppj.acl.adapter.jdbc.dao.sql;

import com.ppj.acl.adapter.jdbc.exception.SqlReaderException;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

@UtilityClass
@Slf4j
public class SqlReader {
    public String read(final String path) {
        ResourceLoader loader = new DefaultResourceLoader();
        Resource resource = loader.getResource(path);
        StringBuilder builder = new StringBuilder();
        try {
            Reader reader = new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8);
            return builder.append(FileCopyUtils.copyToString(reader)).toString().replace("\n", " ");
        } catch (IOException e) {
            log.error("No se puede leer el archivo sql ", e);
            throw new SqlReaderException(e);
        }
    }
}
