package eighteen;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.security.spec.DSAGenParameterSpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import eighteen.Directory.FileInfo;


final class Directory {
	public static File[] local(File dir, final String regex) {
		return dir.listFiles(new FilenameFilter() {
			private Pattern pattern = Pattern.compile(regex);
			@Override
			public boolean accept(File dir, String name) {
				return pattern.matcher(new File(name).getName()).matches();
			}
		});
	}
	
	public static File[] local(String path, final String regex) {
		return local(new File(path), regex);
	}
	
	public static class FileInfo implements Iterable<File> {
		public List<File> files = new ArrayList<>();
		public List<File> dirs = new ArrayList<>();
		
		@Override
		public Iterator<File> iterator() {
			return files.iterator();
		}
		
		public void addAll(FileInfo info) {
			files.addAll(info.files);
			dirs.addAll(info.dirs);
		}
		
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Dirs: [");
			for (File file : dirs)
				builder.append(file.getAbsolutePath()+ " ");
			builder.append("]\nFiles: [");
			for (File file : files)
				builder.append(file.getAbsolutePath() + " ");
			builder.append("]");
			return builder.toString();	
		}
		
		public static FileInfo walk(File start, String regex) {
			return recurseDirs(start, regex);
		}
		
		public static FileInfo walk(String start, String regex) {
			return recurseDirs(new File(start), regex);
		}
		
		public static FileInfo walk(File start) {
			return recurseDirs(start, ".*");
		}

		public static FileInfo walk(String start) {
			return recurseDirs(new File(start), ".*");
		}
		
		/**
		 * 
		 * @param dir 开始目录
		 * @param regex 过滤文件的正则表达式
		 * @return FileInfo对象，包含所有的子目录和过滤文件
		 */
		static FileInfo recurseDirs(File dir, String regex) {
			FileInfo result = new FileInfo();
			for (File file : dir.listFiles())
				if (file.isDirectory()) {
					result.dirs.add(file);
					result.addAll(recurseDirs(file, regex));
				}
				else
					if (file.getName().matches(regex))
						result.files.add(file);
			return result;
		}
		
	}
}

class ProcessFiles {
	public interface Strategy {
		void process(File file);
	}
	private Strategy strategy;
	private String ext;
	public ProcessFiles(Strategy strategy, String ext) {
		this.strategy = strategy;
		this.ext = ext;
	}
	
	public void processDirectory(File root) throws IOException {
		for (File file : FileInfo.walk(root.getAbsolutePath(), ".*\\." + ext))
			strategy.process(file.getCanonicalFile());
	}
	
	public void start(String[] args) {
		try {
			if (args.length == 0)
				processDirectory(new File(""));
			else {
				for (String arg : args) {
					File file = new File(arg);
					if (file.isDirectory())
						processDirectory(file);
					else {
						if (!arg.endsWith("." + ext))
							arg += "." + ext;
						strategy.process(new File(arg).getCanonicalFile());
					}
				}
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

public class TestFile {
	public static void listFiles(String regex) {
		String separator = File.separator;
		File path = new File("c:" + separator + "users" + separator + "jiahaoyang" + 
					separator + "desktop" + separator + "java" + separator + "thinkinginjava" 
					+ separator + "src" + separator + "twelve");
		
		String[] lists = path.list(new FilenameFilter() {
			private Pattern pattern = Pattern.compile(regex);
			
			@Override
			public boolean accept(File dir, String name) {
				return pattern.matcher(name).matches();
			}
		});
		Arrays.sort(lists, String.CASE_INSENSITIVE_ORDER);
		for (String list : lists)
			System.out.println(list);
	}
	
	public static void testFile() throws IOException {
		File file = new File("a/a.txt");
		if (!file.exists())
			file.createNewFile();
		System.out.println(file.getParentFile());
		System.out.println(file.canWrite());
		System.out.println(file.getAbsolutePath());
	}
	
	public static void main(String[] args) throws IOException {
//		listFiles(".*\\.java");
//		File file = new File("src/eight");
//		System.out.println(file.getAbsolutePath());
//		System.out.println(FileInfo.walk("src", "S.*\\.java"));
//		for (File file : Directory.local("src/eight", "S.*\\.java"))
//			System.out.println(file.getAbsolutePath());
//		new ProcessFiles(new ProcessFiles.Strategy() {
//			
//			@Override
//			public void process(File file) {
//				System.out.println(file);
//			}
//		}, "java").start(new String[] {});
//		File file = new File("src");
//		System.out.println(file.getAbsolutePath());
		testFile();
	}
}
