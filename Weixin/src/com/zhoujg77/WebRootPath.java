package com.zhoujg77;

import java.io.File;
import java.net.URL;

public class WebRootPath {
	
	public static String getWebRootPath() throws ClassNotFoundException{
		String webInfoPath = null;
		 WebRootPath w = new WebRootPath();
		 Class a =  w.getClass();
		    URL url =  a.getResource("/");
		    String s = url.getPath();
		 File f = new File(url.getPath());
		webInfoPath = f.getParent();
		 return webInfoPath;
	}
}
