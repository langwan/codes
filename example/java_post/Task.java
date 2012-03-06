import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class Task {
	public void run() throws IOException
	{
		HttpURLConnection conn = null;
		DataOutputStream dos = null;
		DataInputStream dis = null;
		try 
		{
			
			String string = "{\"option\":2}";
			URL url = new URL("http://10.237.35.116/poll.pollvote.xmji");
			conn = (HttpURLConnection) url.openConnection();
			conn.setUseCaches(false);	
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestMethod("POST");
			conn.setDoInput(true);
			conn.setDoOutput(true);
			OutputStream os = conn.getOutputStream();
			dos = new DataOutputStream(os);
			dos.writeBytes(string);
	
			//System.out.println(string);
			dos.flush();
			dos.close();
			
			InputStream is=conn.getInputStream();
		   dis=new DataInputStream(is);
		   byte d[]=new byte[dis.available()];
		   dis.read(d);
		   String data=new String(d);
		 //  System.out.println(data);
			
		}catch(Exception ex)
		{
			//ex.printStackTrace();
		}finally
		{
			dos.close();
			dis.close();
			
			conn.disconnect();
		}
		
	}
}
