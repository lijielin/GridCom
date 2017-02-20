package com.inc.gtc.transform;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;



@Component("fmMediaCompressor")
public class FmMediaCompressor implements MediaCompressor{
	
	private static final Logger logger = Logger.getLogger(FmMediaCompressor.class);
	
	@Value("${ffmpeg_compressmp4}")
	private String compressMp4Command;
	
	@Value("${ffmpeg_compressogg}")
	private String compressOggCommand;
	
	@Value("${ffmpeg_compressaudio}")
	private String compressAudioCommand;
	
	@Value("${ffmpeg_capturevideo}")
	private String thumbnailCommand;

	@Override
	public void compressAudio(File src, File dest, boolean delSrc) {
		try
		{
			String cmd = compressAudioCommand.replace("{source}", src.getPath()).replace("{dest}", dest.getPath());
			exec(cmd,line->{System.out.println(line);});
			if (delSrc)
				FileUtils.forceDelete(src);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void compressVideoThumbnail(File src, File dest,File thumbnail,MediaType type, boolean delSrc) {
		try
		{
			/**
			 * create thumnail
			 */
			String cmd = null;
			if (thumbnail!=null)
			{
				cmd= thumbnailCommand.replace("{source}", src.getPath()).replace("{thumbnail}", thumbnail.getPath());
				exec(cmd,line->{System.out.println(line);});
			}
			
			/**
			 * compress video
			 */
			if (type.equals(MediaType.MP4))
				cmd = compressMp4Command.replace("{source}", src.getPath()).replace("{dest}", dest.getPath());
			else
				cmd = compressOggCommand.replace("{source}", src.getPath()).replace("{dest}", dest.getPath());
			exec(cmd,line->{System.out.println(line);});
			if (delSrc)
				FileUtils.forceDelete(src);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	private void exec(String cmd,CompressListener listener)
	{
		try
		{
		logger.info("execute cmd:"+cmd);
		 String[] ary = cmd.split(" ");
		 List<String> cmdList = new ArrayList<String>();
		 for (String str : ary)
		 {
			 cmdList.add(str.trim());
		 }
	     ProcessBuilder builder = new ProcessBuilder();    
         builder.command(cmdList);  
         builder.redirectErrorStream(true);  
         Process proc = builder.start();  
         BufferedReader stdout = new BufferedReader(  
                 new InputStreamReader(proc.getInputStream()));  
         String line;  
         while ((line = stdout.readLine()) != null) {  
        	listener.lisenter(line);
         }  
         proc.waitFor();     
         stdout.close();  
     } catch (Exception e) {  
         e.printStackTrace();  
     }  
	}

}
