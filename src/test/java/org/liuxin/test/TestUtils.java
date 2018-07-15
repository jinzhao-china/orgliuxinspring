package org.liuxin.test;

import java.io.File;

/**
 * Created by zjin010 on 6/18/18.
 */
public class TestUtils {
    static public String getPath() {

        File file = new File("");
        return file.getAbsolutePath();
    }
}
