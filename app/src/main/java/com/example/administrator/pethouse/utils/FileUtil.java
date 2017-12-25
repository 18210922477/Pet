package com.example.administrator.pethouse.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import android.content.Context;
import android.text.TextUtils;

import com.example.administrator.pethouse.app.AppSituation;

public class FileUtil {

	public static final String LOGIN = "login";
	public static final String TOKEN = "token";
	private static final String JPUSHISOK = null;



	/**
	 * 保存Token
	 */
	public static void saveToken() {
		// 对象输出�??
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(AppSituation.context
					.openFileOutput(TOKEN, Context.MODE_PRIVATE));
			// 写入数据
			oos.writeObject(TokenUtil.createToken());
			// 刷新
			oos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 获取Token
	 */
	public static String getToken() {
		String code = null;
		// 对象输入�??
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(AppUtils.getAppContext().openFileInput(
					TOKEN));
			// 获取用户对象
			code = (String) ois.readObject();
			if (TextUtils.isEmpty(code)) {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return code;
	}




	/**
	 * @描述 :保存极光添加信息
	 */
	public static void saveIsOk(int code) {

		// 对象输出流
		ObjectOutputStream oos = null;
		try {
			// 初始化
			oos = new ObjectOutputStream(AppUtils.getAppContext()
					.openFileOutput(FileUtil.JPUSHISOK, Context.MODE_PRIVATE));
			// 写入数据
			oos.writeObject(code);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 
	 * @描述 :读取极光推送结果
	 */
	public static int getIsOk() {
		int code = -1;
		// 对象输入流
		ObjectInputStream ois = null;

		try {
			// 获取对象
			ois = new ObjectInputStream(AppUtils.getAppContext().openFileInput(
					FileUtil.JPUSHISOK));
			// 获取用户对象
			code = (int) ois.readObject();
		} catch (Exception e) {
			return -1;
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return code;
	}

}
