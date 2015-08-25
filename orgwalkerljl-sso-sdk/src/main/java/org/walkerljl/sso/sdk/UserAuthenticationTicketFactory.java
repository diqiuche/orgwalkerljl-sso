package org.walkerljl.sso.sdk;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * UserAuthenticationTicketFactory
 *
 * @author lijunlin
 */
public class UserAuthenticationTicketFactory {
	
	private String ssoAuthCookieName;
	private String ssoAuthCookieKey;
	private String ssoCookieDomain;
	
	public UserAuthenticationTicketFactory(String ssoCookieDomain, String ssoAuthCookieName, String ssoAuthCookieKey) {
		this.ssoCookieDomain = ssoCookieDomain;
		this.ssoAuthCookieName = ssoAuthCookieName;
		this.ssoAuthCookieKey = ssoAuthCookieKey;
	}

	public UserAuthenticationTicket getTicket(HttpServletRequest request) {
		UserAuthenticationTicket ticket = UserAuthenticationTicket.getTicket();
		if (ticket != null) {
			return ticket;
		} else {
			String encryptedCookieString = getCookieValue(request, ssoAuthCookieName);
			String decryptedCookieString = TicketStoreUtils.decrypt(encryptedCookieString, ssoAuthCookieKey);
			return UserAuthenticationTicket.parse(decryptedCookieString);
		}
	}
	
	public void generateTicket(HttpServletResponse response, String userId, String userName) {
		UserAuthenticationTicket ticket = new UserAuthenticationTicket();
		ticket.setUserId(userId);
		ticket.setUserName(userName);
		long currentTime = System.currentTimeMillis();
		ticket.setExpires(currentTime + 30 * 60 * 1000);
		ticket.setCreateDate(currentTime);
		String encryptedCookieString = TicketStoreUtils.encrypt(ticket.toValueString(), ssoAuthCookieKey);
		Cookie cookie = new Cookie(ssoAuthCookieName, encryptedCookieString);
		cookie.setDomain(ssoCookieDomain);
		cookie.setPath("/");
		cookie.setMaxAge(30 * 60);
		UserAuthenticationTicket.set(ticket);
	}
	
	private String getCookieValue(HttpServletRequest request, String key) {
		String result = null;
		Cookie[] cookies = request.getCookies();
		if (cookies == null || cookies.length == 0) {
			return result;
		}
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(key)) {
				result = cookie.getValue();
				break;
	        }
		}
        return result;
	}
}

class TicketStoreUtils {
	
    public static String encrypt(String string, String key) {
        try {
            Cipher cipher = getDesCipher(EncryptType.ENCODE, key);
            return byteArr2HexStr(cipher.doFinal(string.getBytes()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String decrypt(String string, String key) {
        try {
            Cipher cipher = getDesCipher(EncryptType.DECODE, key);
            return new String(cipher.doFinal(hexStr2ByteArr(string)));
        } catch (Exception e) {
        	throw new RuntimeException(e);
        }
    }

    private static Cipher getDesCipher(EncryptType encryptType, String key) {
        Cipher cipher = null;
        try {
            DESKeySpec dks = new DESKeySpec(key.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey secretKey = keyFactory.generateSecret(dks);
            cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            if (EncryptType.ENCODE == encryptType) {
                cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            } else if (EncryptType.DECODE == encryptType) {
                cipher.init(Cipher.DECRYPT_MODE, secretKey);
            } else {
            	throw new RuntimeException("Invalid EncryptType");
            }
        } catch (Exception e) {
        	throw new RuntimeException(e);
        }
        return cipher;
    }

    private static String byteArr2HexStr(byte[] arrB) throws Exception {
        int iLen = arrB.length;
        StringBuilder sb = new StringBuilder(iLen * 2);
        for (int i = 0; i < iLen; i++) {
            int intTmp = arrB[i];
            while (intTmp < 0) {
                intTmp = intTmp + 256;
            }
            if (intTmp < 16) {
                sb.append("0");
            }
            sb.append(Integer.toString(intTmp, 16).toUpperCase());
        }
        return sb.toString();
    }

    private static byte[] hexStr2ByteArr(String strIn) throws Exception {
        byte[] arrB = strIn.getBytes();
        int iLen = arrB.length;

        byte[] arrOut = new byte[iLen / 2];
        for (int i = 0; i < iLen; i = i + 2) {
            String strTmp = new String(arrB, i, 2);
            arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
        }
        return arrOut;
    }
    
    private enum EncryptType {
    	ENCODE, DECODE;
    }
}