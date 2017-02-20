package com.inc.gtc.process;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.inc.gtc.domain.CodecQueue;
import com.inc.gtc.queue.CodecHandleQueue;
import com.inc.gtc.service.CodecQueueService;
import com.inc.gtc.transform.MediaCompressor;
import com.inc.gtc.transform.MediaType;
import com.inc.yun.context.BeanFactory;
import com.inc.yun.core.engin.DefaultExecutorImpl;
import com.inc.yun.core.engin.Executor;

@Component("processExecutor")
@Scope("prototype")
public class CodecProcessExecutor extends DefaultExecutorImpl{
	
	private Logger logger = Logger.getLogger(CodecProcessExecutor.class);

	@Autowired
	private MediaCompressor compressor;
	
	@Autowired
	private CodecQueueService cqService;
	
	@Autowired
	private CodecHandleQueue queue;
	
	
	

	public void execute() {
		try
		{
			CodecQueue wc = queue.get();
			if (wc!=null)
			{
				if (StringUtils.isNotBlank(wc.getPath()))
				{
					File src  = new File(wc.getPath());
					if (src.exists())
					{
						if (wc.getType()==CodecQueue.TYPE_VIDEO_MP4)
						{
							File bakFile = createBak(src);
							compressor.compressVideoThumbnail(bakFile, createFile(src,"mp4"), getThumbnail(src),MediaType.MP4, false);
							compressor.compressVideoThumbnail(bakFile, createFile(src,"ogg"), null,MediaType.OGG, true);
						}
						else if (wc.getType()==CodecQueue.TYPE_VOICE_AAC)
						{
							compressor.compressAudio(createBak(src),src, true);
						}
						
						wc.setStatus(CodecQueue.STATUS_COMPRESSED);
					}
					else
					{
						wc.setStatus(CodecQueue.STATUS_SKIP);
					}
				}
				else
				{
					wc.setStatus(CodecQueue.STATUS_SKIP);
				}
				cqService.save(wc);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			logger.error(e);
		}
		
	}
	
	public File createBak(File src) throws Exception
	{
		File bakFile = new File(FilenameUtils.getFullPath(src.getPath()),FilenameUtils.getBaseName(src.getPath())+"_bak."+FilenameUtils.getExtension(src.getPath()));
		FileUtils.copyFile(src, bakFile);
		logger.info("bakFile:"+bakFile.getPath());
		return bakFile;
	}
	
	public File createFile(File src,String extension)
	{
		return new File(FilenameUtils.getFullPath(src.getPath()),FilenameUtils.getBaseName(src.getPath())+"."+extension);
	}

	public File getThumbnail(File src) throws Exception
	{
		File thumbnail = new File(FilenameUtils.getFullPath(src.getPath()),FilenameUtils.getBaseName(src.getPath())+".png");
		FileUtils.copyFile(src, thumbnail);
		logger.info("thumbnail:"+thumbnail.getPath());
		return thumbnail;
	}
	
	

}
