package gamehbq;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GameResolution {
	public static void main(String[] args) {
		int[] boxId = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int[] secretNum = new int[10];
		String [] str = new String [10];
		
		long currentTime =System.currentTimeMillis();
		System.out.println(currentTime);
		str[0] = boxId[0] + currentTime + "0";
		System.out.println(str[0]);
		String result = SHA256(str[0]);
		System.out.println(result);
		
		
	}
	public static String SHA256(final String strText){
	    return SHA(strText, "SHA-256");
	}
	private static String SHA(final String strText, final String strType){
	    // 返回值
	    String strResult = null;
	 
	    // 是否是有效字符串
	    if (strText != null && strText.length() > 0)
	    {
	      try
	      {
	       
	        MessageDigest messageDigest = MessageDigest.getInstance(strType);
	        
	        messageDigest.update(strText.getBytes());
	        
	        byte byteBuffer[] = messageDigest.digest();
	 
	        
	        StringBuffer strHexString = new StringBuffer();
	        
	        for (int i = 0; i < byteBuffer.length; i++)
	        {
	          String hex = Integer.toHexString(0xff & byteBuffer[i]);
	          if (hex.length() == 1)
	          {
	            strHexString.append('0');
	          }
	          strHexString.append(hex);
	        }
	        
	        strResult = strHexString.toString();
	      }
	      catch (NoSuchAlgorithmException e)
	      {
	        e.printStackTrace();
	      }
	    }
	 
	    return strResult;
	  }



}
