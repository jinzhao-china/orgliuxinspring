package org.liuxin.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by zjin010 on 6/18/18.
 */
public interface Resource {
    public InputStream getInputStream() throws IOException;
    public String getDescription();
}
