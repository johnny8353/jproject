package com.johnny.springmvc.fileupload.handlers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.johnny.springmvc.crud.dao.EmployeeDao;

@RequestMapping("test")
@Controller("fileSpringMVCTest")
public class SpringMVCTest {
	@RequestMapping("/fileList")
	public String getFile(Map<String, Object> map,HttpServletRequest request)
			throws IOException {
		 //获取上传文件的目录
		//ServletRequest的getServletContext方法是Servlet3.0添加的
        String uploadFilePath = request.getServletContext().getRealPath("/WEB-INF/upload");
        //存储要下载的文件名
        Map<String,String> fileNameMap = new HashMap<String,String>();
        //递归遍历filepath目录下的所有文件和目录，将文件的文件名存储到map集合中
        listfile(new File(uploadFilePath),fileNameMap);//File既可以代表一个文件也可以代表一个目录
        //将Map集合发送到listfile.jsp页面进行显示
        map.put("fileNameMap", fileNameMap);
		return "file";
	}
	@RequestMapping("/testFileDown")
	public String testFileDown(@RequestParam("filename") String filename,HttpServletRequest request, HttpServletResponse response,
			OutputStream out)
			throws IOException {
		try {
			filedown(filename,request,response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "file";
	}
	  /**
	    * @Method: findFileSavePathByFileName
	    * @Description: 通过文件名和存储上传文件根目录找出要下载的文件的所在路径
	    * @Anthor:johnny
	    * @param filename 要下载的文件名
	    * @param saveRootPath 上传文件保存的根目录，也就是/WEB-INF/upload目录
	    * @return 要下载的文件的存储目录
	    */ 
	    public String findFileSavePathByFileName(String filename,String saveRootPath){
	        int hashcode = filename.hashCode();
	        int dir1 = hashcode&0xf;  //0--15
	        int dir2 = (hashcode&0xf0)>>4;  //0-15
	        String dir = saveRootPath + "\\" + dir1 + "\\" + dir2;  //upload\2\3  upload\3\5
	        System.out.println(filename+"_存储目录："+dir+";hashcode"+hashcode);
	        File file = new File(dir);
	        if(!file.exists()){
	            //创建目录
	            file.mkdirs();
	        }
	        return dir;
	    }
	public void filedown(String fileName,HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //得到要下载的文件名
//        String fileName = request.getParameter("filename");  //23239283-92489-阿凡达.avi
//        fileName = new String(fileName.getBytes("iso8859-1"),"UTF-8");
        //上传的文件都是保存在/WEB-INF/upload目录下的子目录当中
        String fileSaveRootPath=request.getServletContext().getRealPath("/WEB-INF/upload");
        //通过文件名找出文件的所在目录
        String path = findFileSavePathByFileName(fileName,fileSaveRootPath);
        //得到要下载的文件
        File file = new File(path + "\\" + fileName);
        //如果文件不存在
        if(!file.exists()){
            request.setAttribute("message", "您要下载的资源已被删除！！");
            request.getRequestDispatcher("/fileupload/message.jsp").forward(request, response);
            return;
        }
        //处理文件名
        String realname = fileName.substring(fileName.indexOf("_")+1);
        response.setContentType("application/x-msdownload"); 
        //设置响应头，控制浏览器下载该文件
        String agent = request.getHeader("USER-AGENT");  
        String downLoadName = null;
        if (null != agent && -1 != agent.indexOf("Mozilla")) //Firefox 乱码处理
        {      
        	downLoadName = new String(realname.getBytes("UTF-8"),"iso-8859-1");   
        }  
        else//其他浏览器如IE
        {
        	downLoadName = java.net.URLEncoder.encode(realname, "UTF-8"); 
        }  
        response.setHeader("content-disposition", "attachment;filename=" + downLoadName);
        //读取要下载的文件，保存到文件输入流
        FileInputStream in = new FileInputStream(path + "\\" + fileName);
        //创建输出流
        OutputStream out = response.getOutputStream();
        //getOutputStream() has already been called for this response
        //创建缓冲区
        byte buffer[] = new byte[1024];
        int len = 0;
        //循环将输入流中的内容读取到缓冲区当中
        while((len=in.read(buffer))>0){
            //输出缓冲区的内容到浏览器，实现文件下载
            out.write(buffer, 0, len);
        }
        //关闭文件输入流
        in.close();
        //关闭输出流
        out.close();
  
    }
	
	/**
	    * @Method: listfile
	    * @Description: 递归遍历指定目录下的所有文件
	    * @Anthor:johnny
	    * @param file 即代表一个文件，也代表一个文件目录
	    * @param map 存储文件名的Map集合
	    */ 
	    public void listfile(File file,Map<String,String> map){
	        //如果file代表的不是一个文件，而是一个目录
	        if(!file.isFile()){
	            //列出该目录下的所有文件和目录
	            File files[] = file.listFiles();
	            //遍历files[]数组
	            for(File f : files){
	                //递归
	                listfile(f,map);
	            }
	        }else{
	            /**
	             * 处理文件名，上传后的文件是以uuid_文件名的形式去重新命名的，去除文件名的uuid_部分
	                file.getName().indexOf("_")检索字符串中第一次出现"_"字符的位置，如果文件名类似于：9349249849-88343-8344_阿_凡_达.avi
	                那么file.getName().substring(file.getName().indexOf("_")+1)处理之后就可以得到阿_凡_达.avi部分
	             */
	            String realName = file.getName().substring(file.getName().indexOf("_")+1);
	            //file.getName()得到的是文件的原始名称，这个名称是唯一的，因此可以作为key，realName是处理过后的名称，有可能会重复
	            map.put(file.getName(), realName);
	        }
	    }
	    
	    
	@RequestMapping("/testFileUpload")
	public String testFileUpload(@RequestParam("desc") String desc,
			@RequestParam("file") MultipartFile file,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		System.out.println(request.getParameter("desc"));
		System.out.println("desc: " + desc);
		System.out.println("OriginalFilename: " + file.getOriginalFilename());
		System.out.println("InputStream: " + file.getInputStream());

		try {
			upload(request, response, file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}

	public void upload(HttpServletRequest request,
			HttpServletResponse response, MultipartFile file) throws Exception {
		// 得到上传文件的保存目录，将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
		String savePath = request.getServletContext().getRealPath(
				"/WEB-INF/upload");
		// 上传时生成的临时文件保存目录
		String tempPath = request.getServletContext().getRealPath(
				"/WEB-INF/temp");
		File tmpFile = new File(tempPath);
		if (!tmpFile.exists()) {
			// 创建临时目录
			tmpFile.mkdir();
		}

		// 消息提示
		String message = "";
		try {
			// 使用Apache文件上传组件处理文件上传步骤：
			// 1、创建一个DiskFileItemFactory工厂
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 设置工厂的缓冲区的大小，当上传的文件大小超过缓冲区的大小时，就会生成一个临时文件存放到指定的临时目录当中。
			factory.setSizeThreshold(1024 * 100);// 设置缓冲区的大小为100KB，如果不指定，那么缓冲区的大小默认是10KB
			// 设置上传时生成的临时文件的保存目录
			factory.setRepository(tmpFile);
			// 2、创建一个文件上传解析器
			ServletFileUpload upload = new ServletFileUpload(factory);
			// 监听文件上传进度  
			upload.setProgressListener(new ProgressListener() {
				public void update(long pBytesRead, long pContentLength,
						int arg2) {
					System.out.println("文件大小为：" + pContentLength + ",当前已处理："
							+ pBytesRead);
					/**
					 * 文件大小为：14608,当前已处理：4096 文件大小为：14608,当前已处理：7367
					 * 文件大小为：14608,当前已处理：11419 文件大小为：14608,当前已处理：14608
					 */
				}
			});
			// 解决上传文件名的中文乱码
			upload.setHeaderEncoding("UTF-8");
			// 3、判断提交上来的数据是否是上传表单的数据
			if (!ServletFileUpload.isMultipartContent(request)) {
				// 按照传统方式获取数据
				return;
			}

			// 设置上传单个文件的大小的最大值，目前是设置为1024*1024字节，也就是1MB
			upload.setFileSizeMax(1024 * 1024*20);
			// 设置上传文件总量的最大值，最大值=同时上传的多个文件的大小的最大值的和，目前设置为10MB
			upload.setSizeMax(1024 * 1024 * 200);
			// 4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
			@SuppressWarnings("unchecked")
			//这里springMVC 都为我们封装好成自己的文件对象了,转换的过程就在我们所配置的CommonsMultipartResolver这个转换器里面下面再来看看它的源码
			//他的转换器里面就是调用common-fileupload的方式解析,然后再使用parseFileItems()方法封装成自己的文件对象 . 
			//在Controller里面接收到的request都已经是解析过的,你再次使用upload进行解析获取到的肯定是空
			List<FileItem> list = upload.parseRequest(request);
			// 如果fileitem中封装的是上传文件
			// 得到上传的文件名称，
			String filename = file.getOriginalFilename();
			System.out.println(filename);
			if (filename == null || filename.trim().equals("")) {
				return ;
			}
			// 注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：
			// c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
			// 处理获取到的上传文件的文件名的路径部分，只保留文件名部分
			filename = filename.substring(filename.lastIndexOf("\\") + 1);
			// 得到上传文件的扩展名
			String fileExtName = filename
					.substring(filename.lastIndexOf(".") + 1);
			// 如果需要限制上传的文件类型，那么可以通过文件的扩展名来判断上传的文件类型是否合法
			System.out.println("上传的文件的扩展名是：" + fileExtName);
			// 获取item中的上传文件的输入流
			InputStream in = file.getInputStream();
			// 得到文件保存的名称
			String saveFilename = makeFileName(filename);
			// 得到文件的保存目录
			String realSavePath = makePath(saveFilename, savePath);
			// 创建一个文件输出流
			FileOutputStream out = new FileOutputStream(realSavePath + "\\"
					+ saveFilename);
			// 创建一个缓冲区
			byte buffer[] = new byte[1024];
			// 判断输入流中的数据是否已经读完的标识
			int len = 0;
			// 循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
			while ((len = in.read(buffer)) > 0) {
				// 使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\"
				// + filename)当中
				out.write(buffer, 0, len);
			}
			// 关闭输入流
			in.close();
			// 关闭输出流
			out.close();
			// 删除处理文件上传时生成的临时文件
			// item.delete();
			message = "文件上传成功！";

		} catch (FileUploadBase.FileSizeLimitExceededException e) {
			throw e;
			// e.printStackTrace();
			// request.setAttribute("message", "单个文件超出最大值！！！");
			// request.getRequestDispatcher("/fileupload/message.jsp").forward(request,
			// response);
			// return;
		} catch (FileUploadBase.SizeLimitExceededException e) {
			throw e;
			// e.printStackTrace();
			// request.setAttribute("message", "上传文件的总的大小超出限制的最大值！！！");
			// request.getRequestDispatcher("/fileupload/message.jsp").forward(request,
			// response);
			// return;
		} catch (Exception e) {
			throw e;
			// message = "文件上传失败！";
			// e.printStackTrace();
		}
		// request.setAttribute("message", message);
		// request.getRequestDispatcher("/fileupload/message.jsp").forward(request,
		// response);
	}

	/**
	 * @Method: makeFileName
	 * @Description: 生成上传文件的文件名，文件名以：uuid+"_"+文件的原始名称
	 * @Anthor:johnny
	 * @param filename
	 *            文件的原始名称
	 * @return uuid+"_"+文件的原始名称
	 */
	private String makeFileName(String filename) { // 2.jpg
		// 为防止文件覆盖的现象发生，要为上传文件产生一个唯一的文件名
		return UUID.randomUUID().toString() + "_" + filename;
	}

	/**
	 * 为防止一个目录下面出现太多文件，要使用hash算法打散存储
	 * 
	 * @Method: makePath
	 * @Description:
	 * @Anthor:johnny
	 * 
	 * @param filename
	 *            文件名，要根据文件名生成存储目录
	 * @param savePath
	 *            文件存储路径
	 * @return 新的存储目录
	 */
	private String makePath(String filename, String savePath) {
		// 得到文件名的hashCode的值，得到的就是filename这个字符串对象在内存中的地址
		int hashcode = filename.hashCode();
		int dir1 = hashcode & 0xf; // 0--15
		int dir2 = (hashcode & 0xf0) >> 4; // 0-15
		// 构造新的保存目录
		String dir = savePath + "\\" + dir1 + "\\" + dir2; // upload\2\3
															// upload\3\5
		System.out.println(filename + "_makePath存储目录：" + dir + ";hashcode"
				+ hashcode);
		// File既可以代表文件也可以代表目录
		File file = new File(dir);
		// 如果目录不存在
		if (!file.exists()) {
			// 创建目录
			file.mkdirs();
		}
		return dir;
	}

}
