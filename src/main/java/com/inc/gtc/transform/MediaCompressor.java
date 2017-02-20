package com.inc.gtc.transform;

import java.io.File;

/**
 * 多媒体文件压缩
 * @author inc.courser
 *
 */
public interface MediaCompressor {

	/**
	 * 压缩音频
	 * @param src
	 * @param dest
	 * @param delSrc
	 */
	void compressAudio(File src,File dest,boolean delSrc);
	
	/**
	 * 压缩视频
	 * @param src
	 * @param dest
	 * @param delSrc
	 * @param thumnail 缩略图名称
	 * @return
	 */
	void compressVideoThumbnail(File src,File dest,File thumbnail,MediaType type,boolean delSrc);

}
