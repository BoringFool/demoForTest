package io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 */
public class FileIO {
    //文件路径
    public static final String PATH = "C:" + File.separator + "Users" + File.separator + "13185" + File.separator + "Desktop" + File.separator + "本机" + File.separator + "IOStore" + File.separator + "写入.txt";
    public static final String PATH_COPY = "C:" + File.separator + "Users" + File.separator + "13185" + File.separator + "Desktop" + File.separator + "本机" + File.separator + "IOStore" + File.separator + "写入复制.txt";
    public static final String PATH_COPY_TWO = "C:" + File.separator + "Users" + File.separator + "13185" + File.separator + "Desktop" + File.separator + "本机" + File.separator + "IOStore" + File.separator + "写入复制2.txt";
    public static final String PATH_COPY_OBJECT = "C:" + File.separator + "Users" + File.separator + "13185" + File.separator + "Desktop" + File.separator + "本机" + File.separator + "IOStore" + File.separator + "类序列化";
    public static final String PATH_DELETE = "C:" + File.separator + "Users" + File.separator + "13185" + File.separator + "Desktop" + File.separator + "本机" + File.separator + "IOStore写入.txt";

    private final File byteFile = new File(PATH);
    private final File byteFileCopy = new File(PATH_COPY);
    private final File byteFileCopyTwo = new File(PATH_COPY_TWO);

    private AtomicInteger ai = new AtomicInteger(0);

    /**
     * 常规文件操作
     */
    public void normal() {
        if (!byteFile.exists()) {
            try {
                boolean result = byteFile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


        try (OutputStream os = Files.newOutputStream(byteFile.toPath(), StandardOpenOption.APPEND)) {
            String word = "常规测试写入";
            os.write("\r\n".getBytes());
            os.write(word.getBytes());
            os.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 删除文件
     */
    public void delete() {
        File delete = new File(PATH_DELETE);
        if (delete.exists()) {
            boolean result = delete.delete();
            System.out.println(result ? "删除成功" : "删除失败");
        }
    }

    /**
     * 字符操作
     */
    public void bufferedCharacterOperation() {

        String s;
        try (BufferedReader br = Files.newBufferedReader(byteFile.toPath());
             BufferedWriter bw = Files.newBufferedWriter(byteFileCopy.toPath(), StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
            while ((s = br.readLine()) != null) {
                System.out.println(s);
                bw.write(s);
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *  channel操作
     */
    public void channelOperate() {
        ByteBuffer bb = ByteBuffer.allocate(8 * 1024);

        try {
            FileInputStream fileInputStream = new FileInputStream(byteFile);
            FileOutputStream fileOutputStream = new FileOutputStream(byteFileCopyTwo);

            FileChannel in = fileInputStream.getChannel();
            FileChannel out = fileOutputStream.getChannel();

            while (in.read(bb) != -1) {
                bb.flip();
                out.write(bb);
                bb.clear();
            }

            in.close();
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 类序列化操作
     */
    void serializableOprate() {
        FileDatas fileDatas = new FileDatas();
        ArrayList<FileData> arr = new ArrayList<>();

        FileData fd = new FileData();
        fd.setName("test");
        fd.setNum(1);

        arr.add(fd);
        fileDatas.setFiles(arr);

        try {
            final Path path = Paths.get(PATH_COPY_OBJECT);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(Files.newOutputStream(path, StandardOpenOption.CREATE, StandardOpenOption.WRITE));
            objectOutputStream.writeObject(fileDatas);

            ObjectInputStream objectInputStream = new ObjectInputStream(Files.newInputStream(path, StandardOpenOption.READ));
            FileDatas newFile = (FileDatas) objectInputStream.readObject();
            newFile.getFiles();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
