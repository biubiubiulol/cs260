package project2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Processor extends Thread
	{
		private String path;
		private String size;

		public Processor(String path, String size)
			{
				this.path = path;
				this.size = size + ".txt";
			}

		public void run()
			{
				try
					{
						mergeFile(path);
					} catch (IOException e)
					{
						e.printStackTrace();
					}
				System.out.println(Thread.currentThread().getName());

			}

		public void mergeFile(String path) throws IOException
			{
				File input = new File(path);
				BufferedReader reader = new BufferedReader(new FileReader(input));
				File output = new File("/home/kai/workspace/cs260workspace/test_file/" + size);
				BufferedWriter writer = new BufferedWriter(new FileWriter(output, true));
				char tmp;
				for (long count = 0; count < input.length(); count++)
					{
						tmp =(char) reader.read();
						writer.append(tmp);
					}
				writer.close();
				System.out.println("done");
				reader.close();
			}
	}
