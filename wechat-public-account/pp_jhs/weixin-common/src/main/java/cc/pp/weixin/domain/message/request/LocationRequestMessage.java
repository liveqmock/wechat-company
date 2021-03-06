package cc.pp.weixin.domain.message.request;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Element;

import cc.pp.weixin.constant.MsgFieldName;
import cc.pp.weixin.constant.MsgType;


/**
 * 微信公众平台地理位置消息
 * @author wgybzb
 * @since  2013-04-06
 */
public class LocationRequestMessage extends RequestMessage {
	/**
	 * 默认的序列化版本号
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 地理位置纬度
	 */
	private double locationX;

	public double getLocationX() {
		return locationX;
	}
	public void setLocationX(double locationX) {
		this.locationX = locationX;
	}

	/**
	 * 地理位置经度
	 */
	private double locationY;
	public double getLocationY() {
		return locationY;
	}
	public void setLocationY(double locationY) {
		this.locationY = locationY;
	}

	/**
	 * 地图缩放大小
	 */
	private int scale;
	public int getScale() {
		return scale;
	}
	public void setScale(int scale) {
		this.scale = scale;
	}

	/**
	 * 地理位置信息
	 */
	private String label;
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * 默认消息类型为 地理位置消息
	 */
	public LocationRequestMessage() {
		this.msgType = MsgType.LOCATION;
	}

	/**
	 * 构造函数：根据微信平台的请求数据，封装地理位置消息属性
	 */
	public LocationRequestMessage(Element element) {
		//调用父类的构造方法，初始化通用信息
		super(element);

		if (element == null){
			return;
		}
		String locationXStr = element.elementText(MsgFieldName.LOCATION_X);
		if (StringUtils.isNotEmpty(locationXStr)){
			this.locationX = Double.valueOf(locationXStr);
		}

		String locationYStr = element.elementText(MsgFieldName.LOCATION_Y);
		if (StringUtils.isNotEmpty(locationYStr)){
			this.locationY = Double.valueOf(locationYStr);
		}

		String scaleStr = element.elementText(MsgFieldName.SCALE);
		if (StringUtils.isNotEmpty(scaleStr)){
			this.scale = Integer.valueOf(scaleStr);
		}

		this.label = element.elementText(MsgFieldName.LABEL);
	}

}
