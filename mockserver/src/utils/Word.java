package utils;

import java.io.UnsupportedEncodingException;
import java.util.Random;

public class Word {

	private StringBuilder strB = new StringBuilder();
	private static Word word = new Word();
	
	public static Word getInstance(){
		return word;
	}
	
	
	/**
	 * 随机生成常见汉字
	 * @return
	 */
    private String getRandomChar() {
        String str = "";
        int highCode;
        int lowCode;

        Random random = new Random();

        highCode = (176 + Math.abs(random.nextInt(39))); //B0 + 0~39(16~55) 一级汉字所占区
        lowCode = (161 + Math.abs(random.nextInt(93))); //A1 + 0~93 每区有94个汉字

        byte[] b = new byte[2];
        b[0] = (Integer.valueOf(highCode)).byteValue();
        b[1] = (Integer.valueOf(lowCode)).byteValue();

        try {
            str = new String(b, "GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str;
    }
    
    /**
     * 随机生成汉字
     * @param wordSize
     * @return
     */
    public String randomWord(int wordSize){
    	if(wordSize <= 0) wordSize = 1;
    	strB.delete(0 , strB.length());
    	for(int i = 0 ; i < wordSize ; i ++){
    		strB.append(getRandomChar());
    	}
    	return strB.toString();
    }
}
