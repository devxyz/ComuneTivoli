package comune.tivoli.rm.it.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by stefano on 25/07/16.
 */
public class Zipper {
    FileOutputStream fos;
    ZipOutputStream zos;
    long size = 0;
    int index = 0;

    public static void main(String[] args) throws IOException {
        Zipper z = new Zipper();
        z.pack(new File("/Users/stefano/Downloads/moodle").toPath(),
                new File("/Users/stefano/Downloads/zip/moodle_zip.zip").toPath(),
                30000000);
    }

    public void pack(final Path folder, final Path zipFilePath, final long maxSize) throws IOException {
        size = 0;
        index = 0;
        final File file = new File(zipFilePath.toFile() + "-" + index + ".zip");
        System.out.println(file);
        fos = new FileOutputStream(file);
        zos = new ZipOutputStream(fos);

        Files.walkFileTree(folder, new SimpleFileVisitor<Path>() {
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (size > maxSize) {
                    zos.close();
                    index++;
                    final File file1 = new File(zipFilePath.toFile() + "-" + index + ".zip");
                    System.out.println(file1);
                    fos = new FileOutputStream(file1);
                    zos = new ZipOutputStream(fos);
                    size = 0;

                }

                final String name = folder.relativize(file).toString();
                //System.out.println(name);
                zos.putNextEntry(new ZipEntry(name));
                Files.copy(file, zos);
                zos.closeEntry();
                size += file.toFile().length();
                return FileVisitResult.CONTINUE;
            }

            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                zos.putNextEntry(new ZipEntry(folder.relativize(dir).toString() + "/"));
                zos.closeEntry();
                return FileVisitResult.CONTINUE;
            }
        });

        zos.close();
    }
}
