package com.jnl.boot.utils;

import com.jnl.boot.web.build.entity.Table;
import com.jnl.boot.web.build.tools.CodeBuilder;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.*;

public class FreemakerUtils {

    private static Configuration freemaker = new Configuration();
    static {
        String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        /* freemaker.setDirectoryForTemplateLoading(new File(path+"/com/jnl/boot/template"));*/
        freemaker.setClassForTemplateLoading(FreemakerUtils.class, "/com/jnl/boot/template");
        freemaker.setDefaultEncoding("UTF-8");
        freemaker.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
    }


    public static void createFile(Table table,FtlType ftlType) throws IOException, TemplateException {
        Template temp = freemaker.getTemplate(ftlType.getTemplateName());
        String path = CodeBuilder.getContextPath(table);
        path +="/"+ftlType.getDir();
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }
        OutputStream fos = new FileOutputStream( new File(path, ftlType.getFileName(table.getName()))); //java文件的生成目录
        Writer out = new OutputStreamWriter(fos);
        temp.process(table,out);

        out.close();
        fos.close();
    }


}
