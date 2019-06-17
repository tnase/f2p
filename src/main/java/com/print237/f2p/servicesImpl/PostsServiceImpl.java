package com.print237.f2p.servicesImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.FilenameUtils ;

import com.print237.f2p.Repository.FileRepository;
import com.print237.f2p.Repository.PostRepository;
import com.print237.f2p.Repository.UserRepository;
import com.print237.f2p.Utils.Storage;
import com.print237.f2p.entities.Files;
import com.print237.f2p.entities.Posts;
import com.print237.f2p.entities.Users;
import com.print237.f2p.services.PostsService;

@Service
@Transactional

public class PostsServiceImpl implements PostsService{

	@Autowired FileRepository fileRep ;
	@Autowired Storage storage ;
	@Autowired PostRepository postRep ;
	@Autowired UserRepository userRep ;
	@Autowired ServletContext context ;
	
	@Override
	public Posts createPost(Posts post,MultipartFile file) {
		Files initFile=null ;
		if(file!=null) 
		   initFile=readFile(file);
		post.setCreatedAt(new Date());
		post.setUpdatedAt(new Date());
		post.setFile(initFile);
		return postRep.save(post);
	}

	@Override
	public Boolean deletePost(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Files readFile(MultipartFile file) {
		String fileName=file.getOriginalFilename();
		Files f=new Files();
		
		if((fileRep.findByName(fileName)==null) && (storage.store(file))) {
			
	          f.setName(fileName);
	          f.setCreatedAt(new Date());
 	          f.setUpdatedAt(new Date());
	         return fileRep.save(f);
		}
	     System.out.println(file.getOriginalFilename());
		return null;
	}

	@Override
	public List<Posts> getPostForUser(String email)  {
		Users user=userRep.findByEmail("a1@b");
	     List<Posts> listPost=postRep.getPostByUser(user);
	     System.out.println(listPost);
		return listPost;
	}

	@Override
	public String getImageByPost(String fileName) {
		
   		 String extension =FilenameUtils.getExtension(fileName);
   		 
   		 try {
   			 String encode64 =null ;
   			 File file=new File("./print237-f2p-dir/"+fileName);
				FileInputStream fis =new FileInputStream(file);
				byte[] bytes =new byte[(int)file.length()];
				fis.read(bytes);
			    encode64=Base64.getEncoder().encodeToString(bytes);
			    String url="data:image/"+extension+"base64,"+encode64;
				fis.close();
				return url ;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			    return null;
			}
   	 
	}

}
