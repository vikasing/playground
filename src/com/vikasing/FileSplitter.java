/**
 * 
 */
package com.vikasing;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author vksing3
 *
 */
public class FileSplitter {

	    public static void splitFile(File f) throws IOException {
	        BufferedInputStream bis = new BufferedInputStream(
	                new FileInputStream(f));
	        FileOutputStream out;
	        String name = f.getName();
	        int partCounter = 1;
	        int sizeOfFiles = 1024 * 10240;// 1MB
	        byte[] buffer = new byte[sizeOfFiles];
	        int tmp = 0;
	        while ((tmp = bis.read(buffer)) > 0) {
	            File newFile=new File(name+"."+String.format("%03d", partCounter++));
	            newFile.createNewFile();
	            out = new FileOutputStream(newFile);
	            out.write(buffer,0,tmp);
	            out.close();
	        }
	    }

	    public static void main(String[] args) throws IOException {
	        //splitFile(new File("tcatint82"));
	    	
	    	List<String> li = new ArrayList<String>(){{add("asdfa");add("bbb");add("a");}};
	    	for (int i = 0; i < li.size(); i++) {
	    		System.out.println(li.get(i));
	    		if (li.get(i).equals("asdfa")) {
					li.add("asdasd");
				}
			}
	    	/*ListIterator<String> lii = li.listIterator();
	    	while (lii.hasNext()) {
				System.out.println(lii.next());
				
				li.add("asdasd");
			}
	    	for (String s : li) {
				System.out.println(s);
				li.add("asdasd");
			}*/
	    }
}
