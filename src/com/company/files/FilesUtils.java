package com.company.files;

import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.net.PortUnreachableException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;

public class FilesUtils {
    private File mainFile;

    public FilesUtils(String path){
        setPath(path);
    }

    public void setPath(String path){
        if(path == null || path.equals("")){
            mainFile = new File("C:/");
        }else {
            mainFile = new File(path);
        }
    }

    public String getPath(){
        return mainFile.getPath();
    }

    public void getSubDir() {

        if (mainFile.isDirectory()) {
            System.out.println("Directory");
            System.out.println("with lambda");
            File[] files = mainFile.listFiles((File f) -> f.isDirectory() && !f.isHidden());

            for(File f : files){
                System.out.println(f);
            }

            System.out.println("with inner class");
            files = mainFile.listFiles(new FileFilter() {
                @Override
                public boolean accept(File f) {
                    return f.isDirectory() && !f.isHidden() ? true : false;
                }
            });

            for(File f : files){
                System.out.println(f);
            }
        }else {
            System.out.println("Path is'n a directory");
        }
    }

    public File[] getFiles(String extention){
        //File file = new File(path);
        if (mainFile.isDirectory()) {
            File[] files = mainFile.listFiles((File f)->{
                if(f.isFile()){
                    String ext = f.getName().substring(f.getName().lastIndexOf(".")+1);
                    if(extention.equals(ext)) {
                        return true;
                    }else {
                        return false;
                    }
                }else {
                    return false;
                }

            });

            for(File f : files ){
                System.out.println(f);
            }
        }else {
            System.out.println("Path is'n a directory");
        }

        return null;
    }

    public File[] getFileAndDir(){
        if (mainFile.isDirectory()) {
            return mainFile.listFiles();
        }else {
            System.out.println("Path is'n a directory");
        }

        return null;
    }

    public File[] sortFile(File[] files){

        Comparator<File> comparator = (File f1, File f2)-> {
            if (f1.isFile() && f2.isFile() || f1.isDirectory() && f2.isDirectory()) {
                String str1 = f1.getPath();
                String str2 = f2.getPath();
                return Integer.compare(str1.length(),str2.length());
            } else {
                if (f1.isFile()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        };

        Arrays.sort(files,comparator);
        return files;
    }
}
