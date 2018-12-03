package io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public final class MyUtil {

    private MyUtil() {
        throw new AssertionError();
    }

    public static void fileCopy(String source, String target) throws IOException {
        try (InputStream in = new FileInputStream(source)) {
            try (OutputStream out = new FileOutputStream(target)) {
                byte[] buffer = new byte[4096];
                int bytesToRead;
                while ((bytesToRead = in.read(buffer)) != 0) {
                    out.write(buffer, 0, bytesToRead);
                }
            }
        }
    }

    /**
     * @param
     * @return
     * @author dalongm
     * @description 使用NIO复制文件
     * @date 2018/10/5 15:42
     **/
    public static void fileCopyNIO(String source, String target) throws IOException {
        try (FileInputStream in = new FileInputStream(source)) {
            try (FileOutputStream out = new FileOutputStream(target)) {
                FileChannel inChannel = in.getChannel();
                FileChannel outChannel = out.getChannel();
                ByteBuffer buffer = ByteBuffer.allocate(4096);
                while (inChannel.read(buffer) != -1) {
                    buffer.flip();
                    outChannel.write(buffer);
                    buffer.clear();
                }
            }
        }
    }

    /**
     * @author dalongm
     * @description 统计关键词在文件里出现的次数
     * @date 2018/10/5 15:59
     * @param 
     * @return 
     **/
    public static int countWordInFile(String filename, String word) throws IOException {
        int counter = 0;
        try (FileReader fr = new FileReader(filename)) {
            try (BufferedReader br = new BufferedReader(fr)) {
                String line = null;
                while ((line = br.readLine()) != null) {
                    int index = -1;
                    while (line.length() >= word.length() && (index = line.indexOf(word)) >= 0) {
                        counter++;
                        line = line.substring(index + word.length());
                    }
                }
            }
        }
        return counter;
    }



    /**
     * @author dalongm
     * @description 列出当前文件夹下的文件名，不包含子文件夹
     * @date 2018/10/5 16:02
     * @param
     * @return
     **/
    public static void listFile(String folder){
        File f = new File(folder);
        for(File temp : f.listFiles()){
            if(temp.isFile()){
                System.out.println(temp.getName());
            }
        }
    }

    public static void showDirectory(File f){
        _walkDirectory(f, 0);
    }

    public static void _walkDirectory(File f, int level){
        if(f.isDirectory()){
            for(int i=0;i<level;i++){
                System.out.print("-");
            }
            System.out.println(f.getName());
            for(File temp : f.listFiles()){
                _walkDirectory(temp, level+1);
            }
        }else{
            for(int i=0;i<level-1;i++){
                System.out.print("\t");
            }
            System.out.println(f.getName());
        }
    }

    public static void listFiles(String folder) throws IOException {
        Path initPath = Paths.get(folder);
        Files.walkFileTree(initPath, new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println(file.getFileName().toString());
                return super.visitFile(file, attrs);
            }
        });

    }


    public static void main(String[] args) throws IOException {
//        long old = System.currentTimeMillis();
//        fileCopyNIO("D:\\迅雷下载\\cn_windows_10_consumer_edition_version_1809_updated_sept_2018_x64_dvd_051b7719.iso", "E:\\123.iso");
//        System.out.println("用时：" + (System.currentTimeMillis() - old));
//        showDirectory(new File("H:/"));
        listFiles("H:/");
    }


}
