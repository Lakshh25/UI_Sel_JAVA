package genericLib;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile {
	

	public String GetProperty(String key) throws IOException {
		FileReader reader = new FileReader(AutoConstant.Property_file_path);
		Properties prop = new Properties();
		prop.load(reader);
		return prop.getProperty(key);

}}
