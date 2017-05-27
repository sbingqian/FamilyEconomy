package cn.bq.family.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMethod;

public class HttpUtil {

	/**
	 * 获取http响应直接输出
	 * 
	 * @param response
	 * @param str
	 */
	public static void write(HttpServletResponse response, String str) {
		try {
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			PrintWriter writer = response.getWriter();
			writer.print(str);
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	@SuppressWarnings("finally")
	public static String httpClient(String urlAddress, RequestMethod method, String param) {

		String result = "";
		BufferedReader in = null;
		PrintWriter out = null;

		try {

			URL url = new URL(urlAddress);

			URLConnection uc = url.openConnection();

			uc.setRequestProperty("accept", "*/*");
			uc.setRequestProperty("connection", "Keep-Alive");
			uc.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

			if (RequestMethod.POST == method) {

				uc.setDoOutput(true);
				uc.setDoInput(true);
				out = new PrintWriter(uc.getOutputStream());
				out.print(param);
				out.flush();

			}

			uc.connect();

			in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (out != null) {
					out.close();
				}
			} catch (final Exception e2) {
				e2.printStackTrace();
			}

			return result;
		}

	}
}
