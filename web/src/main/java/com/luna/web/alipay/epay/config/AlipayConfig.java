package com.luna.web.alipay.epay.config;

import org.springframework.stereotype.Component;

@Component
public class AlipayConfig {

    // 商户ID
    private String appid = "2016092300579341";
    // 私钥
    private String rsa_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCkRbVEFHxPkl754hwz4w9iraA62H3/GjZ6RwHa+8LBy2mNOg89IaodAUd99ojYEDgnVxg8U9RhXF4COsm6Q+APy7YpCpu5GJv6X9HJYLXifyxc5gfr48CdR6JQDx2R5/aqMro0Dd69R3HOuZj5rctpVHs7gIvsSn5PV53OCOgLEWzbtcY3DKLkByevmoXVdnBDHRZKqv1H6N8i83YzNRVx6fr3IHZGiIxVbuEHUn5iT1FBArQVuHLki5JaM6nwWQIC2a0T2Yokp1kjqhFoNp08sgDZnlEtQP9SjoeQMrWO0mFI7Jb3ooMLqJwNsdzy0Bwonh0zfrltPwzYcs2d9vTtAgMBAAECggEAW+Kp+8TBq/ihq4Bwag2N45Je18uU3oaZBliFjynXzHKtPdPGBlm4P7UhejHWZZTc9BRheA0j9Lmn0/NyNwAUaoF2CQroA+biCHBkdhHkaybbd7MrpySj7tXM0p9B2QU5EgaB5PAFMTavUAS8rpwp9WbN74B9w9P/Rv4pRL/ym41iYVxFJ3r59GDOZ/GMYzcNrFi3Io5I7LSPBR/DP2XR/Z0V2ahZ5cVBxea0rIDum+veioknLmwglzmxI9/V8C+PkgryjsfokTlH2FWx+XBbhzfcelCq50QLdHSSLAR4u2kuWv1aiswNYBaEFJ7Ir0TUCa4rYzVUkfHb1W4wTHSYwQKBgQDo7btJatR/QfI0c+TmVVcoHdS9QimcJq5dDhccePH7ocHmK5NDabtB1UgzUBHTg/ePNWhrFzuFSV3GN3XZAMkxRNA5YxBnd9R27cI8zzo9ph+BRgInc79usKE4uM1kt3s/8+Tdlx8mMh31ssxy3PrznBec9W663Uz/tpxM/WanlQKBgQC0ixaHjdP8eW7Hrdj8KnBeHqxsrQMUfH37/LTZcnbvuIDGaFCntYTR3C0HjoOIi7mbbIV584A3nxoEhfSt+fTo6GxHHCkF5TIE2ewsCWOxrMGKhoPWibuJZOe+qBXTICaOCR80sKa5zHu3zkjymQcKBxHiLtVgbwW/CLYSt4Th+QKBgQDaps84i+AN1YnXUzN8RIAcWGRrhMAqpOTo1WE8iQweeinaNu12SrpNgjjUckVJmIe7Fxd978EfzU8J0uX9Xo9+gGo2dJfhiMsZGPdMvfqeBGNuppk/D5iT/5pX9KJZ+SLpVblxiXrkEAevrLfe2zF3nP9Nh9b58uNk57axTu4eQQKBgE83yEbqQF3DmowbB959cJibtORqdbODfHQYyfGve+hreHWWR+2OhBzhExEBw00ioepEj7yWz2eYc/4QGPBNgNzBPuFkxctEadIfHLWl2QyY1MNHiomUHamHkPfjINBmhwRDlGG2MTHNO2vHI9Luulv4BizMh+usS0UrOVi1FaVhAoGBAJGhjac7FODXn2cDQY4Rqf0cw8wUy4+XISRlHfRBt51mogZ/9xyfY4A/S5bkKwpzMAXtaF4r6URYj4tP5wFE48ANepHVDnXs4Bj/x+/NsgbLyiK0Mo2fL2WchYxWym8pzsifvWvrxWVI5pGtJRVl0xKN9KsJjwfRsFKS0YSzM0av";
    // 异步回调地址
    private String notify_url;
    // 同步回调地址
    private String return_url;
    // 请求网关地址
    private String gateway_url;
    // 编码
    private String charset = "UTF-8";
    // 返回格式
    private String format = "json";
    // 支付宝公钥
    private String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEApEW1RBR8T5Je+eIcM+MPYq2gOth9/xo2ekcB2vvCwctpjToPPSGqHQFHffaI2BA4J1cYPFPUYVxeAjrJukPgD8u2KQqbuRib+l/RyWC14n8sXOYH6+PAnUeiUA8dkef2qjK6NA3evUdxzrmY+a3LaVR7O4CL7Ep+T1edzgjoCxFs27XGNwyi5Acnr5qF1XZwQx0WSqr9R+jfIvN2MzUVcen69yB2RoiMVW7hB1J+Yk9RQQK0Fbhy5IuSWjOp8FkCAtmtE9mKJKdZI6oRaDadPLIA2Z5RLUD/Uo6HkDK1jtJhSOyW96KDC6icDbHc8tAcKJ4dM365bT8M2HLNnfb07QIDAQAB";
    // RSA2
    private String signtype = "RSA2";

    // 省略get set

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getRsa_private_key() {
		return rsa_private_key;
	}

	public void setRsa_private_key(String rsa_private_key) {
		this.rsa_private_key = rsa_private_key;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

	public String getReturn_url() {
		return return_url;
	}

	public void setReturn_url(String return_url) {
		this.return_url = return_url;
	}

	public String getGateway_url() {
		return gateway_url;
	}

	public void setGateway_url(String gateway_url) {
		this.gateway_url = gateway_url;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getAlipay_public_key() {
		return alipay_public_key;
	}

	public void setAlipay_public_key(String alipay_public_key) {
		this.alipay_public_key = alipay_public_key;
	}

	public String getSigntype() {
		return signtype;
	}

	public void setSigntype(String signtype) {
		this.signtype = signtype;
	}
}