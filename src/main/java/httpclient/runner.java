package httpclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class runner {

	public runner() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws ClientProtocolException, IOException {
		String url = "http://localhost:7001/exec/java";
		String clazz = "/ru.rb.ucb.loader.recounting.RecountingProcessDb2";
		String par = "2017-07-10_P4_P4_0_2017-07-10_40817036250010000018_01141299AUD000099018";
		try(CloseableHttpClient client = HttpClientBuilder.create().build()){
			HttpPost post = new HttpPost(url + clazz + par);
			HttpResponse resp = client.execute(post);
			int respCode = resp.getStatusLine().getStatusCode();
			if (respCode == 200)
				System.out.println(respCode + resp.getStatusLine().getReasonPhrase());
			else
			    System.out.println(resp.getStatusLine().getStatusCode() +" "+resp.getStatusLine().getReasonPhrase());
//			BufferedReader rd = new BufferedReader(new InputStreamReader(resp.getEntity().getContent()));
//			String line = rd.readLine();
//			System.out.println(line);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
