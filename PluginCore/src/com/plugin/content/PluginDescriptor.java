package com.plugin.content;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import com.plugin.util.PaLog;

import android.app.Application;
import android.content.Context;
import android.graphics.drawable.Drawable;

import dalvik.system.DexClassLoader;

/**
 * PluginInfo
 * <Pre>
 * @author Liuyongkui
 * </Pre>
 */
public class PluginDescriptor implements Serializable {

	private static final long serialVersionUID = -7545734825911798344L;

	public static final int UNKOWN = 0;
	public static final int BROADCAST = 1;
	public static final int ACTIVITY = 2;
	public static final int SERVICE = 4;
	public static final int PROVIDER = 6;
	public static final int FRAGMENT = 8;
	public static final int FUNCTION = 9;

	private String pluginID;

	private String pluginName;

	private String packageName;

	private String version;

	private String appUrl;

	private int pluginType;

	private String description;

	private boolean isStandalone;

	private boolean isEnabled;

	private int status;

	private String applicationName;

	private int applicationIcon;

	private int applicationLogo;

	private int applicationTheme;

	private String apkMainActivity;

	private  byte[] appIcon;

	/**
	 * 定义在插件Manifest中的meta-data标签
	 */
	private HashMap<String, String> metaData;

	private HashMap<String, PluginProviderInfo> providerInfos = new HashMap<String, PluginProviderInfo>();

	/**
	 * key: fragment id,
	 * value: fragment class
	 */
	private HashMap<String, String> fragments = new HashMap<String, String>();

	/**
	 * key: activity class name
	 * value: intentfilter list
	 */
	private HashMap<String, ArrayList<PluginIntentFilter>> activitys = new HashMap<String, ArrayList<PluginIntentFilter>>();

	/**
	 * key: activity class name
	 * value: activity info in Manifest
	 */
	public static HashMap<String, PluginActivityInfo> activityInfos = new HashMap<String, PluginActivityInfo>();

	/**
	 * key: service class name
	 * value: intentfilter list
	 */
	private HashMap<String, ArrayList<PluginIntentFilter>> services = new HashMap<String, ArrayList<PluginIntentFilter>>();

	/**
	 * key: receiver class name
	 * value: intentfilter list
	 */
	private HashMap<String, ArrayList<PluginIntentFilter>> receivers = new HashMap<String, ArrayList<PluginIntentFilter>>();

	private String installedPath;

	private transient Application pluginApplication;
	
	private transient DexClassLoader pluginClassLoader;

	private transient Context pluginContext;


	//=============getter and setter======================


	public String getPluginID() {
		return pluginID;
	}

	public void setPluginID(String pluginID) {
		this.pluginID = pluginID;
	}

	public String getPluginName() {
		return pluginName;
	}

