package gamehbq;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GameResolution {
	public static void main(String[] args) {
		int BOX_NUM = 10;
		int[] boxId = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int[] secretNum = new int[BOX_NUM];
		String [] strTemp = new String [BOX_NUM];
		String [] strHash = new String [BOX_NUM];
		/*
		 * long currentTime =System.currentTimeMillis();
		 * System.out.println(currentTime);
		 */
		//str[0] = boxId[0] + currentTime + "0";
		secretNum[0] = Resolution(boxId[0],"0");
		strTemp[0] = boxId[0] + "0" + secretNum[0];
		strHash[0] = SHA256(strTemp[0]);
		for(int j=1;j<10;j++) {
			secretNum[j] = Resolution(boxId[j],strHash[j-1]);
		}
		for(int m=0;m<secretNum.length;m++)
		{
		    System.out.println(secretNum[m]);
		}
	}
	/**
	 * 功能：求取神秘数字
	 * @param id lastHash
	 * @return i 神秘数字
	 */
	private static Integer Resolution(int id,String lastHash) {
		String SUCCESS_RESULT = "00000";
		int i;
		for(i=1;true;i++) {
			String strTemp = id + lastHash + i;
			System.out.println(strTemp);
			String result = SHA256(strTemp);
			System.out.println(result);
			String fontNum = result.substring(0, 5);
			System.out.println(fontNum);
			if(SUCCESS_RESULT.equals(fontNum)) {
				System.out.println("success");
				System.out.println(i);
				break;
			}	
		}
		return i;	
	}
	/**
	 * 获取hash值
	 * @param strText
	 * @return hash值
	 */
	private static String SHA256(final String strText){
	    return SHA(strText, "SHA-256");
	}
	private static String SHA(final String strText, final String strType){
	    String strResult = null;
	    if (strText != null && strText.length() > 0){
	      try{
	        MessageDigest messageDigest = MessageDigest.getInstance(strType);
	        messageDigest.update(strText.getBytes());
	        byte byteBuffer[] = messageDigest.digest();
	        StringBuffer strHexString = new StringBuffer();
	        for (int i = 0; i < byteBuffer.length; i++){
	          String hex = Integer.toHexString(0xff & byteBuffer[i]);
	          if (hex.length() == 1){
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
