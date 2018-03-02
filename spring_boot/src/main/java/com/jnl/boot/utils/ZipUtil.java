package com.jnl.boot.utils;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipUtil {

    public static void zip(String souceFileName, String destFileName) throws IOException {
        File file = new File(souceFileName);
        zip(file, destFileName);
    }

    public static void zip(File souceFile, String destFileName) throws IOException {
        FileOutputStream fileOut = null;
        fileOut = new FileOutputStream(destFileName);
        ZipOutputStream out = new ZipOutputStream(fileOut);
        zip(souceFile, out, "");
        out.close();
    }

    public static void zip(File souceFile, ZipOutputStream out, String base)
            throws IOException {

        if (souceFile.isDirectory()) {
            File[] files = souceFile.listFiles();
            out.putNextEntry(new ZipEntry(base + "/"));
            base = base.length() == 0 ? "" : base + "/";
            for (File file : files) {
                zip(file, out, base + file.getName());
            }
        } else {
            if (base.length() > 0) {
                out.putNextEntry(new ZipEntry(base));
            } else {
                out.putNextEntry(new ZipEntry(souceFile.getName()));
            }
            System.out.println("filepath=" + souceFile.getPath());
            FileInputStream in = new FileInputStream(souceFile);

            int b;
            byte[] by = new byte[1024];
            while ((b = in.read(by)) != -1) {
                out.write(by, 0, b);
            }
            in.close();
        }
    }
}
