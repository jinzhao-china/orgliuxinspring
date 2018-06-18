package org.liuxin.core.io;

import org.liuxin.util.ClassUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by zjin010 on 6/18/18.
 */
public class FileSystemResource implements Resource {
    private String path;
    private File file;

    public FileSystemResource(String path) {
        this.path = path;
        this.file = new File(path);
    }

    public InputStream getInputStream() throws IOException{
        return new FileInputStream(this.file);
    }

    public String getDescription() {
        return "file [" + this.file.getAbsolutePath() + "]";
    }
}