	public void setPluginName(String pluginName) {
		this.pluginName = pluginName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Context getPluginContext() {
		return pluginContext;
	}

	public void setPluginContext(Context pluginContext) {
		this.pluginContext = pluginContext;
	}

	public DexClassLoader getPluginClassLoader() {
		return pluginClassLoader;
	}

	public void setPluginClassLoader(DexClassLoader pluginLoader) {
		this.pluginClassLoader = pluginLoader;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public int getApplicationIcon() {
		return applicationIcon;
	}

	public void setApplicationIcon(int icon) {
		this.applicationIcon = icon;
	}

	public int getApplicationLogo() {
		return applicationLogo;
	}

	public void setApplicationLogo(int logo) {
		this.applicationLogo = logo;
	}

	public int getApplicationTheme() {
		return applicationTheme;
	}

	public void setApplicationTheme(int theme) {
		this.applicationTheme = theme;
	}

	public HashMap<String, String> getMetaData() {
		return metaData;
	}

	public void setMetaData(HashMap<String, String> metaData) {
		this.metaData = metaData;
	}

	public HashMap<String, String> getFragments() {
		return fragments;
	}

	public void setfragments(HashMap<String, String> fragments) {
		this.fragments = fragments;
	}

	public HashMap<String, ArrayList<PluginIntentFilter>> getReceivers() {
		return receivers;
	}

	public void setReceivers(HashMap<String, ArrayList<PluginIntentFilter>> receivers) {
		this.receivers = receivers;
	}

	public HashMap<String, ArrayList<PluginIntentFilter>> getActivitys() {
		return activitys;
	}

	public void setActivitys(HashMap<String, ArrayList<PluginIntentFilter>> activitys) {
		this.activitys = activitys;
	}

	public HashMap<String, PluginActivityInfo> getActivityInfos() {
		return activityInfos;
	}

	public void setActivityInfos(HashMap<String, PluginActivityInfo> activityInfos) {
		this.activityInfos = activityInfos;
	}

	public HashMap<String, ArrayList<PluginIntentFilter>> getServices() {
		return services;
	}

	public void setServices(HashMap<String, ArrayList<PluginIntentFilter>> services) {
		this.services = services;
	}

	public String getApkMainActivity() {
		return apkMainActivity;
	}

	public void setApkMainActivity(String apkMainActivity) {
		this.apkMainActivity = apkMainActivity;
	}

	public String getInstalledPath() {
		return installedPath;
	}

	public void setInstalledPath(String installedPath) {
		this.installedPath = installedPath;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}
	
	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public Application getPluginApplication() {
		return pluginApplication;
	}

	public void setPluginApplication(Application pluginApplication) {
		this.pluginApplication = pluginApplication;
	}

	public String getUrl() {
		return appUrl;
	}

	public void setUrl(String url) {
		appUrl = url;
	}

	public int getPluginType() {
		return pluginType;
	}

	public void setPluginType(int pluginType) {
		this.pluginType = pluginType;
	}

	public boolean isStandalone() {
		return isStandalone;
	}

	public void setStandalone(boolean isStandalone) {
		this.isStandalone = isStandalone;
	}

	public HashMap<String, PluginProviderInfo> getProviderInfos() {
		return providerInfos;
	}

	public void setProviderInfos(HashMap<String, PluginProviderInfo> providerInfos) {
		this.providerInfos = providerInfos;
	}

	public String getDescription() {
		if (description != null && description.startsWith("@") && description.length() == 9) {
			String idHex = description.replace("@", "");
			try {
				int id = Integer.parseInt(idHex, 16);
				//此时context可能还没有初始化
				if (pluginContext != null) {
					String des = pluginContext.getString(id);
					return des;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return description;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public byte[] getAppIcon() {
		return appIcon;
	}

	public void setAppIcon(byte[] appIcon) {
		this.appIcon = appIcon;
	}

	//=============getter and setter======================


	public PluginDescriptor() {
	}

	/**
	 * 需要根据id查询的只有fragment
	 * @param clazzId
	 * @return
	 */
	public String getPluginClassNameById(String clazzId) {
		String clazzName = getFragments().get(clazzId);

		if (clazzName == null) {
			PaLog.d("PluginDescriptor", "clazzName not found for classId ", clazzId);
		} else {
			PaLog.d("PluginDescriptor", "clazzName found ", clazzName);
		}
		return clazzName;
	}

	/**
	 * 需要根据Id查询的只有fragment
	 * @param clazzId
	 * @return
	 */
	public boolean containsFragment(String clazzId) {
		if (getFragments().containsKey(clazzId) && isEnabled()) {
			return true;
		}
		return false;
	}

	/**
	 * 根据PluginPath查询
	 * @param clazzPath
	 * @return
	 */
	public boolean containsPath(String clazzPath) {
		if (getFragments().containsValue(clazzPath) && isEnabled()) {
			return true;
		} else if (getActivitys().containsKey(clazzPath) && isEnabled()) {
			return true;
		}  else if (getReceivers().containsKey(clazzPath) && isEnabled()) {
			return true;
		}  else if (getServices().containsKey(clazzPath) && isEnabled()) {
			return true;
		} else if (getProviderInfos().containsKey(clazzPath) && isEnabled()) {
			return true;
		}
		return false;
	}
	
	/**
	 * 根据className查询
	 * @param clazzName
	 * @return
	 */
	public boolean containsName(String clazzName) {
		if (getFragments().containsValue(clazzName) && isEnabled()) {
			return true;
		} else if (getActivitys().containsKey(clazzName) && isEnabled()) {
			return true;
		}  else if (getReceivers().containsKey(clazzName) && isEnabled()) {
			return true;
		}  else if (getServices().containsKey(clazzName) && isEnabled()) {
			return true;
		} else if (getProviderInfos().containsKey(clazzName) && isEnabled()) {
			return true;
		}
		return false;
	}

	/**
	 * 获取class的类型： activity
	 * @return
	 */
	public int getType(String clazzName) {
		if (getFragments().containsValue(clazzName) && isEnabled()) {
			return FRAGMENT;
		} else if (getActivitys().containsKey(clazzName) && isEnabled()) {
			return ACTIVITY;
		}  else if (getReceivers().containsKey(clazzName) && isEnabled()) {
			return BROADCAST;
		}  else if (getServices().containsKey(clazzName) && isEnabled()) {
			return SERVICE;
		} else if (getProviderInfos().containsKey(clazzName) && isEnabled()) {
			return PROVIDER;
		}
		return UNKOWN;
	}
}
