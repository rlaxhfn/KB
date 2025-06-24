package org.scoula.util;

public class UploadFileName {
    public static String getFileName(String fileName) {
        int index = fileName.lastIndexOf(".");
        String name = fileName.substring(0, index);
        String ext = fileName.substring(index + 1);
        return String.format("%s-%d.%s", name, System.currentTimeMillis(), ext);
    }
}
