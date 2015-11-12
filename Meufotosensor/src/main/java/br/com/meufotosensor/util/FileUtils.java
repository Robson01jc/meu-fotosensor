package br.com.meufotosensor.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtils {
	
	public static final int BSIZE = 8*1024;
	
	
	public static void bcopy (InputStream src, File dst, String wt) throws FileNotFoundException, IOException {
		bcopy (src, new FileOutputStream(dst), "copyStreamToFile:"+wt);
	}
	
	
	
	public static void bcopy (InputStream src, OutputStream dst, String wt) throws IOException {

		BufferedInputStream  bis = new BufferedInputStream(src);
		BufferedOutputStream bos = getBos (dst);

		try {
			cpio (bis, bos, wt);
			bos.flush();
		} catch (IOException e) {
			throw new RuntimeException("I/O error in cpio "+wt);
		} finally {
			bos.close();
			dst.close();
			bis.close(); // no effect
			src.close(); // no effect
		}
	}
	
	public static BufferedOutputStream getBos (OutputStream os) {
		return new BufferedOutputStream (os, BSIZE);
	}
	
public static long cpio (InputStream in, OutputStream out, String wt) throws IOException {
		
		byte[] buffer = new byte[BSIZE];

		int c;
		long tot = 0;
		/*long s = System.nanoTime();*/
		while ((c = in.read(buffer, 0, buffer.length)) != -1) {
    		out.write(buffer, 0, c);
    		tot += c;
		}
		
		/*long tim = System.nanoTime() - s;
		double dtim = tim == 0 ? 0.5 : tim; // avg of those less than 1 nanoseconds is taken as 0.5 nanoseconds
		double bps = tot*1000*1000/dtim;
		log.debug(String.format("cpio %,13d bytes %6.2f ms avg %6.1f Mbps %s%n", tot, dtim/1000/1000, bps/1024, wt));*/
		return tot;
	}
}
