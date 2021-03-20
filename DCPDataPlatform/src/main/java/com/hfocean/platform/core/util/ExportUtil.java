package com.hfocean.platform.core.util;

import com.jmatio.io.MatFileWriter;
import com.jmatio.types.MLDouble;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;

/**
 * @desc 导出工具类（导出大文件，可以先生成文件，然后再下载、导出文件）
 * @author ws
 * @since 2021/3/20
 */
public class ExportUtil {

    /**
     * 导出临时文件，并删除临时文件
     * @param file
     * @param exportFileName 导出文件名
     * @param res
     * @param deleteOrNot  true 导出后删除源文件， false 继续保留
     * @throws Exception
     */
    public static void exportFile(File file, String exportFileName, boolean deleteOrNot, HttpServletResponse res) throws Exception {
        res.setContentType("application/octet-stream; charset=utf-8");
        res.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(exportFileName, "utf-8"));
        try {
            try (BufferedInputStream br = new BufferedInputStream(new FileInputStream(file.getAbsolutePath())); BufferedOutputStream out = new BufferedOutputStream(res.getOutputStream())) {
                int len = 0;
                byte[] buffer = new byte[1024 * 10];
                while ((len = br.read(buffer)) != -1) {
                    out.write(buffer, 0, len);
                }
            } catch (IOException e) {
                System.err.println("文件写出导出异常" + e);
                throw new Exception("导出文件异常" + e.getMessage());
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception("导出文件异常" + e.getMessage());
        } finally {
            if (deleteOrNot) {
                if (file.exists() && file.isFile()) {
                    // 删除临时文件
                    file.delete();
                }
            }
        }
    }

    /**
     * 导出TXT文件
     * 导出大文件，可以先生成文件，然后再下载、导出文件
     * @param res
     */
    public static void exportTxt(HttpServletResponse res) throws Exception {
        File file = writeToTxt();
        String exportFileName = "test.txt";
        ExportUtil.exportFile(file, exportFileName,false, res);
    }

    /**
     * @return
     * @throws IOException
     */
    public static File writeToTxt() throws IOException {
        // 创建临时文件
        File file = File.createTempFile("tmp", ".txt", new File("F:\\Temp"));
        // 输出绝对路径
        System.out.println("File path: "+ file.getAbsolutePath());
        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file))) {
            String tab = "  ";
            String enter = "\r\n";
            StringBuffer sb0 = new StringBuffer();
            sb0.append("列1");
            sb0.append(tab);
            sb0.append("列2");
            sb0.append(enter);
            out.write(sb0.toString().getBytes("UTF-8"));
            for (int i = 0; i < 10000; i++) {
                StringBuffer sb = new StringBuffer();
                sb.append(i);
                sb.append(tab);
                sb.append(i);
                sb.append(enter);
                out.write(sb.toString().getBytes("UTF-8"));
            }
        }
        return file;
    }

    /**
     * 导出MAT文件
     * 导出大文件，可以先生成文件，然后再下载、导出文件
     * @param res
     */
    public static void exportMat(HttpServletResponse res) throws Exception {
        File file = writeToMat();
        String exportFileName = "test.mat";
        ExportUtil.exportFile(file, exportFileName, true, res);
    }

    /**
     * @return
     * @throws IOException
     */
    public static File writeToMat() throws IOException {
        //1. First create example arrays
        double[][] xsrc = new double[1][100] ;
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 100; j++) {
                xsrc[i][j] = i + j;
            }
        }
        double[][] ysrc = new double[1][100] ;
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 100; j++) {
                ysrc[i][j] = 2* i + 2*j;
            }
        }
        MLDouble y = new MLDouble( "YY", ysrc);
        MLDouble x = new MLDouble( "XX", xsrc);
        //2. write arrays to file
        ArrayList list = new ArrayList();
        list.add( x );
        list.add( y );
        MatFileWriter matFileWriter = new MatFileWriter();
        // 创建临时文件
        File file = File.createTempFile("tmp", ".mat", new File("F:\\Temp"));
        // 输出绝对路径
        System.out.println("File path: "+ file.getAbsolutePath());
        matFileWriter.write(file, list);
        return file;
    }
}
