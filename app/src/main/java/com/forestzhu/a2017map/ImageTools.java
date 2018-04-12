package com.forestzhu.a2017map;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.util.Log;
public final class ImageTools {
	public static Bitmap zoomBitmap(Bitmap bitmap, int width, int height) {
		int w = bitmap.getWidth();
		int h = bitmap.getHeight();
		Matrix matrix = new Matrix();
		float scaleWidth = ((float) width / w);
		float scaleHeight = ((float) height / h);
		matrix.postScale(scaleWidth, scaleHeight);
		Bitmap newbmp = Bitmap.createBitmap(bitmap, 0, 0, w, h, matrix, true);
		return newbmp;
	}
	public static void savePhotoToSDCard(Bitmap photoBitmap, String path, String photoName) {
		String endingpath = path+"/com.foerstzhu";
		File dir = new File(endingpath);
			if (!dir.exists()) {
<<<<<<< HEAD

				dir.mkdirs();//创建文件夹！！
			}

			File photoFile = new File(endingpath,photoName + ".png");//在parent的文件夹下创立文件！
			FileOutputStream fileOutputStream = null;
			try {

				fileOutputStream = new FileOutputStream(photoFile);
				if (photoBitmap != null) {
					if (photoBitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream)) {
						fileOutputStream.flush();
=======
				Log.e("savePhoto","执行dir.mkdirs");
				dir.mkdirs();//创建文件夹！！
			}
		Log.e("savePhoto","开始执行new File");
			File photoFile = new File(endingpath,photoName + ".png");//在parent的文件夹下创立文件！
			FileOutputStream fileOutputStream = null;
			try {
				Log.e("savePhoto","开始储存");
				fileOutputStream = new FileOutputStream(photoFile);
				if (photoBitmap != null) {
					Log.e("savePhoto","开始创建文件");
					if (photoBitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream)) {
						fileOutputStream.flush();
						Log.e("错误1", "第一次关闭");
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
					    fileOutputStream.close();
					}
				}
			} catch (FileNotFoundException e) {
				photoFile.delete();
				e.printStackTrace();
			} catch (IOException e) {
				photoFile.delete();
				e.printStackTrace();
			}finally{
				try {
<<<<<<< HEAD
=======
					Log.e("错误1","第二次关闭");
>>>>>>> 9ffe6332a5004bb42d1eebe66de32ca94f7a88ab
					fileOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	}
}
