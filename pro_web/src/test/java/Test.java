import java.math.BigDecimal;

public class Test {
	public static void main(String[] args) {
	/*	String path = "C:\\Users\\lijianan\\Desktop\\jdk-8u131-windows-x64.exe";
		long start,end;
	*//*	 start = System.currentTimeMillis();
			test(path);
		 end = System.currentTimeMillis();
		System.out.println("test运行时间"+(end-start));*//*
		start = System.currentTimeMillis();
		test2(path);
		end = System.currentTimeMillis();
		System.out.println("test1运行时间"+(end-start));*/

		//new BigDecimal("12");
		String a = "hello2";
		final String b = "hello";
		String d = "hello";
		String c = b + 2;
		String e = d + 2;
		System.out.println((a == c));
		System.out.println((a == e));
	}

/*
	public static void test2(String path) throws IOException {
		InputStream in = new FileInputStream(path);
		File file = new File("C:\\Users\\lijianan\\Desktop\\test2.exe");
		if(file.exists()){
			file.delete();
		}
		file.createNewFile();
		OutputStream out = new FileOutputStream(file);
		byte[] b = new byte[1024*num];
		int len;
		while((len =in.read(b))!=-1){
			out.write(b,0,len);
		}
		out.close();
		in.close();
	}
	public static void test1(String path) throws IOException {
		RandomAccessFile file = new RandomAccessFile(path,"rw");
		File file1 = new File("C:\\Users\\lijianan\\Desktop\\test1.exe");
		if(file1.exists()){
			file1.delete();
		}
		file1.createNewFile();
		FileChannel channel = file.getChannel();
		ByteBuffer bffer = ByteBuffer.allocateDirect(1024*num);
		FileOutputStream out = new FileOutputStream(file1);
		FileChannel channel1 = out.getChannel();
		int len;
		while((len = channel.read(bffer))!=-1){
			bffer.flip();
			channel1.write(bffer);
			bffer.clear();
		}
		channel.close();
		channel1.close();
		out.close();
	}
	public static void test(String path) throws IOException {
		RandomAccessFile file = new RandomAccessFile(path,"rw");
		File file1 = new File("C:\\Users\\lijianan\\Desktop\\test.exe");
		if(file1.exists()){
			file1.delete();
		}
		file1.createNewFile();
		FileChannel channel = file.getChannel();
		ByteBuffer bffer = ByteBuffer.allocate(1024*num);
		FileOutputStream out = new FileOutputStream(file1);
		FileChannel channel1 = out.getChannel();
		int len;
		while((len = channel.read(bffer))!=-1){
			bffer.flip();
			channel1.write(bffer);
			bffer.clear();
		}
		channel.close();
		channel1.close();
		out.close();
	}*/
}
