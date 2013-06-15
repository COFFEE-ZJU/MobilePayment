package cn.edu.zju.cs.onlinepayment.utils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

/*public void setViewImage(ImageView v, String value) {
 new ImageDownloadTask().execute(url, bmp);
 }*/
public class ImageDownloadTask extends AsyncTask<Object, Object, Bitmap> {
	private Bitmap dest;

	@Override
	protected Bitmap doInBackground(Object... params) {
		// TODO Auto-generated method stub
		Bitmap bmp = null;
		dest = (Bitmap) params[1];
		try {
			bmp = getImage((String) params[0]);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		params[1] = bmp;
		return bmp;
	}

	protected void onPostExecute(Bitmap result) {
	}

	Bitmap getImage(String Url) throws Exception {
		try {
			Log.i("pclee",Url);
			URL url = new URL("http://www.elongstatic.com/imageapp/hotels/hotelimages/1201/41201313/17_cf31e9d8-2309-4501-bbbd-ca95f2557927.jpg");
			URLConnection urlCon = url.openConnection(); 
			String responseCode = urlCon.getHeaderField(0);
			if (responseCode.indexOf("200") < 0)
				throw new Exception("图片文件不存在或路径错误，错误代码：" + responseCode);
			return BitmapFactory.decodeStream(urlCon.getInputStream());
		} catch (IOException e) {
			throw new Exception(e.getMessage());

		}

	}
}
