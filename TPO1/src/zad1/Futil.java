package zad1;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;

public class Futil {

	public static void processDir(String dirName, String resultFileName) {
		Charset charsetIn = Charset.forName("Cp1250");
		Charset charsetOut = Charset.forName("UTF-8");
		Path start = Paths.get(dirName);

		Path newFile = Paths.get(resultFileName);

		File resultFile = new File(resultFileName);
		if (resultFile.exists()) {
			resultFile.delete();
		}
		try {
			resultFile.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try {
			Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
				@Override
				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
					FileChannel fcin = FileChannel.open(file, StandardOpenOption.READ);
					ByteBuffer bb = ByteBuffer.allocate((int) fcin.size());
					fcin.read(bb);

					fcin.close();

					bb.flip();
					CharBuffer cpBuf = charsetIn.decode(bb);

					bb = charsetOut.encode(cpBuf);
					FileChannel fcout = FileChannel.open(newFile, StandardOpenOption.APPEND);
					fcout.write(bb);

					fcout.close();

					return FileVisitResult.CONTINUE;
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}